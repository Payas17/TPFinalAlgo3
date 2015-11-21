package fiuba.algo3.tests;

import modelo.*;
import modelo.Carta.*;
import modelo.Errores.NoTieneFlorError;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Payas on 08/11/2015.
 */
public class PruebasFlorTest {

    @Test(expected = NoTieneFlorError.class)
    public void testNoTengoFlorCantoFlorYTiraError() {
        Jugador jugador1= new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        Jugada jugada = new Jugada(equipo1,equipo2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();

        Carta espada1 = new Espada(1, valoresTrucoYEnvido);
        Carta espada10 = new Espada(10, valoresTrucoYEnvido);
        Carta basto5 = new Basto(5, valoresTrucoYEnvido);

        jugador1.agregarCarta(espada10);
        jugador1.agregarCarta(basto5);
        jugador1.agregarCarta(espada1);

        jugador1.cantarFlor(jugada);
    }

    @Test
    public void testJugador1CantaFlorYJugador2NoTieneFlor(){

        Jugador jugador1= new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        Jugada jugada = new Jugada(equipo1,equipo2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();

        Carta oro7 = new Oro(7, valoresTrucoYEnvido);
        Carta oro1 = new Oro(1, valoresTrucoYEnvido);
        Carta oro10 = new Oro(10, valoresTrucoYEnvido);

        Carta oro5 = new Oro(5, valoresTrucoYEnvido);
        Carta oro2 = new Oro(2, valoresTrucoYEnvido);
        Carta espada2 = new Espada(2, valoresTrucoYEnvido);

        jugador1.agregarCarta(oro5);
        jugador1.agregarCarta(oro2);
        jugador1.agregarCarta(oro10);

        jugador2.agregarCarta(oro7);
        jugador2.agregarCarta(oro1);
        jugador2.agregarCarta(espada2);

        jugador1.cantarFlor(jugada);
        jugador2.noAceptarFlor(jugada);

        Assert.assertEquals(equipo1.obtenerPuntos(),3);
    }

    @Test
    public void testJugador1CantaFlorYJugador2AceptaFlor() {

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        Jugada jugada = new Jugada(equipo1, equipo2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();

        Carta oro7 = new Oro(7, valoresTrucoYEnvido);
        Carta oro1 = new Oro(1, valoresTrucoYEnvido);
        Carta oro2 = new Oro(2, valoresTrucoYEnvido);

        Carta espada5 = new Espada(5, valoresTrucoYEnvido);
        Carta espada2 = new Espada(2, valoresTrucoYEnvido);
        Carta espada1 = new Espada(1, valoresTrucoYEnvido);

        jugador1.agregarCarta(oro7);
        jugador1.agregarCarta(oro1);
        jugador1.agregarCarta(oro2);

        jugador2.agregarCarta(espada1);
        jugador2.agregarCarta(espada5);
        jugador2.agregarCarta(espada2);

        jugador1.cantarFlor(jugada);
        jugador2.aceptarFlor(jugada);

        Assert.assertEquals(equipo1.obtenerPuntos(), 6);
    }

    @Test
    public void testJugador1CantaFlorYJugador2AceptaFlorYAmbosTienenLaMismaCantidadDeFlor() {

        Jugador jugador1 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        Jugada jugada = new Jugada(equipo1, equipo2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();

        Carta oro7 = new Oro(7, valoresTrucoYEnvido);
        Carta oro1 = new Oro(1, valoresTrucoYEnvido);
        Carta oro10 = new Oro(10, valoresTrucoYEnvido);

        Carta espada5 = new Espada(5, valoresTrucoYEnvido);
        Carta espada2 = new Espada(2, valoresTrucoYEnvido);
        Carta espada1 = new Espada(1, valoresTrucoYEnvido);

        jugador1.agregarCarta(oro7);
        jugador1.agregarCarta(oro1);
        jugador1.agregarCarta(oro10);

        jugador2.agregarCarta(espada1);
        jugador2.agregarCarta(espada5);
        jugador2.agregarCarta(espada2);

        jugador1.cantarFlor(jugada);
        jugador2.aceptarFlor(jugada);

        Assert.assertEquals(equipo1.obtenerPuntos(), 6);
    }

    @Test
    public void testPartidaDe4JugadoresYAmbosEquiposTienenFlor(){
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
        Jugada jugada = new Jugada(equipo1,equipo2);
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
        jugador3.aceptarFlor(jugada);

        Assert.assertEquals(equipo1.obtenerPuntos(),4);
        Assert.assertEquals(equipo2.obtenerPuntos(),2);
    }



}