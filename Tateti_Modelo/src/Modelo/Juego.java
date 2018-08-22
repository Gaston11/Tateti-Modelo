package Modelo;

/**
 * Created by gaston on 18/07/17.
 */
public class Juego {
    private Tablero tablero = new Tablero();
    private CombinacionesParaGanar combinacionesParaGanar = new CombinacionesParaGanar();
    private String jugadorActual;
    private boolean juegoTerminado = false;

    public Juego(){
        this.generarJugadorAleatorio();
    }

    public boolean esJuegoTerminado(){
        return this.juegoTerminado;
    }

    private void generarJugadorAleatorio(){
        int aleatorio = (int)(Math.random()*2 + 1);
        if (aleatorio == 1){
            this.jugadorActual = "JugadorCirculo";
        }
        else
            this.jugadorActual = "JugadorCruz";
    }

    public void marcarEnTableroConCirculo( int fila, int columna) {
        this.tablero.colocarCirculoEn( fila, columna );
        this.jugadorActual = "JugadorCruz";
        this.comprobarEstadoDelJuego();
    }

    public void marcarEnTableroConCruz( int fila, int columna)  {
        this.tablero.colocarCruzEn( fila, columna );
        this.jugadorActual = "JugadorCirculo";
        this.comprobarEstadoDelJuego();
    }

    private void comprobarEstadoDelJuego(){
        this.combinacionesParaGanar.cargarTablero( this.tablero );
        if (this.combinacionesParaGanar.hayGanador())
            throw new JuegoTerminadoException();
    }

    public void jugar(int fila, int columna){
        try {

            if (!juegoTerminado) {
                if (this.jugadorActual == "JugadorCruz") {
                    this.marcarEnTableroConCruz( fila, columna );
                }
                else {
                    this.marcarEnTableroConCirculo( fila, columna );
                }
            }
        } catch (JuegoTerminadoException juegoTerminadoException ){
            this.juegoTerminado= true; }
    }

    public String nombreJugador(){
        return this.jugadorActual;
    }

}
