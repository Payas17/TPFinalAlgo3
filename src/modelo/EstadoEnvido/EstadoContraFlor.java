package modelo.EstadoEnvido;

import modelo.Equipo;
import modelo.Errores.NoSePuedeCantarEsoError;
import modelo.Jugada.Jugada;
import modelo.Jugada.JugadaPicaPica;

/**
 * Created by Payas on 21/11/2015.
 */
public class EstadoContraFlor implements EstadoDeEnvido {

    final int PUNTOS_QUIERO = 6;
    final int PUNTOS_NO_QUIERO = 3;

    @Override
    public void cantarEnvido(Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void cantarRealEnvido(Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void cantarFaltaEnvido(Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }


    @Override
    public int obtenerPuntos() {
        return PUNTOS_QUIERO;
    }

    @Override
    public void noAceptarEnvido(Equipo equipoGanador, Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void cantarFaltaEnvidoPicaPica(JugadaPicaPica jugadaPicaPica) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void cantarFlor(Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void contraFlor(Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void contraFlorAlResto(Jugada jugada) {
        jugada.cambiarEstadoEnvido(new EstadoContraFlorAlResto());
    }

    @Override
    public void noAceptarFlor(Equipo equipo, Jugada jugada) {
        equipo.sumarPuntos(PUNTOS_NO_QUIERO);
    }

    @Override
    public void aceptarFlor(Equipo equipo1, Equipo equipo2, Jugada jugada) {
        jugada.obtenerEquipoGanadorFlor(jugada.obtenerEquipo1(), jugada.obtenerEquipo2()).sumarPuntos(PUNTOS_QUIERO);
    }

    @Override
    public void aceptarEnvido(Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void cantarContraFlorAlRestoPicaPica(JugadaPicaPica jugadaPicaPica) {
       jugadaPicaPica.cambiarEstadoEnvido(new EstadoContraFlorAlRestoPicaPica());
    }
}

