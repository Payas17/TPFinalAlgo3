package fiuba.algo3.tests;

import modelo.Carta.*;
import modelo.Equipo;
import modelo.Errores.NoPuedeJugarError;
import modelo.Errores.NoSePuedeJugarCarta;
import modelo.Jugada;
import modelo.Jugador;
import modelo.Partida.EstadoPartidaTerminada;
import modelo.Partida.Partida;
import modelo.ValoresTrucoYEnvido;
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


}
