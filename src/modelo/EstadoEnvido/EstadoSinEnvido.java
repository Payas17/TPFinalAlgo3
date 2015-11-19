package modelo.EstadoEnvido;

import modelo.Equipo;
import modelo.Errores.NoSePuedeCantarEsoError;
import modelo.Jugada;

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
    public void aceptarEnvido(Equipo equipoGanador, Equipo equipoPerdedor, int puntos) {
        throw new NoSePuedeCantarEsoError();

    }

    @Override
    public int obtenerPuntos() {
        return PUNTOS;
    }

    @Override
    public void noAceptarEnvido(Equipo equipoGanador, int puntos) {
        throw new NoSePuedeCantarEsoError();
    }
}
