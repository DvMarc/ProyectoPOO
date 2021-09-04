/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectopoo;

import Modelo.Sistema;
import Modelo.Visita;
import Modelo.Visitante;
import Usuario.Residente;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
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
    public void setResidente(Residente user){
        residente = user;
    }

    @FXML
    private void registrarVisitante(MouseEvent event) {
        String cedula = ciVisitante.getText();
        String correo = correoVisitante.getText();
        String nombre = nombreVisitante.getText();
        String hora = horaIngreso.getValue();
        String min = minIngreso.getValue();
        LocalDate diaIngreso = fechaIngreso.getValue();
        LocalDateTime diaHora = diaIngreso.atTime(Integer.parseInt(hora), 
                Integer.parseInt(min));
        if(cedula.isEmpty()|nombre.isEmpty()|hora==null|min==null|diaIngreso==null){
            error.setText("Campos no pueden estar vacios");
        }else if(Sistema.validarCorreo(correo)==false){
            error.setText("Correo invalido");
        }else if(Sistema.validarFecha()==false){
            error.setText("Fecha no puede ser pasada");

        }else{
            error.setText("");
            Visitante visitante = new Visitante(cedula, nombre, correo);
            Visita visita = new Visita(Sistema.generarCodigo(),diaHora);
            residente.registrarVisitante(visitante);
            residente.registrarVisita(visita);
        }
    }
    
}
