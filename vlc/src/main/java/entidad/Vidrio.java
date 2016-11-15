/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sergio
 */
@Entity
@Table(name = "vidrio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vidrio.findAll", query = "SELECT v FROM Vidrio v"),
    @NamedQuery(name = "Vidrio.findByIdVidrio", query = "SELECT v FROM Vidrio v WHERE v.idVidrio = :idVidrio"),
    @NamedQuery(name = "Vidrio.findByGrosor", query = "SELECT v FROM Vidrio v WHERE v.grosor = :grosor"),
    @NamedQuery(name = "Vidrio.findByLargo", query = "SELECT v FROM Vidrio v WHERE v.largo = :largo"),
    @NamedQuery(name = "Vidrio.findByAncho", query = "SELECT v FROM Vidrio v WHERE v.ancho = :ancho"),
    @NamedQuery(name = "Vidrio.findByDescripcion", query = "SELECT v FROM Vidrio v WHERE v.descripcion = :descripcion"),
    @NamedQuery(name = "Vidrio.findByPrecio", query = "SELECT v FROM Vidrio v WHERE v.precio = :precio")})
public class Vidrio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vidrio")
    private Integer idVidrio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "grosor")
    private double grosor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "largo")
    private double largo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ancho")
    private double ancho;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private double precio;

    public Vidrio() {
    }

    public Vidrio(Integer idVidrio, double grosor, double largo, double ancho, String descripcion, double precio) {
        this.idVidrio = idVidrio;
        this.grosor = grosor;
        this.largo = largo;
        this.ancho = ancho;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Integer getIdVidrio() {
        return idVidrio;
    }

    public void setIdVidrio(Integer idVidrio) {
        this.idVidrio = idVidrio;
    }

    public double getGrosor() {
        return grosor;
    }

    public void setGrosor(double grosor) {
        this.grosor = grosor;
    }

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVidrio != null ? idVidrio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vidrio)) {
            return false;
        }
        Vidrio other = (Vidrio) object;
        if ((this.idVidrio == null && other.idVidrio != null) || (this.idVidrio != null && !this.idVidrio.equals(other.idVidrio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vidrio{" + "idVidrio=" + idVidrio + ", grosor=" + grosor + ", largo=" + largo + ", ancho=" + ancho + ", descripcion=" + descripcion + ", precio=" + precio + '}';
    }

    

}
