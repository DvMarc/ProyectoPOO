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
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class VistaSimulacionVisitanteController implements Initializable {

    @FXML
    private Button ButtonConCodigo;
    @FXML
    private Button ButtonSinCodigo;
    @FXML
    private BorderPane panePrincipal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ButtonConCodigo.setOnMouseClicked((MouseEvent event)->{
            event.consume();

            try{
                FXMLLoader loader = new FXMLLoader(App.class.getResource("VistaCodigoAcceso.fxml"));
                Parent root = loader.load();
                panePrincipal.setCenter(root);
                VistaCodigoAccesoController vistaConCodi = loader.getController();

                
            } catch (IOException ex) {
                System.out.println("No se pudo cargar VistaInformacion.fxml");
            } 
        });
        ButtonSinCodigo.setOnMouseClicked((MouseEvent event)->{
            event.consume();

            try{
                FXMLLoader loader = new FXMLLoader(App.class.getResource("VistasSinCodigoAcceso.fxml"));
                Parent root = loader.load();
                panePrincipal.setCenter(root);
                VistasSinCodigoAccesoController vistaSinCodi = loader.getController();

                
            } catch (IOException ex) {
                System.out.println("No se pudo cargar VistaInformacion.fxml");
            } 
        });
        
        
        // TODO
    }    
    
}
