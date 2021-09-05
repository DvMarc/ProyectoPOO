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
public class Residente extends Usuario implements Serializable{
    
    private String nombreResidente;
    private String correo;
    private String mz;
    private String villa;
    private String pin;
    private String genero;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Visitante> visitantes;
    private ArrayList<Visita> visitas;

    public Residente(String user, String contrasenia, String nombreResidente, String correo, String pin,String mz, String villa, 
            String genero) {
        super(user, contrasenia);
        this.nombreResidente = nombreResidente;
        this.correo = correo;
        this.mz = mz;
        this.villa = villa;
        this.pin = pin;
        this.genero = genero;
        vehiculos = new ArrayList<>();
        visitantes = new ArrayList<>();
        visitas = new ArrayList<>();
    }
    
    public Residente(String user, String contrasenia, String nombreResidente, String correo, String pin, 
            String genero){
        super(user, contrasenia);
        this.correo=correo;
        this.nombreResidente=nombreResidente;
        this.pin=pin;
        this.genero=genero;
        vehiculos = new ArrayList<>();
        visitantes = new ArrayList<>();
        visitas = new ArrayList<>();
    }
    public String getNombre(){
        return nombreResidente;
    }
    public String getCorreo(){
        return correo;
    }
    public String getPin(){
        return pin;
    }
    @Override
    public String getUser(){
        return super.getUser();
    }
    public void setPin(String pin){
        this.pin=pin;
    }
    public void registrarVehiculo(String matricula){
        Vehiculo vehiculo = new Vehiculo(matricula, nombreResidente);
        vehiculos.add(vehiculo);
        VehiculosData.agregarVehiculo(nombreResidente, matricula);
    }
    public ArrayList<Vehiculo> getVehiculos(){
        return vehiculos;
    }
    public void registrarVisitante(Visitante visitante){
        visitantes.add(visitante);
    }
    public void registrarVisita(Visita visita){
        visitas.add(visita);
    }
}

