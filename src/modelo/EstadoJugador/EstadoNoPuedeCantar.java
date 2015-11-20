package modelo.EstadoJugador;

import modelo.Equipo;
import modelo.Errores.NoTienElQuieroError;

/**
 * Created by Payas on 19/11/2015.
 */
public class EstadoNoPuedeCantar implements EstadoDeJugador{
    @Override
    public void cantar(Equipo equipoCanta, Equipo equipoQuiere) {
        throw new NoTienElQuieroError();
    }

    @Override
    public void aceptar() {
        throw new NoTienElQuieroError();
    }
}
