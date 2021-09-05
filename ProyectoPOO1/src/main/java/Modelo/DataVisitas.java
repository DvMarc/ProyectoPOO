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
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author EVELYN
 */
public class DataVisitas {
    static String ruta = "archivos/visitas.dat";
    
    public static void registrarVisita(ArrayList<RegistrarVisita> lista){
        try (ObjectOutputStream objOutputStream =
            new ObjectOutputStream(new FileOutputStream(ruta))){
            objOutputStream.writeObject(lista);
            System.out.println("Se esta reescribiendo el archivo visitas");
        }catch(IOException ex){
            ex.getMessage();
        }
    }


    public static ArrayList<RegistrarVisita> leerVisitas()
        throws IOException, ClassNotFoundException{
        ArrayList<RegistrarVisita> visitas = null;
        try(ObjectInputStream objInputStream 
                = new ObjectInputStream(new FileInputStream(ruta))) {
          visitas = (ArrayList<RegistrarVisita>)objInputStream.readObject();
        }
        return visitas;
    }
    
    public static void main(String[] args) throws IOException{
        ArrayList<RegistrarVisita> lista = new ArrayList<RegistrarVisita>();
        lista.add(new RegistrarVisita(LocalDateTime.of(2021,1,2,4,5,6),"residente"));
        lista.add(new RegistrarVisita(LocalDateTime.of(2021,1,2,4,7,6),"residente"));
        lista.add(new RegistrarVisita(LocalDateTime.of(2021,1,2,4,7,6),"visitante"));
        lista.add(new RegistrarVisita(LocalDateTime.of(2021,1,2,5,5,6),"residente"));
        lista.add(new RegistrarVisita(LocalDateTime.of(2021,1,2,5,5,6),"visitante"));
        lista.add(new RegistrarVisita(LocalDateTime.of(2021,1,2,6,5,6),"visitante"));
        lista.add(new RegistrarVisita(LocalDateTime.of(2021,1,2,6,5,6),"visitante"));
        lista.add(new RegistrarVisita(LocalDateTime.of(2021,1,2,6,6,6),"visitante"));
        lista.add(new RegistrarVisita(LocalDateTime.of(2021,1,2,6,9,6),"visitante"));
        lista.add(new RegistrarVisita(LocalDateTime.of(2021,1,2,7,5,6),"residente"));
        lista.add(new RegistrarVisita(LocalDateTime.of(2021,1,2,7,5,6),"residente"));
        registrarVisita(lista);
    }
}
