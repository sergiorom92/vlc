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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sergio
 */
@Entity
@Table(name = "detalle_factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleFactura.findAll", query = "SELECT d FROM DetalleFactura d")
    ,
    @NamedQuery(name = "DetalleFactura.findByFacturaId", query = "SELECT d FROM DetalleFactura d WHERE d.facturaId = :facturaId")})
public class DetalleFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "factura_id")
    private Integer facturaId;
    @JoinColumn(name = "id_vidrio", referencedColumnName = "id_vidrio")
    @ManyToOne(optional = false)
    private Vidrio idVidrio;
    @JoinColumn(name = "factura_id", referencedColumnName = "factura_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Factura factura;

    public DetalleFactura() {
    }

    public Integer getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(Integer facturaId) {
        this.facturaId = facturaId;
    }

    public Vidrio getIdVidrio() {
        return idVidrio;
    }

    public void setIdVidrio(Vidrio idVidrio) {
        this.idVidrio = idVidrio;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public DetalleFactura(Integer facturaId, Vidrio idVidrio) {
        this.facturaId = facturaId;
        this.idVidrio = idVidrio;
    }

    public DetalleFactura(Integer facturaId, Vidrio idVidrio, Factura factura) {
        this.facturaId = facturaId;
        this.idVidrio = idVidrio;
        this.factura = factura;
    }

    @Override
    public String toString() {
        return "DetalleFactura{" + "facturaId=" + facturaId + ", idVidrio=" + idVidrio + ", factura=" + factura + '}';
    }

    
}
