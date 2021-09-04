/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectopoo;

import Usuario.Residente;
import Usuario.Usuario;
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
    
    private Residente residente;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
                  
        verInformacion.setOnMouseClicked((MouseEvent event)->{
            event.consume();
            try{
                FXMLLoader loader = new FXMLLoader(App.class.getResource("VistaInformacion.fxml"));
                Parent root = loader.load();
                panePrincipal.setCenter(root);
                VistaInformacionController vistaInfo = loader.getController();
                vistaInfo.setResidente(residente);
                
            } catch (IOException ex) {
                System.out.println("No se pudo cargar VistaInformacion.fxml");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        });
        btnVisitantes.setOnMouseClicked((MouseEvent event)->{
            event.consume();
            try{
                FXMLLoader loader = new FXMLLoader(App.class.getResource("vistaVisitante.fxml"));
                Parent root = loader.load();
                panePrincipal.setCenter(root);
                VistaVisitanteController vistaVisit = loader.getController();
                vistaVisit.setResidente(residente);
            } catch (IOException ex) {
                System.out.println("No se pudo cargar vistaVisitantes.fxml");
            }
        });
        btnVehiculos.setOnMouseClicked((MouseEvent event)->{
           try{
                FXMLLoader loader = new FXMLLoader(App.class.getResource("vistaVehiculos.fxml"));
                Parent root = loader.load();
                panePrincipal.setCenter(root);
                VistaVehiculosController vistaVehiculos = loader.getController();
                vistaVehiculos.setResidente(residente);
            } catch (IOException ex) {
                System.out.println("No se pudo cargar vistaVehiculos.fxml");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        });
    } 
    
    public void setUsuario(Usuario user){
      if(user instanceof Residente){
          residente = (Residente) user;
      }
        
    }
    
    
}
