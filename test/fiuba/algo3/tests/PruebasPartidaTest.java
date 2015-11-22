package fiuba.algo3.tests;

import modelo.*;
import modelo.Carta.*;
import modelo.Errores.NoPuedeJugarError;
import modelo.Errores.NoSePuedeJugarCarta;
import modelo.Partida.EstadoPartidaTerminada;
import modelo.Partida.Partida;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucio on 21/11/2015.
 */
public class PruebasPartidaTest {

    @Test
    public void testPartidaTerminadaCuandoUnEquipoLlegaA30Puntos(){
        Jugador jugador1= new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Jugador jugador3= new Jugador();
        jugadores.add(jugador3);
        Jugador jugador4 = new Jugador();
        jugadores2.add(jugador4);

        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        Partida partida = new Partida(equipo1,equipo2);

        partida.jugarConFlor();
        Jugada jugada = partida.crearJugada();


        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();

        Carta copa10 = new Copa(10,valoresTrucoYEnvido);
        Carta copa4 = new Copa(4,valoresTrucoYEnvido);
        Carta copa5 = new Copa(5,valoresTrucoYEnvido);
        jugador1.agregarCarta(copa10);
        jugador1.agregarCarta(copa4);
        jugador1.agregarCarta(copa5);

        Carta oro11 = new Oro(11,valoresTrucoYEnvido);
        Carta oro4 = new Oro(4,valoresTrucoYEnvido);
        Carta oro5 = new Oro(5,valoresTrucoYEnvido);
        jugador2.agregarCarta(oro11);
        jugador2.agregarCarta(oro4);
        jugador2.agregarCarta(oro5);

        Carta espada12 = new Espada(12,valoresTrucoYEnvido);
        Carta espada6 = new Espada(6,valoresTrucoYEnvido);
        Carta espada7 = new Espada(7,valoresTrucoYEnvido);
        jugador3.agregarCarta(espada12);
        jugador3.agregarCarta(espada6);
        jugador3.agregarCarta(espada7);

        Carta basto5 = new Basto(5,valoresTrucoYEnvido);
        Carta basto4 = new Basto(4,valoresTrucoYEnvido);
        Carta basto3 = new Basto(3,valoresTrucoYEnvido);
        jugador4.agregarCarta(basto3);
        jugador4.agregarCarta(basto4);
        jugador4.agregarCarta(basto5);

        jugador2.cantarFlor(jugada);
        jugador3.contraFlorAlResto(jugada);
        jugador2.aceptarFlor(jugada);


        Assert.assertEquals(equipo1.obtenerPuntos(), 30);
        Assert.assertEquals(equipo2.obtenerPuntos(),0);
        Assert.assertEquals(partida.obtenerEstado().getClass(), EstadoPartidaTerminada.class);
    }

    @Test(expected = NoSePuedeJugarCarta.class)
    public void testPartidaTerminadaEntoncesDevuelveErrorSiSeQuiereSeguirJugando(){
        Jugador jugador1= new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Jugador jugador3= new Jugador();
        jugadores.add(jugador3);
        Jugador jugador4 = new Jugador();
        jugadores2.add(jugador4);

        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        Partida partida = new Partida(equipo1,equipo2);

        partida.jugarConFlor();
        Jugada jugada = partida.crearJugada();


        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();

        Carta copa10 = new Copa(10,valoresTrucoYEnvido);
        Carta copa4 = new Copa(4,valoresTrucoYEnvido);
        Carta copa5 = new Copa(5,valoresTrucoYEnvido);
        jugador1.agregarCarta(copa10);
        jugador1.agregarCarta(copa4);
        jugador1.agregarCarta(copa5);

        Carta oro11 = new Oro(11,valoresTrucoYEnvido);
        Carta oro4 = new Oro(4,valoresTrucoYEnvido);
        Carta oro5 = new Oro(5,valoresTrucoYEnvido);
        jugador2.agregarCarta(oro11);
        jugador2.agregarCarta(oro4);
        jugador2.agregarCarta(oro5);

        Carta espada12 = new Espada(12,valoresTrucoYEnvido);
        Carta espada6 = new Espada(6,valoresTrucoYEnvido);
        Carta espada7 = new Espada(7,valoresTrucoYEnvido);
        jugador3.agregarCarta(espada12);
        jugador3.agregarCarta(espada6);
        jugador3.agregarCarta(espada7);

        Carta basto5 = new Basto(5,valoresTrucoYEnvido);
        Carta basto4 = new Basto(4,valoresTrucoYEnvido);
        Carta basto3 = new Basto(3,valoresTrucoYEnvido);
        jugador4.agregarCarta(basto3);
        jugador4.agregarCarta(basto4);
        jugador4.agregarCarta(basto5);

        jugador2.cantarFlor(jugada);
        jugador3.contraFlorAlResto(jugada);
        jugador2.aceptarFlor(jugada);


        Assert.assertEquals(equipo1.obtenerPuntos(), 30);
        Assert.assertEquals(equipo2.obtenerPuntos(),0);
        Assert.assertEquals(partida.obtenerEstado().getClass(), EstadoPartidaTerminada.class);

        jugador1.juegaCarta(copa10);
    }

    @Test
    public void testSeJueganDosPicaPica(){

        Jugador jugador1= new Jugador();
        Jugador jugador2= new Jugador();
        Jugador jugador3= new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        jugadores.add(jugador3);

        Jugador jugador4 = new Jugador();
        Jugador jugador5= new Jugador();
        Jugador jugador6= new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador4);
        jugadores2.add(jugador5);
        jugadores2.add(jugador6);

        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        Partida partida = new Partida(equipo1,equipo2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Mazo mazoDeCartas = new Mazo(valoresTrucoYEnvido);
       // Jugada jugada = new Jugada(equipo1,equipo2, mazoDeCartas);

        equipo1.sumarPuntos(5);

        Carta copa10 = new Copa(10,valoresTrucoYEnvido);
        Carta copa4 = new Copa(4,valoresTrucoYEnvido);
        Carta copa5 = new Copa(5,valoresTrucoYEnvido);
        jugador1.agregarCarta(copa10);
        jugador1.agregarCarta(copa4);
        jugador1.agregarCarta(copa5);

        Carta oro11 = new Oro(11,valoresTrucoYEnvido);
        Carta oro4 = new Oro(4,valoresTrucoYEnvido);
        Carta oro5 = new Oro(5,valoresTrucoYEnvido);
        jugador2.agregarCarta(oro11);
        jugador2.agregarCarta(oro4);
        jugador2.agregarCarta(oro5);

        Carta espada12 = new Espada(12,valoresTrucoYEnvido);
        Carta espada6 = new Espada(6,valoresTrucoYEnvido);
        Carta espada7 = new Espada(7,valoresTrucoYEnvido);
        jugador3.agregarCarta(espada12);
        jugador3.agregarCarta(espada6);
        jugador3.agregarCarta(espada7);

        Carta basto5 = new Basto(5,valoresTrucoYEnvido);
        Carta basto4 = new Basto(4,valoresTrucoYEnvido);
        Carta basto3 = new Basto(3,valoresTrucoYEnvido);
        jugador4.agregarCarta(basto3);
        jugador4.agregarCarta(basto4);
        jugador4.agregarCarta(basto5);

        Carta espada10 = new Espada(10,valoresTrucoYEnvido);
        Carta espada1 = new Espada(1,valoresTrucoYEnvido);
        Carta espada4 = new Espada(4,valoresTrucoYEnvido);
        jugador5.agregarCarta(espada10);
        jugador5.agregarCarta(espada1);
        jugador5.agregarCarta(espada4);

        Carta basto7 = new Basto(7,valoresTrucoYEnvido);
        Carta basto6 = new Basto(6,valoresTrucoYEnvido);
        Carta basto2 = new Basto(2,valoresTrucoYEnvido);
        jugador6.agregarCarta(basto7);
        jugador6.agregarCarta(basto6);
        jugador6.agregarCarta(basto2);

        Jugada jugadaPP = partida.crearJugadaPicaPica();

        jugadaPP.armarEquiposParaPicaPica(jugador1, jugador6);
        partida.obtenerEquipo1();
        jugador1.cantarFlor(jugadaPP);
        jugador6.aceptarFlor(jugadaPP);

        jugador1.juegaCarta(copa10);
        jugador6.juegaCarta(basto7);

        jugadaPP.jugarMano();

        jugador1.juegaCarta(copa5);
        jugador6.cantarTruco(jugadaPP);
        jugador1.noAceptarTruco(jugadaPP);

        jugadaPP.jugarMano();

        partida.calcularPuntosPicaPica(jugadaPP);

        Assert.assertTrue(equipo1.obtenerPuntos() == 7);
        Assert.assertTrue(equipo2.obtenerPuntos() == 5);

        Jugada jugadaPP2 = partida.crearJugadaPicaPica();

        jugadaPP2.armarEquiposParaPicaPica(jugador2, jugador5);
        partida.obtenerEquipo1();
        jugador2.irseAlMazo(jugadaPP2);

        partida.calcularPuntosPicaPica(jugadaPP2);

        Assert.assertTrue(equipo1.obtenerPuntos() == 7);
        Assert.assertTrue(equipo2.obtenerPuntos() == 7);

    }

    @Test
    public void testPicaPicaYDespuesJugadaNormal(){

        Jugador jugador1= new Jugador();
        Jugador jugador2= new Jugador();
        Jugador jugador3= new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        jugadores.add(jugador3);

        Jugador jugador4 = new Jugador();
        Jugador jugador5= new Jugador();
        Jugador jugador6= new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador4);
        jugadores2.add(jugador5);
        jugadores2.add(jugador6);

        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        Partida partida = new Partida(equipo1,equipo2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Mazo mazoDeCartas = new Mazo(valoresTrucoYEnvido);
        // Jugada jugada = new Jugada(equipo1,equipo2, mazoDeCartas);

        equipo1.sumarPuntos(5);

        Carta copa10 = new Copa(10,valoresTrucoYEnvido);
        Carta copa4 = new Copa(4,valoresTrucoYEnvido);
        Carta copa5 = new Copa(5,valoresTrucoYEnvido);
        jugador1.agregarCarta(copa10);
        jugador1.agregarCarta(copa4);
        jugador1.agregarCarta(copa5);

        Carta oro11 = new Oro(11,valoresTrucoYEnvido);
        Carta oro4 = new Oro(4,valoresTrucoYEnvido);
        Carta oro5 = new Oro(5,valoresTrucoYEnvido);
        jugador2.agregarCarta(oro11);
        jugador2.agregarCarta(oro4);
        jugador2.agregarCarta(oro5);

        Carta espada12 = new Espada(12,valoresTrucoYEnvido);
        Carta espada6 = new Espada(6,valoresTrucoYEnvido);
        Carta espada7 = new Espada(7,valoresTrucoYEnvido);
        jugador3.agregarCarta(espada12);
        jugador3.agregarCarta(espada6);
        jugador3.agregarCarta(espada7);

        Carta basto5 = new Basto(5,valoresTrucoYEnvido);
        Carta basto4 = new Basto(4,valoresTrucoYEnvido);
        Carta basto3 = new Basto(3,valoresTrucoYEnvido);
        jugador4.agregarCarta(basto3);
        jugador4.agregarCarta(basto4);
        jugador4.agregarCarta(basto5);

        Carta espada10 = new Espada(10,valoresTrucoYEnvido);
        Carta espada1 = new Espada(1,valoresTrucoYEnvido);
        Carta espada4 = new Espada(4,valoresTrucoYEnvido);
        jugador5.agregarCarta(espada10);
        jugador5.agregarCarta(espada1);
        jugador5.agregarCarta(espada4);

        Carta basto7 = new Basto(7,valoresTrucoYEnvido);
        Carta basto6 = new Basto(6,valoresTrucoYEnvido);
        Carta basto2 = new Basto(2,valoresTrucoYEnvido);
        jugador6.agregarCarta(basto7);
        jugador6.agregarCarta(basto6);
        jugador6.agregarCarta(basto2);

        Jugada jugadaPP = partida.crearJugadaPicaPica();

        jugadaPP.armarEquiposParaPicaPica(jugador1, jugador6);
        partida.obtenerEquipo1();
        jugador1.cantarFlor(jugadaPP);
        jugador6.aceptarFlor(jugadaPP);

        jugador1.juegaCarta(copa10);
        jugador6.juegaCarta(basto7);

        jugadaPP.jugarMano();

        jugador1.juegaCarta(copa5);
        jugador6.cantarTruco(jugadaPP);
        jugador1.noAceptarTruco(jugadaPP);

        jugadaPP.jugarMano();

        partida.calcularPuntosPicaPica(jugadaPP);

        Assert.assertTrue(equipo1.obtenerPuntos() == 7);
        Assert.assertTrue(equipo2.obtenerPuntos() == 5);

        Jugada jugadaPP2 = partida.crearJugadaPicaPica();

        jugadaPP2.armarEquiposParaPicaPica(jugador2, jugador5);
        partida.obtenerEquipo1();
        jugador2.irseAlMazo(jugadaPP2);

        partida.calcularPuntosPicaPica(jugadaPP2);

        Assert.assertTrue(equipo1.obtenerPuntos() == 7);
        Assert.assertTrue(equipo2.obtenerPuntos() == 7);

        Jugada jugada = partida.crearJugada();

        jugador1.juegaCarta(espada10);
        jugador4.juegaCarta(basto2);
        jugador2.juegaCarta(copa10);
        jugador5.juegaCarta(oro11);
        jugador3.juegaCarta(basto5);
        jugador6.cantarEnvido(jugada);
        jugador1.aceptarEnvido(jugada);
        jugador6.juegaCarta(espada12);

        jugada.jugarMano();

        jugador4.juegaCarta(espada1);
        jugador2.irseAlMazo(jugada);



        Assert.assertTrue(equipo1.obtenerPuntos() == 9);
        Assert.assertTrue(equipo2.obtenerPuntos() == 8);


    }
    }
