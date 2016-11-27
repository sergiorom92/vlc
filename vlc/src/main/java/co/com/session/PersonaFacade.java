/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.session;

import entidad.Persona;
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
public class PersonaFacade extends AbstractFacade<Persona> {

    @PersistenceContext(unitName = "co.com_vlc_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaFacade() {
        super(Persona.class);
    }

    public void guardar(String idPersona, String nombre, String apellido, String direccion,
            String ciudad, String telefono) {

        try {
            Persona persona = new Persona(idPersona, nombre, apellido, direccion, ciudad, telefono);
            System.out.println("ENTRA HASTA AQUÍ " + persona.toString());
            em.persist(persona);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    public List<Persona> cargar() {
        return em.createNamedQuery("Persona.findAll").getResultList();
    }

    public Persona buscarPersona(String idPersona) {
        List<Persona> temp = em.createNamedQuery("Persona.findAll").getResultList();
        for (Persona persona : temp) {
            if (persona.getIdPersona().equalsIgnoreCase(idPersona)) {
                return persona;
            }
        }
        return null;
    }
}
