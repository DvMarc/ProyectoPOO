/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectopoo;

import Modelo.DataVisitas;
import static Modelo.DataVisitas.leerVisitas;
import Modelo.RegistrarVisita;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author EVELYN
 */
public class Reporte1Controller implements Initializable {
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
    
    
    public static boolean filtroFechas(LocalDateTime inicio, LocalDateTime fin, LocalDateTime buscar){
        return buscar.isAfter(inicio) && buscar.isBefore(fin);
    }
    /**
     * Initializes the controller class.
     */
    
    
    
    public void datos(ArrayList<RegistrarVisita> lista, BarChart chart){
        ObservableList<XYChart.Series<String, Number>> data = FXCollections.observableArrayList();
            int contadorR = 0;
            int contadorV =0;
            int mesA=0;
            int mesD=0;
            for(RegistrarVisita rv:lista){
                if(mesA==0){
                    mesA=rv.getFechaIngreso().getHour();
                    mesD=rv.getFechaIngreso().getHour();
                    if(rv.getTipo().equals("residente")){
                        contadorR+=1;
                    }else{
                        contadorV+=1;
                    }
                }else if(mesA!=rv.getFechaIngreso().getHour()){
                    System.out.println("a la hora: "+mesD+" el ingreso de residentes y visitas respectivamente es de: : "+contadorR+", "+contadorV);
                    crearBarra(mesD, contadorR, contadorV, chart,data);
                    mesD=rv.getFechaIngreso().getHour();
                    contadorR = 0;
                    contadorV = 0;
                    mesA=rv.getFechaIngreso().getHour();
                    if(rv.getTipo().equals("residente")){
                        contadorR+=1;
                    }else{
                        contadorV+=1;
                    }
                }else if(mesA == rv.getFechaIngreso().getHour()){
                    mesD=rv.getFechaIngreso().getHour();
                    if(rv.getTipo().equals("residente")){
                        contadorR+=1;
                    }else{
                        contadorV+=1;
                    }
                }
            }
            System.out.println("a la hora: "+mesD+" el ingreso de residentes y visitas respectivamente es de: : "+contadorR+", "+contadorV);
            crearBarra(mesD, contadorR, contadorV, chart,data);
    }
    
    
    
    public void crearBarra(int mesD, int contadorR, int contadorV, BarChart chart,ObservableList<XYChart.Series<String, Number>> data){
        XYChart.Series<String, Number> hora = new XYChart.Series<>();
        hora.setName(String.valueOf(mesD));
        hora.getData().addAll(
        new XYChart.Data<>("Residentes", contadorR),
        new XYChart.Data<>("Visitantes", contadorV)
        );
        data.add(hora);
        chart.setData(data);
    }
    
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
            
            CategoryAxis xAxis = new CategoryAxis();
            xAxis.setLabel("Horas");

            NumberAxis yAxis = new NumberAxis();
            yAxis.setLabel("Cantidad de ingresos");

            BarChart chart = new BarChart(xAxis, yAxis);
            chart.setTitle("Gráfica de ingresos");
            vBox.getChildren().add(chart);
            System.out.println(lista);
            datos(lista,chart);
            /*
            
            XYChart.Series<String, Number> hora = new XYChart.Series<>();
                    hora.setName(String.valueOf(mesD));
                    hora.getData().addAll(
                        new XYChart.Data<>("Residentes", contadorR),
                        new XYChart.Data<>("Visitantes", contadorV)
                        );
                    ObservableList<XYChart.Series<String, Number>> data = FXCollections.observableArrayList();
                    data.addAll(hora);
                    chart.setData(data);
            
            XYChart.Series<String, Number> autos = new XYChart.Series<>();
            autos.setName("Autos");
            autos.getData().addAll(
                    new XYChart.Data<>("Enero", 358),
                    new XYChart.Data<>("Marzo", 54),
                    new XYChart.Data<>("Mayo", 50),
                    new XYChart.Data<>("Julio", 158));

            XYChart.Series<String, Number> computadores = new XYChart.Series<>();
            computadores.setName("Computadoras");
            computadores.getData().addAll(
                    new XYChart.Data<>("Enero", 1017),
                    new XYChart.Data<>("Marzo", 172),
                    new XYChart.Data<>("Mayo", 59),
                    new XYChart.Data<>("Julio", 285));

            XYChart.Series<String, Number> comida = new XYChart.Series<>();
            comida.setName("Comida");
            comida.getData().addAll(
                    new XYChart.Data<>("Enero", 107),
                    new XYChart.Data<>("Marzo", 128),
                    new XYChart.Data<>("Mayo", 590),
                    new XYChart.Data<>("Julio", 225));

            ObservableList<XYChart.Series<String, Number>> data = FXCollections.observableArrayList();
            data.addAll(autos, comida, computadores);
            chart.setData(data);
            int contadorR = 0;
            int contadorV =0;
            int mesA=0;
            int mesD=0;
            for(RegistrarVisita rv:lista){
                if(mesA==0){
                    mesA=rv.getFechaIngreso().getHour();
                    mesD=rv.getFechaIngreso().getHour();
                    if(rv.getTipo().equals("residente")){
                        contadorR+=1;
                    }else{
                        contadorV+=1;
                    }
                }else if(mesA!=rv.getFechaIngreso().getHour()){
                    System.out.println("a la hora: "+mesD+" el ingreso de residentes y visitas respectivamente es de: : "+contadorR+", "+contadorV);
                    mesD=rv.getFechaIngreso().getHour();
                    contadorR = 0;
                    contadorV = 0;
                    mesA=rv.getFechaIngreso().getHour();
                    if(rv.getTipo().equals("residente")){
                        contadorR+=1;
                    }else{
                        contadorV+=1;
                    }
                }else if(mesA == rv.getFechaIngreso().getHour()){
                    mesD=rv.getFechaIngreso().getHour();
                    if(rv.getTipo().equals("residente")){
                        contadorR+=1;
                    }else{
                        contadorV+=1;
                    }
                }
            }
            System.out.println("a la hora: "+mesD+" el ingreso de residentes y visitas respectivamente es de: : "+contadorR+", "+contadorV);
            
            */
    
    }    
    
}
