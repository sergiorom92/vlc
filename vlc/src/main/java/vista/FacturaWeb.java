/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import co.com.session.DetalleFacturaFacade;
import co.com.session.EmpleadoFacade;
import co.com.session.FacturaFacade;
import co.com.session.PersonaFacade;
import co.com.session.VidrioFacade;
import entidad.Factura;
import entidad.Vidrio;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
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
public class FacturaWeb {

    @EJB
    FacturaFacade ff;
    
    @EJB
    DetalleFacturaFacade dff;

    @EJB
    PersonaFacade pf;

    @EJB
    EmpleadoFacade ef;

    @EJB
    VidrioFacade vf;

    private List<Factura> facturas;
    private List<Vidrio> vidrioCollection;
    private String idPersona;
    private String idEmpleado;
    private Integer facturaId;
    private String idEmpleadoCorte;
    private Date fecha;

    public List<Vidrio> getVidrioCollection() {
        return vidrioCollection;
    }

    public void setVidrioCollection(List<Vidrio> vidrioCollection) {
        this.vidrioCollection = vidrioCollection;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Integer getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(Integer facturaId) {
        this.facturaId = facturaId;
    }

    public String getIdEmpleadoCorte() {
        return idEmpleadoCorte;
    }

    public void setIdEmpleadoCorte(String idEmpleadoCorte) {
        this.idEmpleadoCorte = idEmpleadoCorte;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public void guardar() {
        try {
            List<Vidrio> vidrios = new LinkedList<>(vf.cargar());

            //ff.guardar(collection,ef.buscarEmpleado(idEmpleado),pf.buscarPersona(idPersona),idEmpleadoCorte,new Date(2929919));
            //ff.guardar(collection, ef.buscarEmpleado("1032479542"), pf.buscarPersona("1032479542"), "95121900948", new Date(2929919));
            Factura factura = ff.guardar(ef.buscarEmpleado("1032479542"), pf.buscarPersona("95121900948"), ef.buscarEmpleado("1032479542"), new Date(2929919));
            for (Vidrio vidrio : vidrios) {
                dff.guardar(factura.getFacturaId(), vidrio);
            }
            
        
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }

    }

    public void cargar() {

        facturas = ff.cargar();
    }

    @PostConstruct
    public void init() {
        facturas = new LinkedList<>();
        cargar();
    }

}
