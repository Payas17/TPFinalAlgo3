package modelo.EstadoTruco;

import modelo.Errores.NoSePuedeCantarEsoError;
import modelo.Jugada;

/**
 * Created by Augusto on 14/11/2015.
 */
public class EstadoTruco implements EstadoDeTruco {
    private int puntos;

    @Override
    public void cantarTruco(Jugada jugada){
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public int contarPuntosDeTruco(){
       return this.puntos = 2;
    }

    @Override
    public void cantarReTruco(Jugada jugada) {
        jugada.cambiarEstadoTruco(new EstadoReTruco());
    }
    @Override
    public void cantarValeCuatro(Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }
}
