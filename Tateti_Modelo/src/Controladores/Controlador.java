package Controladores;

import Modelo.Juego;
import Vista.VistaCelda;

import java.awt.*;

public class Controlador {

    private Juego juego;

    public Controlador(Juego unJuego){
        this.juego = unJuego;
    }


    public void jugar(VistaCelda vistaCelda) {

        if (!this.juego.esJuegoTerminado()){
            if (this.juego.nombreJugador() == "JugadorCruz"){
                vistaCelda.dibujarCruz();
                this.juego.jugar(vistaCelda.getCoordenada().getX(), vistaCelda.getCoordenada().getY());
                //this.mostrarTurno();
            }
            else {
                vistaCelda.dibujarCirculo();
                this.juego.jugar(vistaCelda.getCoordenada().getX(), vistaCelda.getCoordenada().getY());
                //this.mostrarTurno();
            }
        }
    }

    /*
    private label etiquetaTurnoJugador(){
        String nombre = this.juego.nombreJugador();
        Label etiqueta = new Label(nombre);
        
    }

    public Label getLabel() {
        return label;
    }
    */

    public void actualizarEtiquetaTurno() {
    }
}