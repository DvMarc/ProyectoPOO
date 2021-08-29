/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectopoo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author gene
 */
public class VistaInformacionController implements Initializable {

    @FXML
    private Pane paneInformacion;
    @FXML
    private ImageView imgResidente;
    @FXML
    private Label mz;
    @FXML
    private Label nombreResidente;
    @FXML
    private Label correoResidente;
    @FXML
    private Label villa;
    @FXML
    private Label pinActual;
    @FXML
    private Button cambiarPin;
    @FXML
    private TextField txtPin;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}
