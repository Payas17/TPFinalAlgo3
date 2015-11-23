package modelo.EstadoJugador;

import modelo.Equipo;
import modelo.Jugada.Jugada;
import modelo.Jugador;

/**
 * Created by Payas on 19/11/2015.
 */
public interface EstadoDeJugador {
    void cantarEnvido(Equipo equipoCanta, Equipo equipoQuiere);

    void cantarTruco(Equipo equipoCanta, Equipo equipoQuiere);

    void aceptar(Jugada jugada);

    void jugarCarta(Jugador jugador);
}
