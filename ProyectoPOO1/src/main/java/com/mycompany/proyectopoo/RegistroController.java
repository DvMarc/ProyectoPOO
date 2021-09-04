/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectopoo;

import Modelo.Casa;
import Modelo.CasasData;
import Modelo.Correo;
import Usuario.Residente;
import Usuario.Usuario;
import Usuario.UsuariosData;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author EVELYN
 */
public class RegistroController implements Initializable {

    @FXML
    private TextField TANombre;
    @FXML
    private TextField TACorreo;
    @FXML
    private ComboBox<String> CBGenero;
    @FXML
    private Button bRegistrar;
    @FXML
    private Button bCancelar;
    private Casa casa;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Casa> casas;
    
    public void setUsuarios(){
        try{
            usuarios=UsuariosData.leerUsuarios();
            casas=CasasData.leerCasas();
        }catch(ClassNotFoundException e1){
                System.out.println("Clase incompatible");
        }catch(IOException e2){
            System.out.println("Clase no serializada");
        }
    }
    
    public boolean comprobarUsername(String username){
        for(Usuario u:usuarios){
            if(username.equals(u.getUser())){
                return false;
            }
        }
        return true;
    }
    
    public boolean comprobarPin(String pin){
        for(Usuario u:usuarios){
            if(u instanceof Residente){
                Residente r = (Residente) u;
                if(pin.equals(r.getPin())){
                    return false;
                }
            }
        }
        return true;
    }
    
    public void cancelar(MouseEvent e){
        try{
        FXMLLoader loader = new FXMLLoader(App.class.getResource("MenuAdministrador.fxml"));
        Parent menua = loader.load();
        App.setRoot(menua);
        MenuAdministradorController principalController = loader.getController();
        }catch(IOException ex){
            System.out.println("No se ha podido cargar la vista");
            System.out.println("MenuAdministrador.fxml");
        }
    }
    
    public String generarUsername(String nombre){
        Random r = new Random();
        String username= "";
        int valor = r.nextInt(nombre.length());
        for (int i=0; i<=valor; i++){
            username+=nombre.charAt(i);
        }
        username+=String.valueOf(r.nextInt(1000));
        return username;
    }
    
    public String generarPin(){
        Random r = new Random();
        String pin = "";
        for(int i =0; i<=3; i++){
            pin += String.valueOf(r.nextInt(10));
        }
        return pin;
    }
    
    public void Registrar(MouseEvent e){
        String nombre = TANombre.getText();
        String correo = TACorreo.getText();
        String genero = CBGenero.getValue();
        String username = "";
        String pin = "";
        boolean condicionUsername = false;
        boolean condicionPin = false;
        while(!condicionUsername){
            username=generarUsername(nombre);
            condicionUsername = comprobarUsername(username);
        }
        while(!condicionPin){
            pin=generarPin();
            condicionPin = comprobarPin(pin);
        }
        Residente r = new Residente(username,username,nombre,correo,pin,casa.getVilla(),genero);
        usuarios.add(r);
        UsuariosData.escribirUsuario(usuarios);
        System.out.println(username);
        for(Casa c:casas){
            if(c.getVilla().equals(casa.getVilla())){
                c.setPropietario(username);                
            }
        }
        CasasData.escribirCasas(casas);
        Thread t = new Thread(new Correo.enviarCorreo(correo,"Datos para el ingreso a la ciudadelo y al sistema", r.toString()));
        t.run();
        try{
            FXMLLoader loader = new FXMLLoader(App.class.getResource("MenuAdministrador.fxml"));
            Parent viewPrincipal = loader.load();
            App.setRoot(viewPrincipal);
            MenuAdministradorController adminController = loader.getController();
            }catch(IOException ex){
            System.out.println("No se ha podido cargar la vista");
            System.out.println("MenuAdministrador.fxml");
            }
    }
    

    public void setCasa(Casa casa) {
        this.casa = casa;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setUsuarios();
        try{
        ArrayList<String> generos = new ArrayList<>();
        generos.add("Masculino");
        generos.add("Femenino");
        CBGenero.getItems().addAll(generos);
        }catch(Exception ex){
          ex.printStackTrace();
        } 
    }    
    
}