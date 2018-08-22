package Modelo;

/**
 * Created by gaston on 17/07/17.
 */
public class Celda {
    private String simbolo;

    public Celda(){
        this.simbolo = "";
    }

    public boolean estaVacia(){
        return this.simbolo == "";
    }

    public void colocarCruz(){
        this.simbolo = "X";
    }

    public void colocarCirculo() {
        this.simbolo = "O";
    }

    public String getSimbolo(){
        return this.simbolo;
    }
}
