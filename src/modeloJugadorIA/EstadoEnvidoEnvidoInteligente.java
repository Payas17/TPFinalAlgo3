package modeloJugadorIA;

import modelo.EstadoEnvido.EstadoEnvidoEnvido;
import modelo.EstadoEnvido.EstadoFaltaEnvido;
import modelo.EstadoEnvido.EstadoSinEnvido;
import modelo.Jugadas.Jugada;
import modelo.Jugador;

/**
 * Created by Augusto on 25/11/2015.
 */
public class EstadoEnvidoEnvidoInteligente implements EstadoDeEnvidoInteligente {
    @Override
    public void cantar(Jugador jugador, Jugada jugada) {
        if (jugada.obtenerEstadoEnvido().getClass() == EstadoSinEnvido.class || jugada.obtenerEstadoEnvido().getClass() == EstadoEnvidoEnvido.class ){
            jugador.cantarRealEnvido(jugada);
        }
        else if(jugada.obtenerEstadoEnvido().getClass() == EstadoFaltaEnvido.class){
            jugador.aceptarEnvido(jugada);
        }
        else{
            jugador.noAceptarFlor(jugada);
        }
    }
}
