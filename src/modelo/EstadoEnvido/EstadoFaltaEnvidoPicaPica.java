package modelo.EstadoEnvido;

import modelo.Errores.NoSePuedeCantarEsoError;
import modelo.EstadoJugada.EstadoJugadaTerminada;
import modelo.Jugada.Jugada;
import modelo.Jugada.JugadaPicaPica;
import modelo.Partida.EstadoPartidaTerminada;
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
        if (partida.obtenerEquipo1().obtenerPuntos() >= MAX_PUNTAJE_PARTIDA || partida.obtenerEquipo2().obtenerPuntos() >= MAX_PUNTAJE_PARTIDA ){
            partida.cambiarEstado(new EstadoPartidaTerminada());
        }
        jugadaPicaPica.cambiarEstadoEnvido(new EstadoNoSePuedeCantarEnvido());
    }
}
