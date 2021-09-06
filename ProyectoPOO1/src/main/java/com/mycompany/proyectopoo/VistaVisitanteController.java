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
        String[] horas = {"01","02","03","04","05","06","07","08","09","10","11","12",
            "13","14","15","16","17","18","19","20","21","22","23","00"};
        String[] minutos = {"00","05","10","15","20","25","30","35","40","45","50","55"};
        horaIngreso.setItems(FXCollections.observableArrayList(horas));
        minIngreso.setItems(FXCollections.observableArrayList(minutos));
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
        
        LocalDateTime diaHora=null;
        try{
            int err = 0;
            if(cedula.isEmpty()||nombre.isEmpty()
                    ||correo.isEmpty()||hora==null||min==null){
                error.setText("Campos no pueden estar vacios");
                err++;
            }if(Sistema.validarCorreo(correo)==false){
                    error.setText("Correo invalido");
                    err++;
                
            }
            if(hora!=null||min!=null){
                diaHora = diaIngreso.atTime(Integer.parseInt(hora), 
                Integer.parseInt(min));
                if(Sistema.validarFecha(diaHora)==false){
                    error.setText("Fecha no puede ser pasada");
                    err++;
                }
            }if(err==0){
                error.setText("");
                String codigoAcceso = Sistema.generarCodigo();
                Visitante visitante = new Visitante(residente.getUser(),cedula, nombre, correo,
                        diaHora, codigoAcceso,"activo");
                
                    VisitasResidenteData.agregarVisita(visitante);
                    error.setText("Se creo visitante");
                    
                    Correo.enviarConGmail(correo, "Codigo de acceso a Ciudadela",
                            "Codigo de acceso: "+codigoAcceso+"\nDia: "+diaIngreso+
                                    hora+":"+min);
                    
                    actualizarTabla();
                
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
}

    

