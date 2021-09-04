/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author EVELYN
 */
public class Casa implements Serializable {
    private Coordenada coordenadas;
    private String manzana;
    private String villa;
    private String propietario;
    private String imagePath;
    private boolean controlador;

    public Casa(Coordenada coordenadas, String manzana, String villa, String propietario, String imagePath) {
        this.coordenadas = coordenadas;
        this.manzana = manzana;
        this.villa = villa;
        this.propietario = propietario;
        this.imagePath = imagePath;
    }

    public Casa(Coordenada coordenadas, String manzana, String villa, String imagePath) {
        this.coordenadas = coordenadas;
        this.manzana = manzana;
        this.villa = villa;
        this.imagePath = imagePath;
        propietario = "";
        controlador = false;
    }

    public Coordenada getCoordenadas() {
        return coordenadas;
    }

    public String getManzana() {
        return manzana;
    }

    public String getVilla() {
        return villa;
    }

    public String getPropietario() {
        return propietario;
    }

    public String getImagePath() {
        return imagePath;
    }

    public boolean getControlador() {
        return controlador;
    }

    public void setControlador(boolean controlador) {
        this.controlador = controlador;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    @Override
    public String toString() {
        return "Casa{" + "coordenadas=" + coordenadas + ", manzana=" + manzana + ", villa=" + villa + ", propietario=" + propietario + ", imagePath=" + imagePath + '}';
    }
    
    
}
