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
public class VistaSimulacionController implements Initializable {
    @FXML
    private Button residentes;
    @FXML
    private Button visitantes;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void vistaResidente(MouseEvent event) {
        try{
        FXMLLoader loader = new FXMLLoader(App.class.getResource("simulacion_residentes.fxml"));
        Parent viewSimulacion = loader.load();
        App.setRoot(viewSimulacion);
        VistaSimulacionController principalController = loader.getController();
        }catch(IOException ex){
            System.out.println("No se ha podido cargar la vista");
            System.out.println("VistaPrincipal.fxml");
        }catch(RuntimeException ex){
            System.out.println("");   
        }
    }

    @FXML
    private void vistaVisitante(MouseEvent event) {
        try{
        FXMLLoader loader = new FXMLLoader(App.class.getResource("VistaSimulacionVisitante.fxml"));
        Parent viewSimulacion = loader.load();
        App.setRoot(viewSimulacion);
        VistaSimulacionController principalController = loader.getController();
        }catch(IOException ex){
            System.out.println("No se ha podido cargar la vista");
            System.out.println("VistaSimulacionVisitante.fxml");
        }catch(RuntimeException ex){
            System.out.println("");   
        }
        

    }
     
}
