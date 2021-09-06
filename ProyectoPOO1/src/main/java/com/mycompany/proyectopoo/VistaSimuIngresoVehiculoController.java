/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectopoo;

import Modelo.Vehiculo;
import Modelo.VehiculosData;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class VistaSimuIngresoVehiculoController implements Initializable {

    private TextField txtNumeroMatricula;
    ArrayList<Vehiculo> vehiculosRegistrados; 


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

            
    }

    @FXML
    private void ingresarMatricula(MouseEvent event) {
        try {
            vehiculosRegistrados = VehiculosData.leerVehiculos();
            
            String matriculaIngresada= txtNumeroMatricula.getText();
         
            for(Vehiculo v : vehiculosRegistrados){
               if (v.getMatricula().equals(matriculaIngresada)){
                  try{
                        FXMLLoader loader = new FXMLLoader(App.class.getResource("VistaAccesoConcedido.fxml"));
                        Parent viewAccesoConsedido = loader.load();
                        App.setRoot(viewAccesoConsedido);
                        VistaAccesoConcedidoController principalController = loader.getController();
                        }catch(IOException ex){
                            System.out.println("No se ha podido cargar la vista");
                            System.out.println("VistaPrincipal.fxml");
                        }catch(RuntimeException ex){
                            System.out.println("");   
                        }
            // TODO
                     }
               else{
                   try{
                        FXMLLoader loader = new FXMLLoader(App.class.getResource("VistaAccesoConcedido.fxml"));
                        Parent viewSimulacion = loader.load();
                        App.setRoot(viewSimulacion);
                        VistaAccesoConcedidoController principalController = loader.getController();
                        }catch(IOException ex){
                            System.out.println("No se ha podido cargar la vista");
                            System.out.println("VistaPrincipal.fxml");
                        }catch(RuntimeException ex){
                            System.out.println("");   
                        }
                   
               }
                 } 
    
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
    }
}
