package modelo.EstadoJugada;

import modelo.Equipo;
import modelo.Jugada.Jugada;

/**
 * Created by Augusto on 14/11/2015.
 */
public class EstadoEmpardado implements EstadoDeJugada {

    @Override
    public void ganoManoEquipo1(Jugada jugada){
        jugada.asignarGanadorDeJugada(jugada.obtenerEquipo1());
    }

    @Override
    public void ganoManoEquipo2(Jugada jugada){
        jugada.asignarGanadorDeJugada(jugada.obtenerEquipo2());
    }

    @Override
    public void manoEmpardada(Jugada jugada) {
        jugada.cambiarEstadoJugada(new EstadoPardaSegundaMano());
    }

    @Override
    public void irseAlMazo(Equipo equipo, Jugada jugada){
        jugada.asignarGanadorDeJugada(equipo);
    }
}
