package modelo.EstadoEnvido;

import modelo.Equipo;
import modelo.Errores.NoSePuedeCantarEsoError;
import modelo.Jugada;

/**
 * Created by Augusto on 14/11/2015.
 */
public class EstadoRealEnvido implements EstadoDeEnvido{

    final int PUNTOS = 3;


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
        jugada.sumarPuntosEnvido(jugada.obtenerEstadoEnvido().obtenerPuntos());
        jugada.cambiarEstadoEnvido(new EstadoFaltaEnvido());

    }

    @Override
    public void aceptarEnvido(Equipo equipoGanador, Equipo equipoPerdedor, int puntos) {
        equipoGanador.sumarPuntos(puntos + PUNTOS);
    }

    @Override
    public int obtenerPuntos() {
        return PUNTOS;
    }

    @Override
    public void noAceptarEnvido(Equipo equipoGanador,int puntos) {
        equipoGanador.sumarPuntos(puntos);
    }

}
