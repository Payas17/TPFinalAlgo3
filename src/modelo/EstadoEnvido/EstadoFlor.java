package modelo.EstadoEnvido;

import modelo.Equipo;
import modelo.Errores.NoSePuedeCantarEsoError;
import modelo.EstadoJugada.EstadoJugadaTerminada;
import modelo.EstadoJugador.EstadoYaJugoCarta;
import modelo.Jugada;
import modelo.Jugador;
import modelo.Partida.EstadoPartidaTerminada;
import modelo.Partida.Partida;

/**
 * Created by Lucio on 21/11/2015.
 */
public class EstadoFlor implements EstadoDeEnvido {

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
        return 3;
    }

    @Override
    public void noAceptarEnvido(Equipo equipoGanador, Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void noAceptarEnvido(Equipo equipoGanador, Jugada jugada, Partida partida) {
        throw new NoSePuedeCantarEsoError();
    }

    public void cantarFlor(Jugada jugada){
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void noAceptarFlor(Equipo equipo, Jugada jugada) {
        jugada.cambiarEstadoEnvido(new EstadoNoSePuedeCantarEnvido());
        equipo.sumarPuntos(3);
    }

    @Override
    public void aceptarFlor(Equipo equipoQueCantoFlor, Equipo equipoQueNoCantoFlor,Jugada jugada) {
        jugada.obtenerEquipoGanadorFlor(equipoQueCantoFlor,equipoQueNoCantoFlor).sumarPuntos(4);
        equipoQueCantoFlor.sumarPuntos(2);
        jugada.cambiarEstadoEnvido(new EstadoNoSePuedeCantarEnvido());
    }

    @Override
    public void contraFlor(Jugada jugada) {
        jugada.cambiarEstadoEnvido(new EstadoContraFlor());
    }

    @Override
    public void contraFlorAlResto(Jugada jugada) {
        jugada.cambiarEstadoEnvido(new EstadoContraFlorAlResto());
    }

    @Override
    public void noAceptarFlor(Equipo equipo, Jugada jugada, Partida partida) {
        equipo.sumarPuntos(3);
        if (equipo.obtenerPuntos() == MAX_PUNTAJE_PARTIDA) {
            jugada.cambiarEstadoJugada(new EstadoJugadaTerminada());
            partida.cambiarEstado(new EstadoPartidaTerminada());

            cambiarEstadoAJugadores(partida.obtenerEquipo1(), partida.obtenerEquipo2());

        } else {
            jugada.cambiarEstadoEnvido(new EstadoNoSePuedeCantarEnvido());
        }
    }

    @Override
    public void aceptarFlor(Equipo equipoQueCantoFlor, Equipo equipoQueNoCantoFlor,Jugada jugada, Partida partida) {
        jugada.obtenerEquipoGanadorFlor(equipoQueCantoFlor, equipoQueNoCantoFlor).sumarPuntos(4);
        equipoQueCantoFlor.sumarPuntos(2);
        if (equipoQueCantoFlor.obtenerPuntos() == MAX_PUNTAJE_PARTIDA || equipoQueNoCantoFlor.obtenerPuntos() == MAX_PUNTAJE_PARTIDA) {
            jugada.cambiarEstadoJugada(new EstadoJugadaTerminada());
            partida.cambiarEstado(new EstadoPartidaTerminada());

            cambiarEstadoAJugadores(partida.obtenerEquipo1(),partida.obtenerEquipo2());

        } else {
            jugada.cambiarEstadoEnvido(new EstadoNoSePuedeCantarEnvido());
        }
    }

    @Override
    public void aceptarEnvido(Jugada jugada, Partida partida) {
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

}
