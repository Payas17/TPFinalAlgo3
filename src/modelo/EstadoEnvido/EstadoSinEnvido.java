package modelo.EstadoEnvido;

import modelo.Equipo;
import modelo.Errores.NoSePuedeCantarEsoError;
import modelo.Errores.NoTieneFlorError;
import modelo.Jugada;
import modelo.Jugador;

/**
 * Created by Payas on 14/11/2015.
 */
public class EstadoSinEnvido implements EstadoDeEnvido {
    final int TANTO = 20;
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
    public void aceptarEnvido(Equipo equipoGanador, Equipo equipoPerdedor,Jugada jugada) {
        throw new NoSePuedeCantarEsoError();

    }

    @Override
    public int obtenerPuntos() {
        return PUNTOS;
    }

    @Override
    public void noAceptarEnvido(Equipo equipoGanador, Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
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

}
