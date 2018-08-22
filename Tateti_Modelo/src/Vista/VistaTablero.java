package Vista;

import Controladores.Controlador;
import Modelo.Coordenada;
import Modelo.Juego;
import javafx.scene.Parent;
import javafx.scene.layout.*;

public class VistaTablero extends BorderPane {

    private Controlador controlador;

    public VistaTablero( Controlador unControlador){
        //this.juego = unJuego;
        this.controlador = unControlador;
    }

    public Parent dibujarTablero(){

        Pane panel = new Pane();
        panel.setPrefSize(400,400);

        VBox contenedorFilas = new VBox();
        for(int fil =0; fil <3; fil++){

            HBox contenedorColumnas = new HBox();
            for (int col =0; col <3; col++){
                Coordenada coordenada = new Coordenada(fil, col);
                VistaCelda vistaCelda = new VistaCelda(coordenada, this.controlador);
                vistaCelda.setVisible(true);
                vistaCelda.setOpacity(1);

                contenedorColumnas.getChildren().add(vistaCelda);
            }
            contenedorFilas.getChildren().add(contenedorColumnas);

        }

        panel.getChildren().add(contenedorFilas);

        return panel;
    }

}