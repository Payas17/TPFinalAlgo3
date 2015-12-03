package modeloJugadorIA;

import modelo.Errores.NoSePuedeCantarEsoError;
import modelo.EstadoEnvido.EstadoFaltaEnvido;
import modelo.EstadoJugador.EstadoPuedeCantarFlor;
import modelo.Jugadas.Jugada;
import modelo.Jugador;

/**
 * Created by Lucio on 02/12/2015.
 */
public class EstadoFaltaEnvidoInteligente implements EstadoDeEnvidoInteligente {
    @Override
    public void cantar(Jugador jugador, Jugada jugada) {
        if ( jugada.obtenerEstadoEnvido().getClass() != EstadoFaltaEnvido.class ){
            if (jugador.obtenerEstado().getClass() == EstadoPuedeCantarFlor.class){
                jugador.noAceptarFlor(jugada);
            }
            else{
                jugador.cantarFaltaEnvido(jugada);
            }
        }
    }
}
