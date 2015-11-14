package modelo;

/**
 * Created by Augusto on 14/11/2015.
 */
public class Envido implements EstadoDeEnvido {
    int puntos;
    @Override
    public void cantarEnvido(){

    }

    @Override
    public int contarPuntosDeEnvido(){
        return puntos=2;
    }
}
