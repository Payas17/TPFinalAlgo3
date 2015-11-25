package modelo.EstadoEnvido;

import modelo.Errores.NoSePuedeCantarEsoError;
import modelo.Jugada.Jugada;
import modelo.Jugada.JugadaPicaPica;

/**
 * Created by Augusto on 22/11/2015.
 */
public class EstadoFaltaEnvidoPicaPica extends EstadoFaltaEnvido {

    private final int MAX_FALTA_ENVIDO_PICAPICA = 6;

    @Override
    public void cantarFaltaEnvidoPicaPica(JugadaPicaPica jugadaPicaPica) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void cantarContraFlorAlRestoPicaPica(JugadaPicaPica jugadaPicaPica) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void aceptarEnvido(Jugada jugadaPicaPica) {
        jugadaPicaPica.obtenerEquipoGanadorEnvido().sumarPuntos(MAX_FALTA_ENVIDO_PICAPICA);
    }
}
