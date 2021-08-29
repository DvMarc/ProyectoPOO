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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author gene
 */
public class VistaVisitanteController implements Initializable {

 
    @FXML
    private TextField ciVisitante;
    @FXML
    private TextField correoVisitante;
    @FXML
    private DatePicker fechaIngreso;
    @FXML
    private ComboBox<?> horaIngreso;
    @FXML
    private TextField nombreVisitante;
    @FXML
    private Button registrarVisitante;
   /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
