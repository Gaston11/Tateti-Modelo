package Modelo;

/**
 * Created by gaston on 18/07/17.
 */
public class JuegoTerminadoException extends RuntimeException{
    //juego finalizado
    public JuegoTerminadoException() {
        super( "juego terminado" );
    }
}
