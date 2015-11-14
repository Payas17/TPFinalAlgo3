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
    public void testPrimeraManoLaGanaElJugador1EnMesaDe2Jugadores(){

        List<Jugador> jugadores = new LinkedList<>();
        Jugador jugador1= new Jugador();
        Jugador jugador2 = new Jugador();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Turnos turnos = new Turnos(jugadores);


        Mano mano = new Mano(turnos);

        Carta espada10 = new Espada(10,valoresTrucoYEnvido);
        Carta basto5 = new Basto(5,valoresTrucoYEnvido);


        jugador1.agregarCarta(espada10);
        jugador2.agregarCarta(basto5);

        mano.jugarMano();

        Assert.assertEquals(jugador1, mano.obtenerJugadorGanador());

    }

    @Test
    public void testPardaPrimeraManoEnMesaDe2Jugadores(){


        List<Jugador> jugadores = new LinkedList<>();
        Jugador jugador1= new Jugador();
        Jugador jugador2 = new Jugador();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        Turnos turnos = new Turnos(jugadores);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();

        Mano mano = new Mano(turnos);

        Carta espada10 = new Espada(10,valoresTrucoYEnvido);
        Carta basto10 = new Basto(10,valoresTrucoYEnvido);

        jugador1.agregarCarta(espada10);
        jugador2.agregarCarta(basto10);


        mano.jugarMano();

        Assert.assertEquals(mano.obtenerJugadorGanador(), null);
    }

    @Test
    public void testPrimeraManoLaGanaElJugador2EnMesaDe4Jugadores(){

        List<Jugador> jugadores = new LinkedList<>();
        Jugador jugador1= new Jugador();
        Jugador jugador2 = new Jugador();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        Jugador jugador3= new Jugador();
        Jugador jugador4 = new Jugador();
        jugadores.add(jugador3);
        jugadores.add(jugador4);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Turnos turnos = new Turnos(jugadores);


        Mano mano = new Mano(turnos);

        Carta espada10 = new Espada(10,valoresTrucoYEnvido);
        Carta basto1 = new Basto(1,valoresTrucoYEnvido);
        Carta copa12 = new Copa(12,valoresTrucoYEnvido);
        Carta oro1 = new Oro(1,valoresTrucoYEnvido);


        jugador1.agregarCarta(espada10);
        jugador2.agregarCarta(basto1);
        jugador3.agregarCarta(copa12);
        jugador4.agregarCarta(oro1);

        mano.jugarMano();

        Assert.assertEquals(jugador2, mano.obtenerJugadorGanador());

    }

    @Test
    public void testPardaPrimeraManoEnMesaDe4Jugadores(){


        List<Jugador> jugadores = new LinkedList<>();
        Jugador jugador1= new Jugador();
        Jugador jugador2 = new Jugador();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        Jugador jugador3= new Jugador();
        Jugador jugador4 = new Jugador();
        jugadores.add(jugador3);
        jugadores.add(jugador4);
        Turnos turnos = new Turnos(jugadores);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();

        Mano mano = new Mano(turnos);

        Carta espada10 = new Espada(10,valoresTrucoYEnvido);
        Carta basto10 = new Basto(10,valoresTrucoYEnvido);
        Carta basto5 = new Basto(5,valoresTrucoYEnvido);
        Carta copa4 = new Copa(4,valoresTrucoYEnvido);

        jugador1.agregarCarta(espada10);
        jugador2.agregarCarta(basto10);
        jugador3.agregarCarta(basto5);
        jugador4.agregarCarta(copa4);


        mano.jugarMano();

        Assert.assertEquals(mano.obtenerJugadorGanador(), null);
    }


}
