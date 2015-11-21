package modelo.EstadoEnvido;

import modelo.Equipo;
import modelo.Errores.NoSePuedeCantarEsoError;
import modelo.Jugada;
import modelo.Jugador;

/**
 * Created by Augusto on 14/11/2015.
 */
public class EstadoEnvidoEnvido implements EstadoDeEnvido {

    final int PUNTOS = 2;

    @Override
    public void cantarEnvido(Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
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
    public void aceptarEnvido(Equipo equipoGanador, Equipo equipoPerdedor, Jugada jugada) {
        equipoGanador.sumarPuntos(jugada.obtenerPuntosEnvido()+ PUNTOS);
        jugada.cambiarEstadoEnvido(new EstadoNoSePuedeCantarEnvido());
    }

    @Override
    public int obtenerPuntos() {
        return PUNTOS;
    }

    @Override
    public void noAceptarEnvido(Equipo equipoGanador,Jugada jugada) {
        equipoGanador.sumarPuntos(jugada.obtenerPuntosEnvido());
        jugada.cambiarEstadoEnvido(new EstadoNoSePuedeCantarEnvido());
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
