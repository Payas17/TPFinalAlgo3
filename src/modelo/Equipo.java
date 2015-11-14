package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucio on 13/11/2015.
 */
public class Equipo {
    private List<Jugador> integrantes;
    private Jugador jugadorConCartaMasAltaEnJuego;

    public Equipo(List<Jugador> integrantes){
        this.integrantes = integrantes;

    }

    public List<Jugador> obtenerIntegrantes(){
        return integrantes;
    }


    public Jugador getMejorJugadorEquipo() {
        setearMejorJugadorEquipo();
        return jugadorConCartaMasAltaEnJuego;
    }

    private void setearMejorJugadorEquipo(){
        jugadorConCartaMasAltaEnJuego = integrantes.get(0);
        for(Jugador jugador : integrantes){
            jugadorConCartaMasAltaEnJuego = obtenerMejorJugador(jugadorConCartaMasAltaEnJuego,jugador);
        }
    }

    private Jugador obtenerMejorJugador(Jugador jugador1, Jugador jugador2){
        return (jugador1.obtenerCartaEnJuego().obtenerValorTruco() >= jugador2.obtenerCartaEnJuego().obtenerValorTruco()) ? jugador1 : jugador2;
    }

    public boolean contieneJugador(Jugador jugador) {
        return integrantes.contains(jugador);
    }
}
