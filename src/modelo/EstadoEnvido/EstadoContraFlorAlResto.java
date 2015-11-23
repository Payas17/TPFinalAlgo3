package modelo.EstadoEnvido;

import modelo.Equipo;
import modelo.Errores.NoSePuedeCantarEsoError;
import modelo.EstadoJugada.EstadoJugadaTerminada;
import modelo.EstadoJugador.EstadoNoPuedeCantar;
import modelo.EstadoJugador.EstadoYaJugoCarta;
import modelo.Jugada;
import modelo.JugadaPicaPica;
import modelo.Jugador;
import modelo.Partida.EstadoPartidaTerminada;
import modelo.Partida.Partida;

/**
 * Created by Payas on 21/11/2015.
 */
public class EstadoContraFlorAlResto implements EstadoDeEnvido {
    final int MAX_PUNTAJE_PARTIDA = 30;

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
    public void aceptarEnvido(Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public int obtenerPuntos() {
        return 0;
    }

    @Override
    public void noAceptarEnvido(Equipo equipoGanador, Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }


    @Override
    public void cantarFlor(Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void noAceptarFlor(Equipo equipo, Jugada jugada) {
        equipo.sumarPuntos(jugada.obtenerEstadoEnvido().obtenerPuntos());
        jugada.cambiarEstadoEnvido(new EstadoNoSePuedeCantarEnvido());
    }

    @Override
    public void aceptarFlor(Equipo equipo1, Equipo equipo2, Jugada jugada) {
        jugada.obtenerEquipoGanadorFlor(equipo1,equipo2).sumarPuntos(30 - jugada.obtenerEquipoQueNoContieneJugador(jugada.obtenerJugadorGanadorFlor()).obtenerPuntos());
        jugada.cambiarEstadoEnvido(new EstadoNoSePuedeCantarEnvido());
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
    public void noAceptarFlor(Equipo equipo, Jugada jugada, Partida partida) {
        equipo.sumarPuntos(jugada.obtenerEstadoEnvido().obtenerPuntos());
        if (equipo.obtenerPuntos() >= MAX_PUNTAJE_PARTIDA) {
            jugada.cambiarEstadoJugada(new EstadoJugadaTerminada());
            partida.cambiarEstado(new EstadoPartidaTerminada());

            cambiarEstadoAJugadores(partida.obtenerEquipo1(),partida.obtenerEquipo2());

        } else {
            jugada.cambiarEstadoEnvido(new EstadoNoSePuedeCantarEnvido());
        }
    }

    @Override
    public void aceptarFlor(Equipo equipo1, Equipo equipo2, Jugada jugada, Partida partida) {
        jugada.obtenerEquipoGanadorFlor(equipo1,equipo2).sumarPuntos(30 - jugada.obtenerEquipoQueNoContieneJugador(jugada.obtenerJugadorGanadorFlor()).obtenerPuntos());
        if (( jugada.obtenerEquipo1().obtenerPuntos() >= MAX_PUNTAJE_PARTIDA) || (jugada.obtenerEquipo2().obtenerPuntos() >= MAX_PUNTAJE_PARTIDA )){
            jugada.cambiarEstadoJugada(new EstadoJugadaTerminada());
            partida.cambiarEstado(new EstadoPartidaTerminada());

            cambiarEstadoAJugadores(partida.obtenerEquipo1(),partida.obtenerEquipo2());
        }
        else{
            jugada.cambiarEstadoEnvido(new EstadoNoSePuedeCantarEnvido());
        }

    }

    @Override
    public void aceptarEnvido(Jugada jugada, Partida partida) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void noAceptarEnvido(Equipo equipoGanador, Jugada jugada, Partida partida) {
        throw new NoSePuedeCantarEsoError();
    }


    private void cambiarEstadoAJugadores(Equipo equipo1, Equipo equipo2) {
        for (Jugador jugador : equipo1.obtenerIntegrantes()) {
            jugador.cambiarEstado(new EstadoYaJugoCarta());
        }
        for (Jugador jugador : equipo2.obtenerIntegrantes()) {
            jugador.cambiarEstado(new EstadoYaJugoCarta());
        }
    }

    @Override
    public void cantarFaltaEnvidoPicaPica(JugadaPicaPica jugadaPicaPica) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void cantarContraFlorAlRestoPicaPica(JugadaPicaPica jugadaPicaPica) {
        throw new NoSePuedeCantarEsoError();
    }
}
