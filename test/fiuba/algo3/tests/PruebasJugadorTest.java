package fiuba.algo3.tests;

import modelo.Carta.*;
import modelo.Equipo;
import modelo.Errores.*;
import modelo.EstadoEnvido.EstadoFlor;
import modelo.EstadoEnvido.EstadoNoSePuedeCantarEnvido;
import modelo.Jugadas.Jugada;
import modelo.Jugador;
import modelo.Partida.Partida;
import modelo.ValoresTrucoYEnvido;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucio on 27/11/2015.
 */
public class PruebasJugadorTest {

    @Test(expected = NoSePuedeJugarCartaError.class)
    public void testJugadorNoPuedeJugarDosVecesSeguidas() {
        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1, equipo2);

        Jugada jugada = partida.crearJugada();
        Carta copa10 = new Copa(10, valoresTrucoYEnvido);
        Carta oro1 = new Oro(1, valoresTrucoYEnvido);
        Carta oro3 = new Oro(3, valoresTrucoYEnvido);
        Carta oro2 = new Oro(2, valoresTrucoYEnvido);
        Carta espada10 = new Espada(10, valoresTrucoYEnvido);
        Carta espada1 = new Espada(1, valoresTrucoYEnvido);

        jugador1.agregarCarta(oro1);
        jugador1.agregarCarta(oro2);
        jugador1.agregarCarta(espada10);

        jugador2.agregarCarta(copa10);
        jugador2.agregarCarta(oro3);
        jugador2.agregarCarta(espada1);

        jugador1.juegaCarta(oro1);
        jugador1.juegaCarta(oro2);
    }

    @Test(expected = NoPuedeJugarError.class)
    public void testJugadorNoPuedeCantarFlorPorqueYaJugo() {
        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1, equipo2);

        Jugada jugada = partida.crearJugada();
        Carta copa10 = new Copa(10, valoresTrucoYEnvido);
        Carta oro1 = new Oro(1, valoresTrucoYEnvido);
        Carta oro3 = new Oro(3, valoresTrucoYEnvido);
        Carta oro2 = new Oro(2, valoresTrucoYEnvido);
        Carta espada10 = new Espada(10, valoresTrucoYEnvido);
        Carta espada1 = new Espada(1, valoresTrucoYEnvido);

        jugador1.agregarCarta(oro1);
        jugador1.agregarCarta(oro2);
        jugador1.agregarCarta(espada10);

        jugador2.agregarCarta(copa10);
        jugador2.agregarCarta(oro3);
        jugador2.agregarCarta(espada1);

        jugador1.juegaCarta(oro1);
        jugador1.cantarFlor(jugada);
    }

    @Test(expected = NoPuedeJugarError.class)
    public void testJugadorNoPuedeCantarEnvidoPorqueYaJugo() {
        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1, equipo2);

        Jugada jugada = partida.crearJugada();
        Carta copa10 = new Copa(10, valoresTrucoYEnvido);
        Carta oro1 = new Oro(1, valoresTrucoYEnvido);
        Carta oro3 = new Oro(3, valoresTrucoYEnvido);
        Carta oro2 = new Oro(2, valoresTrucoYEnvido);
        Carta espada10 = new Espada(10, valoresTrucoYEnvido);
        Carta espada1 = new Espada(1, valoresTrucoYEnvido);

        jugador1.agregarCarta(oro1);
        jugador1.agregarCarta(oro2);
        jugador1.agregarCarta(espada10);

        jugador2.agregarCarta(copa10);
        jugador2.agregarCarta(oro3);
        jugador2.agregarCarta(espada1);

        jugador1.juegaCarta(oro1);
        jugador1.cantarEnvido(jugada);
    }

    @Test(expected = NoPuedeJugarError.class)
    public void testJugadorNoPuedeCantarTrucoPorqueYaJugo() {
        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1, equipo2);

        Jugada jugada = partida.crearJugada();
        Carta copa10 = new Copa(10, valoresTrucoYEnvido);
        Carta oro1 = new Oro(1, valoresTrucoYEnvido);
        Carta oro3 = new Oro(3, valoresTrucoYEnvido);
        Carta oro2 = new Oro(2, valoresTrucoYEnvido);
        Carta espada10 = new Espada(10, valoresTrucoYEnvido);
        Carta espada1 = new Espada(1, valoresTrucoYEnvido);

        jugador1.agregarCarta(oro1);
        jugador1.agregarCarta(oro2);
        jugador1.agregarCarta(espada10);

        jugador2.agregarCarta(copa10);
        jugador2.agregarCarta(oro3);
        jugador2.agregarCarta(espada1);

        jugador1.juegaCarta(oro1);
        jugador1.cantarTruco(jugada);
    }

    @Test(expected = NoPuedeJugarError.class)
    public void testJugadorNoPuedeAceptarPorqueYaJugoYNadieCantoNada() {
        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1, equipo2);

        Jugada jugada = partida.crearJugada();
        Carta copa10 = new Copa(10, valoresTrucoYEnvido);
        Carta oro1 = new Oro(1, valoresTrucoYEnvido);
        Carta oro3 = new Oro(3, valoresTrucoYEnvido);
        Carta oro2 = new Oro(2, valoresTrucoYEnvido);
        Carta espada10 = new Espada(10, valoresTrucoYEnvido);
        Carta espada1 = new Espada(1, valoresTrucoYEnvido);

        jugador1.agregarCarta(oro1);
        jugador1.agregarCarta(oro2);
        jugador1.agregarCarta(espada10);

        jugador2.agregarCarta(copa10);
        jugador2.agregarCarta(oro3);
        jugador2.agregarCarta(espada1);

        jugador1.juegaCarta(oro1);
        jugador1.aceptarEnvido(jugada);
    }

    @Test(expected = NoSePuedeJugarCartaError.class)
    public void testJugador1CantaTrucoJugador2JuegaCartaYLanzaError() {
        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1, equipo2);

        Jugada jugada = partida.crearJugada();
        Carta copa10 = new Copa(10, valoresTrucoYEnvido);
        Carta oro1 = new Oro(1, valoresTrucoYEnvido);
        Carta oro3 = new Oro(3, valoresTrucoYEnvido);
        Carta oro2 = new Oro(2, valoresTrucoYEnvido);
        Carta espada10 = new Espada(10, valoresTrucoYEnvido);
        Carta espada1 = new Espada(1, valoresTrucoYEnvido);

        jugador1.agregarCarta(oro1);
        jugador1.agregarCarta(oro2);
        jugador1.agregarCarta(espada10);

        jugador2.agregarCarta(copa10);
        jugador2.agregarCarta(oro3);
        jugador2.agregarCarta(espada1);

        jugador1.cantarTruco(jugada);
        jugador2.juegaCarta(oro3);

    }

    @Test
    public void testJugador1CantaTrucoJugador2CantaEnvidoJugador1NoAcepta() {
        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1, equipo2);

        Jugada jugada = partida.crearJugada();
        Carta copa10 = new Copa(10, valoresTrucoYEnvido);
        Carta oro1 = new Oro(1, valoresTrucoYEnvido);
        Carta oro3 = new Oro(3, valoresTrucoYEnvido);
        Carta oro2 = new Oro(2, valoresTrucoYEnvido);
        Carta espada10 = new Espada(10, valoresTrucoYEnvido);
        Carta espada1 = new Espada(1, valoresTrucoYEnvido);

        jugador1.agregarCarta(oro1);
        jugador1.agregarCarta(oro2);
        jugador1.agregarCarta(espada10);

        jugador2.agregarCarta(copa10);
        jugador2.agregarCarta(oro3);
        jugador2.agregarCarta(espada1);

        jugador1.cantarTruco(jugada);
        jugador2.cantarEnvido(jugada);
        jugador1.noAceptarEnvido(jugada);

        Assert.assertEquals(jugada.obtenerEstadoEnvido().getClass(), EstadoNoSePuedeCantarEnvido.class);
    }

    @Test
    public void testJugador1CantaTrucoJugador2CantaFlorYEstadoDeEnvidoEsEstadoFlor() {
        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1, equipo2);

        Jugada jugada = partida.crearJugada();
        Carta oro1 = new Oro(1, valoresTrucoYEnvido);
        Carta oro3 = new Oro(3, valoresTrucoYEnvido);
        Carta oro2 = new Oro(2, valoresTrucoYEnvido);
        Carta espada10 = new Espada(10, valoresTrucoYEnvido);


        jugador1.agregarCarta(oro1);
        jugador1.agregarCarta(oro2);
        jugador1.agregarCarta(espada10);

        jugador2.agregarCarta(oro1);
        jugador2.agregarCarta(oro3);
        jugador2.agregarCarta(oro2);

        jugador1.cantarTruco(jugada);
        jugador2.cantarFlor(jugada);

        Assert.assertEquals(jugada.obtenerEstadoEnvido().getClass(), EstadoFlor.class);
    }

    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testJugador1CantaFlorJugador2CantaEnvidoLanzaError() {
        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1, equipo2);

        Jugada jugada = partida.crearJugada();
        Carta oro1 = new Oro(1, valoresTrucoYEnvido);
        Carta oro3 = new Oro(3, valoresTrucoYEnvido);
        Carta oro2 = new Oro(2, valoresTrucoYEnvido);
        Carta espada10 = new Espada(10, valoresTrucoYEnvido);
        Carta espada1 = new Espada(1, valoresTrucoYEnvido);
        Carta espada3 = new Espada(3,valoresTrucoYEnvido);

        jugador1.agregarCarta(espada1);
        jugador1.agregarCarta(espada3);
        jugador1.agregarCarta(espada10);

        jugador2.agregarCarta(oro1);
        jugador2.agregarCarta(oro3);
        jugador2.agregarCarta(oro2);

        jugador1.cantarFlor(jugada);
        jugador2.cantarEnvido(jugada);

    }

    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testJugador1CantaFlorJugador2CantaTrucoLanzaError() {
        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1, equipo2);

        Jugada jugada = partida.crearJugada();
        Carta oro1 = new Oro(1, valoresTrucoYEnvido);
        Carta oro3 = new Oro(3, valoresTrucoYEnvido);
        Carta oro2 = new Oro(2, valoresTrucoYEnvido);
        Carta espada10 = new Espada(10, valoresTrucoYEnvido);
        Carta espada1 = new Espada(1, valoresTrucoYEnvido);
        Carta espada3 = new Espada(3,valoresTrucoYEnvido);

        jugador1.agregarCarta(espada1);
        jugador1.agregarCarta(espada3);
        jugador1.agregarCarta(espada10);

        jugador2.agregarCarta(oro1);
        jugador2.agregarCarta(oro3);
        jugador2.agregarCarta(oro2);

        jugador1.cantarFlor(jugada);
        jugador2.cantarTruco(jugada);

    }

    @Test(expected = NoSePuedeJugarCartaError.class)
    public void testJugador1CantaFlorJugador2JuegaCartaLanzaError() {
        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1, equipo2);

        Jugada jugada = partida.crearJugada();
        Carta oro1 = new Oro(1, valoresTrucoYEnvido);
        Carta oro3 = new Oro(3, valoresTrucoYEnvido);
        Carta oro2 = new Oro(2, valoresTrucoYEnvido);
        Carta espada10 = new Espada(10, valoresTrucoYEnvido);
        Carta espada1 = new Espada(1, valoresTrucoYEnvido);
        Carta espada3 = new Espada(3,valoresTrucoYEnvido);

        jugador1.agregarCarta(espada1);
        jugador1.agregarCarta(espada3);
        jugador1.agregarCarta(espada10);

        jugador2.agregarCarta(oro1);
        jugador2.agregarCarta(oro3);
        jugador2.agregarCarta(oro2);

        jugador1.cantarFlor(jugada);
        jugador2.juegaCarta(oro2);

    }

    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testJugador1CantaTruco2VecesSeguidasYLanzaError() {
        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1, equipo2);

        Jugada jugada = partida.crearJugada();
        Carta oro1 = new Oro(1, valoresTrucoYEnvido);
        Carta oro3 = new Oro(3, valoresTrucoYEnvido);
        Carta oro2 = new Oro(2, valoresTrucoYEnvido);
        Carta espada10 = new Espada(10, valoresTrucoYEnvido);
        Carta espada1 = new Espada(1, valoresTrucoYEnvido);
        Carta espada3 = new Espada(3,valoresTrucoYEnvido);

        jugador1.agregarCarta(espada1);
        jugador1.agregarCarta(espada3);
        jugador1.agregarCarta(espada10);

        jugador2.agregarCarta(oro1);
        jugador2.agregarCarta(oro3);
        jugador2.agregarCarta(oro2);

        jugador1.cantarTruco(jugada);
        jugador1.cantarTruco(jugada);

    }

    @Test(expected = NoPuedeJugarError.class)
    public void testJugador1CantaTrucoYDespuesFlorYLanzaError() {
        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1, equipo2);

        Jugada jugada = partida.crearJugada();
        Carta oro1 = new Oro(1, valoresTrucoYEnvido);
        Carta oro3 = new Oro(3, valoresTrucoYEnvido);
        Carta oro2 = new Oro(2, valoresTrucoYEnvido);
        Carta espada10 = new Espada(10, valoresTrucoYEnvido);
        Carta espada1 = new Espada(1, valoresTrucoYEnvido);
        Carta espada3 = new Espada(3,valoresTrucoYEnvido);

        jugador1.agregarCarta(espada1);
        jugador1.agregarCarta(espada3);
        jugador1.agregarCarta(espada10);

        jugador2.agregarCarta(oro1);
        jugador2.agregarCarta(oro3);
        jugador2.agregarCarta(oro2);

        jugador1.cantarTruco(jugada);
        jugador1.cantarFlor(jugada);

    }

    @Test(expected = NoPuedeJugarError.class)
    public void testJugador1CantaTrucoYDespuesEnvidoYLanzaError() {
        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1, equipo2);

        Jugada jugada = partida.crearJugada();
        Carta oro1 = new Oro(1, valoresTrucoYEnvido);
        Carta oro3 = new Oro(3, valoresTrucoYEnvido);
        Carta oro2 = new Oro(2, valoresTrucoYEnvido);
        Carta espada10 = new Espada(10, valoresTrucoYEnvido);
        Carta espada1 = new Espada(1, valoresTrucoYEnvido);
        Carta espada3 = new Espada(3,valoresTrucoYEnvido);

        jugador1.agregarCarta(espada1);
        jugador1.agregarCarta(espada3);
        jugador1.agregarCarta(espada10);

        jugador2.agregarCarta(oro1);
        jugador2.agregarCarta(oro3);
        jugador2.agregarCarta(oro2);

        jugador1.cantarTruco(jugada);
        jugador1.cantarEnvido(jugada);

    }

    @Test(expected = SoloJugadorPiePuedeCantarError.class)
    public void testJugador1CantaEnvidoYLanzaErrorPorqueNoEsPie() {
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
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1, equipo2);

        Jugada jugada = partida.crearJugada();
        Carta oro1 = new Oro(1, valoresTrucoYEnvido);
        Carta oro3 = new Oro(3, valoresTrucoYEnvido);
        Carta oro2 = new Oro(2, valoresTrucoYEnvido);
        Carta espada10 = new Espada(10, valoresTrucoYEnvido);
        Carta espada1 = new Espada(1, valoresTrucoYEnvido);
        Carta espada3 = new Espada(3,valoresTrucoYEnvido);

        jugador1.agregarCarta(espada1);
        jugador1.agregarCarta(espada3);
        jugador1.agregarCarta(espada10);

        jugador2.agregarCarta(oro1);
        jugador2.agregarCarta(oro3);
        jugador2.agregarCarta(oro2);

        jugador1.cantarEnvido(jugada);

    }

    @Test(expected = SoloJugadorPiePuedeCantarError.class)
    public void testJugador1CantaFlorYLanzaErrorPorqueNoEsPie() {
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
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1, equipo2);

        Jugada jugada = partida.crearJugada();
        Carta oro1 = new Oro(1, valoresTrucoYEnvido);
        Carta oro3 = new Oro(3, valoresTrucoYEnvido);
        Carta oro2 = new Oro(2, valoresTrucoYEnvido);
        Carta espada10 = new Espada(10, valoresTrucoYEnvido);
        Carta espada1 = new Espada(1, valoresTrucoYEnvido);
        Carta espada3 = new Espada(3,valoresTrucoYEnvido);

        jugador1.agregarCarta(espada1);
        jugador1.agregarCarta(espada3);
        jugador1.agregarCarta(espada10);

        jugador2.agregarCarta(oro1);
        jugador2.agregarCarta(oro3);
        jugador2.agregarCarta(oro2);

        jugador1.cantarFlor(jugada);

    }

    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testJugador1AceptaEnvidoYLanzaErrorPorqueNoSeCantoNada() {
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
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1, equipo2);

        Jugada jugada = partida.crearJugada();
        Carta oro1 = new Oro(1, valoresTrucoYEnvido);
        Carta oro3 = new Oro(3, valoresTrucoYEnvido);
        Carta oro2 = new Oro(2, valoresTrucoYEnvido);
        Carta espada10 = new Espada(10, valoresTrucoYEnvido);
        Carta espada1 = new Espada(1, valoresTrucoYEnvido);
        Carta espada3 = new Espada(3,valoresTrucoYEnvido);

        jugador1.agregarCarta(espada1);
        jugador1.agregarCarta(espada3);
        jugador1.agregarCarta(espada10);

        jugador2.agregarCarta(oro1);
        jugador2.agregarCarta(oro3);
        jugador2.agregarCarta(oro2);

        jugador1.aceptarEnvido(jugada);

    }

    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testJugador1AceptaFlorYLanzaErrorPorqueNoSeCantoNada() {
        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);

        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1, equipo2);

        Jugada jugada = partida.crearJugada();
        Carta oro1 = new Oro(1, valoresTrucoYEnvido);
        Carta oro3 = new Oro(3, valoresTrucoYEnvido);
        Carta oro2 = new Oro(2, valoresTrucoYEnvido);
        Carta espada10 = new Espada(10, valoresTrucoYEnvido);
        Carta espada1 = new Espada(1, valoresTrucoYEnvido);
        Carta espada3 = new Espada(3,valoresTrucoYEnvido);

        jugador1.agregarCarta(espada1);
        jugador1.agregarCarta(espada3);
        jugador1.agregarCarta(espada10);

        jugador2.agregarCarta(oro1);
        jugador2.agregarCarta(oro3);
        jugador2.agregarCarta(oro2);

        jugador1.aceptarFlor(jugada);

    }


    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testJugador1CantaFlorJugador2NoAceptaYCantaRealEnvidoEntoncesLanzaError(){

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores1 = new ArrayList<>();
        jugadores1.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);

        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Carta basto12 = new Basto(12, valoresTrucoYEnvido);
        Carta basto7 = new Basto(7, valoresTrucoYEnvido);
        Carta basto6 = new Basto(6, valoresTrucoYEnvido);


        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);
        Jugada jugada = partida.crearJugada();

        jugador1.agregarCarta(basto12);
        jugador1.agregarCarta(basto7);
        jugador1.agregarCarta(basto6);

        jugador2.agregarCarta(basto12);
        jugador2.agregarCarta(basto7);
        jugador2.agregarCarta(basto6);

        jugador1.cantarFlor(jugada);
        jugador2.noAceptarFlor(jugada);

        jugador2.cantarRealEnvido(jugada);
    }


    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testJugador1CantaFlorJugador2NoAceptaYCantaFaltaEnvidoEntoncesLanzaError(){

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores1 = new ArrayList<>();
        jugadores1.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);

        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Carta basto12 = new Basto(12, valoresTrucoYEnvido);
        Carta basto7 = new Basto(7, valoresTrucoYEnvido);
        Carta basto6 = new Basto(6, valoresTrucoYEnvido);



        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);
        Jugada jugada = partida.crearJugada();

        jugador1.agregarCarta(basto12);
        jugador1.agregarCarta(basto7);
        jugador1.agregarCarta(basto6);

        jugador2.agregarCarta(basto12);
        jugador2.agregarCarta(basto7);
        jugador2.agregarCarta(basto6);

        jugador1.cantarFlor(jugada);
        jugador2.noAceptarFlor(jugada);

        jugador2.cantarFaltaEnvido(jugada);
    }

    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testJugador1CantaFlorJugador2NoAceptaFlorYNoAceptaEnvidoEntoncesLanzaError(){

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores1 = new ArrayList<>();
        jugadores1.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);

        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Carta basto12 = new Basto(12, valoresTrucoYEnvido);
        Carta basto7 = new Basto(7, valoresTrucoYEnvido);
        Carta basto6 = new Basto(6, valoresTrucoYEnvido);



        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);
        Jugada jugada = partida.crearJugada();

        jugador1.agregarCarta(basto12);
        jugador1.agregarCarta(basto7);
        jugador1.agregarCarta(basto6);

        jugador2.agregarCarta(basto12);
        jugador2.agregarCarta(basto7);
        jugador2.agregarCarta(basto6);

        jugador1.cantarFlor(jugada);
        jugador2.noAceptarFlor(jugada);

        jugador2.noAceptarEnvido(jugada);
    }

    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testJugador1CantaFlorJugador2NoAceptaYCantaFlorEntoncesLanzaError(){

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores1 = new ArrayList<>();
        jugadores1.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);

        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Carta basto12 = new Basto(12, valoresTrucoYEnvido);
        Carta basto7 = new Basto(7, valoresTrucoYEnvido);
        Carta basto6 = new Basto(6, valoresTrucoYEnvido);



        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);
        Jugada jugada = partida.crearJugada();

        jugador1.agregarCarta(basto12);
        jugador1.agregarCarta(basto7);
        jugador1.agregarCarta(basto6);

        jugador2.agregarCarta(basto12);
        jugador2.agregarCarta(basto7);
        jugador2.agregarCarta(basto6);

        jugador1.cantarFlor(jugada);
        jugador2.noAceptarFlor(jugada);

        jugador2.cantarFlor(jugada);
    }

    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testJugador1CantaFlorJugador2NoAceptaYCantaContraFlorEntoncesLanzaError(){

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores1 = new ArrayList<>();
        jugadores1.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);

        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Carta basto12 = new Basto(12, valoresTrucoYEnvido);
        Carta basto7 = new Basto(7, valoresTrucoYEnvido);
        Carta basto6 = new Basto(6, valoresTrucoYEnvido);



        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);
        Jugada jugada = partida.crearJugada();

        jugador1.agregarCarta(basto12);
        jugador1.agregarCarta(basto7);
        jugador1.agregarCarta(basto6);

        jugador2.agregarCarta(basto12);
        jugador2.agregarCarta(basto7);
        jugador2.agregarCarta(basto6);

        jugador1.cantarFlor(jugada);
        jugador2.noAceptarFlor(jugada);

        jugador2.cantarContraFlor(jugada);
    }

    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testJugador1CantaFlorJugador2NoAceptaYCantaContraFlorAlRestoEntoncesLanzaError(){

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores1 = new ArrayList<>();
        jugadores1.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);

        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Carta basto12 = new Basto(12, valoresTrucoYEnvido);
        Carta basto7 = new Basto(7, valoresTrucoYEnvido);
        Carta basto6 = new Basto(6, valoresTrucoYEnvido);



        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);
        Jugada jugada = partida.crearJugada();

        jugador1.agregarCarta(basto12);
        jugador1.agregarCarta(basto7);
        jugador1.agregarCarta(basto6);

        jugador2.agregarCarta(basto12);
        jugador2.agregarCarta(basto7);
        jugador2.agregarCarta(basto6);

        jugador1.cantarFlor(jugada);
        jugador2.noAceptarFlor(jugada);

        jugador2.cantarContraFlorAlResto(jugada);
    }

    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testJugador1CantaFlorJugador2NoAceptaFlorYLuegoAceptaFlorEntoncesLanzaError(){

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores1 = new ArrayList<>();
        jugadores1.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);

        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Carta basto12 = new Basto(12, valoresTrucoYEnvido);
        Carta basto7 = new Basto(7, valoresTrucoYEnvido);
        Carta basto6 = new Basto(6, valoresTrucoYEnvido);



        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);
        Jugada jugada = partida.crearJugada();
        jugador1.agregarCarta(basto12);
        jugador1.agregarCarta(basto7);
        jugador1.agregarCarta(basto6);

        jugador2.agregarCarta(basto12);
        jugador2.agregarCarta(basto7);
        jugador2.agregarCarta(basto6);

        jugador1.cantarFlor(jugada);
        jugador2.noAceptarFlor(jugada);

        jugador2.aceptarFlor(jugada);
    }


    @Test
    public void testJugador1SeLimpiaBien(){

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores1 = new ArrayList<>();
        jugadores1.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);

        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Carta basto12 = new Basto(12, valoresTrucoYEnvido);
        Carta basto7 = new Basto(7, valoresTrucoYEnvido);
        Carta basto6 = new Basto(6, valoresTrucoYEnvido);



        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);
        Jugada jugada = partida.crearJugada();
        jugador1.agregarCarta(basto12);
        jugador1.agregarCarta(basto7);
        jugador1.agregarCarta(basto6);

        jugada.limpiarJugadores();

        Assert.assertTrue(jugador1.obtenerCartasEnMano().isEmpty());


    }


}
