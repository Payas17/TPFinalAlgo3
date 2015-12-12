package modeloJugadorIA;

import modelo.EstadoEnvido.EstadoEnvido;
import modelo.EstadoEnvido.EstadoRealEnvido;
import modelo.EstadoEnvido.EstadoSinEnvido;
import modelo.EstadoJugador.EstadoPuedeCantarFlor;
import modelo.Jugadas.Jugada;
import modelo.Jugador;

/**
 * Created by Augusto on 25/11/2015.
 */
public class EstadoRealEnvidoInteligente implements EstadoDeEnvidoInteligente {
    @Override
    public void cantar(Jugador jugador, Jugada jugada) {
        if (jugada.obtenerEstadoEnvido().getClass() == EstadoSinEnvido.class || jugada.obtenerEstadoEnvido().getClass() == EstadoEnvido.class){
            jugador.cantarRealEnvido(jugada);
        }
        else if( jugada.obtenerEstadoEnvido().getClass() == EstadoRealEnvido.class){
            jugador.aceptarEnvido(jugada);
        }
        else{
            if (jugador.obtenerEstado().getClass() == EstadoPuedeCantarFlor.class){
                jugador.noAceptarFlor(jugada);
            }
            else{
                jugador.noAceptarEnvido(jugada);
            }
        }
    }
}
