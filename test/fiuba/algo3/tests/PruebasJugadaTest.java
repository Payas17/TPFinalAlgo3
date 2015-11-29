package fiuba.algo3.tests;

import modelo.*;
import modelo.Carta.*;
import modelo.Errores.*;
import modelo.EstadoEnvido.EstadoSinEnvido;
import modelo.Jugada.Jugada;
import modelo.Partida.Partida;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucio on 08/11/2015.
 */
public class PruebasJugadaTest {
    @Test
    public void testHacerUnaJugadaYGanaEnTerceraMano(){
        Jugador jugador1= new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1,equipo2);

        Jugada jugada = partida.crearJugada();
        Carta espada10 = new Espada(10,valoresTrucoYEnvido);
        Carta basto5 = new Basto(5,valoresTrucoYEnvido);

        jugador1.agregarCarta(espada10);
        jugador2.agregarCarta(basto5);

        jugador1.juegaCarta(espada10);
        jugador2.juegaCarta(basto5);

        jugada.jugarMano();

        Carta espada1 = new Espada(1,valoresTrucoYEnvido);
        Carta oro1 = new Oro(1,valoresTrucoYEnvido);

        jugador1.agregarCarta(oro1);
        jugador2.agregarCarta(espada1);

        jugador1.juegaCarta(oro1);
        jugador2.juegaCarta(espada1);

        jugada.jugarMano();

        Carta basto1 = new Basto(1,valoresTrucoYEnvido);
        Carta copa1 = new Copa(1,valoresTrucoYEnvido);

        jugador1.agregarCarta(basto1);
        jugador2.agregarCarta(copa1);

        jugador1.juegaCarta(basto1);
        jugador2.juegaCarta(copa1);

        jugada.jugarMano();

        Assert.assertEquals(jugada.obtenerEquipoGanadorDeJugada(), equipo1);

    }

    @Test
    public void testHacerUnaJugadaYGanaEnSegundaMano(){
        Jugador jugador1= new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1,equipo2);

        Jugada jugada = partida.crearJugada();


        Carta espada10 = new Espada(10,valoresTrucoYEnvido);
        Carta basto11 = new Basto(11,valoresTrucoYEnvido);

        jugador1.agregarCarta(espada10);
        jugador2.agregarCarta(basto11);

        jugador1.juegaCarta(espada10);
        jugador2.juegaCarta(basto11);

        jugada.jugarMano();

        Carta espada2 = new Espada(2,valoresTrucoYEnvido);
        Carta oro3 = new Oro(3,valoresTrucoYEnvido);

        jugador1.agregarCarta(espada2);
        jugador2.agregarCarta(oro3);

        jugador1.juegaCarta(espada2);
        jugador2.juegaCarta(oro3);

        jugada.jugarMano();

        Assert.assertEquals(jugada.obtenerEquipoGanadorDeJugada(), equipo2);

    }



    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testTiraErrorSiCanto3VecesEnvido(){

        Jugador jugador1= new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);

        Jugada jugada = partida.crearJugada();
        jugador1.cantarEnvido(jugada);
        jugador2.cantarEnvido(jugada);
        jugador1.cantarEnvido(jugada);


    }

    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testTiraErrorSiCantoEnvidoRealEnvidoYDespuesEnvido(){

        Jugador jugador1= new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);

        Jugada jugada = partida.crearJugada();

        jugador1.cantarEnvido(jugada);
        jugador2.cantarRealEnvido(jugada);
        jugador1.cantarEnvido(jugada);


    }
    @Test
    public void testEquipo1GanaEnvidoRealEnvido(){

        Jugador jugador1= new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1,equipo2);

        Jugada jugada = partida.crearJugada();

        Carta oro7 = new Oro(7, valoresTrucoYEnvido);
        Carta oro1 = new Oro(1, valoresTrucoYEnvido);
        Carta espada1 = new Espada(7, valoresTrucoYEnvido);

        jugador1.agregarCarta(oro7);
        jugador1.agregarCarta(oro1);
        jugador1.agregarCarta(espada1);

        Carta oro5 = new Oro(5, valoresTrucoYEnvido);
        Carta oro2 = new Oro(2, valoresTrucoYEnvido);
        Carta espada2 = new Espada(2, valoresTrucoYEnvido);

        jugador2.agregarCarta(oro5);
        jugador2.agregarCarta(oro2);
        jugador2.agregarCarta(espada2);

        jugador1.cantarEnvido(jugada);
        jugador2.cantarRealEnvido(jugada);
        jugador1.aceptarEnvido(jugada);

        Assert.assertEquals(jugador1,jugada.obtenerJugadorGanadorEnvido());
        Assert.assertEquals(equipo1,jugada.obtenerEquipoGanadorEnvido());
        Assert.assertEquals(equipo1.obtenerPuntos(),5);
        Assert.assertEquals(equipo2.obtenerPuntos(),0);



    }
    @Test
    public void testEquipo1GanaEnvido4Jugadores(){

        Jugador jugador1= new Jugador();
        Jugador jugador2= new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        Jugador jugador3 = new Jugador();
        Jugador jugador4 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador3);
        jugadores2.add(jugador4);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1,equipo2);

        Jugada jugada = partida.crearJugada();

        Carta oro7 = new Oro(7, valoresTrucoYEnvido);
        Carta oro1 = new Oro(1, valoresTrucoYEnvido);
        Carta espada1 = new Espada(7, valoresTrucoYEnvido);

        jugador1.agregarCarta(oro7);
        jugador1.agregarCarta(oro1);
        jugador1.agregarCarta(espada1);

        Carta basto7 = new Basto(7, valoresTrucoYEnvido);
        Carta basto6 = new Basto(6, valoresTrucoYEnvido);
        Carta espada3 = new Espada(3, valoresTrucoYEnvido);

        jugador2.agregarCarta(basto7);
        jugador2.agregarCarta(basto6);
        jugador2.agregarCarta(espada3);

        Carta oro5 = new Oro(5, valoresTrucoYEnvido);
        Carta oro2 = new Oro(2, valoresTrucoYEnvido);
        Carta espada2 = new Espada(2, valoresTrucoYEnvido);

        jugador3.agregarCarta(oro5);
        jugador3.agregarCarta(oro2);
        jugador3.agregarCarta(espada2);

        Carta basto10 = new Basto(10, valoresTrucoYEnvido);
        Carta basto11 = new Basto(11, valoresTrucoYEnvido);
        Carta espada4 = new Espada(4, valoresTrucoYEnvido);

        jugador4.agregarCarta(basto10);
        jugador4.agregarCarta(basto11);
        jugador4.agregarCarta(espada4);

        jugador2.cantarEnvido(jugada);
        jugador3.aceptarEnvido(jugada);


        Assert.assertEquals(jugador2,jugada.obtenerJugadorGanadorEnvido());
        Assert.assertEquals(equipo1,jugada.obtenerEquipoGanadorEnvido());
        Assert.assertEquals(equipo1.obtenerPuntos(),2);
        Assert.assertEquals(equipo2.obtenerPuntos(),0);



    }

    @Test
    public void testEquipo2GanaEnvidoEnvidoRealEnvido(){

        Jugador jugador1= new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1,equipo2);

        Jugada jugada = partida.crearJugada();
        Carta oro7 = new Oro(7, valoresTrucoYEnvido);
        Carta oro1 = new Oro(1, valoresTrucoYEnvido);
        Carta espada1 = new Espada(7, valoresTrucoYEnvido);

        Carta oro5 = new Oro(5, valoresTrucoYEnvido);
        Carta oro2 = new Oro(2, valoresTrucoYEnvido);
        Carta espada2 = new Espada(2, valoresTrucoYEnvido);

        jugador1.agregarCarta(oro5);
        jugador1.agregarCarta(oro2);
        jugador1.agregarCarta(espada1);

        jugador2.agregarCarta(oro7);
        jugador2.agregarCarta(oro1);
        jugador2.agregarCarta(espada2);

        jugador1.cantarEnvido(jugada);
        jugador2.cantarEnvido(jugada);
        jugador1.cantarRealEnvido(jugada);
        jugador2.aceptarEnvido(jugada);

        Assert.assertEquals(jugador2,jugada.obtenerJugadorGanadorEnvido());
        Assert.assertEquals(equipo2,jugada.obtenerEquipoGanadorEnvido());
        Assert.assertEquals(equipo2.obtenerPuntos(),7);
        Assert.assertEquals(equipo1.obtenerPuntos(),0);



    }

    @Test
    public void testEquipo1GanaPardaEnvidoEnvidoRealEnvido(){

        Jugador jugador1= new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1,equipo2);

        Jugada jugada = partida.crearJugada();
        Carta oro7 = new Oro(7, valoresTrucoYEnvido);
        Carta oro1 = new Oro(1, valoresTrucoYEnvido);
        Carta espada1 = new Espada(7, valoresTrucoYEnvido);

        Carta basto7 = new Basto(7, valoresTrucoYEnvido);
        Carta basto1 = new Basto(1, valoresTrucoYEnvido);
        Carta espada2 = new Espada(2, valoresTrucoYEnvido);

        jugador1.agregarCarta(basto7);
        jugador1.agregarCarta(basto1);
        jugador1.agregarCarta(espada1);



        jugador2.agregarCarta(oro7);
        jugador2.agregarCarta(oro1);
        jugador2.agregarCarta(espada2);

        jugador1.cantarEnvido(jugada);
        jugador2.cantarEnvido(jugada);
        jugador1.cantarRealEnvido(jugada);
        jugador2.aceptarEnvido(jugada);

        Assert.assertEquals(jugador1, jugada.obtenerJugadorGanadorEnvido());
        Assert.assertEquals(equipo1,jugada.obtenerEquipoGanadorEnvido());
        Assert.assertEquals(equipo1.obtenerPuntos(),7);
        Assert.assertEquals(equipo2.obtenerPuntos(),0);



    }


    @Test
    public void testEquipo2GanaFaltaEnvidoCuandoEquipo1EstaEnlasMalasCon3Puntos(){
        Jugador jugador1= new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1,equipo2);

        Jugada jugada = partida.crearJugada();
        equipo1.sumarPuntos(5);
        equipo2.sumarPuntos(15);

        Carta oro7 = new Oro(7, valoresTrucoYEnvido);
        Carta oro1 = new Oro(1, valoresTrucoYEnvido);
        Carta espada1 = new Espada(7, valoresTrucoYEnvido);

        Carta oro5 = new Oro(5, valoresTrucoYEnvido);
        Carta oro2 = new Oro(2, valoresTrucoYEnvido);
        Carta espada2 = new Espada(2, valoresTrucoYEnvido);

        jugador1.agregarCarta(oro5);
        jugador1.agregarCarta(oro2);
        jugador1.agregarCarta(espada1);



        jugador2.agregarCarta(oro7);
        jugador2.agregarCarta(oro1);
        jugador2.agregarCarta(espada2);

        jugador1.cantarFaltaEnvido(jugada);
        jugador2.aceptarEnvido(jugada);

        Assert.assertEquals(equipo2,jugada.obtenerEquipoGanadorEnvido());
        Assert.assertEquals(equipo2.obtenerPuntos(),25);
        Assert.assertEquals(equipo1.obtenerPuntos(),5);

    }

    @Test
    public void testEquipo2GanaFaltaEnvidoCuandoEquipo1EstaEnlasBuenas(){
        Jugador jugador1= new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1,equipo2);

        Jugada jugada = partida.crearJugada();

        equipo1.sumarPuntos(16);
        equipo2.sumarPuntos(1);

        Carta oro7 = new Oro(7, valoresTrucoYEnvido);
        Carta oro1 = new Oro(1, valoresTrucoYEnvido);
        Carta espada1 = new Espada(7, valoresTrucoYEnvido);

        Carta oro5 = new Oro(5, valoresTrucoYEnvido);
        Carta oro2 = new Oro(2, valoresTrucoYEnvido);
        Carta espada2 = new Espada(2, valoresTrucoYEnvido);

        jugador1.agregarCarta(oro5);
        jugador1.agregarCarta(oro2);
        jugador1.agregarCarta(espada1);


        jugador2.agregarCarta(oro7);
        jugador2.agregarCarta(oro1);
        jugador2.agregarCarta(espada2);

        jugador1.cantarFaltaEnvido(jugada);
        jugador2.aceptarEnvido(jugada);

        Assert.assertEquals(equipo2, jugada.obtenerEquipoGanadorEnvido());
        Assert.assertEquals(equipo2.obtenerPuntos(),15);
        Assert.assertEquals(equipo1.obtenerPuntos(),16);

    }

    @Test
    public void testEquipo1GanaEnvidoEnvidoEquipo2NoAceptaFaltaEnvido(){
        Jugador jugador1= new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1,equipo2);

        Jugada jugada = partida.crearJugada();
        Carta oro7 = new Oro(7, valoresTrucoYEnvido);
        Carta oro1 = new Oro(1, valoresTrucoYEnvido);
        Carta espada1 = new Espada(7, valoresTrucoYEnvido);

        Carta oro5 = new Oro(5, valoresTrucoYEnvido);
        Carta oro2 = new Oro(2, valoresTrucoYEnvido);
        Carta espada2 = new Espada(2, valoresTrucoYEnvido);

        jugador2.agregarCarta(oro5);
        jugador2.agregarCarta(oro2);
        jugador2.agregarCarta(espada1);



        jugador1.agregarCarta(oro7);
        jugador1.agregarCarta(oro1);
        jugador1.agregarCarta(espada2);

        jugador1.cantarEnvido(jugada);
        jugador2.cantarEnvido(jugada);
        jugador1.cantarFaltaEnvido(jugada);
        jugador2.noAceptarEnvido(jugada);

        Assert.assertEquals(equipo1.obtenerPuntos(),4);
        Assert.assertEquals(equipo2.obtenerPuntos(),0);


    }

    @Test
    public void testEquipo1GanaEnvidoEnvidoEquipo1NoAceptaRealEnvido(){

        Jugador jugador1= new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1,equipo2);

        Jugada jugada = partida.crearJugada();

        Carta oro7 = new Oro(7, valoresTrucoYEnvido);
        Carta oro1 = new Oro(1, valoresTrucoYEnvido);
        Carta espada1 = new Espada(7, valoresTrucoYEnvido);

        Carta oro5 = new Oro(5, valoresTrucoYEnvido);
        Carta oro2 = new Oro(2, valoresTrucoYEnvido);
        Carta espada2 = new Espada(2, valoresTrucoYEnvido);

        jugador2.agregarCarta(oro5);
        jugador2.agregarCarta(oro2);
        jugador2.agregarCarta(espada1);



        jugador1.agregarCarta(oro7);
        jugador1.agregarCarta(oro1);
        jugador1.agregarCarta(espada2);

        jugador1.cantarEnvido(jugada);
        jugador2.cantarEnvido(jugada);
        jugador1.cantarRealEnvido(jugada);
        jugador2.noAceptarEnvido(jugada);

        Assert.assertEquals(equipo1.obtenerPuntos(),4);
        Assert.assertEquals(equipo2.obtenerPuntos(),0);



    }

    @Test
    public void testEquipo1GanaEnvidoPorqueEquipo2NoAcepta(){
        Jugador jugador1= new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1,equipo2);

        Jugada jugada = partida.crearJugada();

        Carta oro7 = new Oro(7, valoresTrucoYEnvido);
        Carta oro1 = new Oro(1, valoresTrucoYEnvido);
        Carta espada1 = new Espada(7, valoresTrucoYEnvido);

        Carta oro5 = new Oro(5, valoresTrucoYEnvido);
        Carta oro2 = new Oro(2, valoresTrucoYEnvido);
        Carta espada2 = new Espada(2, valoresTrucoYEnvido);

        jugador1.agregarCarta(oro5);
        jugador1.agregarCarta(oro2);
        jugador1.agregarCarta(espada1);



        jugador2.agregarCarta(oro7);
        jugador2.agregarCarta(oro1);
        jugador2.agregarCarta(espada2);

        jugador1.cantarEnvido(jugada);
        jugador2.noAceptarEnvido(jugada);

        Assert.assertEquals(equipo1.obtenerPuntos(),1);
        Assert.assertEquals(equipo2.obtenerPuntos(),0);

    }

    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testEquipo1CantaReTrucoError(){
        Jugador jugador1= new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);


        Partida partida = new Partida(equipo1,equipo2);

        Jugada jugada = partida.crearJugada();

        jugador1.cantarReTruco(jugada);

    }

    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testEquipo1CantaTrucoEquipo2CantaTrucoError(){
        Jugador jugador1= new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);


        Partida partida = new Partida(equipo1,equipo2);

        Jugada jugada = partida.crearJugada();

        jugador1.cantarTruco(jugada);
        jugador2.cantarTruco(jugada);
    }

    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testEquipo1CantaTrucoEquipo2CantaValeCuatroError(){
        Jugador jugador1= new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);

        Jugada jugada = partida.crearJugada();
        jugador1.cantarTruco(jugada);
        jugador2.cantarValeCuatro(jugada);


    }


    @Test
    public void testEquipo1GanaReTrucoEquipo2NoAceptaValeCuatro(){
        Jugador jugador1= new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);

        Jugada jugada = partida.crearJugada();
        jugador1.cantarTruco(jugada);
        jugador2.cantarReTruco(jugada);
        jugador1.cantarValeCuatro(jugada);
        jugador2.noAceptarTruco(jugada);

        Assert.assertEquals(equipo1.obtenerPuntos(),3);
        Assert.assertEquals(equipo2.obtenerPuntos(), 0);

    }

    @Test
    public void testEquipo2GanaTrucoEquipo1NoAceptaReTruco() {
        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);

        Partida partida = new Partida(equipo1,equipo2);

        Jugada jugada = partida.crearJugada();

        jugador1.cantarTruco(jugada);
        jugador2.cantarReTruco(jugada);
        jugador1.noAceptarTruco(jugada);

        Assert.assertEquals(equipo1.obtenerPuntos(), 0);
        Assert.assertEquals(equipo2.obtenerPuntos(), 2);

    }


    @Test
    public void testHacerUnaJugadaDeEmpateYGanaEnTerceraManoEquipo1(){
        Jugador jugador1= new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();

        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);

        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);

        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1,equipo2);

        Jugada jugada = partida.crearJugada();

        Carta espada10 = new Espada(10,valoresTrucoYEnvido);
        Carta basto5 = new Basto(5,valoresTrucoYEnvido);

        jugador1.agregarCarta(espada10);
        jugador2.agregarCarta(basto5);

        jugador1.juegaCarta(espada10);
        jugador2.juegaCarta(basto5);

        jugada.jugarMano();

        //Gana primera mano equipo1

        Carta espada1 = new Espada(1,valoresTrucoYEnvido);
        Carta oro1 = new Oro(1,valoresTrucoYEnvido);

        jugador1.agregarCarta(oro1);
        jugador2.agregarCarta(espada1);

        jugador1.juegaCarta(oro1);
        jugador2.juegaCarta(espada1);

        jugada.jugarMano();

        //Gana segunda mano equipo2

        Carta basto1 = new Basto(1,valoresTrucoYEnvido);
        Carta copa1 = new Copa(1,valoresTrucoYEnvido);

        jugador1.agregarCarta(basto1);
        jugador2.agregarCarta(copa1);

        jugador1.juegaCarta(basto1);
        jugador2.juegaCarta(copa1);

        jugada.jugarMano();

        Assert.assertEquals(equipo1 ,jugada.obtenerEquipoGanadorDeJugada());

    }

    @Test
    public void testHacerUnaJugadaYGanaEnSegundaManoVersionEstados(){
        Jugador jugador1= new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1,equipo2);

        Jugada jugada = partida.crearJugada();

        Carta espada10 = new Espada(10,valoresTrucoYEnvido);
        Carta basto11 = new Basto(11,valoresTrucoYEnvido);

        jugador1.agregarCarta(espada10);
        jugador2.agregarCarta(basto11);

        jugador1.juegaCarta(espada10);
        jugador2.juegaCarta(basto11);

        jugada.jugarMano();

        //Ganando equipo2

        Carta espada2 = new Espada(2,valoresTrucoYEnvido);
        Carta oro3 = new Oro(3,valoresTrucoYEnvido);

        jugador1.agregarCarta(espada2);
        jugador2.agregarCarta(oro3);

        jugador1.juegaCarta(espada2);
        jugador2.juegaCarta(oro3);

        jugada.jugarMano();

        Assert.assertEquals(jugada.obtenerEquipoGanadorDeJugada(), equipo2);

    }

    @Test
         public void testPardanLas3ManosYGanaElJugadorQueEsManoVersionEstados(){

        Jugador jugador1= new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1,equipo2);

        Jugada jugada = partida.crearJugada();

        Carta espada10 = new Espada(10,valoresTrucoYEnvido);
        Carta basto10 = new Basto(10,valoresTrucoYEnvido);

        jugador1.agregarCarta(espada10);
        jugador2.agregarCarta(basto10);

        jugador1.juegaCarta(espada10);
        jugador2.juegaCarta(basto10);

        jugada.jugarMano();

        Carta copa1 = new Copa(1,valoresTrucoYEnvido);
        Carta oro1 = new Oro(1,valoresTrucoYEnvido);

        jugador1.agregarCarta(copa1);
        jugador2.agregarCarta(oro1);

        jugador1.juegaCarta(copa1);
        jugador2.juegaCarta(oro1);

        jugada.jugarMano();

        Carta copa2 = new Copa(2,valoresTrucoYEnvido);
        Carta oro2 = new Oro(2,valoresTrucoYEnvido);

        jugador1.agregarCarta(copa2);
        jugador2.agregarCarta(oro2);

        jugador1.juegaCarta(copa2);
        jugador2.juegaCarta(oro2);

        jugada.jugarMano();

        Assert.assertEquals(jugada.obtenerEquipoGanadorDeJugada(), equipo1);
    }

    @Test(expected = JugadaTerminadaError.class)
    public void testJugadaYaTerminadaDevuelveErrorSiSigueOtraMano(){

        Jugador jugador1= new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1,equipo2);

        Jugada jugada = partida.crearJugada();

        Carta espada10 = new Espada(10,valoresTrucoYEnvido);
        Carta basto10 = new Basto(10,valoresTrucoYEnvido);

        jugador1.agregarCarta(espada10);
        jugador2.agregarCarta(basto10);

        jugador1.juegaCarta(espada10);
        jugador2.juegaCarta(basto10);

        jugada.jugarMano();

        Carta copa1 = new Copa(1,valoresTrucoYEnvido);
        Carta oro1 = new Oro(1,valoresTrucoYEnvido);

        jugador1.agregarCarta(copa1);
        jugador2.agregarCarta(oro1);

        jugador1.juegaCarta(copa1);
        jugador2.juegaCarta(oro1);

        jugada.jugarMano();

        Carta copa2 = new Copa(2,valoresTrucoYEnvido);
        Carta oro2 = new Oro(2,valoresTrucoYEnvido);

        jugador1.agregarCarta(copa2);
        jugador2.agregarCarta(oro2);

        jugador1.juegaCarta(copa2);
        jugador2.juegaCarta(oro2);

        jugada.jugarMano();

        jugada.jugarMano();
    }
    @Test
    public void testEstanEmpatadosYEnTerceraEmpardanYGanaElJugadorQueHizoPrimera(){

        Jugador jugador1= new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1,equipo2);

        Jugada jugada = partida.crearJugada();



        Carta espada11 = new Espada(11,valoresTrucoYEnvido);
        Carta basto10 = new Basto(10,valoresTrucoYEnvido);

        jugador1.agregarCarta(espada11);
        jugador2.agregarCarta(basto10);

        jugador1.juegaCarta(espada11);
        jugador2.juegaCarta(basto10);

        jugada.jugarMano();

        Carta copa10 = new Copa(10,valoresTrucoYEnvido);
        Carta oro1 = new Oro(1,valoresTrucoYEnvido);

        jugador1.agregarCarta(copa10);
        jugador2.agregarCarta(oro1);

        jugador1.juegaCarta(copa10);
        jugador2.juegaCarta(oro1);

        jugada.jugarMano();

        Carta copa2 = new Copa(2,valoresTrucoYEnvido);
        Carta oro2 = new Oro(2,valoresTrucoYEnvido);

        jugador1.agregarCarta(copa2);
        jugador2.agregarCarta(oro2);

        jugador1.juegaCarta(copa2);
        jugador2.juegaCarta(oro2);

        jugada.jugarMano();

        Assert.assertEquals(jugada.obtenerEquipoGanadorDeJugada(), equipo1);
    }

    @Test(expected = NoSePuedeCantarEsoError.class )
    public void testEquipo2CantaEnvidoEnSegundaManoYNoSeLePermite(){
        Jugador jugador1= new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1,equipo2);

        Jugada jugada = partida.crearJugada();
        Carta espada11 = new Espada(11,valoresTrucoYEnvido);
        Carta basto10 = new Basto(10,valoresTrucoYEnvido);

        jugador1.agregarCarta(espada11);
        jugador2.agregarCarta(basto10);

        jugador1.juegaCarta(espada11);
        jugador2.juegaCarta(basto10);

        jugada.jugarMano();

        Carta copa10 = new Copa(10,valoresTrucoYEnvido);
        Carta oro1 = new Oro(1,valoresTrucoYEnvido);

        jugador1.agregarCarta(copa10);
        jugador2.agregarCarta(oro1);

        jugador1.juegaCarta(copa10);
        jugador2.juegaCarta(oro1);

        jugada.jugarMano();

        jugador1.cantarEnvido(jugada);
    }

    @Test(expected = NoSePuedeCantarEsoError.class )
    public void testEquipo2CantaEnvidoEnTerceraManoYNoSeLePermite(){
        Jugador jugador1= new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1,equipo2);

        Jugada jugada = partida.crearJugada();
        Carta espada11 = new Espada(11,valoresTrucoYEnvido);
        Carta basto10 = new Basto(10,valoresTrucoYEnvido);

        jugador1.agregarCarta(espada11);
        jugador2.agregarCarta(basto10);

        jugador1.juegaCarta(espada11);
        jugador2.juegaCarta(basto10);

        jugada.jugarMano();

        Carta copa10 = new Copa(10,valoresTrucoYEnvido);
        Carta oro1 = new Oro(1,valoresTrucoYEnvido);

        jugador1.agregarCarta(copa10);
        jugador2.agregarCarta(oro1);

        jugador1.juegaCarta(copa10);
        jugador2.juegaCarta(oro1);

        jugada.jugarMano();

        Carta oro3 = new Oro(3,valoresTrucoYEnvido);
        Carta oro2 = new Oro(2,valoresTrucoYEnvido);

        jugador1.agregarCarta(oro3);
        jugador2.agregarCarta(oro2);

        jugador1.juegaCarta(oro3);
        jugador2.juegaCarta(oro2);

        jugador1.cantarEnvido(jugada);
    }

    @Test(expected = NoPuedeJugarError.class)
    public void testJugadorDelMismoEquipoNoPuedeAceptarElEnvido(){
        Jugador jugador1= new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1,equipo2);

        Jugada jugada = partida.crearJugada();
        Carta espada11 = new Espada(11,valoresTrucoYEnvido);
        Carta basto10 = new Basto(10,valoresTrucoYEnvido);

        jugador1.agregarCarta(espada11);
        jugador2.agregarCarta(basto10);

        Carta copa10 = new Copa(10,valoresTrucoYEnvido);
        Carta oro1 = new Oro(1,valoresTrucoYEnvido);

        jugador1.agregarCarta(copa10);
        jugador2.agregarCarta(oro1);

        Carta oro3 = new Oro(3,valoresTrucoYEnvido);
        Carta oro2 = new Oro(2,valoresTrucoYEnvido);

        jugador1.agregarCarta(oro3);
        jugador2.agregarCarta(oro2);

        jugador1.cantarEnvido(jugada);
        jugador1.aceptarEnvido(jugada);
    }

    @Test(expected = NoPuedeJugarError.class)
    public void testJugadorDelMismoEquipoNoPuedeAceptarElTruco(){
        Jugador jugador1= new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1,equipo2);

        Jugada jugada = partida.crearJugada();
        Carta espada11 = new Espada(11,valoresTrucoYEnvido);
        Carta basto10 = new Basto(10,valoresTrucoYEnvido);

        jugador1.agregarCarta(espada11);
        jugador2.agregarCarta(basto10);

        Carta copa10 = new Copa(10,valoresTrucoYEnvido);
        Carta oro1 = new Oro(1,valoresTrucoYEnvido);

        jugador1.agregarCarta(copa10);
        jugador2.agregarCarta(oro1);

        Carta oro3 = new Oro(3,valoresTrucoYEnvido);
        Carta oro2 = new Oro(2,valoresTrucoYEnvido);

        jugador1.agregarCarta(oro3);
        jugador2.agregarCarta(oro2);

        jugador1.cantarTruco(jugada);
        jugador1.aceptarTruco(jugada);

    }
    @Test (expected = NoTieneElQuieroError.class)
    public void testJugadorCantaTrucoYdespuesEnvido(){
        Jugador jugador1= new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1,equipo2);

        Jugada jugada = partida.crearJugada();
        Carta espada11 = new Espada(11,valoresTrucoYEnvido);
        Carta basto10 = new Basto(10,valoresTrucoYEnvido);

        jugador1.agregarCarta(espada11);
        jugador2.agregarCarta(basto10);

        Carta copa10 = new Copa(10,valoresTrucoYEnvido);
        Carta oro1 = new Oro(1,valoresTrucoYEnvido);

        jugador1.agregarCarta(copa10);
        jugador2.agregarCarta(oro1);

        Carta oro3 = new Oro(3,valoresTrucoYEnvido);
        Carta oro2 = new Oro(2,valoresTrucoYEnvido);

        jugador1.agregarCarta(oro3);
        jugador2.agregarCarta(oro2);

        jugador1.cantarEnvido(jugada);
        jugador2.cantarTruco(jugada);

    }

    @Test
    public void testEquipo1CantaTrucoEquipo2Acepta(){
        Jugador jugador1= new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1,equipo2);

        Jugada jugada = partida.crearJugada();
        Carta copa10 = new Copa(10,valoresTrucoYEnvido);
        Carta oro1 = new Oro(1,valoresTrucoYEnvido);

        jugador1.agregarCarta(copa10);
        jugador2.agregarCarta(oro1);

        jugador1.juegaCarta(copa10);
        jugador2.juegaCarta(oro1);

        jugada.jugarMano();

        jugador1.cantarTruco(jugada);
        jugador2.aceptarTruco(jugada);

        Carta oro3 = new Oro(3,valoresTrucoYEnvido);
        Carta oro2 = new Oro(2,valoresTrucoYEnvido);


        jugador1.agregarCarta(oro2);
        jugador2.agregarCarta(oro3);

        jugador1.juegaCarta(oro2);
        jugador2.juegaCarta(oro3);

        jugada.jugarMano();

        Assert.assertEquals(jugada.obtenerEquipoGanadorDeJugada(), equipo2);
        Assert.assertEquals(jugada.obtenerEquipoGanadorDeJugada().obtenerPuntos(), 2);

    }

    @Test(expected = SoloJugadorPiePuedeCantarError.class)
    public void testJugadaDe4JugadoresJugadorQueNoEsPieNoPuedeCantarElEnvido(){
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
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();

        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        Partida partida = new Partida(equipo1,equipo2);

        Jugada jugada = partida.crearJugada();
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

        jugador1.cantarEnvido(jugada);


    }

    @Test
    public void testEquipo1CantaEnvidoEquipo2AceptaGanaEquipo1LuegoEquipo2GanaRetruco(){
        Jugador jugador1= new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1,equipo2);

        Jugada jugada = partida.crearJugada();

        Carta copa10 = new Copa(10,valoresTrucoYEnvido);
        Carta oro1 = new Oro(1,valoresTrucoYEnvido);
        Carta oro3 = new Oro(3,valoresTrucoYEnvido);
        Carta oro2 = new Oro(2,valoresTrucoYEnvido);
        Carta espada10 = new Espada(10,valoresTrucoYEnvido);
        Carta espada1 = new Espada(1,valoresTrucoYEnvido);

        jugador1.agregarCarta(oro1);
        jugador1.agregarCarta(oro2);
        jugador1.agregarCarta(espada10);

        jugador2.agregarCarta(copa10);
        jugador2.agregarCarta(oro3);
        jugador2.agregarCarta(espada1);

        jugador1.cantarEnvido(jugada);
        jugador2.aceptarEnvido(jugada);

        jugador1.juegaCarta(oro1);
        jugador2.juegaCarta(copa10);

        jugada.jugarMano();

        jugador1.cantarTruco(jugada);
        jugador2.cantarReTruco(jugada);
        jugador1.aceptarTruco(jugada);



        jugador1.juegaCarta(oro2);
        jugador2.juegaCarta(oro3);

        jugada.jugarMano();

        jugador1.juegaCarta(espada10);
        jugador2.juegaCarta(espada1);

        jugada.jugarMano();
        
        Assert.assertEquals(jugada.obtenerEquipoGanadorDeJugada(),equipo2);
        Assert.assertEquals(jugada.obtenerEquipoGanadorDeJugada().obtenerPuntos(),3);
        Assert.assertEquals(jugada.obtenerEquipo1().obtenerPuntos(),2);

    }

    @Test
    public void testEquipo1CantaRealEnvidoEquipo2AceptaGanaEquipo1LuegoEquipo2GanaRetruco(){
        Jugador jugador1= new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1,equipo2);

        Jugada jugada = partida.crearJugada();

        Carta copa10 = new Copa(10,valoresTrucoYEnvido);
        Carta oro1 = new Oro(1,valoresTrucoYEnvido);
        Carta oro3 = new Oro(3,valoresTrucoYEnvido);
        Carta oro2 = new Oro(2,valoresTrucoYEnvido);
        Carta espada10 = new Espada(10,valoresTrucoYEnvido);
        Carta espada1 = new Espada(1,valoresTrucoYEnvido);

        jugador1.agregarCarta(oro1);
        jugador1.agregarCarta(oro2);
        jugador1.agregarCarta(espada10);

        jugador2.agregarCarta(copa10);
        jugador2.agregarCarta(oro3);
        jugador2.agregarCarta(espada1);

        jugador1.cantarRealEnvido(jugada);
        jugador2.aceptarEnvido(jugada);

        jugador1.juegaCarta(oro1);
        jugador2.juegaCarta(copa10);

        jugada.jugarMano();

        jugador1.cantarTruco(jugada);
        jugador2.cantarReTruco(jugada);
        jugador1.aceptarTruco(jugada);

        jugador1.juegaCarta(oro2);
        jugador2.juegaCarta(oro3);

        jugada.jugarMano();

        jugador1.juegaCarta(espada10);
        jugador2.juegaCarta(espada1);

        jugada.jugarMano();


        Assert.assertEquals(jugada.obtenerEquipoGanadorDeJugada(),equipo2);
        Assert.assertEquals(jugada.obtenerEquipoGanadorDeJugada().obtenerPuntos(),3);
        Assert.assertEquals(jugada.obtenerEquipo1().obtenerPuntos(),3);

    }

    @Test(expected = NoSePuedeJugarCartaError.class)
    public void testJugadorQuiereTirarCartaPeroNoPuedePorqueDebeAceptarElEnvido() {
        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1,equipo2);

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

        jugador1.cantarRealEnvido(jugada);
        jugador2.juegaCarta(copa10);
    }
    @Test
    public void testEquipo1SeVaAlMazoDespuesDelEnvido(){
        Jugador jugador1= new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1,equipo2);

        Jugada jugada = partida.crearJugada();
        Carta copa10 = new Copa(10,valoresTrucoYEnvido);
        Carta oro1 = new Oro(1,valoresTrucoYEnvido);
        Carta oro3 = new Oro(3,valoresTrucoYEnvido);
        Carta oro2 = new Oro(2,valoresTrucoYEnvido);
        Carta espada10 = new Espada(10,valoresTrucoYEnvido);
        Carta espada1 = new Espada(1,valoresTrucoYEnvido);

        jugador1.agregarCarta(oro1);
        jugador1.agregarCarta(oro2);
        jugador1.agregarCarta(espada10);

        jugador2.agregarCarta(copa10);
        jugador2.agregarCarta(oro3);
        jugador2.agregarCarta(espada1);

        jugador1.cantarRealEnvido(jugada);
        jugador2.aceptarEnvido(jugada);

        jugador1.irseAlMazo(jugada);

        Assert.assertEquals(1,equipo2.obtenerPuntos());
        Assert.assertEquals(3,equipo1.obtenerPuntos());
    }
    @Test
    public void testEquipo1SeVaAlMazoAntesDelEnvido(){
        Jugador jugador1= new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1,equipo2);

        Jugada jugada = partida.crearJugada();
        Carta copa10 = new Copa(10,valoresTrucoYEnvido);
        Carta oro1 = new Oro(1,valoresTrucoYEnvido);
        Carta oro3 = new Oro(3,valoresTrucoYEnvido);
        Carta oro2 = new Oro(2,valoresTrucoYEnvido);
        Carta espada10 = new Espada(10,valoresTrucoYEnvido);
        Carta espada1 = new Espada(1,valoresTrucoYEnvido);

        jugador1.agregarCarta(oro1);
        jugador1.agregarCarta(oro2);
        jugador1.agregarCarta(espada10);

        jugador2.agregarCarta(copa10);
        jugador2.agregarCarta(oro3);
        jugador2.agregarCarta(espada1);

        jugador1.irseAlMazo(jugada);

        Assert.assertEquals(2,equipo2.obtenerPuntos());

    }

    @Test
    public void testEquipo1SeVaAlMazoDespuesDeJugarUnaCarta() {
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
        jugador2.juegaCarta(copa10);

        jugador1.irseAlMazo(jugada);

        Assert.assertEquals(2, equipo2.obtenerPuntos());
        Assert.assertEquals(0, equipo1.obtenerPuntos());
    }

    @Test
    public void testJugadaSeCreaConEstadoDeEnvidoDeSinEnvido(){
        Jugador jugador1= new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Partida partida = new Partida(equipo1,equipo2);

        Jugada jugada = partida.crearJugada();

        Assert.assertEquals(jugada.obtenerEstadoEnvido().getClass(), EstadoSinEnvido.class);
    }
}
