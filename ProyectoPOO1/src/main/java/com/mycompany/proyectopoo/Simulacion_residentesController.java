/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectopoo;

import Usuario.Residente;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class Simulacion_residentesController implements Initializable {

    @FXML
    private Button butonPeaton;
    @FXML
    private Button butonVehiculo;
    @FXML
    private BorderPane panePrincipal;
    @FXML
    private Residente residente;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        butonVehiculo.setOnMouseClicked((MouseEvent event)->{
            event.consume();
            try{
                FXMLLoader loader = new FXMLLoader(App.class.getResource("VistaSimuIngresoVehiculo.fxml"));
                Parent root = loader.load();
                panePrincipal.setCenter(root);
                VistaSimuIngresoVehiculoController vistaVehi = loader.getController();

            } catch (IOException ex) {
                System.out.println("No se pudo cargar VistaInformacion.fxml");
            }
        });
        butonPeaton.setOnMouseClicked((MouseEvent event)->{
            event.consume();

            try{
                FXMLLoader loader = new FXMLLoader(App.class.getResource("VistaIngresoPeaton.fxml"));
                Parent root = loader.load();
                panePrincipal.setCenter(root);
                VistaIngresoPeatonController vistaPea = loader.getController();

                
            } catch (IOException ex) {
                System.out.println("No se pudo cargar VistaInformacion.fxml");
            } 
        });
        
      
            }
      
        // TODO
    }   

    

