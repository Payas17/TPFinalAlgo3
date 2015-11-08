package fiuba.algo3.tests;

import modelo.Mazo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Lucio on 07/11/2015.
 */
public class PruebasMazoTest {
    private Mazo mazo;

    @Before
    public void setup() {
        mazo = new Mazo();
    }

    @Test
    public void testMazoSeCreaCon40Cartas(){
        Assert.assertEquals(mazo.cantidadDeCartas(), 40 );
    }
}
