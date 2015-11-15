package modelo.EstadoEnvido;

import modelo.Errores.NoSePuedeCantarEsoError;
import modelo.Jugada;

/**
 * Created by Augusto on 14/11/2015.
 */
public class EstadoEnvidoEnvido implements EstadoDeEnvido {
    int puntos;


    @Override
    public void cantarEnvido(Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public int contarPuntosDeEnvido(){
        return puntos=4;
    }
}
