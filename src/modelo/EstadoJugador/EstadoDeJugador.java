package modelo.EstadoJugador;

import modelo.Equipo;
import modelo.Jugada;

/**
 * Created by Payas on 19/11/2015.
 */
public interface EstadoDeJugador {
    void cantar(Equipo equipoCanta, Equipo equipoQuiere);

    void aceptar(Jugada jugada);
}
