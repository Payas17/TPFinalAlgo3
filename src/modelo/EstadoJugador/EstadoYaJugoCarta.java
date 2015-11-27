package modelo.EstadoJugador;

import modelo.Equipo;
import modelo.Errores.NoPuedeJugarError;
import modelo.Errores.NoSePuedeJugarCartaError;
import modelo.Jugada.Jugada;
import modelo.Jugador;

/**
 * Created by Augusto on 22/11/2015.
 */
public class EstadoYaJugoCarta implements EstadoDeJugador {
    @Override
    public void cantarEnvido(Equipo equipoCanta, Equipo equipoQuiere) {
        throw new NoPuedeJugarError();
    }

    @Override
    public void cantarFlor(Equipo equipoCanta, Equipo equipoQuiere) {
        throw new NoPuedeJugarError();
    }

    @Override
    public void cantarTruco(Equipo equipoCanta, Equipo equipoQuiere) {
        throw new NoPuedeJugarError();
    }

    @Override
    public void aceptar(Jugada jugada) {
        throw new NoPuedeJugarError();
    }

    @Override
    public void jugarCarta(Jugador jugador) {
        throw new NoSePuedeJugarCartaError();
    }
}
