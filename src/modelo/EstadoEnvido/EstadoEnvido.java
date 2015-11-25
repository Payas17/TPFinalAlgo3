package modelo.EstadoEnvido;

import modelo.Equipo;
import modelo.Errores.NoSePuedeCantarEsoError;
import modelo.Jugada.Jugada;
import modelo.Jugada.JugadaPicaPica;

/**
 * Created by Augusto on 14/11/2015.
 */
public class EstadoEnvido implements EstadoDeEnvido {

    final int PUNTOS_QUIERO = 2;
    final int PUNTOS_NO_QUIERO = 1;

    @Override
    public void cantarEnvido(Jugada jugada) {

        jugada.sumarPuntosEnvido(jugada.obtenerEstadoEnvido().obtenerPuntos());
        jugada.cambiarEstadoEnvido(new EstadoEnvidoEnvido());
    }

    @Override
    public void cantarRealEnvido(Jugada jugada) {

        jugada.sumarPuntosEnvido(jugada.obtenerEstadoEnvido().obtenerPuntos());
        jugada.cambiarEstadoEnvido(new EstadoRealEnvido());

    }

    @Override
    public void cantarFaltaEnvido(Jugada jugada) {
        jugada.sumarPuntosEnvido(jugada.obtenerEstadoEnvido().obtenerPuntos());
        jugada.cambiarEstadoEnvido(new EstadoFaltaEnvido());

    }

    @Override
    public int obtenerPuntos() {
        return PUNTOS_QUIERO;
    }


    @Override
    public void cantarFaltaEnvidoPicaPica(JugadaPicaPica jugadaPicaPica) {
        jugadaPicaPica.sumarPuntosEnvido(jugadaPicaPica.obtenerEstadoEnvido().obtenerPuntos());
        jugadaPicaPica.cambiarEstadoEnvido(new EstadoFaltaEnvidoPicaPica());
    }

    @Override
    public void cantarFlor(Jugada jugada) {
        jugada.cambiarEstadoEnvido(new EstadoFlor());
    }


    @Override
    public void contraFlor(Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void contraFlorAlResto(Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void aceptarFlor(Equipo equipo1, Equipo equipo2, Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void noAceptarFlor(Equipo equipo, Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }


    @Override
    public void aceptarEnvido(Jugada jugada) {
        jugada.obtenerEquipoGanadorEnvido().sumarPuntos(jugada.obtenerPuntosEnvido() + PUNTOS_QUIERO);
    }

    @Override
    public void noAceptarEnvido(Equipo equipoGanador, Jugada jugada) {
        equipoGanador.sumarPuntos(PUNTOS_NO_QUIERO);
    }

    @Override
    public void cantarContraFlorAlRestoPicaPica(JugadaPicaPica jugadaPicaPica) {
        throw new NoSePuedeCantarEsoError();
    }

}
