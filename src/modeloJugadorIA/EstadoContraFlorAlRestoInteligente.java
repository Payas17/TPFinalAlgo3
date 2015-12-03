package modeloJugadorIA;

import modelo.EstadoEnvido.EstadoFlor;
import modelo.EstadoEnvido.EstadoSinEnvido;
import modelo.Jugadas.Jugada;
import modelo.Jugador;

/**
 * Created by Lucio on 25/11/2015.
 */
public class EstadoContraFlorAlRestoInteligente implements EstadoDeEnvidoInteligente {
    @Override
    public void cantar(Jugador jugador, Jugada jugada) {
        if (jugada.obtenerEstadoEnvido().getClass() == EstadoFlor.class) {
            jugador.cantarContraFlorAlResto(jugada);
        } else if (jugada.obtenerEstadoEnvido().getClass() == EstadoSinEnvido.class) {
            jugador.cantarFlor(jugada);
        }
    }
}
