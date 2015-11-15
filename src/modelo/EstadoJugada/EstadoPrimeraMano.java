package modelo.EstadoJugada;

import modelo.EstadoEnvido.EstadoDeEnvido;
import modelo.Jugada;

/**
 * Created by Augusto on 14/11/2015.
 */
public class EstadoPrimeraMano implements EstadoDeJugada, EstadoDeEnvido {
    private EstadoDeEnvido estadoDeEnvido;

    @Override
    public void jugarUnaMano(){
    }


    @Override
    public void cantarEnvido(Jugada jugada) {

    }

    @Override
    public int obtenerPuntos() {
        return 0;
    }


    @Override
    public void cantarRealEnvido(Jugada jugada) {

    }

    @Override
    public void cantarFaltaEnvido(Jugada jugada) {

    }

}
