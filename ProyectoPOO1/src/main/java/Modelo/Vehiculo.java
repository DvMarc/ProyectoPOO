/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author ALICE
 */
public class Vehiculo implements Serializable{

    private String matricula;
    private String nombrePropietario;
    
    public Vehiculo(String matricula,String nombrePropietario ){
        this.matricula=matricula;
        this.nombrePropietario= nombrePropietario;
    }

    public String getMatricula() {
        return matricula;
    }
    public String getNombre(){
        return nombrePropietario;
    }
}

