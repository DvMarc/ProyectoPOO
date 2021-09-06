/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private LocalDateTime fechaIngreso;
    private String codigoAcceso;
    private String residente;
    private String estado;
    
   
    public Visitante(String cedula,String nombre,String correo){
        this.cedula=cedula;
        this.nombre=nombre;
        this.correo= correo;
    }
    public Visitante(String residente, String cedula,String nombre,String correo,LocalDateTime
            fecha, String codigo, String estado){
        this(cedula, nombre, correo);
        this.residente = residente;
        codigoAcceso = codigo;
        fechaIngreso = fecha;
        this.estado = estado;
    }
    
    public String getCedula() {
        return cedula;
    }
    public String getNombre() {
        return nombre;
    }
    public String getCodigo(){
        return codigoAcceso;
    }
    public String getFecha(){
        LocalDate fecha = fechaIngreso.toLocalDate();
        return fecha.toString();
    }
    public String getUsuario(){
        return residente;
    }
}
