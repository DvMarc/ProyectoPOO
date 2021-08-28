/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class Visitante implements Serializable{
    
    private ArrayList<Visita> visitas;
    private String cedula;
    private String nombre;
    private String correo;
   
    public Visitante(String cedula,String nombre,String correo){
        this.cedula=cedula;
        this.nombre=nombre;
        this.correo= correo;
        visitas = new ArrayList<>();
    }
    
    public String getCedula() {
        return cedula;
    }
    
    public String getNombre() {
        return nombre;
    }
}
