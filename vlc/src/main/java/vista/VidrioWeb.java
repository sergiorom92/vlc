/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import co.com.session.VidrioFacade;
import java.util.ArrayList;
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

public class VidrioWeb {

    @EJB
    private VidrioFacade vf;

    private Integer idVidrio;
    private double largo;
    private double ancho;
    private double grosor;
    private double precio;
    private String descripcion;

    public Integer getIdVidrio() {
        return idVidrio;
    }

    public void setIdVidrio(Integer idVidrio) {
        this.idVidrio = idVidrio;
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

    public double getGrosor() {
        return grosor;
    }

    public void setGrosor(double grosor) {
        this.grosor = grosor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void guardar() {
        try {

            vf.guardar(largo, ancho, grosor, precio, descripcion);

        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    

}
