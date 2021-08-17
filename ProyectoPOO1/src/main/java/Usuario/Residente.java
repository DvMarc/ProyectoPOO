/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import Modelo.*;
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
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Visitante> visitantes;
    
    
    public Residente(String user, String contrasenia, String nombreResidente, String correo, String pin, 
            String casa){
        super(user, contrasenia);
        this.correo=correo;
        this.casa=casa;
        this.nombreResidente=nombreResidente;
        this.pin=pin;
        vehiculos = new ArrayList<>();
        visitantes = new ArrayList<>();
    }
    
    public void setPin(String pin){
        this.pin=pin;
    }
    public void registrarVehiculo(){
        
    }
    public void registrarVisitante(){
        
    }
}
