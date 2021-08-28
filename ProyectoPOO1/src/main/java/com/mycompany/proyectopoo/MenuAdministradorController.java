/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectopoo;

import Modelo.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextFlow;

/**
 * FXML Controller class
 *
 * @author EVELYN
 */
public class MenuAdministradorController implements Initializable {
    private ArrayList<Casa> casas = null;
    
    @FXML
    private Pane panelMapa;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
            casas = CasasData.leerCasas();
            for (Casa c: casas){
                ImageView imgview = null;
                InputStream input = App.class.getResource(c.getImagePath()).openStream();
                Image img = new Image(input, 50, 50, true, true);
                imgview = new ImageView(img);
                imgview.setLayoutX(c.getCoordenadas().getCoordenadaX());
                imgview.setLayoutY(c.getCoordenadas().getCoordenadaY());
                panelMapa.getChildren().addAll(imgview);
                
                imgview.setOnMouseExited((MouseEvent ev) -> {
                      final Tooltip tp = new Tooltip("Manzana: "+c.getManzana()+"\nVilla: "+c.getVilla()+"\nPropietario: "+c.getPropietario());
                      Tooltip.install(panelMapa, tp);
                    }
                  );
                
                  imgview.setOnMouseClicked((MouseEvent ev) -> {
                      if (c.getPropietario().isEmpty()) {
                        try{
                          FXMLLoader loader = new FXMLLoader(App.class.getResource("Registro.fxml"));
                          Parent registro = loader.load();
                          App.setRoot(registro);
                          RegistroController registroController = loader.getController();
                          registroController.setCasa(c);
                        }catch(IOException ex){
                            System.out.println("No se ha podido cargar la vista");
                            System.out.println("Registro.fxml");
                        }
                      }
                    }
                  );
            }
        }catch(ClassNotFoundException e){
            System.out.println("Clase incompatible");
        }catch(IOException e1){
            System.out.println("Error clase no serializada");
        }
    }
    
}
