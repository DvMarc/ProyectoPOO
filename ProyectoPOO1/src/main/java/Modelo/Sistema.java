package Modelo;


import Usuario.Usuario;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ALICE
 */
public class Sistema {

    public static boolean validarCorreo(String correo) {
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(correo);
        return mather.find();
    }
    public static boolean validarFecha(LocalDateTime fechaIngreso){
        LocalDateTime fechaActual= LocalDateTime.now();
        return fechaActual.isAfter(fechaIngreso);
    }

    public static boolean validarPin(String pin){
        try{
            int pin1 = Integer.parseInt(pin);
            return true;
        }catch(NumberFormatException ex){
            return false;

        }
    }
    public static String generarCodigo(){
        int code = (int) (Math.random() * Math.pow(10, 8));
        return Integer.toString(code);

    }

}
