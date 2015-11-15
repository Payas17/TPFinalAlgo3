package modelo.EstadoJugada;

import modelo.EstadoEnvido.EstadoDeEnvido;
import modelo.Jugada;

/**
 * Created by Augusto on 14/11/2015.
 */
public class EstadoPrimeraMano implements EstadoDeJugada, EstadoDeEnvido {
    private EstadoDeEnvido estadoDeEnvido;

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

    @Override
    public void ganoManoEquipo1(Jugada jugada){
        jugada.cambiarEstadoJugada(new EstadoGanandoEquipo1());
    }

    @Override
    public void ganoManoEquipo2(Jugada jugada){
        jugada.cambiarEstadoJugada(new EstadoGanandoEquipo2());
    }

    @Override
    public void manoEmpardada(Jugada jugada){
        jugada.cambiarEstadoJugada(new EstadoEmpardado());

    }

}
