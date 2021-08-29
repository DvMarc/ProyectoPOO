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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author ALICE
 */
public class VistaResidenteController implements Initializable {

    @FXML
    private BorderPane panePrincipal;
    @FXML
    private Button verInformacion;
    @FXML
    private Button btnVisitantes;
    @FXML
    private Button btnVehiculos;
    @FXML
    private ImageView logo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        verInformacion.setOnMouseClicked((MouseEvent event)->{
            event.consume();
            cargarOpcion("vistaInformacion.fxml");
        });
        btnVisitantes.setOnMouseClicked((MouseEvent event)->{
            event.consume();
            cargarOpcion("vistaVisitante.fxml");
        });
        btnVehiculos.setOnMouseClicked((MouseEvent event)->{
           cargarOpcion("vistaVehiculos.fxml"); 
        });
    }    
    public void cargarOpcion(String vista){
        Parent root = null;
        try{
            root = FXMLLoader.load(getClass().getResource(vista));
        }catch(IOException ex){
            
        }
        panePrincipal.setCenter(root);
    }
     
    
}
