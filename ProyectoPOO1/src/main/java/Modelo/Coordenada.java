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
public class Coordenada implements Serializable {
    private int coordenadaX;
    private int coordenadaY;

    public Coordenada(int coordenadaX, int coordenadaY) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }

    public int getCoordenadaX() {
        return coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }

    @Override
    public String toString() {
        return "Coordenada{" + "coordenadaX=" + coordenadaX + ", coordenadaY=" + coordenadaY + '}';
    }
    
}
