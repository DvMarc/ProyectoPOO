/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalDateTime;

/**
 *
 * @author USUARIO
 */
public class Visita extends Visitante {
    private String codigo;
    private LocalDateTime Finicio;

    public Visita(String cedula, String nombre, String correo) {
        super(cedula, nombre, correo);
    }
    
}
