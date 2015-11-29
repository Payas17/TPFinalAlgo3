package modelo.EstadoEnvido;

import modelo.Equipo;
import modelo.Errores.NoSePuedeCantarEsoError;
import modelo.Jugadas.Jugada;
import modelo.Jugadas.JugadaPicaPica;


/**
 * Created by Payas on 14/11/2015.
 */
public class EstadoSinEnvido implements EstadoDeEnvido {
    final int PUNTOS = 1;

    @Override
    public void cantarEnvido(Jugada jugada) {
        jugada.cambiarEstadoEnvido(new EstadoEnvido());
    }

    @Override
    public void cantarRealEnvido(Jugada jugada) {
        jugada.cambiarEstadoEnvido(new EstadoRealEnvido());
    }

    @Override
    public void cantarFaltaEnvido(Jugada jugada) {
        jugada.cambiarEstadoEnvido(new EstadoFaltaEnvido());
    }

    @Override
    public void cantarFaltaEnvidoPicaPica(JugadaPicaPica jugadaPicaPica) {
        jugadaPicaPica.cambiarEstadoEnvido(new EstadoFaltaEnvidoPicaPica());
    }

    @Override
    public int obtenerPuntos() {
        return PUNTOS;
    }

    @Override
    public void cantarFlor(Jugada jugada) {
        jugada.cambiarEstadoEnvido(new EstadoFlor());
    }


    @Override
    public void cantarContraFlor(Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void cantarContraFlorAlResto(Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void noAceptarFlor(Equipo equipo, Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void aceptarFlor(Equipo equipo1, Equipo equipo2, Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void aceptarEnvido(Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void noAceptarEnvido(Equipo equipoGanador, Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void cantarContraFlorAlRestoPicaPica(JugadaPicaPica jugadaPicaPica) {
        throw new NoSePuedeCantarEsoError();
    }

}
