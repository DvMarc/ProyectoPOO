/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectopoo;

import Modelo.Casa;
import Modelo.CasasData;
import Modelo.Sistema;
import Usuario.Residente;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
    @FXML
    private Label error;
    
    private Residente residente;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }   
    public void setResidente(Residente residente) throws IOException, ClassNotFoundException{
        this.residente = residente;
        actualizarInformacion();
    }
    public void actualizarInformacion() throws IOException, ClassNotFoundException{
        nombreResidente.setText(residente.getNombre());
        correoResidente.setText(residente.getCorreo());
        pinActual.setText(residente.getPin());
        
        try{
            ArrayList<Casa> casas = new ArrayList<>();
            casas = CasasData.leerCasas();
            for(Casa c : casas){
                if(c.getPropietario().equals(residente.getUser())){
                    villa.setText(c.getVilla());
                    mz.setText(c.getManzana());
                }
            }
        }catch(IOException ex){
            
        }
        
    }

    @FXML
    private void cambiarPin(MouseEvent event) {
        String newPin = txtPin.getText();
        if(newPin.isEmpty() | newPin.length()!=4){
            error.setText("Pin invalido");
            if(Sistema.validarPin(newPin)==false){
                error.setText("Pin debe contener solo digitos");
            }
        }else{
            residente.setPin(newPin);
        }
    }
    
    
}
