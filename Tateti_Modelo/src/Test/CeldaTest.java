package Test;

import Modelo.Celda;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Created by gaston on 17/07/17.
 */
public class CeldaTest {

    @Test
    public void test01CrearCeldaVacia(){
        Celda unaCelda = new Celda();

        assertTrue( unaCelda.estaVacia());
    }

    @Test
    public void test02CrearCeldaYColocarElSimboloCruz(){
        Celda miCelda = new Celda();
        miCelda.colocarCruz();

        assertFalse( miCelda.estaVacia() );
    }

    @Test
    public void test03CrearCeldaYColocarElSimboloCirculo(){
        Celda miCelda = new Celda();
        miCelda.colocarCirculo();

        assertFalse( miCelda.estaVacia() );
    }
}
