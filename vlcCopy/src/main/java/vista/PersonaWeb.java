/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import co.com.session.PersonaFacade;
import entidad.Persona;
import java.util.ArrayList;
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

public class PersonaWeb {

    @EJB
    private PersonaFacade pf;

    private List<Persona> personas;
    private String idPersona;
    private String nombre;
    private String apellido;
    private String direccion;
    private String ciudad;
    private String telefono;

    public PersonaFacade getPf() {
        return pf;
    }

    public void setPf(PersonaFacade pf) {
        this.pf = pf;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void guardar() {
        try {

            pf.guardar(idPersona, nombre, apellido, direccion, ciudad, telefono);
            cargar();

        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }

    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    public void cargar() {

        personas = pf.cargar();
    }

    @PostConstruct
    public void init() {
        personas = new LinkedList<>();
        cargar();
    }

}
