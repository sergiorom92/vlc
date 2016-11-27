/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.session;

import entidad.DetalleFactura;
import entidad.Factura;
import entidad.Vidrio;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sergio
 */
@Stateless
public class DetalleFacturaFacade extends AbstractFacade<DetalleFactura> {

    @PersistenceContext(unitName = "co.com_vlc_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleFacturaFacade() {
        super(DetalleFactura.class);
    }

    public void guardar(Integer idFactura, Vidrio idVidrio) {

        try {
            //Factura factura = new Factura(0, new Date(123123), empleado, empleado, cliente, listaVidrios);
            //System.out.println("EMPLEADO2 ENTRA HASTA AQUÍ " + empleado.toString());
            //em.persist(factura);
            //Factura factura = new Factura(Integer.MAX_VALUE, fecha, cliente, empleadoCorte, empleado);

            DetalleFactura detalle = new DetalleFactura(idFactura, idVidrio);
            System.out.println("DETALLE ENTRA HASTA AQUÍ " + detalle);
            em.persist(detalle);
        } catch (Exception e) {
            System.out.println("Error !!!!! ");
            System.out.println(e);
            throw new EJBException(e.getMessage());

        }
    }
}
