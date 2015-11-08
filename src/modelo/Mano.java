package modelo;

import modelo.Jugador;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Augusto on 08/11/2015.
 */
public class Mano {
    List<Jugador> jugadores;
    Jugador jugadorGanador;

    public Mano (Jugador jugador1, Jugador jugador2){
        jugadores = new ArrayList<>();
        jugadores.add (jugador1);
        jugadores.add (jugador2);
    }
    public Mano (Jugador jugador1, Jugador jugador2, Jugador jugador3, Jugador jugador4){
        jugadores = new ArrayList<>();
        jugadores.add (jugador1);
        jugadores.add (jugador2);
        jugadores.add (jugador3);
        jugadores.add (jugador4);
    }

    public void buscarGanador(){
        jugadorGanador = jugadores.get(0);
        for (Jugador jugadorActual: jugadores){
            if (jugadorActual.obtenerCartaEnJuego().obtenerValorTruco() > jugadorGanador.obtenerCartaEnJuego().obtenerValorTruco()){
                jugadorGanador = jugadorActual;
            }
        }

    }

    public Jugador obtenerJugadorGanador() {
        return jugadorGanador;
    }
}
