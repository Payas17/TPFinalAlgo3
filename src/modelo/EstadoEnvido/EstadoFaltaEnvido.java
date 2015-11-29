package modelo.EstadoEnvido;

import modelo.Equipo;
import modelo.Errores.NoSePuedeCantarEsoError;
import modelo.Jugadas.Jugada;
import modelo.Jugadas.JugadaPicaPica;


/**
 * Created by Augusto on 14/11/2015.
 */
public class EstadoFaltaEnvido implements EstadoDeEnvido{

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
    public void aceptarFlor(Equipo equipo1, Equipo equipo2, Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void noAceptarFlor(Equipo equipo, Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void aceptarEnvido(Jugada jugada) {
        Equipo equipoPerdedor = jugada.obtenerEquipoQueNoContieneJugador(jugada.obtenerJugadorGanadorEnvido());
        if (equipoPerdedor.obtenerPuntos() > 15) {
            int maxPuntaje = Math.max(jugada.obtenerEquipoGanadorEnvido().obtenerPuntos(), equipoPerdedor.obtenerPuntos());
            jugada.obtenerEquipoGanadorEnvido().sumarPuntos(30 - maxPuntaje);
        } else {
            jugada.obtenerEquipoGanadorEnvido().sumarPuntos(15 - equipoPerdedor.obtenerPuntos());
        }
    }

    @Override
    public void noAceptarEnvido(Equipo equipoGanador, Jugada jugada) {
        equipoGanador.sumarPuntos(jugada.obtenerPuntosEnvido());
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
