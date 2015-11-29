package fiuba.algo3.tests;

import modelo.Carta.Carta;
import modelo.Carta.Copa;
import modelo.Carta.Espada;
import modelo.Carta.Oro;
import modelo.Equipo;
import modelo.Errores.NoSePuedeCantarEsoError;
import modelo.Jugadas.Jugada;
import modelo.Jugador;
import modelo.Partida.Partida;
import modelo.ValoresTrucoYEnvido;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucio on 27/11/2015.
 */
public class PruebasTrucoTest {

    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testEquipo1CantaValeCuatroSinQueNadieHayaCantadoNadaEntoncesLanzaError() {
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

        jugador1.cantarValeCuatro(jugada);

    }

    @Test(expected = NoSePuedeCantarEsoError.class)
        public void testTrucoReTrucoTrucoLanzaError() {
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
        jugador2.cantarReTruco(jugada);
        jugador1.cantarTruco(jugada);

    }

    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testTrucoReTrucoReTrucoLanzaError() {
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
        jugador2.cantarReTruco(jugada);
        jugador1.cantarReTruco(jugada);

    }

    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testTrucoReTrucoValeCuatroReTrucoLanzaError() {
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
        jugador2.cantarReTruco(jugada);
        jugador1.cantarValeCuatro(jugada);
        jugador2.cantarReTruco(jugada);

    }

    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testTrucoReTrucoValeCuatroTrucoLanzaError() {
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
        jugador2.cantarReTruco(jugada);
        jugador1.cantarValeCuatro(jugada);
        jugador2.cantarTruco(jugada);

    }

    @Test(expected = NoSePuedeCantarEsoError.class)
    public void testTrucoReTrucoValeCuatroValeCuatroLanzaError() {
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
        jugador2.cantarReTruco(jugada);
        jugador1.cantarValeCuatro(jugada);
        jugador2.cantarValeCuatro(jugada);

    }
}
