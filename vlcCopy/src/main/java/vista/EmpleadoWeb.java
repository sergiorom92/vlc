/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import co.com.session.EmpleadoFacade;
import co.com.session.PersonaFacade;
import entidad.Empleado;
import entidad.Persona;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author sergio
 */
@Named
@RequestScoped

public class EmpleadoWeb {

    @EJB
    EmpleadoFacade ef;

    @EJB
    PersonaFacade pf;

    List<Empleado> empleados;

    String idPersona;
    String contrasena;
    boolean gerente;
    Persona persona;

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isGerente() {
        return gerente;
    }

    public void setGerente(boolean gerente) {
        this.gerente = gerente;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }
    
    

    public void guardar() {
        try {
            //ef.guardar(idPersona, contrasena, gerente, pf.buscarPersona(idPersona));
            ef.guardar(idPersona, contrasena, gerente , pf.buscarPersona(idPersona));
            
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }

    }

    public void cargar() {

        empleados = ef.cargar();
    }

    @PostConstruct
    public void init() {
        empleados = new LinkedList<>();
        cargar();
    }

}
