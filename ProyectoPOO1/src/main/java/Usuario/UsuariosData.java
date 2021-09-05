/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import Modelo.Casa;
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
public class UsuariosData {
    static String ruta = "archivos/usuarios.dat";
    
    public static void escribirUsuario(ArrayList<Usuario> usuarios){
        try (ObjectOutputStream objOutputStream =
            new ObjectOutputStream(new FileOutputStream(ruta))){
            objOutputStream.writeObject(usuarios);
            System.out.println("Se esta reescribiendo el archivo usuarios");
        }catch(IOException ex){
            ex.getMessage();
        }
    }


    public static ArrayList<Usuario>leerUsuarios() 
        throws ClassNotFoundException{
        ArrayList<Usuario> usuarios = null;
        try(ObjectInputStream objInputStream 
                = new ObjectInputStream(new FileInputStream(ruta))) {
          usuarios = (ArrayList<Usuario>)objInputStream.readObject();
        }catch(IOException e2){
            System.out.println("Error clase no serializada");
        }
        return usuarios;
    }
    
     public static void main(String[] args){
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios.add(new Administrador("admin","admin"));
        usuarios.add(new Residente("dvmarc","soyyo","david","romdmarc@espol.edu.ec","1234","6","1","Masculino"));
        escribirUsuario(usuarios);
    }

}
