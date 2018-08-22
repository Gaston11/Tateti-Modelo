package Vista;

import Eventos.botonComenzarEventHancler;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.awt.*;

public class VistaPrincipal extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Tateti");

        StackPane contenedor = new StackPane();
        Button botonComenzar = new Button("Comenzar");
        botonComenzar.setOnAction(new botonComenzarEventHancler());

        contenedor.getChildren().add(botonComenzar);

        Scene escena = new Scene(contenedor,300,300);

        primaryStage.setScene(escena);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}