package modelo;


import java.util.List;

/**
 * Created by Augusto on 08/11/2015.
 */
public class Mano {

   private List<Jugador> jugadores;

    public Mano(List<Jugador> jugadores){

        this.jugadores = jugadores;

    }

    public boolean hayParda(Equipo equipo1,Equipo equipo2){
        return (equipo1.obtenerMejorJugadorEquipo().obtenerCartaEnJuego().obtenerValorTruco() == equipo2.obtenerMejorJugadorEquipo().obtenerCartaEnJuego().obtenerValorTruco());
    }

    public Jugador obtenerJugadorGanador() {

        Jugador jugadorGanador = jugadores.get(0);
        for (Jugador jugadorActual : jugadores) {

            jugadorGanador = asignarJugadorGanador(jugadorGanador, jugadorActual);
            jugadorGanador.sumarManosGanadas();
        }
        return jugadorGanador;

    }

    public Equipo obtenerEquipoGanador(Equipo equipo1, Equipo equipo2) {
        return (equipo1.contieneJugador(obtenerJugadorGanador())) ? equipo1 : equipo2;

    }

    public Jugador asignarJugadorGanador(Jugador jugador1, Jugador jugador2){
        return (jugador1.obtenerCartaEnJuego().obtenerValorTruco() >= jugador2.obtenerCartaEnJuego().obtenerValorTruco()) ? jugador1 : jugador2;
    }






}
