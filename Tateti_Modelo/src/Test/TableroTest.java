package Test;

import Modelo.CeldaOcupadaException;
import Modelo.CombinacionesParaGanar;
import Modelo.Tablero;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by gaston on 17/07/17.
 */
public class TableroTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01CrearUntableroConTodasLasCeldasVacias() {
        Tablero miTablero = new Tablero();

        assertTrue( miTablero.estaVacio() );

    }

    @Test
    public void test02CrearUnTableroYColocarUnaCruz() {
        Tablero miTablero = new Tablero();

        miTablero.colocarCruzEn( 0, 0 );

        assertFalse( miTablero.estaVacio() );

    }

    @Test
    public void test03CrearUnTableroYColocarUnCirculo() {
        Tablero miTablero = new Tablero();

        miTablero.colocarCirculoEn( 0, 0 );

        assertFalse( miTablero.estaVacio() );
    }

    @Test
    public void test04CrearUnTableroYColocarUnCirculoYUnaCruzEnLaMismaPosicion() {
        Tablero miTablero = new Tablero();

        miTablero.colocarCirculoEn( 0, 0 );

        thrown.expect( CeldaOcupadaException.class );
        miTablero.colocarCruzEn( 0, 0 );

    }

    @Test
    public void test05CrearUnTableroYColocarCirculosYnoObtenerGanador() {
        Tablero miTablero = new Tablero();
        miTablero.colocarCirculoEn( 0,0 );
        miTablero.colocarCirculoEn( 1,2 );
        miTablero.colocarCirculoEn( 2,1 );

        CombinacionesParaGanar combinacionesParaGanar = new CombinacionesParaGanar();
        combinacionesParaGanar.cargarTablero( miTablero );

        assertFalse( combinacionesParaGanar.hayGanador() );

    }

    @Test
    public void test06CrearUnTableroYColocarCirculosEnLaPrimeraFila() {
        Tablero miTablero = new Tablero();
        miTablero.colocarCirculoEn( 0,0 );
        miTablero.colocarCirculoEn( 0,1 );
        miTablero.colocarCirculoEn( 0,2 );
        CombinacionesParaGanar combinacionesParaGanar = new CombinacionesParaGanar( );
        combinacionesParaGanar.cargarTablero( miTablero );

        assertTrue( combinacionesParaGanar.hayGanador() );

    }

    @Test
    public void test07CrearUnTableroYColocarCirculosEnLaSegundaFila() {
        Tablero miTablero = new Tablero();
        miTablero.colocarCirculoEn( 1,0 );
        miTablero.colocarCirculoEn( 1,1 );
        miTablero.colocarCirculoEn( 1,2 );
        CombinacionesParaGanar combinacionesParaGanar = new CombinacionesParaGanar( );
        combinacionesParaGanar.cargarTablero( miTablero );

        assertTrue( combinacionesParaGanar.hayGanador() );

    }

    @Test
    public void test08CrearUnTableroYColocarCrucesEnLaTerceraFila() {
        Tablero miTablero = new Tablero();
        miTablero.colocarCruzEn( 2,0 );
        miTablero.colocarCruzEn( 2,1 );
        miTablero.colocarCruzEn( 2,2 );
        CombinacionesParaGanar combinacionesParaGanar = new CombinacionesParaGanar( );
        combinacionesParaGanar.cargarTablero( miTablero );

        assertTrue( combinacionesParaGanar.hayGanador() );
    }

    @Test
    public void test09CrearUnTableroYColocarCruzesEnLaPrimeraColumna() {
        Tablero miTablero = new Tablero();
        miTablero.colocarCruzEn( 0,0 );
        miTablero.colocarCruzEn( 1,0 );
        miTablero.colocarCruzEn( 2,0 );
        CombinacionesParaGanar combinacionesParaGanar = new CombinacionesParaGanar( );
        combinacionesParaGanar.cargarTablero( miTablero );

        assertTrue( combinacionesParaGanar.hayGanador() );
    }

    @Test
    public void test10CrearUnTableroYColocarCruzesEnLaSegundaColumna() {
        Tablero miTablero = new Tablero();
        miTablero.colocarCruzEn( 0,1 );
        miTablero.colocarCruzEn( 1,1 );
        miTablero.colocarCruzEn( 2,1 );
        CombinacionesParaGanar combinacionesParaGanar = new CombinacionesParaGanar( );
        combinacionesParaGanar.cargarTablero( miTablero );

        assertTrue( combinacionesParaGanar.hayGanador() );
    }

    @Test
    public void test11CrearUnTableroYColocarCruzesEnLaTerceraColumna() {
        Tablero miTablero = new Tablero();
        miTablero.colocarCruzEn( 0,2 );
        miTablero.colocarCruzEn( 1,2 );
        miTablero.colocarCruzEn( 2,2 );
        CombinacionesParaGanar combinacionesParaGanar = new CombinacionesParaGanar( );
        combinacionesParaGanar.cargarTablero( miTablero );

        assertTrue( combinacionesParaGanar.hayGanador() );
    }

    @Test
    public void test12CrearUnTableroYColocarCruzesEnLaDiagonalIzquierdaADerecha() {
        Tablero miTablero = new Tablero();
        miTablero.colocarCruzEn( 0,0 );
        miTablero.colocarCruzEn( 1,1 );
        miTablero.colocarCruzEn( 2,2 );
        CombinacionesParaGanar combinacionesParaGanar = new CombinacionesParaGanar( );
        combinacionesParaGanar.cargarTablero( miTablero );

        assertTrue( combinacionesParaGanar.hayGanador() );
    }

    @Test
    public void test13CrearUnTableroYColocarCruzesEnLaDiagonalDerechaAIzquierda() {
        Tablero miTablero = new Tablero();
        miTablero.colocarCruzEn( 0,2 );
        miTablero.colocarCruzEn( 1,1 );
        miTablero.colocarCruzEn( 2,0 );
        CombinacionesParaGanar combinacionesParaGanar = new CombinacionesParaGanar( );
        combinacionesParaGanar.cargarTablero( miTablero );

        assertTrue( combinacionesParaGanar.hayGanador() );
    }
}
