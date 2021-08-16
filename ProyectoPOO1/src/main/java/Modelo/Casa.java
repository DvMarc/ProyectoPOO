/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author EVELYN
 */
public class Casa {
    private Coordenada coordenadas;
    private String manzana;
    private String villa;
    private String propietario;

    public Casa(Coordenada coordenadas, String manzana, String villa) {
        this.coordenadas = coordenadas;
        this.manzana = manzana;
        this.villa = villa;
        propietario = "";
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

    
}