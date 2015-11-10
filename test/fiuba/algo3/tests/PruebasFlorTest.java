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
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Carta espada1 = new Espada(1, valoresTrucoYEnvido);
        Carta espada10 = new Espada(10, valoresTrucoYEnvido);
        Carta espada5 = new Espada(5, valoresTrucoYEnvido);

        jugador.agregarCarta(espada10);
        jugador.agregarCarta(espada5);
        jugador.agregarCarta(espada1);

        Assert.assertEquals(jugador.cantarFlor(), 26);
    }

    @Test
    public void testJugadorCantaFlorConFigurasYTieneFlor() {
        Jugador jugador = new Jugador();
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Carta espada10 = new Espada(10, valoresTrucoYEnvido);
        Carta espada11 = new Espada(11, valoresTrucoYEnvido);
        Carta espada12 = new Espada(12, valoresTrucoYEnvido);

        jugador.agregarCarta(espada10);
        jugador.agregarCarta(espada11);
        jugador.agregarCarta(espada12);

        Assert.assertEquals(jugador.cantarFlor(), 20);
    }

    @Test(expected = NoTieneFlorError.class)
    public void testNoTengoFlorCantoFlorYTiraError() {
        Jugador jugador = new Jugador();
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Carta espada1 = new Espada(1, valoresTrucoYEnvido);
        Carta espada10 = new Espada(10, valoresTrucoYEnvido);
        Carta basto5 = new Basto(5, valoresTrucoYEnvido);

        jugador.agregarCarta(espada10);
        jugador.agregarCarta(basto5);
        jugador.agregarCarta(espada1);

       jugador.cantarFlor();
    }

}