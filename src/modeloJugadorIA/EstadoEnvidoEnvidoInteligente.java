package modeloJugadorIA;

import modelo.EstadoEnvido.EstadoEnvido;
import modelo.EstadoEnvido.EstadoEnvidoEnvido;
import modelo.EstadoEnvido.EstadoFaltaEnvido;
import modelo.EstadoEnvido.EstadoSinEnvido;
import modelo.EstadoJugador.EstadoPuedeCantarFlor;
import modelo.Jugadas.Jugada;
import modelo.Jugador;

/**
 * Created by Augusto on 25/11/2015.
 */
public class EstadoEnvidoEnvidoInteligente implements EstadoDeEnvidoInteligente {
    @Override
    public void cantar(Jugador jugador, Jugada jugada) {
        if (jugada.obtenerEstadoEnvido().getClass() == EstadoSinEnvido.class || jugada.obtenerEstadoEnvido().getClass() == EstadoEnvido.class) {
            jugador.cantarEnvido(jugada);
        } else if (jugada.obtenerEstadoEnvido().getClass() == EstadoFaltaEnvido.class || jugada.obtenerEstadoEnvido().getClass() == EstadoEnvidoEnvido.class) {
            jugador.aceptarEnvido(jugada);
        } else {
            if (jugador.obtenerEstado().getClass() == EstadoPuedeCantarFlor.class) {
                jugador.noAceptarFlor(jugada);
            } else {
                jugador.noAceptarEnvido(jugada);
            }
        }
    }
}
