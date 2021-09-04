/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author ALICE
 */
public class VehiculosData {
    static String ruta = "archivos/vehiculos.dat";
    private static ArrayList<Vehiculo> vehiculos;
    
    public static void escribirVehiculo(ArrayList<Vehiculo> vehiculos){
        try (ObjectOutputStream objOutputStream =
            new ObjectOutputStream(new FileOutputStream(ruta))){
            objOutputStream.writeObject(vehiculos);
        }catch(IOException ex){
            ex.getMessage();
        }
    }
    public static ArrayList<Vehiculo> leerVehiculos() 
        throws ClassNotFoundException{
        try(ObjectInputStream objInputStream 
                = new ObjectInputStream(new FileInputStream(ruta))) {
          vehiculos = (ArrayList<Vehiculo>)objInputStream.readObject();
        }catch(IOException e2){
            System.out.println("Error clase no serializada");
        }
        return vehiculos;
    }
    public static void agregarVehiculo(String matricula, String propietario){
        Vehiculo v = new Vehiculo(propietario, matricula);
        vehiculos.add(v);
        escribirVehiculo(vehiculos);
    }
    public static void main(String args[]){
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        Vehiculo v1 = new Vehiculo("AAA000", "david");
        Vehiculo v2 = new Vehiculo("AAA222", "david");
        vehiculos.add(v2);
        vehiculos.add(v1);
        escribirVehiculo(vehiculos);
    }
}
