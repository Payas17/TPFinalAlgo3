package modeloJugadorIA;

import modelo.EstadoEnvido.EstadoContraFlor;
import modelo.EstadoEnvido.EstadoSinEnvido;
import modelo.EstadoJugador.EstadoPuedeCantarFlor;
import modelo.Jugadas.Jugada;
import modelo.Jugador;

/**
 * Created by Lucio on 25/11/2015.
 */
public class EstadoContraFlorInteligente implements EstadoDeEnvidoInteligente {
    @Override
    public void cantar(Jugador jugador, Jugada jugada) {
        if (jugada.obtenerEstadoEnvido().getClass() == EstadoContraFlor.class){
            jugador.aceptarFlor(jugada);
        }
        else if (jugada.obtenerEstadoEnvido().getClass() == EstadoSinEnvido.class){
            jugador.cantarFlor(jugada);
        }
        else{
            if (jugador.obtenerEstado().getClass() == EstadoPuedeCantarFlor.class){
                jugador.cantarContraFlor(jugada);
            }
            else{
                jugador.noAceptarEnvido(jugada);
            }
        }
    }
}
