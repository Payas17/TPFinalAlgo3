package modelo;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Augusto on 08/11/2015.
 */
public class Mano {

   private List<Jugador> jugadores;
   private Jugador jugadorGanador;


    public Mano(List<Jugador> jugadores){

        this.jugadores = jugadores;
        jugadorGanador = null;
    }

    public boolean hayParda(Equipo equipo1,Equipo equipo2){
        return (equipo1.getMejorJugadorEquipo().obtenerCartaEnJuego().obtenerValorTruco() == equipo2.getMejorJugadorEquipo().obtenerCartaEnJuego().obtenerValorTruco());
    }

    public void buscarGanador(Equipo equipo1,Equipo equipo2) {
        if (!hayParda(equipo1, equipo2)){
            jugadorGanador = jugadores.get(0);
            for (Jugador jugadorActual : jugadores) {

                jugadorGanador = asignarJugadorGanador(jugadorGanador, jugadorActual);
                jugadorGanador.sumarManosGanadas();
            }
        }
    }

    public Jugador asignarJugadorGanador(Jugador jugador1, Jugador jugador2){
        return (jugador1.obtenerCartaEnJuego().obtenerValorTruco() >= jugador2.obtenerCartaEnJuego().obtenerValorTruco()) ? jugador1 : jugador2;
    }

    public Jugador obtenerJugadorGanador() {
        return jugadorGanador;
    }

    public Equipo obtenerEquipoGanador(Equipo equipo1, Equipo equipo2){
        return (equipo1.contieneJugador(jugadorGanador)) ? equipo1 : equipo2;
    }




}
