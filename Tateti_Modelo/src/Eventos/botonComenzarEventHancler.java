package Eventos;

import Controladores.Controlador;
import Modelo.Juego;
import Vista.VistaTablero;
import com.sun.javafx.scene.SceneHelper;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.Parent;
import javafx.scene.control.Label;

import java.awt.*;

import javafx.scene.layout.*;

public class botonComenzarEventHancler implements EventHandler<ActionEvent> {

    private StackPane panel;
    private Juego juego;
    private Stage miStage;

    @Override
    public void handle(ActionEvent event) {

        this.miStage = new Stage();
        miStage.setTitle("Tateti a Jugar!!!");
        Juego juegoNuevo = new Juego();
        this.juego = juegoNuevo;
        Controlador controlador = new Controlador(juegoNuevo);
        //Label etiqueta = new Label("esto es una etiqueta ");

        StackPane panel = new StackPane();

        VistaTablero vistaTablero = new VistaTablero(controlador);
        Parent contenedorTablero = vistaTablero.dibujarTablero();

        //StackPane.setAlignment(contenedorTablero, Pos.CENTER);
        panel.getChildren().add( contenedorTablero);

        /*
        Scene escena = new Scene(panel );

        miStage.setScene(escena);
        miStage.show();
        */
        this.actualizarEscena(panel);
        //this.actualizarEtiqueta();
    }


    private void actualizarEtiqueta(){
        String texto = this.juego.nombreJugador();
        Label etiqueta = new Label(texto);
        StackPane.setAlignment(etiqueta, Pos.TOP_RIGHT);
        this.panel.getChildren().add(etiqueta);
        this.actualizarEscena(this.panel);

    }

    private void actualizarEscena(StackPane unPanel){
        Scene escena = new Scene(unPanel);
        miStage.setScene(escena);
        miStage.show();
    }


}