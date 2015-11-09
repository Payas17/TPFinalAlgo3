package modelo;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Augusto on 08/11/2015.
 */
public class Mano {
    List<Jugador> jugadores;
    Jugador jugadorGanador;
    Jugador turnoActualJugador;


    public Mano (List<Jugador> jugadores ){
        this.jugadores = jugadores;
        jugadorGanador = null;
    }
    public Mano (Jugador jugador1, Jugador jugador2, Jugador jugador3, Jugador jugador4){
        jugadores = new ArrayList<>();
        jugadores.add (jugador1);
        jugadores.add (jugador2);
        jugadores.add (jugador3);
        jugadores.add (jugador4);
    }
    public boolean hayGanadorEnMano(Jugador jugador1, Jugador jugador2){
        return (jugador1.obtenerCartaEnJuego().obtenerValorTruco() != jugador2.obtenerCartaEnJuego().obtenerValorTruco());
    }

    public void buscarGanador() {
        Jugador jugadorAux = jugadores.get(0);
        for (Jugador jugadorActual : jugadores) {
            if (hayGanadorEnMano(jugadorAux, jugadorActual)) {
                jugadorGanador = asignarGanador(jugadorAux, jugadorActual);
                jugadorGanador.sumarManosGanadas();
            }
        }
    }

    public Jugador asignarGanador(Jugador jugador1, Jugador jugador2){
        return (jugador1.obtenerCartaEnJuego().obtenerValorTruco() >= jugador2.obtenerCartaEnJuego().obtenerValorTruco()) ? jugador1 : jugador2;
    }

    public Jugador obtenerJugadorGanador() {
        return jugadorGanador;
    }
}
