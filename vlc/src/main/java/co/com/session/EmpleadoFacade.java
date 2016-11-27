/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.session;

import entidad.Empleado;
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
public class EmpleadoFacade extends AbstractFacade<Empleado> {

    @PersistenceContext(unitName = "co.com_vlc_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpleadoFacade() {
        super(Empleado.class);
    }

    public void guardar(String idPersona, String contrasena, boolean gerente, Persona persona) {

        try {
            
            Empleado empleado = new Empleado(idPersona, gerente, contrasena, persona);
            //Empleado empleado = null;
            //Empleado empleado = new Empleado(idPersona, contrasena, gerente);
            System.out.println("EMPLEADO2 ENTRA HASTA AQUÍ " + empleado.toString());
            em.persist(empleado);
        } catch (Exception e) {
            System.out.println("Error " + e);

            throw new EJBException(e.getMessage());
        }
    }

    public List<Empleado> cargar() {
        return em.createNamedQuery("Empleado.findAll").getResultList();
    }

    public Empleado buscarEmpleado(String idPersona) {

        List<Empleado> temp = em.createNamedQuery("Empleado.findAll").getResultList();
        for (Empleado empleado : temp) {
            if (empleado.getIdEmpleado().equalsIgnoreCase(idPersona)) {
                return empleado;
            }
        }
        return null;
    }

}
