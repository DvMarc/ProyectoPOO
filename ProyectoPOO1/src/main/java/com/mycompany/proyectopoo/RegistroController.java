/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectopoo;

import Modelo.Casa;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
    
    public void Registrar(MouseEvent e){
        String nombre = TANombre.getText();
        String correo = TACorreo.getText();
        String genero = CBGenero.getValue();
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
