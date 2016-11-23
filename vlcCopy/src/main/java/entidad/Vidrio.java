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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "vidrio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vidrio.findAll", query = "SELECT v FROM Vidrio v")
    ,
    @NamedQuery(name = "Vidrio.findByIdVidrio", query = "SELECT v FROM Vidrio v WHERE v.idVidrio = :idVidrio")
    ,
    @NamedQuery(name = "Vidrio.findByGrosor", query = "SELECT v FROM Vidrio v WHERE v.grosor = :grosor")
    ,
    @NamedQuery(name = "Vidrio.findByLargo", query = "SELECT v FROM Vidrio v WHERE v.largo = :largo")
    ,
    @NamedQuery(name = "Vidrio.findByAncho", query = "SELECT v FROM Vidrio v WHERE v.ancho = :ancho")
    ,
    @NamedQuery(name = "Vidrio.findByPrecio", query = "SELECT v FROM Vidrio v WHERE v.precio = :precio")
    ,
    @NamedQuery(name = "Vidrio.findByDescripcion", query = "SELECT v FROM Vidrio v WHERE v.descripcion = :descripcion")})
public class Vidrio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vidrio")
    private Integer idVidrio;
    @Basic(optional = false)
    @Column(name = "grosor")
    private double grosor;
    @Basic(optional = false)
    @Column(name = "largo")
    private double largo;
    @Basic(optional = false)
    @Column(name = "ancho")
    private double ancho;
    @Basic(optional = false)
    @Column(name = "precio")
    private double precio;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVidrio")
    private Set<DetalleCotizacion> detalleCotizacionSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVidrio")
    private Set<DetalleFactura> detalleFacturaSet;

    public Vidrio() {
    }

    public Vidrio(Integer idVidrio, double grosor, double largo, double ancho, double precio, String descripcion) {
        this.idVidrio = idVidrio;
        this.grosor = grosor;
        this.largo = largo;
        this.ancho = ancho;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Vidrio{" + "idVidrio=" + idVidrio + ", grosor=" + grosor + ", largo=" + largo + ", ancho=" + ancho + ", precio=" + precio + ", descripcion=" + descripcion + ", detalleCotizacionSet=" + detalleCotizacionSet + ", detalleFacturaSet=" + detalleFacturaSet + '}';
    }
    
    
    
}
