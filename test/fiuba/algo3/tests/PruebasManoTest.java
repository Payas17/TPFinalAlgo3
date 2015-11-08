package fiuba.algo3.tests;

import modelo.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Augusto on 08/11/2015.
 */
public class PruebasManoTest {

    @Test
    public void testPrimeraManoLaGanaElJugador1(){


        Jugador jugador1= new Jugador();
        Jugador jugador2 = new Jugador();

        Mano mano = new Mano(jugador1, jugador2);

        Carta espada10 = new Espada(0,5);
        Carta basto5 = new Basto(5,2);

        jugador1.agregarCarta(espada10);
        jugador2.agregarCarta(basto5);

        jugador1.juegaCarta(espada10);
        jugador2.juegaCarta(basto5);

        mano.buscarGanador();

        Assert.assertEquals(jugador1, mano.obtenerJugadorGanador());


    }
    @Test
    public void testPardaPrimeraMano(){


        Jugador jugador1= new Jugador();
        Jugador jugador2 = new Jugador();

        Mano mano = new Mano(jugador1, jugador2);

        Carta espada10 = new Espada(0,5);
        Carta basto10 = new Basto(0,5);

        jugador1.agregarCarta(espada10);
        jugador2.agregarCarta(basto10);

        jugador1.juegaCarta(espada10);
        jugador2.juegaCarta(basto10);

        mano.buscarGanador();

        Assert.assertFalse(mano.hayGanadorEnMano(jugador1, jugador2));


    }
    @Test
    public void testPrimeraManoLaGanaElJugador3con4jugadores(){


        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Jugador jugador3 = new Jugador();
        Jugador jugador4 = new Jugador();

        Mano mano = new Mano(jugador1, jugador2, jugador3, jugador4);

        Carta espada10 = new Espada(0,5);
        Carta basto5 = new Basto(5,2);
        Carta espada1 = new Espada (1,14);
        Carta oro3 = new Oro(3,10);

        jugador1.agregarCarta(espada10);
        jugador2.agregarCarta(basto5);
        jugador3.agregarCarta(espada1);
        jugador4.agregarCarta(oro3);

        jugador1.juegaCarta(espada10);
        jugador2.juegaCarta(basto5);
        jugador3.juegaCarta(espada1);
        jugador4.juegaCarta(oro3);

        mano.buscarGanador();

        Assert.assertEquals(jugador3, mano.obtenerJugadorGanador());


    }
}
