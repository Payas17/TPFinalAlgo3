package modelo;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Augusto on 08/11/2015.
 */
public class Mano {
   private Equipo equipo1;
   private Equipo equipo2;
   private List<Jugador> jugadores;
   private Jugador jugadorGanador;


    public Mano(Equipo equipo1, Equipo equipo2){

        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.jugadores = new ArrayList<>();

        for(int i = 0; i < equipo1.obtenerIntegrantes().size();i++ ){
            jugadores.add(equipo1.obtenerIntegrantes().get(i));
            jugadores.add(equipo2.obtenerIntegrantes().get(i));
        }
        jugadorGanador = null;
    }

    public boolean hayParda(Jugador jugador1, Jugador jugador2){
        return (jugador1.obtenerCartaEnJuego().obtenerValorTruco() == jugador2.obtenerCartaEnJuego().obtenerValorTruco());
    }

    public void buscarGanador() {
        Jugador jugadorAux = jugadores.get(0);
        for (Jugador jugadorActual : jugadores) {
            if (!hayParda(jugadorAux, jugadorActual)) {
                jugadorGanador = asignarJugadorGanador(jugadorAux, jugadorActual);
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

    public Equipo obtenerEquipoGanador(){
        return (equipo1.contieneJugador(jugadorGanador)) ? equipo1 : equipo2;
    }




}
