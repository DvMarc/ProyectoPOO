/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectopoo;

import Usuario.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author EVELYN
 */
public class IniciarSesionController implements Initializable {
    ArrayList<Usuario> usuarios = null;
    @FXML
    private Button bCancelar;
    @FXML
    private Button bIniciarSesion;
    @FXML
    private TextField lcontra;
    @FXML
    private TextField lUsername;

    public void cancelarBoton(MouseEvent event){
        try{
        FXMLLoader loader = new FXMLLoader(App.class.getResource("VistaPrincipal.fxml"));
        Parent viewPrincipal = loader.load();
        App.setRoot(viewPrincipal);
        VistaPrincipalController principalController = loader.getController();
        }catch(IOException ex){
            System.out.println("No se ha podido cargar la vista");
            System.out.println("VistaPrincipal.fxml");
        }
    }
    public void iniciarSesion(MouseEvent e){
        /*String ruta = "archivos/usuarios.txt";
        Charset charset = Charset.forName("UTF-8");
        try(
             BufferedReader reader = 
                    new BufferedReader(new FileReader(ruta, charset)) 
            ){
            String username = lUsername.getText();
            String contrasenia = lcontra.getText();
            if (username.isEmpty() | contrasenia.isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Usuario o contraeña no pueden estar en blanco");
                alert.showAndWait()
                .filter(response -> response == ButtonType.OK)
                .ifPresent(response -> formatSystem());
            }else{
                Usuario a = new Usuario(username,contrasenia);
                String line = null;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    String[] partes = line.split(",");
                    int contador = 0;
                    for (String s:partes){
                        contador+=1;
                    }
                    System.out.println(contador);
                    String user = partes[0];
                    String contra = partes[1];
                    Usuario a1 = new Usuario(user,contra);
                    if(a1.equals(a)){
                        switch(contador){
                            case 2: System.out.println("Es admin");
                                    FXMLLoader loader = new FXMLLoader(App.class.getResource("MenuAdministrador.fxml"));
                                    Parent viewPrincipal = loader.load();
                                    App.setRoot(viewPrincipal);
                                    MenuAdministradorController adminController = loader.getController();
                                break;
                            case 6: System.out.println("Es residente");
                                    FXMLLoader loader1 = new FXMLLoader(App.class.getResource("vistaResidente.fxml"));
                                    Parent viewPrincipal1 = loader1.load();
                                    App.setRoot(viewPrincipal1);
                                    VistaResidenteController residentController1 = loader1.getController();
                                break;
                        }
                    } 
                    contador = 0;
                }
            }
        }catch (IOException ex) {
            ex.printStackTrace();
        }catch(RuntimeException ex){
            System.out.println("");   
        }*/
        try{
            usuarios=UsuariosData.leerUsuarios();
            String username = lUsername.getText();
            String contrasenia = lcontra.getText();
            if (username.isEmpty() | contrasenia.isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Usuario o contraeña no pueden estar en blanco");
                alert.showAndWait()
                .filter(response -> response == ButtonType.OK)
                .ifPresent(response -> formatSystem());
            }else{
                Usuario user = new Usuario(username,contrasenia);
                for(Usuario u:usuarios){
                    if(u.equals(user)){
                        if(u instanceof Administrador){
                            System.out.println("Es admin");
                            try{
                                    FXMLLoader loader = new FXMLLoader(App.class.getResource("MenuAdministrador.fxml"));
                                    Parent viewPrincipal = loader.load();
                                    App.setRoot(viewPrincipal);
                                    MenuAdministradorController adminController = loader.getController();
                            }catch(IOException ex){
                            System.out.println("No se ha podido cargar la vista");
                            System.out.println("MenuAdministrador.fxml");
                        }
                        }else if(u instanceof Residente){
                            System.out.println("Es residente");
                            try{
                                    FXMLLoader loader1 = new FXMLLoader(App.class.getResource("VistaResidente.fxml"));
                                    Parent viewPrincipal1 = loader1.load();
                                    App.setRoot(viewPrincipal1);
                                    VistaResidenteController residentController1 = loader1.getController();
                            }catch(IOException ex){
                            System.out.println("No se ha podido cargar la vista");
                            System.out.println("VistaResidente.fxml");
                        }
                        }
                    }
                }
            }
        }catch(ClassNotFoundException e1){
            System.out.println("Clase incompatible");
        }
    }
    
        private void formatSystem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
