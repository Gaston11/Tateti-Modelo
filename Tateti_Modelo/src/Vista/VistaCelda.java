package Vista;

import Controladores.Controlador;
import Eventos.SeleccionarCeldaEventHandler;
import Modelo.Coordenada;
import javafx.scene.layout.StackPane;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VistaCelda extends StackPane {

    private Image imagenCelda = new Image("file:src/Imagenes/celdaVacia.png");
    private Image imagenCirculo = new Image("file:src/Imagenes/circulo.png");
    private Image imagenCruz = new Image("file:src/Imagenes/cruz.png");
    private Coordenada coordenada;
    private ImageView imagen;
    private Controlador controlador;
    private boolean ocupado;


    public VistaCelda(Coordenada unaCoordenada, Controlador unControlador){
        this.coordenada = unaCoordenada;
        this.controlador = unControlador;
        this.ocupado = false;
        //Rectangle borde = new Rectangle(50,50,50,50);
        //Rectangle cuadro = new Rectangle(50,50,50,50);
        //cuadro.setOpacity(0);
        //borde.setFill(Color.TRANSPARENT);
        //borde.setStroke(Color.BLACK);
        this.imagen = this.dibujarImagen(this.imagenCelda);

        this.setOnMouseClicked(new SeleccionarCeldaEventHandler(this, this.controlador ));
        this.getChildren().addAll(imagen);

    }

    private ImageView dibujarImagen(Image unaImagen) {

        ImageView contenedorImagen = new ImageView();
        contenedorImagen.setFitHeight(80);
        contenedorImagen.setFitWidth(80);
        contenedorImagen.setImage(unaImagen);
        contenedorImagen.setOpacity(1);
        return contenedorImagen;
    }

    public void dibujarCirculo(){
        if(!this.ocupado) {
            ImageView imagen = this.dibujarImagen(this.imagenCirculo);
            this.getChildren().add(imagen);
            this.ocupado = true;
        }
    }

    public void dibujarCruz(){
        if (!this.ocupado) {
            ImageView imagen = this.dibujarImagen(this.imagenCruz);
            this.getChildren().add(imagen);
            this.ocupado = true;
        }
    }

    public Coordenada getCoordenada(){
        return this.coordenada;
    }


}