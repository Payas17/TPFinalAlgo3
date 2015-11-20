package modelo.EstadoEnvido;

import modelo.Equipo;
import modelo.Jugada;

/**
 * Created by Augusto on 14/11/2015.
 */
public class EstadoEnvido implements EstadoDeEnvido {

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
    public void aceptarEnvido(Equipo equipoGanador, Equipo equipoPerdedor,Jugada jugada) {
        equipoGanador.sumarPuntos(jugada.obtenerPuntosEnvido()+ PUNTOS);
        jugada.cambiarEstadoEnvido(new EstadoNoSePuedeCantarEnvido());
    }

    @Override
    public int obtenerPuntos() {
        return PUNTOS;
    }

    @Override
    public void noAceptarEnvido(Equipo equipoGanador,Jugada jugada) {
        equipoGanador.sumarPuntos(1);
        jugada.cambiarEstadoEnvido(new EstadoNoSePuedeCantarEnvido());
    }


}
