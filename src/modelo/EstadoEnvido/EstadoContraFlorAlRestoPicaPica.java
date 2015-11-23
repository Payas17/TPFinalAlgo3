package modelo.EstadoEnvido;

import modelo.Equipo;
import modelo.Errores.NoSePuedeCantarEsoError;
import modelo.EstadoJugada.EstadoJugadaTerminada;
import modelo.Jugada;
import modelo.JugadaPicaPica;
import modelo.Partida.EstadoPartidaTerminada;
import modelo.Partida.Partida;

/**
 * Created by Augusto on 22/11/2015.
 */
public class EstadoContraFlorAlRestoPicaPica extends EstadoContraFlorAlResto {

    @Override
    public void cantarContraFlorAlRestoPicaPica(JugadaPicaPica jugadaPicaPica) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void aceptarFlor(Equipo equipo1, Equipo equipo2, Jugada jugada, Partida partida) {
        jugada.obtenerEquipoGanadorFlor(equipo1,equipo2).sumarPuntos(6);
        jugada.cambiarEstadoEnvido(new EstadoNoSePuedeCantarEnvido());
    }
}
