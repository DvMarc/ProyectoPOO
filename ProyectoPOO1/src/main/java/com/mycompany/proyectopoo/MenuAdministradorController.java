/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectopoo;

import Modelo.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author EVELYN
 */
public class MenuAdministradorController implements Initializable {

    @FXML
    private Pane panelMapa;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String ruta = "archivos/casas.txt";
        
        Charset charset = Charset.forName("UTF-8");
        try(
             BufferedReader reader = 
                    new BufferedReader(new FileReader(ruta, charset)) 
            ){
            
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                String[] partes = line.split(",");
                int coordenadaX = Integer.valueOf(partes[0]);
                int coordenadaY = Integer.valueOf(partes[1]);
                String manzana = partes[2];
                String villa = partes[3];
                String imagePath = partes[4];
                Casa c = new Casa(new Coordenada(coordenadaX,coordenadaY), manzana, villa, imagePath);
                System.out.println(c);
                ImageView imgview = null;
                try{
                  //agrego la imagen del aagente
                  InputStream input = App.class.getResource(c.getImagePath()).openStream();
                  Image img = new Image(input, 50, 50, true, true);
                  imgview = new ImageView(img);
                  imgview.setLayoutX(c.getCoordenadas().getCoordenadaX());
                  imgview.setLayoutY(c.getCoordenadas().getCoordenadaY());
                  panelMapa.getChildren().addAll(imgview);
                }catch(NullPointerException ex){
                  imgview = new ImageView();
                }catch (IOException ex) { 
                      ex.printStackTrace();
                }
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   
    
}
