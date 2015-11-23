package modelo.EstadoEnvido;

import modelo.Equipo;
import modelo.Errores.NoSePuedeCantarEsoError;
import modelo.EstadoJugada.EstadoJugadaTerminada;
import modelo.EstadoJugador.EstadoYaJugoCarta;
import modelo.Jugada;
import modelo.JugadaPicaPica;
import modelo.Jugador;
import modelo.Partida.EstadoPartidaTerminada;
import modelo.Partida.Partida;

/**
 * Created by Augusto on 14/11/2015.
 */
public class EstadoEnvido implements EstadoDeEnvido {

    final int MAX_PUNTAJE_PARTIDA = 30;
    final int PUNTOS = 2;

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
    public void aceptarEnvido(Jugada jugada) {
        jugada.obtenerEquipoGanadorEnvido().sumarPuntos(jugada.obtenerPuntosEnvido() + PUNTOS);
        if (jugada.obtenerEquipoGanadorEnvido().obtenerPuntos() == 30){
            jugada.cambiarEstadoJugada(new EstadoJugadaTerminada());
        }
        jugada.cambiarEstadoEnvido(new EstadoNoSePuedeCantarEnvido());
    }

    @Override
    public int obtenerPuntos() {
        return PUNTOS;
    }

    @Override
    public void noAceptarEnvido(Equipo equipoGanador, Jugada jugada) {
        equipoGanador.sumarPuntos(1);
        jugada.cambiarEstadoEnvido(new EstadoNoSePuedeCantarEnvido());
    }


    @Override
    public void noAceptarEnvido(Equipo equipoGanador, Jugada jugada,Partida partida) {
        equipoGanador.sumarPuntos(1);
        if (equipoGanador.obtenerPuntos() >= MAX_PUNTAJE_PARTIDA) {
            jugada.cambiarEstadoJugada(new EstadoJugadaTerminada());
            partida.cambiarEstado(new EstadoPartidaTerminada());

            cambiarEstadoAJugadores(partida.obtenerEquipo1(),partida.obtenerEquipo2());

        } else {
            jugada.cambiarEstadoEnvido(new EstadoNoSePuedeCantarEnvido());
        }
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
    public void noAceptarFlor(Equipo equipo, Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void aceptarFlor(Equipo equipoQueCantoFlor, Equipo equipoQueNoCantoFlor,Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
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
        throw new NoSePuedeCantarEsoError();
    }


    @Override
    public void aceptarFlor(Equipo equipo1, Equipo equipo2, Jugada jugada, Partida partida) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void aceptarEnvido(Jugada jugada, Partida partida) {
        jugada.obtenerEquipoGanadorEnvido().sumarPuntos(jugada.obtenerPuntosEnvido() + PUNTOS);
        if (jugada.obtenerEquipoGanadorEnvido().obtenerPuntos() >= MAX_PUNTAJE_PARTIDA) {
            jugada.cambiarEstadoJugada(new EstadoJugadaTerminada());
            partida.cambiarEstado(new EstadoPartidaTerminada());

            cambiarEstadoAJugadores(partida.obtenerEquipo1(),partida.obtenerEquipo2());

        } else {
            jugada.cambiarEstadoEnvido(new EstadoNoSePuedeCantarEnvido());
        }
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
    public void cantarContraFlorAlRestoPicaPica(JugadaPicaPica jugadaPicaPica) {
        throw new NoSePuedeCantarEsoError();
    }

}
