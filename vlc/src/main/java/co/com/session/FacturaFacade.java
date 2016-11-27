/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.session;

import entidad.Empleado;
import entidad.Factura;
import entidad.Persona;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sergio
 */
@Stateless
public class FacturaFacade extends AbstractFacade<Factura> {

    @PersistenceContext(unitName = "co.com_vlc_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FacturaFacade() {
        super(Factura.class);
    }

    
    public Factura guardar(Empleado empleado, Persona cliente, Empleado empleadoCorte, Date fecha) {

        try {
            //Factura factura = new Factura(0, new Date(123123), empleado, empleado, cliente, listaVidrios);
            //System.out.println("EMPLEADO2 ENTRA HASTA AQUÍ " + empleado.toString());
            //em.persist(factura);
            Factura factura = new Factura(Integer.MAX_VALUE, fecha, cliente, empleadoCorte, empleado);
            //System.out.println("EMPLEADO2 ENTRA HASTA AQUÍ " + empleado.toString());
            em.persist(factura);
            return factura;
        } catch (Exception e) {
            System.out.println("Error !!!!! " );
            System.out.println(e);
            throw new EJBException(e.getMessage());

        }
    }

    public List<Factura> cargar() {
        return em.createNamedQuery("Factura.findAll").getResultList();
    }
}
