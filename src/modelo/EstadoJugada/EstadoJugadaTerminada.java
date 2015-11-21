package modelo.EstadoJugada;

import modelo.Equipo;
import modelo.Errores.JugadaTerminadaError;
import modelo.Jugada;

/**
 * Created by Lucio on 15/11/2015.
 */
public class EstadoJugadaTerminada implements EstadoDeJugada {

    @Override
    public void ganoManoEquipo1(Jugada jugada) { throw new JugadaTerminadaError(); }

    @Override
    public void ganoManoEquipo2(Jugada jugada) {  throw new JugadaTerminadaError(); }

    @Override
    public void manoEmpardada(Jugada jugada) {  throw new JugadaTerminadaError(); }

    @Override
    public void irseAlMazo(Equipo equipo, Jugada jugada){
        throw new JugadaTerminadaError();
    }
}
