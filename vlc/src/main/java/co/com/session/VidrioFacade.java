/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.session;

import entidad.Persona;
import entidad.Vidrio;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sergio
 */
@Stateless
public class VidrioFacade extends AbstractFacade<Vidrio> {

    @PersistenceContext(unitName = "co.com_vlc_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VidrioFacade() {
        super(Vidrio.class);
    }

    public void guardar(double largo, double ancho,
            double grosor, double precio, String descripcion) {

        try {
            Vidrio vidrio = new Vidrio(0, grosor, largo, ancho, descripcion, precio);
            System.out.println("ENTRA HASTA AQUÍ " + vidrio.toString());
            em.persist(vidrio);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    
}
