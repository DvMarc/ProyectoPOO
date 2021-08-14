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
    private Casa casa;
    private String pin;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Visitante> visitantes;
    
    
    public Residente(String nombreResidente, String correo, String pin, 
            Casa casa, String user, String contrasenia){
        super(user, contrasenia);
        this.casa=casa;
        this.correo=correo;
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
