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
        List<Jugador> jugadores1 = new ArrayList<>();
        jugadores1.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();

        List<Jugador> jugadores = new ArrayList<>();
        for(int i = 0; i < equipo1.obtenerIntegrantes().size();i++ ){
           jugadores.add(equipo1.obtenerIntegrantes().get(i));
           jugadores.add(equipo2.obtenerIntegrantes().get(i));
        }


        Mano mano = new Mano(jugadores);

        Carta espada10 = new Espada(10,valoresTrucoYEnvido);
        Carta basto5 = new Basto(5,valoresTrucoYEnvido);


        jugador1.agregarCarta(espada10);
        jugador2.agregarCarta(basto5);

        jugador1.juegaCarta(espada10);
        jugador2.juegaCarta(basto5);

        mano.buscarGanador(equipo1,equipo2);

        Assert.assertEquals(equipo1, mano.obtenerEquipoGanador(equipo1,equipo2));
        Assert.assertEquals(jugador1, mano.obtenerJugadorGanador());


    }
    @Test
    public void testPardaMano(){

        Jugador jugador1= new Jugador();
        List<Jugador> jugadores1 = new ArrayList<>();
        jugadores1.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();

        List<Jugador> jugadores = new ArrayList<>();
        for(int i = 0; i < equipo1.obtenerIntegrantes().size();i++ ){
            jugadores.add(equipo1.obtenerIntegrantes().get(i));
            jugadores.add(equipo2.obtenerIntegrantes().get(i));
        }


        Mano mano = new Mano(jugadores);

        Carta espada10 = new Espada(10,valoresTrucoYEnvido);
        Carta basto10 = new Basto(10,valoresTrucoYEnvido);

        jugador1.agregarCarta(espada10);
        jugador2.agregarCarta(basto10);

        jugador1.juegaCarta(espada10);
        jugador2.juegaCarta(basto10);

        mano.buscarGanador(equipo1,equipo2);

        Assert.assertTrue(mano.hayParda(equipo1, equipo2));

    }

    @Test
    public void testManoLaGanaElEquipo2Con4Jugadores(){

        Jugador jugador1= new Jugador();
        Jugador jugador2= new Jugador();
        List<Jugador> jugadores1 = new ArrayList<>();
        jugadores1.add(jugador1);
        jugadores1.add(jugador2);
        Jugador jugador3 = new Jugador();
        Jugador jugador4 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador3);
        jugadores2.add(jugador4);
        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();

        List<Jugador> jugadores = new ArrayList<>();
        for(int i = 0; i < equipo1.obtenerIntegrantes().size();i++ ){
            jugadores.add(equipo1.obtenerIntegrantes().get(i));
            jugadores.add(equipo2.obtenerIntegrantes().get(i));
        }

        Mano mano = new Mano(jugadores);

        Carta espada10 = new Espada(10,valoresTrucoYEnvido);
        Carta basto5 = new Basto(5,valoresTrucoYEnvido);
        Carta espada2 = new Espada(2,valoresTrucoYEnvido);
        Carta basto3 = new Basto(3,valoresTrucoYEnvido);


        jugador1.agregarCarta(espada10);
        jugador2.agregarCarta(basto5);
        jugador3.agregarCarta(espada2);
        jugador4.agregarCarta(basto3);

        jugador1.juegaCarta(espada10);
        jugador2.juegaCarta(basto5);
        jugador3.juegaCarta(espada2);
        jugador4.juegaCarta(basto3);

        mano.buscarGanador(equipo1,equipo2);

        Assert.assertEquals(equipo2, mano.obtenerEquipoGanador(equipo1,equipo2));
        Assert.assertEquals(jugador4, mano.obtenerJugadorGanador());
    }

    @Test
    public void testManoLaGanaElEquipo2Con4JugadoresPardaEnElMismoEquipo(){

        Jugador jugador1= new Jugador();
        Jugador jugador2= new Jugador();
        List<Jugador> jugadores1 = new ArrayList<>();
        jugadores1.add(jugador1);
        jugadores1.add(jugador2);
        Jugador jugador3 = new Jugador();
        Jugador jugador4 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador3);
        jugadores2.add(jugador4);
        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();

        List<Jugador> jugadores = new ArrayList<>();
        for(int i = 0; i < equipo1.obtenerIntegrantes().size();i++ ){
            jugadores.add(equipo1.obtenerIntegrantes().get(i));
            jugadores.add(equipo2.obtenerIntegrantes().get(i));
        }

        Mano mano = new Mano(jugadores);

        Carta espada10 = new Espada(10,valoresTrucoYEnvido);
        Carta basto5 = new Basto(5,valoresTrucoYEnvido);
        Carta espada3 = new Espada(3,valoresTrucoYEnvido);
        Carta basto3 = new Basto(3,valoresTrucoYEnvido);


        jugador1.agregarCarta(espada10);
        jugador2.agregarCarta(basto5);
        jugador3.agregarCarta(espada3);
        jugador4.agregarCarta(basto3);

        jugador1.juegaCarta(espada10);
        jugador2.juegaCarta(basto5);
        jugador3.juegaCarta(espada3);
        jugador4.juegaCarta(basto3);

        mano.buscarGanador(equipo1,equipo2);

        Assert.assertEquals(equipo2, mano.obtenerEquipoGanador(equipo1,equipo2));
        Assert.assertEquals(jugador3, mano.obtenerJugadorGanador());
    }

    @Test
    public void testManoPardaEquiposDeA4(){

        Jugador jugador1= new Jugador();
        Jugador jugador2= new Jugador();
        List<Jugador> jugadores1 = new ArrayList<>();
        jugadores1.add(jugador1);
        jugadores1.add(jugador2);
        Jugador jugador3 = new Jugador();
        Jugador jugador4 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador3);
        jugadores2.add(jugador4);
        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();

        List<Jugador> jugadores = new ArrayList<>();
        for(int i = 0; i < equipo1.obtenerIntegrantes().size();i++ ){
            jugadores.add(equipo1.obtenerIntegrantes().get(i));
            jugadores.add(equipo2.obtenerIntegrantes().get(i));
        }

        Mano mano = new Mano(jugadores);

        Carta espada10 = new Espada(10,valoresTrucoYEnvido);
        Carta basto5 = new Basto(5,valoresTrucoYEnvido);
        Carta espada3 = new Espada(3,valoresTrucoYEnvido);
        Carta basto3 = new Basto(3,valoresTrucoYEnvido);


        jugador1.agregarCarta(espada10);
        jugador2.agregarCarta(espada3);
        jugador3.agregarCarta(basto5);
        jugador4.agregarCarta(basto3);

        jugador1.juegaCarta(espada10);
        jugador2.juegaCarta(espada3);
        jugador3.juegaCarta(basto5);
        jugador4.juegaCarta(basto3);

        mano.buscarGanador(equipo1,equipo2);

        Assert.assertTrue(mano.hayParda(equipo1, equipo2));

    }

    @Test
    public void testVaPardandoYElUltimoJugadorTiraUnaMasAltaYGanaLaMano(){

        Jugador jugador1= new Jugador();
        Jugador jugador2= new Jugador();
        List<Jugador> jugadores1 = new ArrayList<>();
        jugadores1.add(jugador1);
        jugadores1.add(jugador2);
        Jugador jugador3 = new Jugador();
        Jugador jugador4 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador3);
        jugadores2.add(jugador4);
        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();

        List<Jugador> jugadores = new ArrayList<>();
        for(int i = 0; i < equipo1.obtenerIntegrantes().size();i++ ){
            jugadores.add(equipo1.obtenerIntegrantes().get(i));
            jugadores.add(equipo2.obtenerIntegrantes().get(i));
        }

        Mano mano = new Mano(jugadores);

        Carta basto3 = new Basto(3,valoresTrucoYEnvido);
        Carta basto5 = new Basto(5,valoresTrucoYEnvido);
        Carta espada3 = new Espada(3,valoresTrucoYEnvido);
        Carta basto1 = new Basto(1,valoresTrucoYEnvido);


        jugador1.agregarCarta(basto3);
        jugador2.agregarCarta(basto5);
        jugador3.agregarCarta(espada3);
        jugador4.agregarCarta(basto1);

        jugador1.juegaCarta(basto3);
        jugador2.juegaCarta(basto5);
        jugador3.juegaCarta(espada3);
        jugador4.juegaCarta(basto1);

        mano.buscarGanador(equipo1,equipo2);

        Assert.assertEquals(equipo2, mano.obtenerEquipoGanador(equipo1,equipo2));
        Assert.assertEquals(jugador4, mano.obtenerJugadorGanador());
    }




}
