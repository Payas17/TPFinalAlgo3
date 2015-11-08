package fiuba.algo3.tests;

import modelo.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Payas on 08/11/2015.
 */
public class PruebasFlorTest {

    @Test
    public void testTengoFlorCantoFlorYAnda() {
        Jugador jugador = new Jugador();
        Carta espada1 = new Espada(1, 14);
        Carta espada10 = new Espada(0, 5);
        Carta espada5 = new Espada(5, 2);

        jugador.agregarCarta(espada10);
        jugador.agregarCarta(espada5);
        jugador.agregarCarta(espada1);

        Assert.assertEquals(jugador.cantarFlor(), 26);
    }

    @Test(expected = NoTieneFlorError.class)
    public void testNoTengoFlorCantoFlorYTiraError() {
        Jugador jugador = new Jugador();
        Carta espada1 = new Espada(1, 14);
        Carta espada10 = new Espada(0, 5);
        Carta basto5 = new Basto(5, 2);

        jugador.agregarCarta(espada10);
        jugador.agregarCarta(basto5);
        jugador.agregarCarta(espada1);

       jugador.cantarFlor();
    }
}