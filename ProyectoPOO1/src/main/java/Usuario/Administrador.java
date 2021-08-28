/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import java.io.Serializable;

/**
 *
 * @author EVELYN
 */
public class Administrador extends Usuario implements Serializable{
    
    public Administrador(String user, String contrasenia) {
        super(user, contrasenia);
    }
    
}
