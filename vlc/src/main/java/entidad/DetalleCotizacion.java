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
@Table(name = "detalle_cotizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleCotizacion.findAll", query = "SELECT d FROM DetalleCotizacion d")
    ,
    @NamedQuery(name = "DetalleCotizacion.findByCotizacionId", query = "SELECT d FROM DetalleCotizacion d WHERE d.cotizacionId = :cotizacionId")})
public class DetalleCotizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cotizacion_id")
    private Integer cotizacionId;
    @JoinColumn(name = "id_vidrio", referencedColumnName = "id_vidrio")
    @ManyToOne(optional = false)
    private Vidrio idVidrio;
    @JoinColumn(name = "cotizacion_id", referencedColumnName = "cotizacion_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Cotizacion cotizacion;

    public DetalleCotizacion() {
    }

    
}
