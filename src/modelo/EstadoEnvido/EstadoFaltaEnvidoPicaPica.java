package modelo.EstadoEnvido;

import modelo.Equipo;
import modelo.Errores.NoSePuedeCantarEsoError;
import modelo.EstadoJugada.EstadoJugadaTerminada;
import modelo.Jugada;
import modelo.JugadaPicaPica;
import modelo.Partida.Partida;

/**
 * Created by Augusto on 22/11/2015.
 */
public class EstadoFaltaEnvidoPicaPica extends EstadoFaltaEnvido {

    @Override
    public void cantarFaltaEnvidoPicaPica(JugadaPicaPica jugadaPicaPica) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void cantarContraFlorAlRestoPicaPica(JugadaPicaPica jugadaPicaPica) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void aceptarEnvido(Jugada jugadaPicaPica, Partida partida) {
        jugadaPicaPica.obtenerEquipoGanadorEnvido().sumarPuntos(6);
        jugadaPicaPica.cambiarEstadoJugada(new EstadoJugadaTerminada());
    }
}
