package modelo.EstadoJugada;



import modelo.Equipo;
import modelo.EstadoEnvido.EstadoNoSePuedeCantarEnvido;
import modelo.EstadoEnvido.EstadoSinEnvido;
import modelo.Jugadas.Jugada;

/**
 * Created by Augusto on 14/11/2015.
 */
public class EstadoPrimeraMano implements EstadoDeJugada {


    @Override
    public void ganoManoEquipo1(Jugada jugada){
        jugada.cambiarEstadoJugada(new EstadoGanandoEquipo1());
        jugada.cambiarEstadoEnvido(new EstadoNoSePuedeCantarEnvido());
        jugada.asignarGanadorPrimeraMano(jugada.obtenerEquipo1());
    }

    @Override
    public void ganoManoEquipo2(Jugada jugada){
        jugada.cambiarEstadoJugada(new EstadoGanandoEquipo2());
        jugada.cambiarEstadoEnvido(new EstadoNoSePuedeCantarEnvido());
        jugada.asignarGanadorPrimeraMano(jugada.obtenerEquipo2());
    }

    @Override
    public void manoEmpardada(Jugada jugada){
        jugada.cambiarEstadoJugada(new EstadoEmpardado());
        jugada.cambiarEstadoEnvido(new EstadoNoSePuedeCantarEnvido());

    }
    @Override
    public void irseAlMazo(Equipo equipo, Jugada jugada){
        if (jugada.obtenerEstadoEnvido().getClass()== EstadoSinEnvido.class){
            equipo.sumarPuntos(1);
        }
        jugada.asignarGanadorDeJugada(equipo);
    }


}
