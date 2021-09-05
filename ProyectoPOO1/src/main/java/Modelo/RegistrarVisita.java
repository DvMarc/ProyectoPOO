/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author EVELYN
 */
public class RegistrarVisita implements Serializable{
    private LocalDateTime fechaIngreso;
    private String tipo;

    public RegistrarVisita(LocalDateTime fechaIngreso, String tipo) {
        this.fechaIngreso = fechaIngreso;
        this.tipo = tipo;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public String getTipo() {
        return tipo;
    }
    
    
    public static boolean filtroFechas(LocalDateTime inicio, LocalDateTime fin, LocalDateTime buscar){
        return buscar.isAfter(inicio) && buscar.isBefore(fin);
    }
}
