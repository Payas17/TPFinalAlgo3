package modeloJugadorIA;


import modelo.EstadoEnvido.EstadoSinEnvido;
import modelo.EstadoJugador.EstadoPuedeCantarFlor;
import modelo.Jugadas.Jugada;
import modelo.Jugador;

/**
 * Created by Augusto on 25/11/2015.
 */
public class EstadoSinEnvidoInteligente implements EstadoDeEnvidoInteligente {
    @Override
    public void cantar(Jugador jugador, Jugada jugada) {
        if (jugada.obtenerEstadoEnvido().getClass() != EstadoSinEnvido.class) {
            if (jugador.obtenerEstado().getClass() == EstadoPuedeCantarFlor.class){
                jugador.noAceptarFlor(jugada);
            }
            else{
                jugador.noAceptarEnvido(jugada);
            }
        }
    }
}
