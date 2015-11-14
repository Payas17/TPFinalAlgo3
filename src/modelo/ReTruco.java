package modelo;

/**
 * Created by Augusto on 14/11/2015.
 */
public class ReTruco implements EstadoDeTruco {

    private int puntos;
    @Override
    public void cantarTruco(){

    }

    @Override
    public int contarPuntosDeTruco(){
        return this.puntos = 3;
    }
}


