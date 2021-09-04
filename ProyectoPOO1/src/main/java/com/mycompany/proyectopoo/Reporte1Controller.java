/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectopoo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.MenuItem;

/**
 * FXML Controller class
 *
 * @author EVELYN
 */
public class Reporte1Controller implements Initializable {

    @FXML
    private MenuItem mapaCiudadela;
    @FXML
    private MenuItem rp1;
    @FXML
    private MenuItem rp2;
    @FXML
    private MenuItem cerrarsesion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mapaCiudadela.setOnAction(new EventHandler<ActionEvent>(){
                public void handle(ActionEvent t){
                    try{
                        FXMLLoader loader = new FXMLLoader(App.class.getResource("MenuAdministrador.fxml"));
                        Parent viewPrincipal = loader.load();
                        App.setRoot(viewPrincipal);
                        MenuAdministradorController adminController = loader.getController();
                    }catch(IOException ex){
                        System.out.println("No se ha podido cargar la vista");
                        System.out.println("MenuAdministrador.fxml");
                    }catch(RuntimeException ex){
                        System.out.println("");   
                    }
                }
            });
            rp1.setOnAction(new EventHandler<ActionEvent>(){
                public void handle(ActionEvent t){
                    try{
                        FXMLLoader loader = new FXMLLoader(App.class.getResource("Reporte1.fxml"));
                        Parent viewPrincipal = loader.load();
                        App.setRoot(viewPrincipal);
                        Reporte1Controller adminController = loader.getController();
                    }catch(IOException ex){
                        System.out.println("No se ha podido cargar la vista");
                        System.out.println("Reporte1.fxml");
                    }catch(RuntimeException ex){
                        System.out.println("");   
                    }
                }
            });
            rp2.setOnAction(new EventHandler<ActionEvent>(){
                public void handle(ActionEvent t){
                    try{
                        FXMLLoader loader = new FXMLLoader(App.class.getResource("Reporte2.fxml"));
                        Parent viewPrincipal = loader.load();
                        App.setRoot(viewPrincipal);
                        Reporte2Controller adminController = loader.getController();
                    }catch(IOException ex){
                        System.out.println("No se ha podido cargar la vista");
                        System.out.println("Reporte2.fxml");
                    }catch(RuntimeException ex){
                        System.out.println("");   
                    }
                }
            });
    }    
    
}
