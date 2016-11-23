/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sergio
 */
@Entity
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")
    ,
    @NamedQuery(name = "Factura.findByFacturaId", query = "SELECT f FROM Factura f WHERE f.facturaId = :facturaId")
    ,
    @NamedQuery(name = "Factura.findByFecha", query = "SELECT f FROM Factura f WHERE f.fecha = :fecha")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "factura_id")
    private Integer facturaId;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne(optional = false)
    private Persona idPersona;
    @JoinColumn(name = "id_empleado_corte", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false)
    private Empleado idEmpleadoCorte;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false)
    private Empleado idEmpleado;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "factura")
    private DetalleFactura detalleFactura;

    public Integer getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(Integer facturaId) {
        this.facturaId = facturaId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    public Empleado getIdEmpleadoCorte() {
        return idEmpleadoCorte;
    }

    public void setIdEmpleadoCorte(Empleado idEmpleadoCorte) {
        this.idEmpleadoCorte = idEmpleadoCorte;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public DetalleFactura getDetalleFactura() {
        return detalleFactura;
    }

    public void setDetalleFactura(DetalleFactura detalleFactura) {
        this.detalleFactura = detalleFactura;
    }

    public Factura() {
    }

    public Factura(Date fecha, Persona idPersona, Empleado idEmpleadoCorte, Empleado idEmpleado, DetalleFactura detalleFactura) {
        this.fecha = fecha;
        this.idPersona = idPersona;
        this.idEmpleadoCorte = idEmpleadoCorte;
        this.idEmpleado = idEmpleado;
        this.detalleFactura = detalleFactura;
    }

    public Factura(Integer facturaId, Date fecha, Persona idPersona, Empleado idEmpleadoCorte, Empleado idEmpleado) {
        this.facturaId = facturaId;
        this.fecha = fecha;
        this.idPersona = idPersona;
        this.idEmpleadoCorte = idEmpleadoCorte;
        this.idEmpleado = idEmpleado;
    }

    @Override
    public String toString() {
        return "Factura{" + "facturaId=" + facturaId + ", fecha=" + fecha + ", idPersona=" + idPersona + ", idEmpleadoCorte=" + idEmpleadoCorte + ", idEmpleado=" + idEmpleado + ", detalleFactura=" + detalleFactura + '}';
    }

}
