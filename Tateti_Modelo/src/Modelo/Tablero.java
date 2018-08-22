package Modelo;

/**
 * Created by gaston on 17/07/17.
 */
public class Tablero {

    private Celda[][] matriz = new Celda[3][3];

    public Tablero(){

        for (int fila =0; fila < 3; fila++){
            for (int columna =0; columna < 3; columna++){
                this.matriz[fila][columna] = new Celda();
            }
        }
    }

    public boolean estaVacio(){

        return (this.columnasEstanVacias(0) && this.columnasEstanVacias(1) && this.columnasEstanVacias(2) &&
               this.filasEstanVacias(0) && this.filasEstanVacias(1) && filasEstanVacias(2) );

    }

    private boolean columnasEstanVacias(int columna){
        boolean vacio = true;
        int fil =0;
        int col = columna;

        while (vacio && fil<3 ){
            vacio = this.matriz[fil][col].estaVacia();
            fil++;
        }
        return vacio;

    }

    private boolean filasEstanVacias(int fila){

        boolean vacio = true;
        int fil = fila;
        int col = 0;

        while (vacio && col<3 ){
            vacio = this.matriz[fil][col].estaVacia();
            col++;
        }
        return vacio;

    }

    private boolean celdaVaciaEnTablero(int fila, int columna){
        return this.matriz[fila][columna].estaVacia();
    }

    public void colocarCruzEn(int fila, int columna) {
        if (!this.celdaVaciaEnTablero( fila,columna ))
            throw new CeldaOcupadaException();
        else
            this.matriz[fila][columna].colocarCruz();
    }

    public void colocarCirculoEn(int fila, int columna) {
        if (!this.celdaVaciaEnTablero( fila,columna ))
            throw new CeldaOcupadaException();
        else
            this.matriz[fila][columna].colocarCirculo();
    }

    public Celda[][] getTablero(){
        return this.matriz;
    }
}
