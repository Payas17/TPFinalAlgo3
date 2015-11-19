package modelo.EstadoJugada;



import modelo.Jugada;

/**
 * Created by Augusto on 14/11/2015.
 */
public class EstadoPrimeraMano implements EstadoDeJugada {


    @Override
    public void ganoManoEquipo1(Jugada jugada){
        jugada.cambiarEstadoJugada(new EstadoGanandoEquipo1());
        jugada.asignarGanadorPrimeraMano(jugada.obtenerEquipo1());
    }

    @Override
    public void ganoManoEquipo2(Jugada jugada){
        jugada.cambiarEstadoJugada(new EstadoGanandoEquipo2());
        jugada.asignarGanadorPrimeraMano(jugada.obtenerEquipo2());
    }

    @Override
    public void manoEmpardada(Jugada jugada){
        jugada.cambiarEstadoJugada(new EstadoEmpardado());


    }


}
