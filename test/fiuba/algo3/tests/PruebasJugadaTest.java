package fiuba.algo3.tests;

import modelo.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lucio on 08/11/2015.
 */
/*public class PruebasJugadaTest {
    @Test
    public void testHacerUnaJugadaYGanaEnTerceraMano(){
        List<Jugador> jugadores = new LinkedList<>();
        Jugador jugador1= new Jugador();
        Jugador jugador2 = new Jugador();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        Jugada jugada = new Jugada(jugadores);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();


        Carta espada10 = new Espada(10,valoresTrucoYEnvido);
        Carta basto5 = new Basto(5,valoresTrucoYEnvido);

        jugador1.agregarCarta(espada10);
        jugador2.agregarCarta(basto5);

        jugador1.juegaCarta(espada10);
        jugador2.juegaCarta(basto5);

        jugada.crearNuevaMano();

        Carta espada1 = new Espada(1,valoresTrucoYEnvido);
        Carta oro1 = new Oro(1,valoresTrucoYEnvido);

        jugador1.agregarCarta(oro1);
        jugador2.agregarCarta(espada1);

        jugador1.juegaCarta(oro1);
        jugador2.juegaCarta(espada1);

        jugada.crearNuevaMano();

        Carta basto1 = new Basto(1,valoresTrucoYEnvido);
        Carta copa1 = new Copa(1,valoresTrucoYEnvido);

        jugador1.agregarCarta(basto1);
        jugador2.agregarCarta(copa1);

        jugador1.juegaCarta(basto1);
        jugador2.juegaCarta(copa1);

        jugada.crearNuevaMano();

        Assert.assertEquals(jugada.obtenerGanador(), jugador1);

    }

    @Test
    public void testHacerUnaJugadaYGanaEnSegundaMano(){
        List<Jugador> jugadores = new LinkedList<>();
        Jugador jugador1= new Jugador();
        Jugador jugador2 = new Jugador();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        Jugada jugada = new Jugada(jugadores);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();


        Carta espada10 = new Espada(10,valoresTrucoYEnvido);
        Carta basto11 = new Basto(11,valoresTrucoYEnvido);

        jugador1.agregarCarta(espada10);
        jugador2.agregarCarta(basto11);

        jugador1.juegaCarta(espada10);
        jugador2.juegaCarta(basto11);

        jugada.crearNuevaMano();

        Carta espada2 = new Espada(2,valoresTrucoYEnvido);
        Carta oro3 = new Oro(3,valoresTrucoYEnvido);

        jugador1.agregarCarta(espada2);
        jugador2.agregarCarta(oro3);

        jugador1.juegaCarta(espada2);
        jugador2.juegaCarta(oro3);

        jugada.crearNuevaMano();

        Assert.assertEquals(jugada.obtenerGanador(), jugador2);

    }

    @Test
    public void testPardanLas3ManosYGanaElJugadorQueEsMano(){

        List<Jugador> jugadores = new LinkedList<>();
        Jugador jugador1= new Jugador();
        Jugador jugador2 = new Jugador();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        Jugada jugada = new Jugada(jugadores);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();


        Carta espada10 = new Espada(10,valoresTrucoYEnvido);
        Carta basto10 = new Basto(10,valoresTrucoYEnvido);

        jugador1.agregarCarta(espada10);
        jugador2.agregarCarta(basto10);

        jugador1.juegaCarta(espada10);
        jugador2.juegaCarta(basto10);

        jugada.crearNuevaMano();

        Carta copa1 = new Copa(1,valoresTrucoYEnvido);
        Carta oro1 = new Oro(1,valoresTrucoYEnvido);

        jugador1.agregarCarta(copa1);
        jugador2.agregarCarta(oro1);

        jugador1.juegaCarta(copa1);
        jugador2.juegaCarta(oro1);

        jugada.crearNuevaMano();

        Carta copa2 = new Copa(2,valoresTrucoYEnvido);
        Carta oro2 = new Oro(2,valoresTrucoYEnvido);

        jugador1.agregarCarta(copa2);
        jugador2.agregarCarta(oro2);

        jugador1.juegaCarta(copa2);
        jugador2.juegaCarta(oro2);

        jugada.crearNuevaMano();

        Assert.assertEquals(jugada.obtenerGanador(), jugador1);

    }


}*/
