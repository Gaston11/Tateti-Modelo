package Test;

import Modelo.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by gaston on 18/07/17.
 */
public class JuegoTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01CrearUnJuegoYJugadorCirculoGana(){
        Juego miJuego = new Juego();

        miJuego.marcarEnTableroConCirculo(0,0); // es un movimiento x jugador
        miJuego.marcarEnTableroConCruz(0,1);
        miJuego.marcarEnTableroConCirculo(1,1);
        miJuego.marcarEnTableroConCruz(0,2);
        thrown.expect( JuegoTerminadoException.class );
        miJuego.marcarEnTableroConCirculo(2,2);
    }

    @Test
    public void test02CrearUnJuegoYJugadorCruzGana(){
        Juego miJuego = new Juego();

        miJuego.marcarEnTableroConCruz(0,1);
        miJuego.marcarEnTableroConCirculo(1,1);
        miJuego.marcarEnTableroConCruz(0,2);
        miJuego.marcarEnTableroConCirculo(2,2);
        thrown.expect( JuegoTerminadoException.class );
        miJuego.marcarEnTableroConCruz( 0,0 );
    }

    @Test
    public void test05CrearUnJuegoYColocarSimbolosEnLaMismaPosicion(){
        Juego miJuego = new Juego();

        miJuego.jugar( 0,0 );
        thrown.expect( CeldaOcupadaException.class );
        miJuego.jugar( 0,0 );

    }

    @Test
    public void test04CrearUnJuegoYJugadorGana(){
        Juego miJuego = new Juego();

        miJuego.jugar(0,1);
        miJuego.jugar(1,1);
        miJuego.jugar(0,2);
        miJuego.jugar(2,2);
        miJuego.jugar( 0,0 );

        assertTrue(miJuego.esJuegoTerminado()  );
    }

}


