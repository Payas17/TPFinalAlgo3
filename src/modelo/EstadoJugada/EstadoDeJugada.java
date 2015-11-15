package modelo.EstadoJugada;


import modelo.Jugada;
/**
 * Created by Augusto on 14/11/2015.
 */
public interface EstadoDeJugada {


    void ganoManoEquipo1(Jugada jugada);

    void ganoManoEquipo2(Jugada jugada);

    void manoEmpardada(Jugada jugada);


}
