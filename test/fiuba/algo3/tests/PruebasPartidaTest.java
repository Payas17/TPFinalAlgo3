package fiuba.algo3.tests;

import modelo.*;
import modelo.Carta.*;
import modelo.Errores.NoSePuedeJugarCartaError;
import modelo.Jugada.Jugada;
import modelo.Jugada.JugadaPicaPica;
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
    public void testPartidaTerminadaCuandoUnEquipoLlegaA30Puntos() {
        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Jugador jugador3 = new Jugador();
        jugadores.add(jugador3);
        Jugador jugador4 = new Jugador();
        jugadores2.add(jugador4);

        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        Partida partida = new Partida(equipo1, equipo2);

        partida.jugarConFlor();
        Jugada jugada = partida.crearJugada();

        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();

        Carta copa10 = new Copa(10, valoresTrucoYEnvido);
        Carta copa4 = new Copa(4, valoresTrucoYEnvido);
        Carta copa5 = new Copa(5, valoresTrucoYEnvido);
        jugador1.agregarCarta(copa10);
        jugador1.agregarCarta(copa4);
        jugador1.agregarCarta(copa5);

        Carta oro11 = new Oro(11, valoresTrucoYEnvido);
        Carta oro4 = new Oro(4, valoresTrucoYEnvido);
        Carta oro5 = new Oro(5, valoresTrucoYEnvido);
        jugador2.agregarCarta(oro11);
        jugador2.agregarCarta(oro4);
        jugador2.agregarCarta(oro5);

        Carta espada12 = new Espada(12, valoresTrucoYEnvido);
        Carta espada6 = new Espada(6, valoresTrucoYEnvido);
        Carta espada7 = new Espada(7, valoresTrucoYEnvido);
        jugador3.agregarCarta(espada12);
        jugador3.agregarCarta(espada6);
        jugador3.agregarCarta(espada7);

        Carta basto5 = new Basto(5, valoresTrucoYEnvido);
        Carta basto4 = new Basto(4, valoresTrucoYEnvido);
        Carta basto3 = new Basto(3, valoresTrucoYEnvido);
        jugador4.agregarCarta(basto3);
        jugador4.agregarCarta(basto4);
        jugador4.agregarCarta(basto5);

        jugador1.juegaCarta(copa10);
        jugador2.juegaCarta(oro11);
        jugador3.cantarFlor(jugada);
        jugador4.cantarContraFlorAlResto(jugada);
        jugador3.aceptarFlor(jugada);


        Assert.assertEquals(equipo1.obtenerPuntos(), 30);
        Assert.assertEquals(equipo2.obtenerPuntos(), 0);
        Assert.assertEquals(partida.obtenerEstado().getClass(), EstadoPartidaTerminada.class);
    }

    @Test(expected = NoSePuedeJugarCartaError.class)
    public void testPartidaTerminadaEntoncesDevuelveErrorSiSeQuiereSeguirJugando() {
        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Jugador jugador3 = new Jugador();
        jugadores.add(jugador3);
        Jugador jugador4 = new Jugador();
        jugadores2.add(jugador4);

        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        Partida partida = new Partida(equipo1, equipo2);

        partida.jugarConFlor();
        Jugada jugada = partida.crearJugada();


        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();

        Carta copa10 = new Copa(10, valoresTrucoYEnvido);
        Carta copa4 = new Copa(4, valoresTrucoYEnvido);
        Carta copa5 = new Copa(5, valoresTrucoYEnvido);
        jugador1.agregarCarta(copa10);
        jugador1.agregarCarta(copa4);
        jugador1.agregarCarta(copa5);

        Carta oro11 = new Oro(11, valoresTrucoYEnvido);
        Carta oro4 = new Oro(4, valoresTrucoYEnvido);
        Carta oro5 = new Oro(5, valoresTrucoYEnvido);
        jugador2.agregarCarta(oro11);
        jugador2.agregarCarta(oro4);
        jugador2.agregarCarta(oro5);

        Carta espada12 = new Espada(12, valoresTrucoYEnvido);
        Carta espada6 = new Espada(6, valoresTrucoYEnvido);
        Carta espada7 = new Espada(7, valoresTrucoYEnvido);
        jugador3.agregarCarta(espada12);
        jugador3.agregarCarta(espada6);
        jugador3.agregarCarta(espada7);

        Carta basto5 = new Basto(5, valoresTrucoYEnvido);
        Carta basto4 = new Basto(4, valoresTrucoYEnvido);
        Carta basto3 = new Basto(3, valoresTrucoYEnvido);
        jugador4.agregarCarta(basto3);
        jugador4.agregarCarta(basto4);
        jugador4.agregarCarta(basto5);

        jugador3.cantarFlor(jugada);
        jugador4.cantarContraFlorAlResto(jugada);
        jugador3.aceptarFlor(jugada);


        Assert.assertEquals(equipo1.obtenerPuntos(), 30);
        Assert.assertEquals(equipo2.obtenerPuntos(), 0);
        Assert.assertEquals(partida.obtenerEstado().getClass(), EstadoPartidaTerminada.class);

        jugador1.juegaCarta(copa10);
    }

    @Test
    public void testSeJuegaPartidaCompletaYDebeGanarElEquipo2Con30PuntosA24PorCantoDeTanto() {

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Jugador jugador3 = new Jugador();
        jugadores.add(jugador3);
        Jugador jugador4 = new Jugador();
        jugadores2.add(jugador4);

        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        Partida partida = new Partida(equipo1, equipo2);

        partida.jugarConFlor();
        Jugada jugada = partida.crearJugada();


        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();

        Carta copa10 = new Copa(10, valoresTrucoYEnvido);
        Carta copa4 = new Copa(4, valoresTrucoYEnvido);
        Carta copa5 = new Copa(5, valoresTrucoYEnvido);
        Carta espada12 = new Espada(12, valoresTrucoYEnvido);
        Carta espada6 = new Espada(6, valoresTrucoYEnvido);
        Carta espada7 = new Espada(7, valoresTrucoYEnvido);
        Carta oro11 = new Oro(11, valoresTrucoYEnvido);
        Carta oro4 = new Oro(4, valoresTrucoYEnvido);
        Carta oro5 = new Oro(5, valoresTrucoYEnvido);
        Carta basto5 = new Basto(5, valoresTrucoYEnvido);
        Carta basto4 = new Basto(4, valoresTrucoYEnvido);
        Carta basto3 = new Basto(3, valoresTrucoYEnvido);
        Carta espada1 = new Espada(1, valoresTrucoYEnvido);
        Carta espada10 = new Espada(10, valoresTrucoYEnvido);
        Carta copa3 = new Copa(3, valoresTrucoYEnvido);
        Carta oro3 = new Oro(3, valoresTrucoYEnvido);
        Carta espada3 = new Espada(3, valoresTrucoYEnvido);
        Carta oro2 = new Oro(2, valoresTrucoYEnvido);
        Carta basto2 = new Basto(2, valoresTrucoYEnvido);
        Carta espada2 = new Espada(2, valoresTrucoYEnvido);
        Carta copa2 = new Copa(2, valoresTrucoYEnvido);
        Carta espada4 = new Espada(4, valoresTrucoYEnvido);


        //Nueva Jugada
        jugador1.agregarCarta(copa10);
        jugador1.agregarCarta(copa4);
        jugador1.agregarCarta(copa5);


        jugador2.agregarCarta(oro11);
        jugador2.agregarCarta(oro4);
        jugador2.agregarCarta(oro5);


        jugador3.agregarCarta(espada12);
        jugador3.agregarCarta(espada6);
        jugador3.agregarCarta(espada7);


        jugador4.agregarCarta(basto3);
        jugador4.agregarCarta(basto4);
        jugador4.agregarCarta(basto5);

        jugador1.juegaCarta(copa4);
        jugador2.juegaCarta(oro4);
        jugador3.cantarFlor(jugada);
        jugador2.aceptarFlor(jugada);
        jugador3.juegaCarta(espada12);
        jugador4.juegaCarta(basto3);

        jugada.jugarMano();

        jugador4.cantarTruco(jugada);
        jugador1.noAceptarTruco(jugada);

        Assert.assertEquals(equipo1.obtenerPuntos(), 6);
        Assert.assertEquals(equipo2.obtenerPuntos(), 1);

        jugador1.sacarCartas();
        jugador2.sacarCartas();
        jugador3.sacarCartas();
        jugador4.sacarCartas();

        //Nueva Jugada
        jugada = partida.crearJugada();


        jugador1.agregarCarta(espada10);
        jugador1.agregarCarta(copa4);
        jugador1.agregarCarta(espada1);

        jugador2.agregarCarta(espada12);
        jugador2.agregarCarta(oro4);
        jugador2.agregarCarta(oro5);

        jugador3.agregarCarta(oro11);
        jugador3.agregarCarta(espada6);
        jugador3.agregarCarta(basto5);

        jugador4.agregarCarta(basto3);
        jugador4.agregarCarta(basto4);
        jugador4.agregarCarta(espada7);

        jugador2.juegaCarta(oro4);
        jugador3.juegaCarta(espada6);
        jugador4.juegaCarta(basto3);
        jugador1.cantarRealEnvido(jugada);
        jugador2.aceptarEnvido(jugada);
        jugador1.juegaCarta(espada1);

        jugada.jugarMano();

        jugador1.cantarTruco(jugada);
        jugador2.cantarReTruco(jugada);
        jugador1.cantarValeCuatro(jugada);
        jugador2.aceptarTruco(jugada);
        jugador1.juegaCarta(copa4);
        jugador2.juegaCarta(oro5);
        jugador3.juegaCarta(basto5);
        jugador4.juegaCarta(espada7);

        jugada.jugarMano();

        jugador4.juegaCarta(basto4);
        jugador1.juegaCarta(espada10);
        jugador2.juegaCarta(espada12);
        jugador3.juegaCarta(oro11);
        jugada.jugarMano();

        Assert.assertEquals(equipo1.obtenerPuntos(), 6);
        Assert.assertEquals(equipo2.obtenerPuntos(), 8);

        jugador1.sacarCartas();
        jugador2.sacarCartas();
        jugador3.sacarCartas();
        jugador4.sacarCartas();

        //Nueva Jugada
        jugada = partida.crearJugada();

        jugador1.agregarCarta(espada10);
        jugador1.agregarCarta(copa4);
        jugador1.agregarCarta(espada1);

        jugador2.agregarCarta(espada12);
        jugador2.agregarCarta(oro4);
        jugador2.agregarCarta(oro5);

        jugador3.agregarCarta(oro11);
        jugador3.agregarCarta(espada6);
        jugador3.agregarCarta(espada4);

        jugador4.agregarCarta(basto3);
        jugador4.agregarCarta(basto4);
        jugador4.agregarCarta(espada7);

        jugador3.juegaCarta(espada4);
        jugador4.juegaCarta(basto4);
        jugador1.cantarFaltaEnvido(jugada);
        jugador2.aceptarEnvido(jugada);
        jugador1.juegaCarta(copa4);
        jugador2.juegaCarta(oro4);

        jugada.jugarMano();

        jugador3.cantarTruco(jugada);
        jugador4.cantarReTruco(jugada);
        jugador3.cantarValeCuatro(jugada);
        jugador4.aceptarTruco(jugada);

        jugador3.juegaCarta(oro11);
        jugador4.juegaCarta(espada7);
        jugador1.juegaCarta(espada1);
        jugador2.juegaCarta(espada12);

        jugada.jugarMano();

        Assert.assertEquals(equipo1.obtenerPuntos(), 17);
        Assert.assertEquals(equipo2.obtenerPuntos(), 8);

        jugador1.sacarCartas();
        jugador2.sacarCartas();
        jugador3.sacarCartas();
        jugador4.sacarCartas();

        //Nueva Partida
        jugada = partida.crearJugada();

        jugador1.agregarCarta(espada10);
        jugador1.agregarCarta(copa4);
        jugador1.agregarCarta(copa3);

        jugador2.agregarCarta(espada12);
        jugador2.agregarCarta(oro4);
        jugador2.agregarCarta(oro3);

        jugador3.agregarCarta(oro11);
        jugador3.agregarCarta(espada4);
        jugador3.agregarCarta(espada3);

        jugador4.agregarCarta(basto3);
        jugador4.agregarCarta(basto4);
        jugador4.agregarCarta(espada7);

        jugador4.juegaCarta(basto3);
        jugador1.juegaCarta(copa3);
        jugador2.cantarFaltaEnvido(jugada);
        jugador1.aceptarEnvido(jugada);
        jugador2.juegaCarta(oro3);
        jugador3.juegaCarta(espada3);

        jugada.jugarMano();

        jugador4.cantarTruco(jugada);
        jugador3.cantarReTruco(jugada);
        jugador4.cantarValeCuatro(jugada);
        jugador3.aceptarTruco(jugada);
        jugador4.juegaCarta(basto4);
        jugador1.juegaCarta(copa4);
        jugador2.juegaCarta(oro4);
        jugador3.juegaCarta(espada4);

        jugada.jugarMano();

        jugador4.juegaCarta(espada7);
        jugador1.juegaCarta(espada10);
        jugador2.juegaCarta(espada12);
        jugador3.juegaCarta(oro11);

        jugada.jugarMano();

        Assert.assertEquals(equipo1.obtenerPuntos(), 17);
        Assert.assertEquals(equipo2.obtenerPuntos(), 25);

        jugador1.sacarCartas();
        jugador2.sacarCartas();
        jugador3.sacarCartas();
        jugador4.sacarCartas();

        //Nueva Partida
        jugada = partida.crearJugada();

        jugador1.agregarCarta(basto2);
        jugador1.agregarCarta(copa4);
        jugador1.agregarCarta(copa3);

        jugador2.agregarCarta(copa2);
        jugador2.agregarCarta(oro4);
        jugador2.agregarCarta(oro3);

        jugador3.agregarCarta(oro2);
        jugador3.agregarCarta(espada4);
        jugador3.agregarCarta(espada3);

        jugador4.agregarCarta(basto3);
        jugador4.agregarCarta(basto4);
        jugador4.agregarCarta(espada2);

        jugador1.juegaCarta(copa3);
        jugador2.juegaCarta(oro3);
        jugador3.cantarFaltaEnvido(jugada);
        jugador2.aceptarEnvido(jugada);
        jugador3.juegaCarta(espada3);
        jugador4.juegaCarta(basto3);


        jugada.jugarMano();

        jugador1.juegaCarta(copa4);
        jugador2.juegaCarta(oro4);
        jugador3.juegaCarta(espada4);
        jugador4.cantarTruco(jugada);
        jugador3.aceptarTruco(jugada);
        jugador4.juegaCarta(basto4);


        jugada.jugarMano();

        jugador1.juegaCarta(basto2);
        jugador2.juegaCarta(copa2);
        jugador3.juegaCarta(oro2);
        jugador4.juegaCarta(espada2);


        jugada.jugarMano();

        Assert.assertEquals(equipo1.obtenerPuntos(), 24);
        Assert.assertEquals(equipo2.obtenerPuntos(), 25);

        jugador1.sacarCartas();
        jugador2.sacarCartas();
        jugador3.sacarCartas();
        jugador4.sacarCartas();

        //Nueva Partida
        jugada = partida.crearJugada();

        jugador1.agregarCarta(basto2);
        jugador1.agregarCarta(copa4);
        jugador1.agregarCarta(copa3);

        jugador2.agregarCarta(copa2);
        jugador2.agregarCarta(oro4);
        jugador2.agregarCarta(oro3);

        jugador3.agregarCarta(oro2);
        jugador3.agregarCarta(espada4);
        jugador3.agregarCarta(espada3);

        jugador4.agregarCarta(basto3);
        jugador4.agregarCarta(basto4);
        jugador4.agregarCarta(espada2);

        jugador2.juegaCarta(oro3);
        jugador3.juegaCarta(espada3);
        jugador4.cantarEnvido(jugada);
        jugador3.cantarRealEnvido(jugada);
        jugador4.cantarFaltaEnvido(jugada);
        jugador3.noAceptarEnvido(jugada);

        Assert.assertEquals(equipo1.obtenerPuntos(), 24);
        Assert.assertEquals(equipo2.obtenerPuntos(), 30);
        Assert.assertEquals(partida.obtenerEstado().getClass(), EstadoPartidaTerminada.class);

    }

    @Test
    public void testSeJuegaPartidaCompletaYDebeGanarElEquipo2Con30PuntosA24PorCantoDeTruco() {

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Jugador jugador3 = new Jugador();
        jugadores.add(jugador3);
        Jugador jugador4 = new Jugador();
        jugadores2.add(jugador4);

        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        Partida partida = new Partida(equipo1, equipo2);

        partida.jugarConFlor();
        Jugada jugada = partida.crearJugada();


        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();

        Carta copa10 = new Copa(10, valoresTrucoYEnvido);
        Carta copa4 = new Copa(4, valoresTrucoYEnvido);
        Carta copa5 = new Copa(5, valoresTrucoYEnvido);
        Carta espada12 = new Espada(12, valoresTrucoYEnvido);
        Carta espada6 = new Espada(6, valoresTrucoYEnvido);
        Carta espada7 = new Espada(7, valoresTrucoYEnvido);
        Carta oro11 = new Oro(11, valoresTrucoYEnvido);
        Carta oro4 = new Oro(4, valoresTrucoYEnvido);
        Carta oro5 = new Oro(5, valoresTrucoYEnvido);
        Carta basto5 = new Basto(5, valoresTrucoYEnvido);
        Carta basto4 = new Basto(4, valoresTrucoYEnvido);
        Carta basto3 = new Basto(3, valoresTrucoYEnvido);
        Carta espada1 = new Espada(1, valoresTrucoYEnvido);
        Carta espada10 = new Espada(10, valoresTrucoYEnvido);
        Carta copa3 = new Copa(3, valoresTrucoYEnvido);
        Carta oro3 = new Oro(3, valoresTrucoYEnvido);
        Carta espada3 = new Espada(3, valoresTrucoYEnvido);
        Carta oro2 = new Oro(2, valoresTrucoYEnvido);
        Carta basto2 = new Basto(2, valoresTrucoYEnvido);
        Carta espada2 = new Espada(2, valoresTrucoYEnvido);
        Carta copa2 = new Copa(2, valoresTrucoYEnvido);
        Carta espada4 = new Espada(4, valoresTrucoYEnvido);


        //Nueva Jugada
        jugador1.agregarCarta(copa10);
        jugador1.agregarCarta(copa4);
        jugador1.agregarCarta(copa5);


        jugador2.agregarCarta(oro11);
        jugador2.agregarCarta(oro4);
        jugador2.agregarCarta(oro5);


        jugador3.agregarCarta(espada12);
        jugador3.agregarCarta(espada6);
        jugador3.agregarCarta(espada7);


        jugador4.agregarCarta(basto3);
        jugador4.agregarCarta(basto4);
        jugador4.agregarCarta(basto5);

        jugador1.juegaCarta(copa4);
        jugador2.juegaCarta(oro4);
        jugador3.cantarFlor(jugada);
        jugador2.aceptarFlor(jugada);
        jugador3.juegaCarta(espada12);
        jugador4.juegaCarta(basto3);

        jugada.jugarMano();

        jugador4.cantarTruco(jugada);
        jugador1.noAceptarTruco(jugada);

        Assert.assertEquals(equipo1.obtenerPuntos(), 6);
        Assert.assertEquals(equipo2.obtenerPuntos(), 1);

        jugador1.sacarCartas();
        jugador2.sacarCartas();
        jugador3.sacarCartas();
        jugador4.sacarCartas();

        //Nueva Jugada
        jugada = partida.crearJugada();


        jugador1.agregarCarta(espada10);
        jugador1.agregarCarta(copa4);
        jugador1.agregarCarta(espada1);

        jugador2.agregarCarta(espada12);
        jugador2.agregarCarta(oro4);
        jugador2.agregarCarta(oro5);

        jugador3.agregarCarta(oro11);
        jugador3.agregarCarta(espada6);
        jugador3.agregarCarta(basto5);

        jugador4.agregarCarta(basto3);
        jugador4.agregarCarta(basto4);
        jugador4.agregarCarta(espada7);

        jugador2.juegaCarta(oro4);
        jugador3.juegaCarta(espada6);
        jugador4.juegaCarta(basto3);
        jugador1.cantarRealEnvido(jugada);
        jugador2.aceptarEnvido(jugada);
        jugador1.juegaCarta(espada1);

        jugada.jugarMano();

        jugador1.cantarTruco(jugada);
        jugador2.cantarReTruco(jugada);
        jugador1.cantarValeCuatro(jugada);
        jugador2.aceptarTruco(jugada);
        jugador1.juegaCarta(copa4);
        jugador2.juegaCarta(oro5);
        jugador3.juegaCarta(basto5);
        jugador4.juegaCarta(espada7);

        jugada.jugarMano();

        jugador4.juegaCarta(basto4);
        jugador1.juegaCarta(espada10);
        jugador2.juegaCarta(espada12);
        jugador3.juegaCarta(oro11);
        jugada.jugarMano();

        Assert.assertEquals(equipo1.obtenerPuntos(), 6);
        Assert.assertEquals(equipo2.obtenerPuntos(), 8);

        jugador1.sacarCartas();
        jugador2.sacarCartas();
        jugador3.sacarCartas();
        jugador4.sacarCartas();

        //Nueva Jugada
        jugada = partida.crearJugada();

        jugador1.agregarCarta(espada10);
        jugador1.agregarCarta(copa4);
        jugador1.agregarCarta(espada1);

        jugador2.agregarCarta(espada12);
        jugador2.agregarCarta(oro4);
        jugador2.agregarCarta(oro5);

        jugador3.agregarCarta(oro11);
        jugador3.agregarCarta(espada6);
        jugador3.agregarCarta(espada4);

        jugador4.agregarCarta(basto3);
        jugador4.agregarCarta(basto4);
        jugador4.agregarCarta(espada7);

        jugador3.juegaCarta(espada4);
        jugador4.juegaCarta(basto4);
        jugador1.cantarFaltaEnvido(jugada);
        jugador2.aceptarEnvido(jugada);
        jugador1.juegaCarta(copa4);
        jugador2.juegaCarta(oro4);

        jugada.jugarMano();

        jugador3.cantarTruco(jugada);
        jugador4.cantarReTruco(jugada);
        jugador3.cantarValeCuatro(jugada);
        jugador4.aceptarTruco(jugada);

        jugador3.juegaCarta(oro11);
        jugador4.juegaCarta(espada7);
        jugador1.juegaCarta(espada1);
        jugador2.juegaCarta(espada12);

        jugada.jugarMano();

        Assert.assertEquals(equipo1.obtenerPuntos(), 17);
        Assert.assertEquals(equipo2.obtenerPuntos(), 8);

        jugador1.sacarCartas();
        jugador2.sacarCartas();
        jugador3.sacarCartas();
        jugador4.sacarCartas();

        //Nueva Partida
        jugada = partida.crearJugada();

        jugador1.agregarCarta(espada10);
        jugador1.agregarCarta(copa4);
        jugador1.agregarCarta(copa3);

        jugador2.agregarCarta(espada12);
        jugador2.agregarCarta(oro4);
        jugador2.agregarCarta(oro3);

        jugador3.agregarCarta(oro11);
        jugador3.agregarCarta(espada4);
        jugador3.agregarCarta(espada3);

        jugador4.agregarCarta(basto3);
        jugador4.agregarCarta(basto4);
        jugador4.agregarCarta(espada7);

        jugador4.juegaCarta(basto3);
        jugador1.juegaCarta(copa3);
        jugador2.cantarFaltaEnvido(jugada);
        jugador1.aceptarEnvido(jugada);
        jugador2.juegaCarta(oro3);
        jugador3.juegaCarta(espada3);

        jugada.jugarMano();

        jugador4.cantarTruco(jugada);
        jugador3.cantarReTruco(jugada);
        jugador4.cantarValeCuatro(jugada);
        jugador3.aceptarTruco(jugada);
        jugador4.juegaCarta(basto4);
        jugador1.juegaCarta(copa4);
        jugador2.juegaCarta(oro4);
        jugador3.juegaCarta(espada4);

        jugada.jugarMano();

        jugador4.juegaCarta(espada7);
        jugador1.juegaCarta(espada10);
        jugador2.juegaCarta(espada12);
        jugador3.juegaCarta(oro11);

        jugada.jugarMano();

        Assert.assertEquals(equipo1.obtenerPuntos(), 17);
        Assert.assertEquals(equipo2.obtenerPuntos(), 25);

        jugador1.sacarCartas();
        jugador2.sacarCartas();
        jugador3.sacarCartas();
        jugador4.sacarCartas();

        //Nueva Partida
        jugada = partida.crearJugada();

        jugador1.agregarCarta(basto2);
        jugador1.agregarCarta(copa4);
        jugador1.agregarCarta(copa3);

        jugador2.agregarCarta(copa2);
        jugador2.agregarCarta(oro4);
        jugador2.agregarCarta(oro3);

        jugador3.agregarCarta(oro2);
        jugador3.agregarCarta(espada4);
        jugador3.agregarCarta(espada3);

        jugador4.agregarCarta(basto3);
        jugador4.agregarCarta(basto4);
        jugador4.agregarCarta(espada2);

        jugador1.juegaCarta(copa3);
        jugador2.juegaCarta(oro3);
        jugador3.cantarFaltaEnvido(jugada);
        jugador2.aceptarEnvido(jugada);
        jugador3.juegaCarta(espada3);
        jugador4.juegaCarta(basto3);


        jugada.jugarMano();

        jugador1.juegaCarta(copa4);
        jugador2.juegaCarta(oro4);
        jugador3.juegaCarta(espada4);
        jugador4.cantarTruco(jugada);
        jugador3.aceptarTruco(jugada);
        jugador4.juegaCarta(basto4);


        jugada.jugarMano();

        jugador1.juegaCarta(basto2);
        jugador2.juegaCarta(copa2);
        jugador3.juegaCarta(oro2);
        jugador4.juegaCarta(espada2);


        jugada.jugarMano();

        Assert.assertEquals(equipo1.obtenerPuntos(), 24);
        Assert.assertEquals(equipo2.obtenerPuntos(), 25);

        jugador1.sacarCartas();
        jugador2.sacarCartas();
        jugador3.sacarCartas();
        jugador4.sacarCartas();

        //Nueva Partida
        jugada = partida.crearJugada();

        jugador1.agregarCarta(basto2);
        jugador1.agregarCarta(copa4);
        jugador1.agregarCarta(copa3);

        jugador2.agregarCarta(copa2);
        jugador2.agregarCarta(oro4);
        jugador2.agregarCarta(oro3);

        jugador3.agregarCarta(oro2);
        jugador3.agregarCarta(espada4);
        jugador3.agregarCarta(espada3);

        jugador4.agregarCarta(basto3);
        jugador4.agregarCarta(basto4);
        jugador4.agregarCarta(espada2);

        jugador2.juegaCarta(oro3);
        jugador3.juegaCarta(espada4);
        jugador4.juegaCarta(basto4);

        jugador1.cantarEnvido(jugada);
        jugador2.cantarEnvido(jugada);
        jugador1.noAceptarEnvido(jugada);

        jugador1.cantarTruco(jugada);
        jugador2.cantarReTruco(jugada);
        jugador1.cantarValeCuatro(jugada);
        jugador2.aceptarTruco(jugada);

        jugador1.juegaCarta(basto2);

        jugada.jugarMano();

        jugador3.juegaCarta(oro2);
        jugador4.juegaCarta(basto3);
        jugador1.juegaCarta(copa4);
        jugador2.juegaCarta(copa2);

        jugada.jugarMano();

        Assert.assertEquals(equipo1.obtenerPuntos(), 24);
        Assert.assertEquals(equipo2.obtenerPuntos(), 31);
        Assert.assertEquals(partida.obtenerEstado().getClass(), EstadoPartidaTerminada.class);

    }

    @Test
    public void testSeJueganDosPicaPica() {

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Jugador jugador3 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        jugadores.add(jugador3);

        Jugador jugador4 = new Jugador();
        Jugador jugador5 = new Jugador();
        Jugador jugador6 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador4);
        jugadores2.add(jugador5);
        jugadores2.add(jugador6);

        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        Partida partida = new Partida(equipo1, equipo2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Mazo mazoDeCartas = new Mazo(valoresTrucoYEnvido);
        // Jugada jugada = new Jugada(equipo1,equipo2, mazoDeCartas);

        equipo1.sumarPuntos(5);

        Carta copa10 = new Copa(10, valoresTrucoYEnvido);
        Carta copa4 = new Copa(4, valoresTrucoYEnvido);
        Carta copa5 = new Copa(5, valoresTrucoYEnvido);
        jugador1.agregarCarta(copa10);
        jugador1.agregarCarta(copa4);
        jugador1.agregarCarta(copa5);

        Carta oro11 = new Oro(11, valoresTrucoYEnvido);
        Carta oro4 = new Oro(4, valoresTrucoYEnvido);
        Carta oro5 = new Oro(5, valoresTrucoYEnvido);
        jugador2.agregarCarta(oro11);
        jugador2.agregarCarta(oro4);
        jugador2.agregarCarta(oro5);

        Carta espada12 = new Espada(12, valoresTrucoYEnvido);
        Carta espada6 = new Espada(6, valoresTrucoYEnvido);
        Carta espada7 = new Espada(7, valoresTrucoYEnvido);
        jugador3.agregarCarta(espada12);
        jugador3.agregarCarta(espada6);
        jugador3.agregarCarta(espada7);

        Carta basto5 = new Basto(5, valoresTrucoYEnvido);
        Carta basto4 = new Basto(4, valoresTrucoYEnvido);
        Carta basto3 = new Basto(3, valoresTrucoYEnvido);
        jugador4.agregarCarta(basto3);
        jugador4.agregarCarta(basto4);
        jugador4.agregarCarta(basto5);

        Carta espada10 = new Espada(10, valoresTrucoYEnvido);
        Carta espada1 = new Espada(1, valoresTrucoYEnvido);
        Carta espada4 = new Espada(4, valoresTrucoYEnvido);
        jugador5.agregarCarta(espada10);
        jugador5.agregarCarta(espada1);
        jugador5.agregarCarta(espada4);

        Carta basto7 = new Basto(7, valoresTrucoYEnvido);
        Carta basto6 = new Basto(6, valoresTrucoYEnvido);
        Carta basto2 = new Basto(2, valoresTrucoYEnvido);
        jugador6.agregarCarta(basto7);
        jugador6.agregarCarta(basto6);
        jugador6.agregarCarta(basto2);

        JugadaPicaPica jugadaPP = partida.crearJugadaPicaPica();

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

        Assert.assertEquals(equipo1.obtenerPuntos() , 7);
        Assert.assertEquals(equipo2.obtenerPuntos() , 5);

        JugadaPicaPica jugadaPP2 = partida.crearJugadaPicaPica();

        jugadaPP2.armarEquiposParaPicaPica(jugador2, jugador5);
        partida.obtenerEquipo1();
        jugador2.irseAlMazo(jugadaPP2);

        partida.calcularPuntosPicaPica(jugadaPP2);

        Assert.assertEquals(equipo1.obtenerPuntos(), 7);
        Assert.assertEquals(equipo2.obtenerPuntos(), 7);

    }

    @Test
    public void testPicaPicaYDespuesJugadaNormal() {

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Jugador jugador3 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        jugadores.add(jugador3);

        Jugador jugador4 = new Jugador();
        Jugador jugador5 = new Jugador();
        Jugador jugador6 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador4);
        jugadores2.add(jugador5);
        jugadores2.add(jugador6);

        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        Partida partida = new Partida(equipo1, equipo2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();


        Carta copa10 = new Copa(10, valoresTrucoYEnvido);
        Carta copa4 = new Copa(4, valoresTrucoYEnvido);
        Carta copa5 = new Copa(5, valoresTrucoYEnvido);
        jugador1.agregarCarta(copa10);
        jugador1.agregarCarta(copa4);
        jugador1.agregarCarta(copa5);

        Carta oro11 = new Oro(11, valoresTrucoYEnvido);
        Carta oro4 = new Oro(4, valoresTrucoYEnvido);
        Carta oro5 = new Oro(5, valoresTrucoYEnvido);
        jugador2.agregarCarta(oro11);
        jugador2.agregarCarta(oro4);
        jugador2.agregarCarta(oro5);

        Carta espada12 = new Espada(12, valoresTrucoYEnvido);
        Carta espada6 = new Espada(6, valoresTrucoYEnvido);
        Carta espada7 = new Espada(7, valoresTrucoYEnvido);
        jugador3.agregarCarta(espada12);
        jugador3.agregarCarta(espada6);
        jugador3.agregarCarta(espada7);

        Carta basto5 = new Basto(5, valoresTrucoYEnvido);
        Carta basto4 = new Basto(4, valoresTrucoYEnvido);
        Carta basto3 = new Basto(3, valoresTrucoYEnvido);
        jugador4.agregarCarta(basto3);
        jugador4.agregarCarta(basto4);
        jugador4.agregarCarta(basto5);

        Carta espada10 = new Espada(10, valoresTrucoYEnvido);
        Carta espada1 = new Espada(1, valoresTrucoYEnvido);
        Carta espada4 = new Espada(4, valoresTrucoYEnvido);
        jugador5.agregarCarta(espada10);
        jugador5.agregarCarta(espada1);
        jugador5.agregarCarta(espada4);

        Carta basto7 = new Basto(7, valoresTrucoYEnvido);
        Carta basto6 = new Basto(6, valoresTrucoYEnvido);
        Carta basto2 = new Basto(2, valoresTrucoYEnvido);
        jugador6.agregarCarta(basto7);
        jugador6.agregarCarta(basto6);
        jugador6.agregarCarta(basto2);

        JugadaPicaPica jugadaPP = partida.crearJugadaPicaPica();

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

        Assert.assertTrue(equipo1.obtenerPuntos() == 2);
        Assert.assertTrue(equipo2.obtenerPuntos() == 5);

        JugadaPicaPica jugadaPP2 = partida.crearJugadaPicaPica();

        jugadaPP2.armarEquiposParaPicaPica(jugador2, jugador5);
        partida.obtenerEquipo1();
        jugador2.irseAlMazo(jugadaPP2);

        partida.calcularPuntosPicaPica(jugadaPP2);

        Assert.assertTrue(equipo1.obtenerPuntos() == 2);
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


        Assert.assertTrue(equipo1.obtenerPuntos() == 4);
        Assert.assertTrue(equipo2.obtenerPuntos() == 8);


    }
    @Test
    public void testFaltaEnvidoEnPicaPicaSuma6Puntos() {

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Jugador jugador3 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        jugadores.add(jugador3);

        Jugador jugador4 = new Jugador();
        Jugador jugador5 = new Jugador();
        Jugador jugador6 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador4);
        jugadores2.add(jugador5);
        jugadores2.add(jugador6);

        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        Partida partida = new Partida(equipo1, equipo2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();


        equipo1.sumarPuntos(5);

        Carta copa10 = new Copa(10, valoresTrucoYEnvido);
        Carta copa4 = new Copa(4, valoresTrucoYEnvido);
        Carta copa5 = new Copa(5, valoresTrucoYEnvido);
        jugador1.agregarCarta(copa10);
        jugador1.agregarCarta(copa4);
        jugador1.agregarCarta(copa5);

        Carta oro11 = new Oro(11, valoresTrucoYEnvido);
        Carta oro4 = new Oro(4, valoresTrucoYEnvido);
        Carta oro5 = new Oro(5, valoresTrucoYEnvido);
        jugador2.agregarCarta(oro11);
        jugador2.agregarCarta(oro4);
        jugador2.agregarCarta(oro5);

        Carta espada12 = new Espada(12, valoresTrucoYEnvido);
        Carta espada6 = new Espada(6, valoresTrucoYEnvido);
        Carta espada7 = new Espada(7, valoresTrucoYEnvido);
        jugador3.agregarCarta(espada12);
        jugador3.agregarCarta(espada6);
        jugador3.agregarCarta(espada7);

        Carta basto5 = new Basto(5, valoresTrucoYEnvido);
        Carta basto4 = new Basto(4, valoresTrucoYEnvido);
        Carta basto3 = new Basto(3, valoresTrucoYEnvido);
        jugador4.agregarCarta(basto3);
        jugador4.agregarCarta(basto4);
        jugador4.agregarCarta(basto5);

        Carta espada10 = new Espada(10, valoresTrucoYEnvido);
        Carta espada1 = new Espada(1, valoresTrucoYEnvido);
        Carta espada4 = new Espada(4, valoresTrucoYEnvido);
        jugador5.agregarCarta(espada10);
        jugador5.agregarCarta(espada1);
        jugador5.agregarCarta(espada4);

        Carta basto7 = new Basto(7, valoresTrucoYEnvido);
        Carta basto6 = new Basto(6, valoresTrucoYEnvido);
        Carta basto2 = new Basto(2, valoresTrucoYEnvido);
        jugador6.agregarCarta(basto7);
        jugador6.agregarCarta(basto6);
        jugador6.agregarCarta(basto2);

        JugadaPicaPica jugadaPP = partida.crearJugadaPicaPica();

        jugadaPP.armarEquiposParaPicaPica(jugador1, jugador6);
        partida.obtenerEquipo1();
        jugador1.cantarFaltaEnvido(jugadaPP);
        jugador6.aceptarEnvido(jugadaPP);

        partida.calcularPuntosPicaPica(jugadaPP);

        Assert.assertTrue(equipo1.obtenerPuntos() == 5);
        Assert.assertTrue(equipo2.obtenerPuntos() == 6);
}
    @Test
    public void testContraFlorAlRestoEnPicaPicaSuma6Puntos() {

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Jugador jugador3 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        jugadores.add(jugador3);

        Jugador jugador4 = new Jugador();
        Jugador jugador5 = new Jugador();
        Jugador jugador6 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador4);
        jugadores2.add(jugador5);
        jugadores2.add(jugador6);

        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        Partida partida = new Partida(equipo1, equipo2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();


        equipo1.sumarPuntos(5);

        Carta copa10 = new Copa(10, valoresTrucoYEnvido);
        Carta copa4 = new Copa(4, valoresTrucoYEnvido);
        Carta copa5 = new Copa(5, valoresTrucoYEnvido);
        jugador1.agregarCarta(copa10);
        jugador1.agregarCarta(copa4);
        jugador1.agregarCarta(copa5);

        Carta oro11 = new Oro(11, valoresTrucoYEnvido);
        Carta oro4 = new Oro(4, valoresTrucoYEnvido);
        Carta oro5 = new Oro(5, valoresTrucoYEnvido);
        jugador2.agregarCarta(oro11);
        jugador2.agregarCarta(oro4);
        jugador2.agregarCarta(oro5);

        Carta espada12 = new Espada(12, valoresTrucoYEnvido);
        Carta espada6 = new Espada(6, valoresTrucoYEnvido);
        Carta espada7 = new Espada(7, valoresTrucoYEnvido);
        jugador3.agregarCarta(espada12);
        jugador3.agregarCarta(espada6);
        jugador3.agregarCarta(espada7);

        Carta basto5 = new Basto(5, valoresTrucoYEnvido);
        Carta basto4 = new Basto(4, valoresTrucoYEnvido);
        Carta basto3 = new Basto(3, valoresTrucoYEnvido);
        jugador4.agregarCarta(basto3);
        jugador4.agregarCarta(basto4);
        jugador4.agregarCarta(basto5);

        Carta espada10 = new Espada(10, valoresTrucoYEnvido);
        Carta espada1 = new Espada(1, valoresTrucoYEnvido);
        Carta espada4 = new Espada(4, valoresTrucoYEnvido);
        jugador5.agregarCarta(espada10);
        jugador5.agregarCarta(espada1);
        jugador5.agregarCarta(espada4);

        Carta basto7 = new Basto(7, valoresTrucoYEnvido);
        Carta basto6 = new Basto(6, valoresTrucoYEnvido);
        Carta basto2 = new Basto(2, valoresTrucoYEnvido);
        jugador6.agregarCarta(basto7);
        jugador6.agregarCarta(basto6);
        jugador6.agregarCarta(basto2);

        JugadaPicaPica jugadaPP = partida.crearJugadaPicaPica();

        jugadaPP.armarEquiposParaPicaPica(jugador1, jugador6);
        partida.obtenerEquipo1();
        jugador1.cantarFlor(jugadaPP);
        jugador6.cantarContraFlorAlResto(jugadaPP);
        jugador1.aceptarFlor(jugadaPP);

        partida.calcularPuntosPicaPica(jugadaPP);

        Assert.assertEquals(equipo1.obtenerPuntos(),5);
        Assert.assertEquals(equipo2.obtenerPuntos(),6);

    }

    @Test
    public void testSeJuegaPartidaCompletaConPicaPicaYDebeGanarElEquipo2() {

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Jugador jugador3 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        jugadores.add(jugador3);

        Jugador jugador4 = new Jugador();
        Jugador jugador5 = new Jugador();
        Jugador jugador6 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador4);
        jugadores2.add(jugador5);
        jugadores2.add(jugador6);

        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        Partida partida = new Partida(equipo1, equipo2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();

        partida.jugarConFlor();
        Jugada jugada = partida.crearJugada();

        Carta copa10 = new Copa(10, valoresTrucoYEnvido);
        Carta copa4 = new Copa(4, valoresTrucoYEnvido);
        Carta copa5 = new Copa(5, valoresTrucoYEnvido);
        Carta espada12 = new Espada(12, valoresTrucoYEnvido);
        Carta espada6 = new Espada(6, valoresTrucoYEnvido);
        Carta espada7 = new Espada(7, valoresTrucoYEnvido);
        Carta oro11 = new Oro(11, valoresTrucoYEnvido);
        Carta oro4 = new Oro(4, valoresTrucoYEnvido);
        Carta oro5 = new Oro(5, valoresTrucoYEnvido);
        Carta basto5 = new Basto(5, valoresTrucoYEnvido);
        Carta basto4 = new Basto(4, valoresTrucoYEnvido);
        Carta basto3 = new Basto(3, valoresTrucoYEnvido);
        Carta espada1 = new Espada(1, valoresTrucoYEnvido);
        Carta espada10 = new Espada(10, valoresTrucoYEnvido);
        Carta copa3 = new Copa(3, valoresTrucoYEnvido);
        Carta oro3 = new Oro(3, valoresTrucoYEnvido);
        Carta espada3 = new Espada(3, valoresTrucoYEnvido);
        Carta oro2 = new Oro(2, valoresTrucoYEnvido);
        Carta basto2 = new Basto(2, valoresTrucoYEnvido);
        Carta espada2 = new Espada(2, valoresTrucoYEnvido);
        Carta copa2 = new Copa(2, valoresTrucoYEnvido);
        Carta espada4 = new Espada(4, valoresTrucoYEnvido);


        //Nueva Jugada
        jugador1.agregarCarta(copa10);
        jugador1.agregarCarta(copa4);
        jugador1.agregarCarta(copa5);

        jugador2.agregarCarta(oro11);
        jugador2.agregarCarta(oro4);
        jugador2.agregarCarta(oro5);


        jugador3.agregarCarta(espada12);
        jugador3.agregarCarta(espada6);
        jugador3.agregarCarta(espada7);


        jugador4.agregarCarta(basto3);
        jugador4.agregarCarta(basto4);
        jugador4.agregarCarta(basto5);

        jugador5.agregarCarta(basto2);
        jugador5.agregarCarta(basto4);
        jugador5.agregarCarta(basto3);

        jugador6.agregarCarta(copa10);
        jugador6.agregarCarta(copa3);
        jugador6.agregarCarta(copa4);


        jugador1.juegaCarta(copa4);
        jugador4.juegaCarta(basto3);
        jugador2.juegaCarta(oro4);
        jugador5.juegaCarta(basto4);
        jugador3.juegaCarta(espada12);
        jugador6.cantarFlor(jugada);
        jugador2.aceptarFlor(jugada);
        jugador6.juegaCarta(copa4);

        jugada.jugarMano();

        jugador4.cantarTruco(jugada);
        jugador1.noAceptarTruco(jugada);

        Assert.assertEquals(equipo1.obtenerPuntos(), 4);
        Assert.assertEquals(equipo2.obtenerPuntos(), 3);

        jugador1.sacarCartas();
        jugador2.sacarCartas();
        jugador3.sacarCartas();
        jugador4.sacarCartas();
        jugador5.sacarCartas();
        jugador6.sacarCartas();

        //Termino partida normal arranca PICA PICA
        JugadaPicaPica jugadaPP = partida.crearJugadaPicaPica();


        jugador1.agregarCarta(espada10);
        jugador1.agregarCarta(copa4);
        jugador1.agregarCarta(espada1);

        jugador5.agregarCarta(basto2);
        jugador5.agregarCarta(basto4);
        jugador5.agregarCarta(basto3);

        jugadaPP.armarEquiposParaPicaPica(jugador1,jugador5);

        jugador1.juegaCarta(espada10);
        jugador5.juegaCarta(basto4);

        jugadaPP.jugarMano();

        jugador1.cantarTruco(jugadaPP);
        jugador5.noAceptarTruco(jugadaPP);

        partida.calcularPuntosPicaPica(jugadaPP);

        Assert.assertEquals(equipo1.obtenerPuntos(),5);
        Assert.assertEquals(equipo2.obtenerPuntos(),3);

        //Nueva jugada pica pica

        JugadaPicaPica jugadaPP2 = partida.crearJugadaPicaPica();

        jugador4.agregarCarta(basto3);
        jugador4.agregarCarta(basto4);
        jugador4.agregarCarta(espada7);

        jugador3.agregarCarta(oro11);
        jugador3.agregarCarta(espada6);
        jugador3.agregarCarta(basto5);

        jugadaPP2.armarEquiposParaPicaPica(jugador4,jugador3);

        jugador4.cantarFaltaEnvido(jugadaPP2);
        jugador3.aceptarEnvido(jugadaPP2);
        jugador4.cantarTruco(jugadaPP2);
        jugador3.noAceptarTruco(jugadaPP2);

        partida.calcularPuntosPicaPica(jugadaPP2);

        Assert.assertEquals(equipo1.obtenerPuntos(),12);
        Assert.assertEquals(equipo2.obtenerPuntos(),3);

        //Nueva jugada pica pica

        JugadaPicaPica jugadaPP3 = partida.crearJugadaPicaPica();

        jugador2.agregarCarta(espada12);
        jugador2.agregarCarta(oro4);
        jugador2.agregarCarta(oro5);

        jugador6.agregarCarta(copa10);
        jugador6.agregarCarta(copa3);
        jugador6.agregarCarta(copa4);

        jugadaPP3.armarEquiposParaPicaPica(jugador2,jugador6);

        jugador2.cantarFaltaEnvido(jugadaPP3);
        jugador6.aceptarEnvido(jugadaPP3);
        jugador6.cantarTruco(jugadaPP3);
        jugador2.noAceptarTruco(jugadaPP3);

        Assert.assertEquals(equipo1.obtenerPuntos(),12);
        Assert.assertEquals(equipo2.obtenerPuntos(),3);

        jugador1.sacarCartas();
        jugador2.sacarCartas();
        jugador3.sacarCartas();
        jugador4.sacarCartas();
        jugador5.sacarCartas();
        jugador6.sacarCartas();

        //Nueva Jugada normal
        Jugada jugada2 = partida.crearJugada();

        jugador1.agregarCarta(copa10);
        jugador1.agregarCarta(copa4);
        jugador1.agregarCarta(copa5);

        jugador2.agregarCarta(oro11);
        jugador2.agregarCarta(oro4);
        jugador2.agregarCarta(oro5);


        jugador3.agregarCarta(espada12);
        jugador3.agregarCarta(espada6);
        jugador3.agregarCarta(espada7);


        jugador4.agregarCarta(basto3);
        jugador4.agregarCarta(basto4);
        jugador4.agregarCarta(basto5);

        jugador5.agregarCarta(basto2);
        jugador5.agregarCarta(basto4);
        jugador5.agregarCarta(basto3);

        jugador6.agregarCarta(copa10);
        jugador6.agregarCarta(copa3);
        jugador6.agregarCarta(copa4);


        jugador1.juegaCarta(copa4);
        jugador2.juegaCarta(oro4);
        jugador3.juegaCarta(espada12);
        jugador4.juegaCarta(basto3);
        jugador5.juegaCarta(basto4);
        jugador6.juegaCarta(copa4);

        jugada2.jugarMano();

        jugador5.cantarTruco(jugada2);
        jugador6.noAceptarTruco(jugada2);

        jugador1.sacarCartas();
        jugador2.sacarCartas();
        jugador3.sacarCartas();
        jugador4.sacarCartas();
        jugador5.sacarCartas();
        jugador6.sacarCartas();


        Assert.assertEquals(equipo1.obtenerPuntos(), 13);
        Assert.assertEquals(equipo2.obtenerPuntos(), 3);


        //Termino partida normal arranca PICA PICA
        JugadaPicaPica jugadaPP4 = partida.crearJugadaPicaPica();

        jugador1.agregarCarta(espada1);
        jugador1.agregarCarta(espada6);
        jugador1.agregarCarta(espada7);

        jugador5.agregarCarta(basto2);
        jugador5.agregarCarta(basto4);
        jugador5.agregarCarta(basto3);

        jugadaPP4.armarEquiposParaPicaPica(jugador1,jugador5);

        jugador1.cantarFaltaEnvido(jugadaPP4);
        jugador5.aceptarEnvido(jugadaPP4);


        jugador1.juegaCarta(espada1);
        jugador5.juegaCarta(basto4);

        jugadaPP4.jugarMano();

        jugador1.cantarTruco(jugadaPP4);
        jugador5.cantarReTruco(jugadaPP4);
        jugador1.cantarValeCuatro(jugadaPP4);
        jugador5.aceptarTruco(jugadaPP4);

        jugador1.juegaCarta(espada7);
        jugador5.irseAlMazo(jugadaPP4);

        partida.calcularPuntosPicaPica(jugadaPP4);

        Assert.assertEquals(equipo1.obtenerPuntos(), 23);
        Assert.assertEquals(equipo2.obtenerPuntos(), 3);

        //Nuevo pica pica
        JugadaPicaPica jugadaPP5 = partida.crearJugadaPicaPica();

        jugador4.agregarCarta(espada1);
        jugador4.agregarCarta(espada6);
        jugador4.agregarCarta(espada7);

        jugador3.agregarCarta(basto2);
        jugador3.agregarCarta(basto4);
        jugador3.agregarCarta(basto3);

        jugadaPP5.armarEquiposParaPicaPica(jugador4,jugador3);

        jugador4.cantarFaltaEnvido(jugadaPP5);
        jugador3.aceptarEnvido(jugadaPP5);

        jugador4.juegaCarta(espada1);
        jugador3.juegaCarta(basto4);

        jugadaPP5.jugarMano();

        jugador4.cantarTruco(jugadaPP5);
        jugador3.cantarReTruco(jugadaPP5);
        jugador4.cantarValeCuatro(jugadaPP5);
        jugador3.aceptarTruco(jugadaPP5);

        jugador4.juegaCarta(espada7);
        jugador3.irseAlMazo(jugadaPP5);

        partida.calcularPuntosPicaPica(jugadaPP5);

        Assert.assertEquals(equipo1.obtenerPuntos(), 33);
        Assert.assertEquals(equipo2.obtenerPuntos(), 3);

        Assert.assertEquals(partida.obtenerEstado().getClass(), EstadoPartidaTerminada.class);

    }


}









