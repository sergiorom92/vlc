/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sergio
 */
@Entity
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    ,
    @NamedQuery(name = "Persona.findByIdPersona", query = "SELECT p FROM Persona p WHERE p.idPersona = :idPersona")
    ,
    @NamedQuery(name = "Persona.findByNombre", query = "SELECT p FROM Persona p WHERE p.nombre = :nombre")
    ,
    @NamedQuery(name = "Persona.findByApellido", query = "SELECT p FROM Persona p WHERE p.apellido = :apellido")
    ,
    @NamedQuery(name = "Persona.findByDireccion", query = "SELECT p FROM Persona p WHERE p.direccion = :direccion")
    ,
    @NamedQuery(name = "Persona.findByCiudad", query = "SELECT p FROM Persona p WHERE p.ciudad = :ciudad")
    ,
    @NamedQuery(name = "Persona.findByTelefono", query = "SELECT p FROM Persona p WHERE p.telefono = :telefono")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id_persona")
    private String idPersona;
    
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    
    @Basic(optional = false)
    @Column(name = "ciudad")
    private String ciudad;
    
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private Set<Cotizacion> cotizacionSet;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private Set<Factura> facturaSet;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private Set<Empleado> empleadoSet;

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

    public Set<Cotizacion> getCotizacionSet() {
        return cotizacionSet;
    }

    public void setCotizacionSet(Set<Cotizacion> cotizacionSet) {
        this.cotizacionSet = cotizacionSet;
    }

    public Set<Factura> getFacturaSet() {
        return facturaSet;
    }

    public void setFacturaSet(Set<Factura> facturaSet) {
        this.facturaSet = facturaSet;
    }

    public Set<Empleado> getEmpleadoSet() {
        return empleadoSet;
    }

    public void setEmpleadoSet(Set<Empleado> empleadoSet) {
        this.empleadoSet = empleadoSet;
    }

    public Persona(String idPersona, String nombre, String apellido, String direccion, String ciudad, String telefono) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.telefono = telefono;
    }

    public Persona() {
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", ciudad=" + ciudad + ", telefono=" + telefono + ", cotizacionSet=" + cotizacionSet + ", facturaSet=" + facturaSet + ", empleadoSet=" + empleadoSet + '}';
    }

}
