package fiuba.algo3.tests.JugadorIATest;


import modelo.Carta.*;

import modelo.Equipo;
import modelo.EstadoEnvido.*;
import modelo.EstadoJugada.EstadoJugadaTerminada;
import modelo.EstadoTruco.EstadoTruco;
import modelo.Jugadas.Jugada;
import modelo.Jugador;
import modelo.Partida.Partida;
import modelo.ValoresTrucoYEnvido;
import modeloJugadorIA.EstadoRealEnvidoInteligente;
import modeloJugadorIA.JugadorIA;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Augusto on 24/11/2015.
 */
public class PruebasJugadorIATest {

    @Test
    public void testSiJugadorIAtiene26SePoneEnEstadoEnvido() {
        Jugador jugador = new Jugador();
        JugadorIA jugadorIA = new JugadorIA(jugador);

        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();

        Carta oro7 = new Oro(7, valoresTrucoYEnvido);
        Carta oro1 = new Oro(1, valoresTrucoYEnvido);
        Carta espada1 = new Espada(7, valoresTrucoYEnvido);

        jugadorIA.agregarCarta(oro7);
        jugadorIA.agregarCarta(oro1);
        jugadorIA.agregarCarta(espada1);


        Assert.assertEquals(jugadorIA.obtenerEstadoEnvido().getClass(), EstadoRealEnvidoInteligente.class);
    }

    @Test
    public void testJugadorIATieneParaRealEnvido() {

        Jugador jugador = new Jugador();
        JugadorIA jugadorIA = new JugadorIA(jugador);

        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();

        Carta oro7 = new Oro(7, valoresTrucoYEnvido);
        Carta oro1 = new Oro(1, valoresTrucoYEnvido);
        Carta espada1 = new Espada(7, valoresTrucoYEnvido);

        jugadorIA.agregarCarta(oro7);
        jugadorIA.agregarCarta(oro1);
        jugadorIA.agregarCarta(espada1);


        Assert.assertEquals(jugadorIA.obtenerEstadoEnvido().getClass(), EstadoRealEnvidoInteligente.class);
    }

    @Test
    public void testJugadorIAJuegaPrimeroEntoncesJuegaLaCartaMasBaja() {

        Jugador jugador1 = new Jugador();
        JugadorIA jugadorIA = new JugadorIA(jugador1);
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

        Carta basto5 = new Basto(5, valoresTrucoYEnvido);
        Carta basto3 = new Basto(3, valoresTrucoYEnvido);
        Carta basto6 = new Basto(6, valoresTrucoYEnvido);

        jugadorIA.agregarCarta(basto5);
        jugadorIA.agregarCarta(basto3);
        jugadorIA.agregarCarta(basto6);

        jugadorIA.jugarCarta(jugada);

        Assert.assertEquals(jugadorIA.obtenerCartaEnJuego(), basto5);
    }

    @Test
    public void testJugadorIAJuegaMenorCartaParaGanarLaManoEnBaseALoQueJugaronLosDelOtroEquipo() {

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        JugadorIA jugadorIA = new JugadorIA(jugador2);
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1, equipo2);

        Jugada jugada = partida.crearJugada();

        Carta basto5 = new Basto(5, valoresTrucoYEnvido);
        Carta basto3 = new Basto(3, valoresTrucoYEnvido);
        Carta oro7 = new Oro(7, valoresTrucoYEnvido);

        jugadorIA.agregarCarta(basto5);
        jugadorIA.agregarCarta(basto3);
        jugadorIA.agregarCarta(oro7);

        Carta copa10 = new Copa(10, valoresTrucoYEnvido);
        Carta copa7 = new Copa(7, valoresTrucoYEnvido);
        Carta copa2 = new Copa(2, valoresTrucoYEnvido);

        jugador1.agregarCarta(copa10);
        jugador1.agregarCarta(copa7);
        jugador1.agregarCarta(copa2);

        jugador1.juegaCarta(copa2);
        jugadorIA.jugarCarta(jugada);

        Assert.assertEquals(jugadorIA.obtenerCartaEnJuego(), basto3);

        jugada.jugarMano();

        jugadorIA.jugarCarta(jugada);
        jugador1.juegaCarta(copa10);

        Assert.assertEquals(jugadorIA.obtenerCartaEnJuego(), basto5);

        jugada.jugarMano();

        jugador1.juegaCarta(copa7);
        jugadorIA.jugarCarta(jugada);

        Assert.assertEquals(jugadorIA.obtenerCartaEnJuego(), oro7);
    }

    @Test
    public void testJugadorIATiene23DeEnvidoYNoAceptaEnvido() {

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        JugadorIA jugadorIA = new JugadorIA(jugador2);
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1, equipo2);

        Jugada jugada = partida.crearJugada();

        Carta basto1 = new Basto(1, valoresTrucoYEnvido);
        Carta basto2 = new Basto(2, valoresTrucoYEnvido);
        Carta oro7 = new Oro(7, valoresTrucoYEnvido);

        jugadorIA.agregarCarta(basto1);
        jugadorIA.agregarCarta(basto2);
        jugadorIA.agregarCarta(oro7);

        Carta copa10 = new Copa(10, valoresTrucoYEnvido);
        Carta copa7 = new Copa(7, valoresTrucoYEnvido);
        Carta copa2 = new Copa(2, valoresTrucoYEnvido);

        jugador1.agregarCarta(copa10);
        jugador1.agregarCarta(copa7);
        jugador1.agregarCarta(copa2);

        jugador1.cantarEnvido(jugada);
        jugadorIA.obtenerEstadoEnvido();
        jugadorIA.cantar(jugada, partida);

        Assert.assertEquals(jugada.obtenerEstadoEnvido().getClass(), EstadoNoSePuedeCantarEnvido.class);
        Assert.assertEquals(equipo1.obtenerPuntos(), 1);
    }

    @Test
    public void testJugadorIATiene24LeCantanEnvidoYCantaEnvidoDeNuevo() {

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        JugadorIA jugadorIA = new JugadorIA(jugador2);
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1, equipo2);

        Jugada jugada = partida.crearJugada();

        Carta basto1 = new Basto(1, valoresTrucoYEnvido);
        Carta basto3 = new Basto(3, valoresTrucoYEnvido);
        Carta oro7 = new Oro(7, valoresTrucoYEnvido);

        jugadorIA.agregarCarta(basto1);
        jugadorIA.agregarCarta(basto3);
        jugadorIA.agregarCarta(oro7);

        Carta copa10 = new Copa(10, valoresTrucoYEnvido);
        Carta copa7 = new Copa(7, valoresTrucoYEnvido);
        Carta copa2 = new Copa(2, valoresTrucoYEnvido);

        jugador1.agregarCarta(copa10);
        jugador1.agregarCarta(copa7);
        jugador1.agregarCarta(copa2);

        jugador1.cantarEnvido(jugada);
        jugadorIA.cantar(jugada, partida);

        Assert.assertEquals(jugada.obtenerEstadoEnvido().getClass(), EstadoEnvidoEnvido.class);
    }

    @Test
    public void testJugadorIATiene30LeCantanRealEnvidoYAcepta() {

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();

        List<Jugador> jugadores2 = new ArrayList<>();
        JugadorIA jugadorIA = new JugadorIA(jugador2);
        jugadores2.add(jugador2);

        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1, equipo2);

        Jugada jugada = partida.crearJugada();

        Carta basto7 = new Basto(7, valoresTrucoYEnvido);
        Carta basto3 = new Basto(3, valoresTrucoYEnvido);
        Carta oro7 = new Oro(7, valoresTrucoYEnvido);

        jugadorIA.agregarCarta(basto7);
        jugadorIA.agregarCarta(basto3);
        jugadorIA.agregarCarta(oro7);

        Carta copa10 = new Copa(10, valoresTrucoYEnvido);
        Carta copa7 = new Copa(7, valoresTrucoYEnvido);
        Carta copa2 = new Copa(2, valoresTrucoYEnvido);

        jugador1.agregarCarta(copa10);
        jugador1.agregarCarta(copa7);
        jugador1.agregarCarta(copa2);

        jugador1.cantarRealEnvido(jugada);
        jugadorIA.cantar(jugada, partida);

        Assert.assertEquals(jugada.obtenerEstadoEnvido().getClass(), EstadoNoSePuedeCantarEnvido.class);
        Assert.assertEquals(equipo2.obtenerPuntos(), 3);
    }

    @Test
    public void testJugadorIATiene30LeCantanEnvidoYCantaRealEnvido() {

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();

        List<Jugador> jugadores2 = new ArrayList<>();
        JugadorIA jugadorIA = new JugadorIA(jugador2);
        jugadores2.add(jugador2);

        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1, equipo2);

        Jugada jugada = partida.crearJugada();

        Carta basto7 = new Basto(7, valoresTrucoYEnvido);
        Carta basto3 = new Basto(3, valoresTrucoYEnvido);
        Carta oro7 = new Oro(7, valoresTrucoYEnvido);

        jugadorIA.agregarCarta(basto7);
        jugadorIA.agregarCarta(basto3);
        jugadorIA.agregarCarta(oro7);

        Carta copa10 = new Copa(10, valoresTrucoYEnvido);
        Carta copa7 = new Copa(7, valoresTrucoYEnvido);
        Carta copa2 = new Copa(2, valoresTrucoYEnvido);

        jugador1.agregarCarta(copa10);
        jugador1.agregarCarta(copa7);
        jugador1.agregarCarta(copa2);

        jugador1.cantarEnvido(jugada);
        jugadorIA.cantar(jugada, partida);
        jugador1.aceptarEnvido(jugada);

        Assert.assertEquals(jugada.obtenerEstadoEnvido().getClass(), EstadoNoSePuedeCantarEnvido.class);
        Assert.assertEquals(equipo2.obtenerPuntos(), 5);
    }

    @Test
    public void testJugadorIATiene22LeCantanFlorYNoAcepta() {

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();

        List<Jugador> jugadores2 = new ArrayList<>();
        JugadorIA jugadorIA = new JugadorIA(jugador2);
        jugadores2.add(jugador2);

        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1, equipo2);

        Jugada jugada = partida.crearJugada();

        Carta basto10 = new Basto(10, valoresTrucoYEnvido);
        Carta basto2 = new Basto(2, valoresTrucoYEnvido);
        Carta oro7 = new Oro(7, valoresTrucoYEnvido);

        jugadorIA.agregarCarta(basto10);
        jugadorIA.agregarCarta(basto2);
        jugadorIA.agregarCarta(oro7);

        Carta copa10 = new Copa(10, valoresTrucoYEnvido);
        Carta copa7 = new Copa(7, valoresTrucoYEnvido);
        Carta copa2 = new Copa(2, valoresTrucoYEnvido);

        jugador1.agregarCarta(copa10);
        jugador1.agregarCarta(copa7);
        jugador1.agregarCarta(copa2);

        jugador1.cantarFlor(jugada);
        jugadorIA.cantar(jugada, partida);

        Assert.assertEquals(jugada.obtenerEstadoEnvido().getClass(), EstadoNoSePuedeCantarEnvido.class);
        Assert.assertEquals(equipo1.obtenerPuntos(), 3);
    }

    @Test
    public void testJugadorIATiene34DeFlorLeCantanFlorYAcepta() {

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();

        List<Jugador> jugadores2 = new ArrayList<>();
        JugadorIA jugadorIA = new JugadorIA(jugador2);
        jugadores2.add(jugador2);

        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1, equipo2);

        Jugada jugada = partida.crearJugada();

        Carta basto7 = new Basto(7, valoresTrucoYEnvido);
        Carta basto6 = new Basto(6, valoresTrucoYEnvido);
        Carta basto1 = new Basto(1, valoresTrucoYEnvido);

        jugadorIA.agregarCarta(basto1);
        jugadorIA.agregarCarta(basto6);
        jugadorIA.agregarCarta(basto7);

        Carta copa10 = new Copa(10, valoresTrucoYEnvido);
        Carta copa7 = new Copa(7, valoresTrucoYEnvido);
        Carta copa2 = new Copa(2, valoresTrucoYEnvido);

        jugador1.agregarCarta(copa10);
        jugador1.agregarCarta(copa7);
        jugador1.agregarCarta(copa2);

        jugador1.cantarFlor(jugada);
        jugadorIA.cantar(jugada, partida);

        Assert.assertEquals(jugada.obtenerEstadoEnvido().getClass(), EstadoNoSePuedeCantarEnvido.class);
        Assert.assertEquals(equipo1.obtenerPuntos(), 2);
        Assert.assertEquals(equipo2.obtenerPuntos(), 4);
    }

    @Test
    public void testJugadorIATiene37DeFlorLeCantanFlorYCantaContraFlor() {

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();

        List<Jugador> jugadores2 = new ArrayList<>();
        JugadorIA jugadorIA = new JugadorIA(jugador2);
        jugadores2.add(jugador2);

        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1, equipo2);

        Jugada jugada = partida.crearJugada();

        Carta basto7 = new Basto(7, valoresTrucoYEnvido);
        Carta basto6 = new Basto(6, valoresTrucoYEnvido);
        Carta basto4 = new Basto(4, valoresTrucoYEnvido);

        jugadorIA.agregarCarta(basto4);
        jugadorIA.agregarCarta(basto6);
        jugadorIA.agregarCarta(basto7);

        Carta copa10 = new Copa(10, valoresTrucoYEnvido);
        Carta copa7 = new Copa(7, valoresTrucoYEnvido);
        Carta copa2 = new Copa(2, valoresTrucoYEnvido);

        jugador1.agregarCarta(copa10);
        jugador1.agregarCarta(copa7);
        jugador1.agregarCarta(copa2);

        jugador1.cantarFlor(jugada);
        jugadorIA.cantar(jugada, partida);

        Assert.assertEquals(jugada.obtenerEstadoEnvido().getClass(), EstadoContraFlor.class);
    }


    @Test
    public void testJugadorIATiene38DeFlorLeCantanFlorYCantaContraFlorAlResto() {

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();

        List<Jugador> jugadores2 = new ArrayList<>();
        JugadorIA jugadorIA = new JugadorIA(jugador2);
        jugadores2.add(jugador2);

        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1, equipo2);

        Jugada jugada = partida.crearJugada();

        Carta basto7 = new Basto(7, valoresTrucoYEnvido);
        Carta basto6 = new Basto(6, valoresTrucoYEnvido);
        Carta basto5 = new Basto(5, valoresTrucoYEnvido);

        jugadorIA.agregarCarta(basto5);
        jugadorIA.agregarCarta(basto6);
        jugadorIA.agregarCarta(basto7);

        Carta copa10 = new Copa(10, valoresTrucoYEnvido);
        Carta copa7 = new Copa(7, valoresTrucoYEnvido);
        Carta copa2 = new Copa(2, valoresTrucoYEnvido);

        jugador1.agregarCarta(copa10);
        jugador1.agregarCarta(copa7);
        jugador1.agregarCarta(copa2);

        jugador1.cantarFlor(jugada);
        jugadorIA.cantar(jugada, partida);

        Assert.assertEquals(jugada.obtenerEstadoEnvido().getClass(), EstadoContraFlorAlResto.class);
    }

    @Test
    public void testJugadorIATiene38DeFlorNoLeCantanNadaYCantaFlor() {

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();

        List<Jugador> jugadores2 = new ArrayList<>();
        JugadorIA jugadorIA = new JugadorIA(jugador2);
        jugadores2.add(jugador2);

        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1, equipo2);

        Jugada jugada = partida.crearJugada();

        Carta basto7 = new Basto(7, valoresTrucoYEnvido);
        Carta basto6 = new Basto(6, valoresTrucoYEnvido);
        Carta basto5 = new Basto(5, valoresTrucoYEnvido);

        jugadorIA.agregarCarta(basto5);
        jugadorIA.agregarCarta(basto6);
        jugadorIA.agregarCarta(basto7);

        Carta copa10 = new Copa(10, valoresTrucoYEnvido);
        Carta copa7 = new Copa(7, valoresTrucoYEnvido);
        Carta copa2 = new Copa(2, valoresTrucoYEnvido);

        jugador1.agregarCarta(copa10);
        jugador1.agregarCarta(copa7);
        jugador1.agregarCarta(copa2);

        jugador1.juegaCarta(copa10);
        jugadorIA.cantar(jugada, partida);

        Assert.assertEquals(jugada.obtenerEstadoEnvido().getClass(), EstadoFlor.class);
    }

    @Test
    public void testJugadorIACantaTrucoSiNoLeCantaronNadaEnSegundaMano() {

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();

        List<Jugador> jugadores2 = new ArrayList<>();
        JugadorIA jugadorIA = new JugadorIA(jugador2);
        jugadores2.add(jugador2);

        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1, equipo2);

        Jugada jugada = partida.crearJugada();

        Carta basto7 = new Basto(7, valoresTrucoYEnvido);
        Carta basto6 = new Basto(6, valoresTrucoYEnvido);
        Carta basto5 = new Basto(5, valoresTrucoYEnvido);

        jugadorIA.agregarCarta(basto5);
        jugadorIA.agregarCarta(basto6);
        jugadorIA.agregarCarta(basto7);

        Carta copa10 = new Copa(10, valoresTrucoYEnvido);
        Carta copa7 = new Copa(7, valoresTrucoYEnvido);
        Carta copa2 = new Copa(2, valoresTrucoYEnvido);

        jugador1.agregarCarta(copa10);
        jugador1.agregarCarta(copa7);
        jugador1.agregarCarta(copa2);

        jugador1.juegaCarta(copa10);
        jugadorIA.jugarCarta(jugada);

        jugada.jugarMano();

        jugador1.juegaCarta(copa7);
        jugadorIA.cantar(jugada,partida);

        Assert.assertEquals(jugada.obtenerEstadoTruco().getClass(), EstadoTruco.class);
    }

    @Test
    public void testJugadorIALeCantanReTrucoSinJugarNadaYNoAceptaPorqueTiene2CartasMenorAUn2EnSegundaMano(){
        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();

        List<Jugador> jugadores2 = new ArrayList<>();
        JugadorIA jugadorIA = new JugadorIA(jugador2);
        jugadores2.add(jugador2);

        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1, equipo2);

        Jugada jugada = partida.crearJugada();

        Carta basto3 = new Basto(3, valoresTrucoYEnvido);
        Carta copa1 = new Copa(1, valoresTrucoYEnvido);
        Carta oro12 = new Oro(12, valoresTrucoYEnvido);

        jugadorIA.agregarCarta(basto3);
        jugadorIA.agregarCarta(copa1);
        jugadorIA.agregarCarta(oro12);

        Carta copa10 = new Copa(10, valoresTrucoYEnvido);
        Carta copa7 = new Copa(7, valoresTrucoYEnvido);
        Carta copa2 = new Copa(2, valoresTrucoYEnvido);

        jugador1.agregarCarta(copa10);
        jugador1.agregarCarta(copa7);
        jugador1.agregarCarta(copa2);

        jugador1.juegaCarta(copa2);
        jugadorIA.jugarCarta(jugada);

        Assert.assertEquals(jugadorIA.obtenerCartaEnJuego(), basto3);

        jugada.jugarMano();

        jugadorIA.cantar(jugada,partida);
        jugador1.cantarReTruco(jugada);
        jugadorIA.cantar(jugada,partida);


        Assert.assertEquals(jugada.obtenerEstadoJugada().getClass(), EstadoJugadaTerminada.class);
    }

    @Test
    public void testJugadorIATiene31DeEnvidoLeCantanFaltaEnvidoYAcepta() {

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();

        List<Jugador> jugadores2 = new ArrayList<>();
        JugadorIA jugadorIA = new JugadorIA(jugador2);
        jugadores2.add(jugador2);

        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1, equipo2);

        Jugada jugada = partida.crearJugada();

        Carta basto7 = new Basto(7, valoresTrucoYEnvido);
        Carta espada1 = new Espada(1, valoresTrucoYEnvido);
        Carta basto4 = new Basto(4, valoresTrucoYEnvido);

        jugadorIA.agregarCarta(basto4);
        jugadorIA.agregarCarta(espada1);
        jugadorIA.agregarCarta(basto7);

        Carta copa10 = new Copa(10, valoresTrucoYEnvido);
        Carta copa7 = new Copa(7, valoresTrucoYEnvido);
        Carta copa2 = new Copa(2, valoresTrucoYEnvido);

        jugador1.agregarCarta(copa10);
        jugador1.agregarCarta(copa7);
        jugador1.agregarCarta(copa2);

        jugador1.cantarFaltaEnvido(jugada);
        jugadorIA.cantar(jugada, partida);

        Assert.assertEquals(jugada.obtenerEstadoEnvido().getClass(), EstadoNoSePuedeCantarEnvido.class);
        Assert.assertEquals(equipo2.obtenerPuntos(), 15);
    }

}
