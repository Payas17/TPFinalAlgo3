package modelo.EstadoJugador;

import modelo.Equipo;
import modelo.Jugadas.Jugada;
import modelo.Jugador;

/**
 * Created by Payas on 19/11/2015.
 */
public interface EstadoDeJugador {
    void cantarEnvido(Equipo equipoCanta, Equipo equipoQuiere);

    void cantarFlor(Equipo equipoCanta, Equipo equipoQuiere);

    void cantarTruco(Equipo equipoCanta, Equipo equipoQuiere);

    void aceptar(Equipo equipoCanta, Equipo equipoQuiere);

    void jugarCarta(Jugador jugador);
}
