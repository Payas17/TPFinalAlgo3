package modelo.EstadoEnvido;

import modelo.Errores.NoSePuedeCantarEsoError;
import modelo.Jugada;

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
    public int obtenerPuntos() {
        return PUNTOS;
    }

    @Override
    public void cantarRealEnvido(Jugada jugada) {
        jugada.cambiarEstadoEnvido(new EstadoRealEnvido());
    }

    @Override
    public void cantarFaltaEnvido(Jugada jugada) {
        jugada.cambiarEstadoEnvido(new EstadoFaltaEnvido());
    }
}
