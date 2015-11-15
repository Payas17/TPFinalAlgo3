package modelo.EstadoTruco;

/**
 * Created by Augusto on 14/11/2015.
 */
public class EstadoSinTruco implements EstadoDeTruco {
    private int puntos;
    @Override
    public void cantarTruco(){
    }

    @Override
    public int contarPuntosDeTruco(){
       return this.puntos = 1;
    }
}
