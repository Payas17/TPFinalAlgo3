package modelo;

/**
 * Created by Augusto on 14/11/2015.
 */
public class PrimeraMano implements EstadoDeJugada, EstadoDeEnvido {
    private EstadoDeEnvido estadoDeEnvido;

    @Override
    public void jugarUnaMano(){
    }

    @Override
    public void cantarEnvido(){
        this.estadoDeEnvido.cantarEnvido();
    }

    @Override
    public int contarPuntosDeEnvido(){
       return this.estadoDeEnvido.contarPuntosDeEnvido();
    }
}
