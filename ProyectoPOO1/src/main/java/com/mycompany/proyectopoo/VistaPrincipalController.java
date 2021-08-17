/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectopoo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author EVELYN
 */
public class VistaPrincipalController implements Initializable {

    @FXML
    private Button bIniciarSesion;
    @FXML
    private Button bSimulacion;

    
    public void iniciarSesion(MouseEvent e){
        try{
        FXMLLoader loader = new FXMLLoader(App.class.getResource("IniciarSesion.fxml"));
        Parent viewPrincipal = loader.load();
        App.setRoot(viewPrincipal);
        VistaPrincipalController principalController = loader.getController();
        }catch(IOException ex){
            System.out.println("No se ha podido cargar la vista");
            System.out.println("VistaPrincipal.fxml");
        }catch(RuntimeException ex){
            System.out.println("");   
        }
    }
    public void simulacion(MouseEvent e){
        try{
        FXMLLoader loader = new FXMLLoader(App.class.getResource("VistaSimulacion.fxml"));
        Parent viewPrincipal = loader.load();
        App.setRoot(viewPrincipal);
        VistaPrincipalController principalController = loader.getController();
        }catch(IOException ex){
            System.out.println("No se ha podido cargar la vista");
            System.out.println("VistaPrincipal.fxml");
        }catch(RuntimeException ex){
            System.out.println("");   
        }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
