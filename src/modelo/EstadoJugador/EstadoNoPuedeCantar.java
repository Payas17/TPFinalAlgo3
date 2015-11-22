package modelo.EstadoJugador;

import modelo.Equipo;
import modelo.Errores.NoPuedeJugarError;
import modelo.Errores.NoSePuedeJugarCarta;
import modelo.Errores.NoTienElQuieroError;
import modelo.Jugada;

/**
 * Created by Payas on 19/11/2015.
 */
public class EstadoNoPuedeCantar implements EstadoDeJugador{
    @Override
    public void cantarEnvido(Equipo equipoCanta, Equipo equipoQuiere) {
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
    public void jugarCarta() {
        throw new NoPuedeJugarError();
    }
}
