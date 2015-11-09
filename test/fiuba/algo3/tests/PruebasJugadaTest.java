package fiuba.algo3.tests;

import modelo.*;
import org.junit.Assert;
import org.junit.Test;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lucio on 08/11/2015.
 */
public class PruebasJugadaTest {
    @Test
    public void testHacerUnaJugadaYGanaEnTerceraMano(){
        List<Jugador> jugadores = new LinkedList<>();
        Jugador jugador1= new Jugador();
        Jugador jugador2 = new Jugador();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        Jugada jugada = new Jugada(jugadores);


        Carta espada10 = new Espada(0,5);
        Carta basto5 = new Basto(5,2);

        jugador1.agregarCarta(espada10);
        jugador2.agregarCarta(basto5);

        jugador1.juegaCarta(espada10);
        jugador2.juegaCarta(basto5);

        jugada.crearNuevaMano();

        Carta espada1 = new Espada(1,14);
        Carta oro1 = new Oro(1,11);

        jugador1.agregarCarta(oro1);
        jugador2.agregarCarta(espada1);

        jugador1.juegaCarta(oro1);
        jugador2.juegaCarta(espada1);

        jugada.crearNuevaMano();

        Carta basto1 = new Basto(1,13);
        Carta copa1 = new Copa(1,11);

        jugador1.agregarCarta(basto1);
        jugador2.agregarCarta(copa1);

        jugador1.juegaCarta(basto1);
        jugador2.juegaCarta(copa1);

        jugada.crearNuevaMano();

        Assert.assertEquals(jugada.obtenerGanador(),jugador1);

    }

    @Test
    public void testHacerUnaJugadaYGanaEnSegundaMano(){
        List<Jugador> jugadores = new LinkedList<>();
        Jugador jugador1= new Jugador();
        Jugador jugador2 = new Jugador();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        Jugada jugada = new Jugada(jugadores);


        Carta espada10 = new Espada(0,5);
        Carta basto5 = new Basto(5,2);

        jugador1.agregarCarta(espada10);
        jugador2.agregarCarta(basto5);

        jugador1.juegaCarta(espada10);
        jugador2.juegaCarta(basto5);

        jugada.crearNuevaMano();

        Carta espada1 = new Espada(1,14);
        Carta oro1 = new Oro(1,11);

        jugador1.agregarCarta(espada1);
        jugador2.agregarCarta(oro1);

        jugador1.juegaCarta(espada1);
        jugador2.juegaCarta(oro1);

        Assert.assertEquals(jugada.obtenerGanador(),jugador1);

    }

}
