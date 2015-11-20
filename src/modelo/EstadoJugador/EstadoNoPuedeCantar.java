package modelo.EstadoJugador;

import modelo.Equipo;
import modelo.Errores.NoTienElQuieroError;
import modelo.Jugada;

/**
 * Created by Payas on 19/11/2015.
 */
public class EstadoNoPuedeCantar implements EstadoDeJugador{
    @Override
    public void cantar(Equipo equipoCanta, Equipo equipoQuiere) {
        throw new NoTienElQuieroError();
    }

    @Override
    public void aceptar(Jugada jugada) {
        throw new NoTienElQuieroError();
    }
}
