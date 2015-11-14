package fiuba.algo3.tests;

import modelo.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Augusto on 08/11/2015.
 */
public class PruebasManoTest {

    @Test
    public void testPrimeraManoLaGanaElEquipo1(){

        Jugador jugador1= new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);

        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();


        Mano mano = new Mano(equipo1,equipo2);

        Carta espada10 = new Espada(10,valoresTrucoYEnvido);
        Carta basto5 = new Basto(5,valoresTrucoYEnvido);


        jugador1.agregarCarta(espada10);
        jugador2.agregarCarta(basto5);

        jugador1.juegaCarta(espada10);
        jugador2.juegaCarta(basto5);

        mano.buscarGanador();

        Assert.assertEquals(equipo1, mano.obtenerEquipoGanador());
        Assert.assertEquals(jugador1, mano.obtenerJugadorGanador());


    }
    @Test
    public void testPardaMano(){


        Jugador jugador1= new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();

        Mano mano = new Mano(equipo1,equipo2);

        Carta espada10 = new Espada(10,valoresTrucoYEnvido);
        Carta basto10 = new Basto(10,valoresTrucoYEnvido);

        jugador1.agregarCarta(espada10);
        jugador2.agregarCarta(basto10);

        jugador1.juegaCarta(espada10);
        jugador2.juegaCarta(basto10);

        mano.buscarGanador();

        Assert.assertTrue(mano.hayParda(jugador1, jugador2));



    }


}
