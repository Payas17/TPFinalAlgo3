package modelo;


/**
 * Created by Augusto on 08/11/2015.
 */
public class Mano {
    Turnos turnos;
    Jugador jugadorGanador;


    public Mano (Turnos turnos){
        this.turnos = turnos;
        jugadorGanador = null;
    }

    public boolean hayParda(Jugador jugador1, Jugador jugador2){
        return (jugador1.obtenerCartaEnJuego().obtenerValorTruco() == jugador2.obtenerCartaEnJuego().obtenerValorTruco());
    }

    public void jugarMano() {
        Jugador jugadorAnterior = turnos.obtenerJugadorQueJuega();
        jugadorAnterior.jugar();
        jugadorGanador = jugadorAnterior;
        while (turnos.quedaJugadorPorJugar()) {
            Jugador jugadorQueJuega = turnos.obtenerJugadorQueJuega();
            jugadorQueJuega.jugar();
            if (!hayParda(jugadorGanador, jugadorQueJuega)) {
                jugadorGanador = asignarGanador(jugadorGanador, jugadorQueJuega);
            }
            else{
                jugadorGanador = null;
            }
        }
    }

    public Jugador asignarGanador(Jugador jugador1, Jugador jugador2){
        return (jugador1.obtenerCartaEnJuego().obtenerValorTruco() > jugador2.obtenerCartaEnJuego().obtenerValorTruco()) ? jugador1 : jugador2;
    }

    public Jugador obtenerJugadorGanador() {
        return jugadorGanador;
    }
}
