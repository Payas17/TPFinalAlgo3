package modelo.EstadoEnvido;

import modelo.Jugada;

/**
 * Created by Payas on 14/11/2015.
 */
public class SinEnvido implements EstadoDeEnvido {


    @Override
    public void cantarEnvido(Jugada jugada) {
        jugada.cambiarEstadoEnvido(new EstadoEnvido());
    }

    @Override
    public int contarPuntosDeEnvido() {
        return 0;
    }
}
