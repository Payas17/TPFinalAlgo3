package fiuba.algo3.tests;

import modelo.Jugador;
import modelo.Errores.NoQuedanJugadoresPorJugarError;
import modelo.Turnos;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lucio on 13/11/2015.
 */
public class PruebasTurnosTest {
    @Test
    public void testPrimeraManoJueganEnElOrdenQueEstanSentados(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Jugador jugador3 = new Jugador();
        Jugador jugador4 = new Jugador();
        List<Jugador> ordenJugadores = new LinkedList<>();
        ordenJugadores.add(jugador1);
        ordenJugadores.add(jugador2);
        ordenJugadores.add(jugador3);
        ordenJugadores.add(jugador4);
        Turnos turnos = new Turnos(ordenJugadores);

        Assert.assertEquals(turnos.obtenerJugadorQueJuega(), jugador1);
        Assert.assertEquals(turnos.obtenerJugadorQueJuega(), jugador2);
        Assert.assertEquals(turnos.obtenerJugadorQueJuega(), jugador3);
        Assert.assertEquals(turnos.obtenerJugadorQueJuega(), jugador4);
    }

    @Test
    public void testSegundaRondaJueganEnOrden2341PorqueGanoJugador2(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Jugador jugador3 = new Jugador();
        Jugador jugador4 = new Jugador();
        List<Jugador> ordenJugadores = new LinkedList<>();
        ordenJugadores.add(jugador1);
        ordenJugadores.add(jugador2);
        ordenJugadores.add(jugador3);
        ordenJugadores.add(jugador4);
        Turnos turnos = new Turnos(ordenJugadores);

        Assert.assertEquals(turnos.obtenerJugadorQueJuega(), jugador1);
        Assert.assertEquals(turnos.obtenerJugadorQueJuega(), jugador2);
        Assert.assertEquals(turnos.obtenerJugadorQueJuega(), jugador3);
        Assert.assertEquals(turnos.obtenerJugadorQueJuega(), jugador4);

        turnos.actualizarTurnos(jugador2);
        Assert.assertEquals(turnos.obtenerJugadorQueJuega(), jugador2);
        Assert.assertEquals(turnos.obtenerJugadorQueJuega(), jugador3);
        Assert.assertEquals(turnos.obtenerJugadorQueJuega(), jugador4);
        Assert.assertEquals(turnos.obtenerJugadorQueJuega(), jugador1);

    }

    @Test
    public void testSegundaRondaJueganEnOrden4123PorqueGanoJugador4(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Jugador jugador3 = new Jugador();
        Jugador jugador4 = new Jugador();
        List<Jugador> ordenJugadores = new LinkedList<>();
        ordenJugadores.add(jugador1);
        ordenJugadores.add(jugador2);
        ordenJugadores.add(jugador3);
        ordenJugadores.add(jugador4);
        Turnos turnos = new Turnos(ordenJugadores);

        Assert.assertEquals(turnos.obtenerJugadorQueJuega(), jugador1);
        Assert.assertEquals(turnos.obtenerJugadorQueJuega(), jugador2);
        Assert.assertEquals(turnos.obtenerJugadorQueJuega(), jugador3);
        Assert.assertEquals(turnos.obtenerJugadorQueJuega(), jugador4);

        turnos.actualizarTurnos(jugador2);
        Assert.assertEquals(turnos.obtenerJugadorQueJuega(), jugador2);
        Assert.assertEquals(turnos.obtenerJugadorQueJuega(), jugador3);
        Assert.assertEquals(turnos.obtenerJugadorQueJuega(), jugador4);
        Assert.assertEquals(turnos.obtenerJugadorQueJuega(), jugador1);

        turnos.actualizarTurnos(jugador4);
        Assert.assertEquals(turnos.obtenerJugadorQueJuega(), jugador4);
        Assert.assertEquals(turnos.obtenerJugadorQueJuega(), jugador1);
        Assert.assertEquals(turnos.obtenerJugadorQueJuega(), jugador2);
        Assert.assertEquals(turnos.obtenerJugadorQueJuega(), jugador3);
    }

    @Test(expected = NoQuedanJugadoresPorJugarError.class)
    public void testCuandoNoQuedanJugadoresPorJugarLaManoDevuelveErrorSiIntentoPedirJugadorQueJuega(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Jugador jugador3 = new Jugador();
        Jugador jugador4 = new Jugador();
        List<Jugador> ordenJugadores = new LinkedList<>();
        ordenJugadores.add(jugador1);
        ordenJugadores.add(jugador2);
        ordenJugadores.add(jugador3);
        ordenJugadores.add(jugador4);
        Turnos turnos = new Turnos(ordenJugadores);

        Assert.assertEquals(turnos.obtenerJugadorQueJuega(), jugador1);
        Assert.assertEquals(turnos.obtenerJugadorQueJuega(), jugador2);
        Assert.assertEquals(turnos.obtenerJugadorQueJuega(), jugador3);
        Assert.assertEquals(turnos.obtenerJugadorQueJuega(), jugador4);
        turnos.obtenerJugadorQueJuega();
    }

}
