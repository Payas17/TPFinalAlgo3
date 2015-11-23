package modelo.EstadoEnvido;

import modelo.Equipo;
import modelo.Errores.NoSePuedeCantarEsoError;
import modelo.EstadoJugada.EstadoJugadaTerminada;
import modelo.EstadoJugador.EstadoYaJugoCarta;
import modelo.Jugada.Jugada;
import modelo.Jugada.JugadaPicaPica;
import modelo.Jugador;
import modelo.Partida.EstadoPartidaTerminada;
import modelo.Partida.Partida;

/**
 * Created by Augusto on 14/11/2015.
 */
public class EstadoFaltaEnvido implements EstadoDeEnvido{

    final int MAX_PUNTAJE_PARTIDA = 30;

    final int PUNTOS =30;
    @Override
    public void cantarEnvido(Jugada jugada) {throw new NoSePuedeCantarEsoError(); }

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
        return PUNTOS;
    }

    @Override
    public void noAceptarEnvido(Equipo equipoGanador, Jugada jugada, Partida partida) {
        equipoGanador.sumarPuntos(jugada.obtenerPuntosEnvido());
        if (equipoGanador.obtenerPuntos() >= MAX_PUNTAJE_PARTIDA) {
            jugada.cambiarEstadoJugada(new EstadoJugadaTerminada());
            partida.cambiarEstado(new EstadoPartidaTerminada());

            cambiarEstadoAJugadores(partida.obtenerEquipo1(), partida.obtenerEquipo2());

        } else {
            jugada.cambiarEstadoEnvido(new EstadoNoSePuedeCantarEnvido());
        }
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
    public void noAceptarFlor(Equipo equipo, Jugada jugada, Partida partida) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void aceptarFlor(Equipo equipo1, Equipo equipo2, Jugada jugada, Partida partida) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void aceptarEnvido(Jugada jugada, Partida partida) {
        Equipo equipoPerdedor = jugada.obtenerEquipoQueNoContieneJugador(jugada.obtenerJugadorGanadorEnvido());
        if (equipoPerdedor.obtenerPuntos() > 15) {
            int maxPuntaje = Math.max(jugada.obtenerEquipoGanadorEnvido().obtenerPuntos(), equipoPerdedor.obtenerPuntos());
            jugada.obtenerEquipoGanadorEnvido().sumarPuntos(30 - maxPuntaje);
        } else {
            jugada.obtenerEquipoGanadorEnvido().sumarPuntos(15 - equipoPerdedor.obtenerPuntos());
        }
        if (jugada.obtenerEquipoGanadorEnvido().obtenerPuntos() >= MAX_PUNTAJE_PARTIDA) {
            jugada.cambiarEstadoJugada(new EstadoJugadaTerminada());
            partida.cambiarEstado(new EstadoPartidaTerminada());

            cambiarEstadoAJugadores(partida.obtenerEquipo1(), partida.obtenerEquipo2());

        }else{
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
    public void cantarFaltaEnvidoPicaPica(JugadaPicaPica jugadaPicaPica) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void cantarContraFlorAlRestoPicaPica(JugadaPicaPica jugadaPicaPica) {
        throw new NoSePuedeCantarEsoError();
    }
}
