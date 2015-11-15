package modelo.EstadoEnvido;

import modelo.Jugada;

/**
 * Created by Augusto on 14/11/2015.
 */
public class EstadoRealEnvido implements EstadoDeEnvido{
    int puntos;


    @Override
    public void cantarEnvido(Jugada jugada) {

    }

    @Override
    public int contarPuntosDeEnvido(){
        return puntos=3;
    }
}
