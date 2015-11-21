package modelo.EstadoJugada;

import modelo.Equipo;
import modelo.Jugada;

/**
 * Created by Lucio on 18/11/2015.
 */
public class EstadoPardaSegundaMano implements EstadoDeJugada {

    @Override
    public void ganoManoEquipo1(Jugada jugada) {
        jugada.asignarGanadorDeJugada(jugada.obtenerEquipo1());
    }

    @Override
    public void ganoManoEquipo2(Jugada jugada) {
        jugada.asignarGanadorDeJugada(jugada.obtenerEquipo2());
    }

    @Override
    public void manoEmpardada(Jugada jugada) {
        jugada.asignarGanadorDeJugada(jugada.obtenerEquipoJugadorMano());

    }

    @Override
    public void irseAlMazo(Equipo equipo, Jugada jugada){
        jugada.asignarGanadorDeJugada(equipo);
    }
}
