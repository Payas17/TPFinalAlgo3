package modelo.EstadoEnvido;

import modelo.Jugada;

/**
 * Created by Augusto on 14/11/2015.
 */
public class EstadoEnvido implements EstadoDeEnvido {


    @Override
    public void cantarEnvido(Jugada jugada) {

        jugada.cambiarEstadoEnvido(new EstadoEnvidoEnvido());
    }

    @Override
    public int contarPuntosDeEnvido(){return 0;}




}
