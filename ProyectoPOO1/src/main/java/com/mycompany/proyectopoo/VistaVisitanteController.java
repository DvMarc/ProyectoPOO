/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectopoo;

import Modelo.Correo;
import Modelo.Sistema;
import Modelo.Visita;
import Modelo.Visitante;
import Modelo.VisitasResidenteData;
import Usuario.Residente;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
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
    private ComboBox<String> horaIngreso;
    @FXML
    private TextField nombreVisitante;
    @FXML
    private Button registrar;
    @FXML
    private ComboBox<String> minIngreso;
    @FXML
    private Label error;
    @FXML
    private GridPane gridVisitas;
    
    private Residente residente;
    
   /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String[] horas = {"1","2","3","4","5","6","7","8","9","10","11","12",
            "13","14","15","16","17","18","19","20","21","22","23","00"};
        String[] minutos = {"00","05","10","15","20","25","30","35","40","45","50","55"};
        minIngreso.setItems(FXCollections.observableArrayList(horas));
        horaIngreso.setItems(FXCollections.observableArrayList(minutos));     
    }    
    
    public void setResidente(Residente user) throws ClassNotFoundException{
        residente = user;
        actualizarTabla();
    }
    
    @FXML
    private void registrarVisitante(MouseEvent event) throws ClassNotFoundException {
        String cedula = ciVisitante.getText();
        String correo = correoVisitante.getText();
        String nombre = nombreVisitante.getText();
        String hora = horaIngreso.getValue();
        String min = minIngreso.getValue();
        LocalDate diaIngreso = fechaIngreso.getValue();
        LocalDateTime diaHora = diaIngreso.atTime(Integer.parseInt(hora), 
                Integer.parseInt(min));
        try{
            if(cedula.isEmpty()||nombre.isEmpty()
                    ||correo.isEmpty()||hora==null||min==null){
                error.setText("Campos no estan vacios");
            }else if(Sistema.validarCorreo(correo)==false){
                error.setText("Correo invalido");
            }else if(Sistema.validarFecha(diaHora)==false){
                error.setText("Fecha no puede ser pasada");
            }else{
                error.setText("");
                Visitante visitante = new Visitante(residente.getUser(),cedula, nombre, correo,
                        diaHora, Sistema.generarCodigo());
                if(visitante == null){
                    VisitasResidenteData.agregarVisita(visitante);
                    actualizarTabla();
                }  
            }
        }catch(NullPointerException ex){
            error.setText("Campos no pueden estar vacios");
        } 
    }
    
    private void actualizarTabla() throws ClassNotFoundException{
        ArrayList<Visitante> visitantes = VisitasResidenteData.leerVisitas();
        if(visitantes!=null){
           int row=1;
            for(Visitante vt:visitantes){
                if(vt.getUsuario().equals(residente.getUser())){
                    Label nombre=new Label(vt.getNombre());
                    Label ci = new Label(vt.getCedula());
                    Label code=new Label(vt.getCodigo());
                    Label fecha = new Label(vt.getFecha());
                    gridVisitas.add(nombre,0,row);
                    gridVisitas.add(ci, 1, row);
                    gridVisitas.add(code,2,row);
                    gridVisitas.add(fecha, 3, row);
                    row++;
                }
            }
        }  
    }
    
    @FXML
    private void eliminar(MouseEvent event) {
        
    }
    public void addGridEvent() {
        gridVisitas.getChildren().forEach(item -> {
            item.setOnMouseClicked((MouseEvent event) -> {
                if (event.getClickCount() == 1) {
                    
                }
                if (event.isPrimaryButtonDown()) {
                    
                }
            });

        });
    }
}

    

