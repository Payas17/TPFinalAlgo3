package modelo.EstadoEnvido;

import modelo.Jugada;

/**
 * Created by Augusto on 14/11/2015.
 */
public class EstadoEnvido implements EstadoDeEnvido {

    final int PUNTOS = 2;

    @Override
    public void cantarEnvido(Jugada jugada) {

        jugada.cambiarEstadoEnvido(new EstadoEnvidoEnvido());
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
