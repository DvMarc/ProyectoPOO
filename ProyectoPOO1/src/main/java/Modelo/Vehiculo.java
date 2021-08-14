/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author ALICE
 */
public class Vehiculo {

    private String matricula;
    private String nombrePropietario;
    
    public Vehiculo(String matricula,String nombrePropietario ){
        this.matricula=matricula;
        this.nombrePropietario= nombrePropietario;
    }

    public String getMatricula() {
        return matricula;
    }
}

