package fiuba.algo3.tests;

import modelo.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Augusto on 08/11/2015.
 */
public class PruebasManoTest {

    @Test
    public void testPrimeraManoLaGanaElJugador1(){

        List<Jugador> jugadores = new LinkedList<>();
        Jugador jugador1= new Jugador();
        Jugador jugador2 = new Jugador();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();


        Mano mano = new Mano(jugadores);

        Carta espada10 = new Espada(10,valoresTrucoYEnvido);
        Carta basto5 = new Basto(5,valoresTrucoYEnvido);


        jugador1.agregarCarta(espada10);
        jugador2.agregarCarta(basto5);

        jugador1.juegaCarta(espada10);
        jugador2.juegaCarta(basto5);

        mano.buscarGanador();

        Assert.assertEquals(jugador1, mano.obtenerJugadorGanador());


    }
  /*  @Test
    public void testPardaPrimeraMano(){


        List<Jugador> jugadores = new LinkedList<>();
        Jugador jugador1= new Jugador();
        Jugador jugador2 = new Jugador();
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        Mano mano = new Mano(jugadores);

        Carta espada10 = new Espada(0,5);
        Carta basto10 = new Basto(0,5);

        jugador1.agregarCarta(espada10);
        jugador2.agregarCarta(basto10);

        jugador1.juegaCarta(espada10);
        jugador2.juegaCarta(basto10);

        mano.buscarGanador();

        Assert.assertFalse(mano.hayGanadorEnMano(jugador1, jugador2));
        Assert.assertTrue(mano.obtenerJugadorGanador() == null);


    }*/


}
