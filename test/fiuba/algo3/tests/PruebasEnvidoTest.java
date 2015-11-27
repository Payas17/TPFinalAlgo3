package fiuba.algo3.tests;



import modelo.*;
import modelo.Carta.*;
import modelo.Errores.NoSePuedeCantarEsoError;
import modelo.EstadoEnvido.*;
import modelo.Jugada.Jugada;
import modelo.Partida.Partida;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Lucio on 07/11/2015.
 */

public class PruebasEnvidoTest {

    @Test
    public void testTengo1DeOro7DeOroY7DeEspadaYCuenta28DeEnvido() {
        Jugador jugador = new Jugador();
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Carta oro7 = new Oro(7, valoresTrucoYEnvido);
        Carta oro1 = new Oro(1, valoresTrucoYEnvido);
        Carta espada1 = new Espada(7, valoresTrucoYEnvido);

        jugador.agregarCarta(oro7);
        jugador.agregarCarta(oro1);
        jugador.agregarCarta(espada1);

        Assert.assertEquals(jugador.obtenerEnvido(), 28);

    }

    @Test
    public void testTengo1DeEspada10DeEspadaY5DeBastoYCuenta28DeEnvido() {
        Jugador jugador = new Jugador();
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Carta espada1 = new Espada(1, valoresTrucoYEnvido);
        Carta espada10 = new Espada(10, valoresTrucoYEnvido);
        Carta basto5 = new Basto(5, valoresTrucoYEnvido);

        jugador.agregarCarta(espada10);
        jugador.agregarCarta(basto5);
        jugador.agregarCarta(espada1);

        Assert.assertEquals(jugador.obtenerEnvido(), 21);

    }

    @Test
    public void testTengo1DeCopa11DeBasto3DeCopaYCuenta24DeEnvido() {
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Jugador jugador = new Jugador();
        Carta copa1 = new Copa(1, valoresTrucoYEnvido);
        Carta basto11 = new Basto(11, valoresTrucoYEnvido);
        Carta copa3 = new Copa(3, valoresTrucoYEnvido);

        jugador.agregarCarta(copa1);
        jugador.agregarCarta(basto11);
        jugador.agregarCarta(copa3);

        Assert.assertEquals(jugador.obtenerEnvido(), 24);

    }

    @Test
    public void testTengo12DeCopa7DeBasto6DeBastoYCuenta33DeEnvido() {
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Jugador jugador = new Jugador();
        Carta copa12 = new Copa(12, valoresTrucoYEnvido);
        Carta basto7 = new Basto(7, valoresTrucoYEnvido);
        Carta basto6 = new Basto(6, valoresTrucoYEnvido);

        jugador.agregarCarta(copa12);
        jugador.agregarCarta(basto7);
        jugador.agregarCarta(basto6);

        Assert.assertEquals(jugador.obtenerEnvido(), 33);
    }

    @Test
    public void testJuegaCartaYCuentaBienElEnvido(){

        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Jugador jugador = new Jugador();
        Carta copa12 = new Copa(12, valoresTrucoYEnvido);
        Carta basto7 = new Basto(7, valoresTrucoYEnvido);
        Carta basto6 = new Basto(6, valoresTrucoYEnvido);

        jugador.agregarCarta(copa12);
        jugador.agregarCarta(basto7);
        jugador.agregarCarta(basto6);

        jugador.juegaCarta(basto7);

        Assert.assertEquals(jugador.obtenerEnvido(), 33);
    }

    @Test
    public void testEquipo1CantaEnvidoYElEstadoDeEnvidoEsEstadoEnvido(){

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores1 = new ArrayList<>();
        jugadores1.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);


        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);
        Jugada jugada = partida.crearJugada();

        jugador1.cantarEnvido(jugada);

        Assert.assertEquals(jugada.obtenerEstadoEnvido().getClass(), EstadoEnvido.class);
        Assert.assertEquals(jugada.obtenerEstadoEnvido().obtenerPuntos(), 2);
    }

    @Test
    public void testEquipo1CantaEnvidoEquipo2CantaEnvidoYElEstadoDeEnvidoEsEstadoEnvidoEnvido(){

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores1 = new ArrayList<>();
        jugadores1.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);


        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);
        Jugada jugada = partida.crearJugada();

        jugador1.cantarEnvido(jugada);
        jugador2.cantarEnvido(jugada);

        Assert.assertEquals(jugada.obtenerEstadoEnvido().getClass(), EstadoEnvidoEnvido.class);
    }

    @Test
    public void testEquipo1CantaEnvidoEquipo2CantaRealEnvidoYElEstadoDeEnvidoEsRealEnvido(){

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores1 = new ArrayList<>();
        jugadores1.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);


        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);
        Jugada jugada = partida.crearJugada();

        jugador1.cantarEnvido(jugada);
        jugador2.cantarRealEnvido(jugada);

        Assert.assertEquals(jugada.obtenerEstadoEnvido().getClass(), EstadoRealEnvido.class);
        Assert.assertEquals(jugada.obtenerEstadoEnvido().obtenerPuntos(), 3);
    }

    @Test
    public void testEquipo1CantaRealEnvidoEquipo2CantaRealEnvidoYElEstadoDeEnvidoEsRealEnvidoRealEnvido(){

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores1 = new ArrayList<>();
        jugadores1.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);


        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);
        Jugada jugada = partida.crearJugada();

        jugador1.cantarRealEnvido(jugada);
        jugador2.cantarRealEnvido(jugada);

        Assert.assertEquals(jugada.obtenerEstadoEnvido().getClass(), EstadoRealEnvidoRealEnvido.class);
    }

    @Test
    public void testEquipo1CantaRealEnvidoEquipo2NoAceptaYElEstadoDeEnvidoNoSePuedeCantarEnvido(){

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores1 = new ArrayList<>();
        jugadores1.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);


        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);
        Jugada jugada = partida.crearJugada();

        jugador1.cantarRealEnvido(jugada);
        jugador2.noAceptarEnvido(jugada);

        Assert.assertEquals(jugada.obtenerEstadoEnvido().getClass(), EstadoNoSePuedeCantarEnvido.class);
    }

    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testEquipo1CantaRealEnvidoEquipo2CantaEnvidoYLanzaErrorNoSePuedeCantarEso(){

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores1 = new ArrayList<>();
        jugadores1.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);


        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);
        Jugada jugada = partida.crearJugada();

        jugador1.cantarRealEnvido(jugada);
        jugador2.cantarEnvido(jugada);
    }

    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testEquipo1CantaRealEnvidoEquipo2ContraFlorYLanzaErrorNoSePuedeCantarEso(){

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores1 = new ArrayList<>();
        jugadores1.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);


        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);
        Jugada jugada = partida.crearJugada();

        jugador1.cantarRealEnvido(jugada);
        jugador2.cantarContraFlor(jugada);
    }

    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testEquipo1CantaRealEnvidoEquipo2noAceptaFlorYLanzaErrorNoSePuedeCantarEso(){

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores1 = new ArrayList<>();
        jugadores1.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);


        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);
        Jugada jugada = partida.crearJugada();

        jugador1.cantarRealEnvido(jugada);
        jugador2.noAceptarFlor(jugada);
    }

    @Test
    public void testEquipo1EnvidoEquipo2NoAceptaYElEstadoDeEnvidoNoSePuedeCantarEnvido(){

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores1 = new ArrayList<>();
        jugadores1.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);


        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);
        Jugada jugada = partida.crearJugada();

        jugador1.cantarEnvido(jugada);
        jugador2.noAceptarEnvido(jugada);

        Assert.assertEquals(jugada.obtenerEstadoEnvido().getClass(), EstadoNoSePuedeCantarEnvido.class);
    }

    @Test
    public void testEquipo1EnvidoEquipo2CantaFlorYEstadoEnvidoEsEstadoFlor(){

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

        jugador2.agregarCarta(basto12);
        jugador2.agregarCarta(basto7);
        jugador2.agregarCarta(basto6);

        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);
        Jugada jugada = partida.crearJugada();

        jugador1.cantarEnvido(jugada);
        jugador2.cantarFlor(jugada);

        Assert.assertEquals(jugada.obtenerEstadoEnvido().getClass(),EstadoFlor.class);
    }

    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testEquipo1EnvidoEquipo2ContraFlorYLanzaErrorNoSePuedeCantarEso(){

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores1 = new ArrayList<>();
        jugadores1.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);


        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);
        Jugada jugada = partida.crearJugada();

        jugador1.cantarEnvido(jugada);
        jugador2.cantarContraFlor(jugada);
    }

    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testEquipo1EnvidoEquipo2noAceptaFlorYLanzaErrorNoSePuedeCantarEso(){

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores1 = new ArrayList<>();
        jugadores1.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);


        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);
        Jugada jugada = partida.crearJugada();

        jugador1.cantarEnvido(jugada);
        jugador2.noAceptarFlor(jugada);
    }

    @Test
    public void testEquipo1FaltaEnvidoEquipo2NoAceptaYElEstadoDeEnvidoNoSePuedeCantarEnvido(){

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores1 = new ArrayList<>();
        jugadores1.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);


        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);
        Jugada jugada = partida.crearJugada();

        jugador1.cantarFaltaEnvido(jugada);
        jugador2.noAceptarEnvido(jugada);

        Assert.assertEquals(jugada.obtenerEstadoEnvido().getClass(), EstadoNoSePuedeCantarEnvido.class);
    }

    @Test
    public void testEquipo1FaltaEnvidoEquipo2CantaFlorYEstadoEnvidoEsEstadoFlor(){

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

        jugador2.agregarCarta(basto12);
        jugador2.agregarCarta(basto7);
        jugador2.agregarCarta(basto6);

        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);
        Jugada jugada = partida.crearJugada();

        jugador1.cantarFaltaEnvido(jugada);
        jugador2.cantarFlor(jugada);

        Assert.assertEquals(jugada.obtenerEstadoEnvido().getClass(),EstadoFlor.class);
    }

    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testEquipo1FaltaEnvidoEquipo2ContraFlorYLanzaErrorNoSePuedeCantarEso(){

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores1 = new ArrayList<>();
        jugadores1.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);


        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);
        Jugada jugada = partida.crearJugada();

        jugador1.cantarFaltaEnvido(jugada);
        jugador2.cantarContraFlor(jugada);
    }

    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testEquipo1FaltaEnvidoEquipo2noAceptaFlorYLanzaErrorNoSePuedeCantarEso(){

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores1 = new ArrayList<>();
        jugadores1.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);


        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);
        Jugada jugada = partida.crearJugada();

        jugador1.cantarFaltaEnvido(jugada);
        jugador2.noAceptarFlor(jugada);
    }

    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testEquipo1FaltaEnvidoEquipo2FaltaEnvidoYLanzaErrorNoSePuedeCantarEso(){

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores1 = new ArrayList<>();
        jugadores1.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);


        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);
        Jugada jugada = partida.crearJugada();

        jugador1.cantarFaltaEnvido(jugada);
        jugador2.cantarFaltaEnvido(jugada);
    }

    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testEquipo1CantaFaltaEnvidoEquipo2RealEnvidoYLanzaErrorNoSePuedeCantarEso() {

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores1 = new ArrayList<>();
        jugadores1.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);


        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1, equipo2);
        Jugada jugada = partida.crearJugada();

        jugador1.cantarFaltaEnvido(jugada);
        jugador2.cantarRealEnvido(jugada);
    }

    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testEquipo1CantaFaltaEnvidoEquipo2EnvidoYLanzaErrorNoSePuedeCantarEso(){

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores1 = new ArrayList<>();
        jugadores1.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);


        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);
        Jugada jugada = partida.crearJugada();

        jugador1.cantarFaltaEnvido(jugada);
        jugador2.cantarEnvido(jugada);
    }

    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testEnvidoEnvidoContraFlorYLanzaErrorNoSePuedeCantarEso(){

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

        jugador1.agregarCarta(basto12);
        jugador1.agregarCarta(basto7);
        jugador1.agregarCarta(basto6);


        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);
        Jugada jugada = partida.crearJugada();

        jugador1.cantarEnvido(jugada);
        jugador2.cantarEnvido(jugada);
        jugador1.cantarContraFlor(jugada);
    }

    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testEnvidoEnvidoNoAceptaFlorYLanzaErrorNoSePuedeCantarEso(){

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

        jugador1.agregarCarta(basto12);
        jugador1.agregarCarta(basto7);
        jugador1.agregarCarta(basto6);


        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);
        Jugada jugada = partida.crearJugada();

        jugador1.cantarEnvido(jugada);
        jugador2.cantarEnvido(jugada);
        jugador1.aceptarFlor(jugada);
    }

    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testEnvidoEnvidoAceptarFlorYLanzaErrorNoSePuedeCantarEso(){

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores1 = new ArrayList<>();
        jugadores1.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);


        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);
        Jugada jugada = partida.crearJugada();

        jugador1.cantarEnvido(jugada);
        jugador2.cantarEnvido(jugada);
        jugador1.aceptarFlor(jugada);
    }

    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testEnvidoEnvidoContraFlorAlRestoYLanzaErrorNoSePuedeCantarEso(){

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores1 = new ArrayList<>();
        jugadores1.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);


        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);
        Jugada jugada = partida.crearJugada();

        jugador1.cantarEnvido(jugada);
        jugador2.cantarEnvido(jugada);
        jugador1.cantarContraFlorAlResto(jugada);
    }


    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testEnvidoEnvidoEnvidoYLanzaErrorNoSePuedeCantarEso(){

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores1 = new ArrayList<>();
        jugadores1.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);


        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);
        Jugada jugada = partida.crearJugada();

        jugador1.cantarEnvido(jugada);
        jugador2.cantarEnvido(jugada);
        jugador1.cantarEnvido(jugada);
    }


    @Test(expected = NoSePuedeCantarEsoError.class)
    public void tesRealEnvidoRealEnvidoContraFlorYLanzaErrorNoSePuedeCantarEso(){

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

        jugador1.agregarCarta(basto12);
        jugador1.agregarCarta(basto7);
        jugador1.agregarCarta(basto6);


        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);
        Jugada jugada = partida.crearJugada();

        jugador1.cantarRealEnvido(jugada);
        jugador2.cantarRealEnvido(jugada);
        jugador1.cantarContraFlor(jugada);
    }

    @Test
    public void tesRealEnvidoRealEnvidoFaltaEnvidoNoAceptarYEstadoDeEnvidoEsEstadoNoSePuedeCantarEnvido(){

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

        jugador1.agregarCarta(basto12);
        jugador1.agregarCarta(basto7);
        jugador1.agregarCarta(basto6);


        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);
        Jugada jugada = partida.crearJugada();

        jugador1.cantarRealEnvido(jugada);
        jugador2.cantarRealEnvido(jugada);
        jugador1.cantarFaltaEnvido(jugada);
        jugador2.noAceptarEnvido(jugada);

        Assert.assertEquals(jugada.obtenerEstadoEnvido().getClass(), EstadoNoSePuedeCantarEnvido.class);
    }

    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testRealEnvidoRealEnvidoNoAceptaFlorYLanzaErrorNoSePuedeCantarEso(){

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

        jugador1.agregarCarta(basto12);
        jugador1.agregarCarta(basto7);
        jugador1.agregarCarta(basto6);


        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);
        Jugada jugada = partida.crearJugada();

        jugador1.cantarRealEnvido(jugada);
        jugador2.cantarRealEnvido(jugada);
        jugador1.noAceptarFlor(jugada);
    }

    @Test(expected = NoSePuedeCantarEsoError.class)
    public void tesRealEnvidoRealEnvidoAceptarFlorYLanzaErrorNoSePuedeCantarEso(){

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores1 = new ArrayList<>();
        jugadores1.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);


        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);
        Jugada jugada = partida.crearJugada();

        jugador1.cantarRealEnvido(jugada);
        jugador2.cantarRealEnvido(jugada);
        jugador1.aceptarFlor(jugada);
    }

    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testRealEnvidoRealEnvidoContraFlorAlRestoYLanzaErrorNoSePuedeCantarEso(){

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores1 = new ArrayList<>();
        jugadores1.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);


        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);
        Jugada jugada = partida.crearJugada();

        jugador1.cantarRealEnvido(jugada);
        jugador2.cantarRealEnvido(jugada);
        jugador1.cantarContraFlorAlResto(jugada);
    }


    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testRealEnvidoRealEnvidoRealEnvidoYLanzaErrorNoSePuedeCantarEso(){

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores1 = new ArrayList<>();
        jugadores1.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);


        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);
        Jugada jugada = partida.crearJugada();

        jugador1.cantarRealEnvido(jugada);
        jugador2.cantarRealEnvido(jugada);
        jugador1.cantarRealEnvido(jugada);
    }

    @Test
    public void testRealEnvidoRealEnvidoNoAceptarYElEstadoDeEnvidoNoSePuedeCantarEnvido(){

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores1 = new ArrayList<>();
        jugadores1.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);


        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);
        Jugada jugada = partida.crearJugada();

        jugador1.cantarRealEnvido(jugada);
        jugador2.cantarRealEnvido(jugada);
        jugador1.noAceptarEnvido(jugada);

        Assert.assertEquals(jugada.obtenerEstadoEnvido().getClass(), EstadoNoSePuedeCantarEnvido.class);
    }

    @Test
    public void testRealEnvidoRealEnvidoYEstadoEnvidoEsEstadoRealEnvidoRealEnvido(){

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

        jugador2.agregarCarta(basto12);
        jugador2.agregarCarta(basto7);
        jugador2.agregarCarta(basto6);

        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);
        Jugada jugada = partida.crearJugada();

        jugador1.cantarRealEnvido(jugada);
        jugador2.cantarRealEnvido(jugada);

        Assert.assertEquals(jugada.obtenerEstadoEnvido().getClass(),EstadoRealEnvidoRealEnvido.class);
    }

    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testEstadoSinEnvidoYSeCantaContraFlorLanzaErrorNoSePuedeCantarEso(){

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

        jugador2.agregarCarta(basto12);
        jugador2.agregarCarta(basto7);
        jugador2.agregarCarta(basto6);

        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);
        Jugada jugada = partida.crearJugada();

        jugador1.cantarContraFlor(jugada);

    }


    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testEstadoSinEnvidoYSeCantaContraFlorAlRestoLanzaErrorNoSePuedeCantarEso(){

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

        jugador2.agregarCarta(basto12);
        jugador2.agregarCarta(basto7);
        jugador2.agregarCarta(basto6);

        Equipo equipo1 = new Equipo(jugadores1);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);
        Jugada jugada = partida.crearJugada();

        jugador1.cantarContraFlorAlResto(jugada);

    }

}
