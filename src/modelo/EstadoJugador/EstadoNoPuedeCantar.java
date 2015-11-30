package modelo.EstadoJugador;

import modelo.Equipo;
import modelo.Errores.NoPuedeJugarError;
import modelo.Errores.NoSePuedeCantarEsoError;
import modelo.Jugadas.Jugada;
import modelo.Jugador;

/**
 * Created by Payas on 19/11/2015.
 */
public class EstadoNoPuedeCantar implements EstadoDeJugador{
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
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void aceptar(Equipo equipoCanta, Equipo equipoQuiere) {
        throw new NoPuedeJugarError();
    }

   @Override
   public void jugarCarta(Jugador jugador) {
        jugador.cambiarEstadoNormal(new EstadoYaJugoCarta());
    }
}
