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
 * @author EVELYN
 */
public class CasasData {
    static String ruta = "archivos/casas.dat";
    
    public static void escribirCasas(ArrayList<Casa> casas){
        try (ObjectOutputStream objOutputStream =
            new ObjectOutputStream(new FileOutputStream(ruta))){
            objOutputStream.writeObject(casas);
            System.out.println("Se esta reescribiendo el archivo casas");
        }catch(IOException ex){
            ex.getMessage();
        }
    }


    public static ArrayList<Casa>leerCasas() 
        throws IOException, ClassNotFoundException{
        ArrayList<Casa> casas = null;
        try(ObjectInputStream objInputStream 
                = new ObjectInputStream(new FileInputStream(ruta))) {
          casas = (ArrayList<Casa>)objInputStream.readObject();
        }
        return casas;
    }
    
    public static void main(String[] args) throws IOException{
        ArrayList<Casa> casas = new ArrayList<Casa>();
        casas.add(new Casa(new Coordenada(111,20),"6","1","casa11.png"));
        casas.add(new Casa(new Coordenada(551,20),"5","2","casa1.png"));
        casas.add(new Casa(new Coordenada(621,280),"3","3","casa3.png"));
        casas.add(new Casa(new Coordenada(41,280),"1","4","casa2.png"));
        escribirCasas(casas);
    }
}
