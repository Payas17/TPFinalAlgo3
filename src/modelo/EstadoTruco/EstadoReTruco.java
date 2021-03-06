package modelo.EstadoTruco;

import modelo.Errores.NoSePuedeCantarEsoError;
import modelo.Jugadas.Jugada;

/**
 * Created by Augusto on 14/11/2015.
 */
public class EstadoReTruco implements EstadoDeTruco {

    private int puntos;
    @Override
    public void cantarTruco(Jugada jugada){
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public int contarPuntosDeTruco(){
        return this.puntos = 3;
    }

    @Override
    public void cantarReTruco(Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void cantarValeCuatro(Jugada jugada) {
        jugada.cambiarEstadoTruco(new EstadoValeCuatro());
    }
}


