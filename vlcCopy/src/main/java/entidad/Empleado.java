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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")
    ,
    @NamedQuery(name = "Empleado.findByIdEmpleado", query = "SELECT e FROM Empleado e WHERE e.idEmpleado = :idEmpleado")
    ,
    @NamedQuery(name = "Empleado.findByGerente", query = "SELECT e FROM Empleado e WHERE e.gerente = :gerente")
    ,
    @NamedQuery(name = "Empleado.findByContrasena", query = "SELECT e FROM Empleado e WHERE e.contrasena = :contrasena")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_empleado")
    private String idEmpleado;
    @Basic(optional = false)
    @Column(name = "gerente")
    private boolean gerente;
    @Basic(optional = false)
    @Column(name = "contrasena")
    private String contrasena;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleado")
    private Set<Cotizacion> cotizacionSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleadoCorte")
    private Set<Factura> facturaSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleado")
    private Set<Factura> facturaSet1;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne(optional = false)
    private Persona idPersona;

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public boolean isGerente() {
        return gerente;
    }

    public void setGerente(boolean gerente) {
        this.gerente = gerente;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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

    public Set<Factura> getFacturaSet1() {
        return facturaSet1;
    }

    public void setFacturaSet1(Set<Factura> facturaSet1) {
        this.facturaSet1 = facturaSet1;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    public Empleado() {
    }

    public Empleado(String idEmpleado, boolean gerente, String contrasena, Persona idPersona) {
        this.idEmpleado = idEmpleado;
        this.gerente = gerente;
        this.contrasena = contrasena;
        this.idPersona = idPersona;
    }

    @Override
    public String toString() {
        return "Empleado{" + "idEmpleado=" + idEmpleado + ", gerente=" + gerente + ", contrasena=" + contrasena + ", cotizacionSet=" + cotizacionSet + ", facturaSet=" + facturaSet + ", facturaSet1=" + facturaSet1 + ", idPersona=" + idPersona + '}';
    }
    
    
}
