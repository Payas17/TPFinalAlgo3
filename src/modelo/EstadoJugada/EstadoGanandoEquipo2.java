package modelo.EstadoJugada;

import modelo.Equipo;
import modelo.Jugadas.Jugada;

/**
 * Created by Augusto on 14/11/2015.
 */
public class EstadoGanandoEquipo2 implements EstadoDeJugada {
    @Override
    public void ganoManoEquipo1(Jugada jugada){
        jugada.cambiarEstadoJugada(new EstadoEmpate());
    }

    @Override
    public void ganoManoEquipo2(Jugada jugada){
        jugada.asignarGanadorDeJugada(jugada.obtenerEquipo2());
    }

    @Override
    public void manoEmpardada(Jugada jugada) {
        jugada.asignarGanadorDeJugada(jugada.obtenerEquipo2());
    }

    @Override
    public void irseAlMazo(Equipo equipo, Jugada jugada){
        jugada.asignarGanadorDeJugada(equipo);
    }
}
