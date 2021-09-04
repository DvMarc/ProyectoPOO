/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import java.io.Serializable;

/**
 *
 * @author ALICE
 */
public class Usuario implements Serializable{
    private String user;
    private String contrasenia;
    
    public Usuario(String user, String contrasenia){
        this.user=user;
        this.contrasenia=contrasenia;
    }

    public String getUser() {
        return user;
    }

    public String getContrasenia() {
        return contrasenia;
    }
    
    public boolean equals(Object obj ){
      if(obj!=null&& obj instanceof Usuario){
          Usuario u = (Usuario)obj;
          if(u.user.equals(user)&&u.contrasenia.equals(contrasenia)){
              return true;
          }
      } return false;  
    }

    @Override
    public String toString() {
        return "Su usuario es: "+user+"\nSu contraseña es: "+contrasenia;
    }
    
    
}
