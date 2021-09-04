/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import Modelo.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author ALICE
 */
public class Residente extends Usuario{
    
    private String nombreResidente;
    private String correo;
    private String casa;
    private String pin;
    private String genero;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Visitante> visitantes;
    
    
    public Residente(String user, String contrasenia, String nombreResidente, String correo, String pin, 
            String casa, String genero){
        super(user, contrasenia);
        this.correo=correo;
        this.casa=casa;
        this.nombreResidente=nombreResidente;
        this.pin=pin;
        this.genero=genero;
        vehiculos = new ArrayList<>();
        visitantes = new ArrayList<>();
    }

    public String getNombreResidente() {
        return nombreResidente;
    }

    public String getCorreo() {
        return correo;
    }

    public String getCasa() {
        return casa;
    }

    public String getPin() {
        return pin;
    }

    public String getGenero() {
        return genero;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public ArrayList<Visitante> getVisitantes() {
        return visitantes;
    }
    
    public void setPin(String pin){
        this.pin=pin;
    }
    public void registrarVehiculo(){
        
    }
    public void registrarVisitante(){
        
    }

    @Override
    public String toString() {
        return  super.toString()+"\nSu casa es: " + casa + "\nSu pin es: "+pin;
    }
    
    
}
