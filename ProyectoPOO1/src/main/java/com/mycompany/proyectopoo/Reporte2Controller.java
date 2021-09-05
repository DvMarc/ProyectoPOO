/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectopoo;

import Modelo.DataVisitas;
import Modelo.RegistrarVisita;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author EVELYN
 */
public class Reporte2Controller implements Initializable {
    private ArrayList<RegistrarVisita> lista;
    @FXML
    private MenuItem mapaCiudadela;
    @FXML
    private MenuItem rp1;
    @FXML
    private MenuItem rp2;
    @FXML
    private MenuItem cerrarsesion;
    @FXML
    private VBox vBox;

    /**
     * Initializes the controller class.
     */
    
  

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
            lista = DataVisitas.leerVisitas();
        }catch(IOException e){
            e.getMessage();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
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
            ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
            int contadorV = 0;
            int contadorR = 0;
            
            for(RegistrarVisita rv:lista){
                if (rv.getTipo().equals("residente")){
                    contadorR+=1;
                }else if(rv.getTipo().equals("visitante")){
                    contadorV+=1;
                }
            }
            PieChart.Data dataR = new PieChart.Data("Residentes",contadorR);
            data.add(dataR);
            PieChart.Data dataV = new PieChart.Data("Visitantes",contadorV);
            data.add(dataV);
            PieChart pie = new PieChart(data);
            pie.setTitle("Ingreso total de Residentes y Visitantes");
            vBox.getChildren().add(pie);
    }    
    
}
