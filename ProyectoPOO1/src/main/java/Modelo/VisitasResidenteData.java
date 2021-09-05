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
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author ALICE
 */
public class VisitasResidenteData implements Serializable{
    static String ruta = "archivos/vehiculos.dat";
    private static ArrayList<Visitante> visitas;
    
    public static void escribirVisitas(ArrayList<Visitante> visitas){
        try (ObjectOutputStream objOutputStream =
            new ObjectOutputStream(new FileOutputStream(ruta))){
            objOutputStream.writeObject(visitas);
        }catch(IOException ex){
            ex.getMessage();
        }
    }
    public static ArrayList<Visitante> leerVisitas() 
        throws ClassNotFoundException{
        try(ObjectInputStream objInputStream 
                = new ObjectInputStream(new FileInputStream(ruta))) {
          visitas = (ArrayList<Visitante>)objInputStream.readObject();
        }catch(IOException e2){
            System.out.println("Error clase no serializada");
        }
        return visitas;
    }
    public static void agregarVisita(Visitante visitante){
        visitas.add(visitante);
    }
    public static void main(String args[]){
        
    }
}
