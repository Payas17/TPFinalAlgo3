package fiuba.algo3.tests;

import modelo.Carta.Carta;
import modelo.Carta.Copa;
import modelo.Carta.Espada;
import modelo.Carta.Oro;
import modelo.Equipo;
import modelo.Errores.*;
import modelo.EstadoEnvido.EstadoFlor;
import modelo.EstadoEnvido.EstadoNoSePuedeCantarEnvido;
import modelo.Jugada.Jugada;
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
}
