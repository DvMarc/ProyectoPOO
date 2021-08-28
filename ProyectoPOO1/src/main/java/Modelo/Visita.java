/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author USUARIO
 */
public class Visita implements Serializable{
    private String codigo;
    private LocalDateTime Finicio;

    public Visita(String codigo, LocalDateTime Finicio) {
        this.codigo = codigo;
        this.Finicio = Finicio;
    }
    
}
