package Modelo;

/**
 * Created by gaston on 17/07/17.
 */
public class CombinacionesParaGanar {
    private Tablero tablero;

    public CombinacionesParaGanar(){

    }

    public void cargarTablero(Tablero unTablero){
        this.tablero = unTablero;
    }

    private boolean celdasConSimbolosIguales(Celda unaCelda, Celda otraCelda){
        if (unaCelda.getSimbolo() == "" || otraCelda.getSimbolo() == ""){
            return false;}
        else {
            return unaCelda.getSimbolo() == otraCelda.getSimbolo();
        }
    }

    private boolean ganadorEnFila(int fila){
        Celda unaCelda = this.tablero.getTablero()[fila][0];
        Celda celdaAComparar = this.tablero.getTablero()[fila][1];
        Celda otraCeldaAComparar = this.tablero.getTablero()[fila][2];

        return (this.celdasConSimbolosIguales( unaCelda, celdaAComparar )) &&
                (this.celdasConSimbolosIguales( unaCelda, otraCeldaAComparar ));
    }

    private boolean ganadorEnColumna(int columna){
        Celda unaCelda = this.tablero.getTablero()[0][columna];
        Celda celdaAComparar = this.tablero.getTablero()[1][columna];
        Celda otraCeldaAComparar = this.tablero.getTablero()[2][columna];

        return (this.celdasConSimbolosIguales( unaCelda, celdaAComparar )) &&
                (this.celdasConSimbolosIguales( unaCelda, otraCeldaAComparar ));
    }

    private boolean ganadorEnDiagonalIzquierdaADerecha(){
        Celda unaCelda = this.tablero.getTablero()[0][0];
        Celda celdaAComparar = this.tablero.getTablero()[1][1];
        Celda otraCeldaAComparar = this.tablero.getTablero()[2][2];

        return (this.celdasConSimbolosIguales( unaCelda, celdaAComparar )) &&
                (this.celdasConSimbolosIguales( unaCelda, otraCeldaAComparar ));
    }

    private boolean ganadorEnDiagonalDerechaAIzquierda(){
        Celda unaCelda = this.tablero.getTablero()[0][2];
        Celda celdaAComparar = this.tablero.getTablero()[1][1];
        Celda otraCeldaAComparar = this.tablero.getTablero()[2][0];

        return (this.celdasConSimbolosIguales( unaCelda, celdaAComparar )) &&
                (this.celdasConSimbolosIguales( unaCelda, otraCeldaAComparar ));
    }

    private boolean ganadorEnFilas(){

        return ( this.ganadorEnFila( 0 ) || this.ganadorEnFila( 1 ) || this.ganadorEnFila( 2 ) );
    }

    private boolean ganadorEnColumnas(){
        return (this.ganadorEnColumna( 0 ) || this.ganadorEnColumna( 1 ) || this.ganadorEnColumna( 2 ) );
    }

    private boolean ganadorEnDiagonles(){
        return (this.ganadorEnDiagonalDerechaAIzquierda() || this.ganadorEnDiagonalIzquierdaADerecha());
    }

    public boolean hayGanador(){
        return (this.ganadorEnFilas() || this.ganadorEnColumnas() ||
                this.ganadorEnDiagonles() );
    }

}
