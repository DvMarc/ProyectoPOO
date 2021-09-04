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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
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
    @FXML
    private MenuItem cerrarsesion;
    @FXML
    private MenuItem mapaCiudadela;
    @FXML
    private MenuItem rp1;
    @FXML
    private MenuItem rp2;

    
    private static class Position {
        double x;
        double y;
    }
    /**
     * Initializes the controller class.
     */
    
    private void arrastrarYmover(Node node, Casa c){
        final Position pos = new Position();
    
        node.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> node.setCursor(Cursor.HAND));
        node.addEventHandler(MouseEvent.MOUSE_EXITED, event -> node.setCursor(Cursor.DEFAULT));

        node.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
                node.setCursor(Cursor.MOVE);
                event.consume();
                pos.x = event.getX();
                pos.y = event.getY();
        });
        node.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> node.setCursor(Cursor.DEFAULT));

        node.addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> {
            double distanceX = event.getX() - pos.x;
            double distanceY = event.getY() - pos.y;

            double x = node.getLayoutX() + distanceX;
            double y = node.getLayoutY() + distanceY;
            node.relocate(x, y);
            event.consume();
                 });
    }
    
    
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
                      System.out.println("en onmouseclicked");
                      System.out.println(c.getControlador());
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
                  arrastrarYmover(imgview, c);
            }
            cerrarsesion.setOnAction(new EventHandler<ActionEvent>(){
                public void handle(ActionEvent t){
                    try{
                    FXMLLoader loader = new FXMLLoader(App.class.getResource("IniciarSesion.fxml"));
                    Parent viewPrincipal = loader.load();
                    App.setRoot(viewPrincipal);
                    VistaPrincipalController principalController = loader.getController();
                    }catch(IOException ex){
                        System.out.println("No se ha podido cargar la vista");
                        System.out.println("IniciarSesion.fxml");
                    }catch(RuntimeException ex){
                        System.out.println("");   
                    }
                }
            });
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
        }catch(ClassNotFoundException e){
            System.out.println("Clase incompatible");
        }catch(IOException e1){
            System.out.println("Error clase no serializada");
        }
    }
   
}
