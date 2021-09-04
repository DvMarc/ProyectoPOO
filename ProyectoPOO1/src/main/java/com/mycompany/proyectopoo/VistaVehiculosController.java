/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectopoo;

import Modelo.Vehiculo;
import Modelo.VehiculosData;
import Usuario.Residente;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author gene
 */
public class VistaVehiculosController implements Initializable {

    @FXML
    private TextField nuevaMatricula;
    @FXML
    private Label error;
    @FXML
    private Label vehiculos;
    @FXML
    private Button registrar;
    
    ArrayList<Vehiculo> vehiculosRegistrados; 
    
    private Residente residente;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    public void setResidente(Residente user) throws ClassNotFoundException{
        residente = user;
        vehiculosRegistrados();
    }
    public void vehiculosRegistrados() throws ClassNotFoundException{
        try{
        vehiculosRegistrados = VehiculosData.leerVehiculos();
        String nombre = residente.getNombre();
        String str= "";
        
        if(vehiculosRegistrados!=null | !vehiculosRegistrados.isEmpty()|nombre!=null){
            for(Vehiculo v : vehiculosRegistrados){
                if(v.getNombre().equals(nombre)){
                    str = str + v.getMatricula()+" - ";
                }
                
            } 
        }else{
            str = "Sin Vehiculos Registrados";
        }
        vehiculos.setText(str);
        }catch(ClassNotFoundException ex){
            System.out.println("Clase no encontrada");
        }
    }

    @FXML
    private void registrarVehiculo(MouseEvent event) {
        String matricula = nuevaMatricula.getText();
        if(matricula.isEmpty()){
            error.setText("Matricula no puede ser vacia");
        }else{
            matricula = matricula.toLowerCase();
            residente.registrarVehiculo(matricula);
        }
    }
}
