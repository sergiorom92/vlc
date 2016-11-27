/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "cotizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cotizacion.findAll", query = "SELECT c FROM Cotizacion c")
    ,
    @NamedQuery(name = "Cotizacion.findByCotizacionId", query = "SELECT c FROM Cotizacion c WHERE c.cotizacionId = :cotizacionId")})
public class Cotizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cotizacion_id")
    private Integer cotizacionId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cotizacion")
    private DetalleCotizacion detalleCotizacion;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne(optional = false)
    private Persona idPersona;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false)
    private Empleado idEmpleado;

    public Cotizacion() {
    }
    
    
    
}
