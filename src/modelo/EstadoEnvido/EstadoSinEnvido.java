package modelo.EstadoEnvido;

import modelo.Jugada;

/**
 * Created by Payas on 14/11/2015.
 */
public class EstadoSinEnvido implements EstadoDeEnvido {


    @Override
    public void cantarEnvido(Jugada jugada) {
        jugada.cambiarEstadoEnvido(new EstadoEnvido());
    }

    @Override
    public int obtenerPuntos() {
        return 0;
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
