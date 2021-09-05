package com.mycompany.proyectopoo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
        public void start(Stage stage) throws IOException {
        //creamos la vista
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("VistaPrincipal.fxml"));
        Parent root = fxmlLoader.load();
        //creamos la escena y le pasamos la vista
        scene = new Scene(root, 700, 450);
        //fijamos al vista la stage
        stage.setScene(scene);
        //mostramos el stage
        stage.show();
    }

    public static void setRoot(Parent root) {
        scene.setRoot(root);
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}