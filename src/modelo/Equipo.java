package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucio on 13/11/2015.
 */
public class Equipo {
    private List<Jugador> integrantes;
    private int puntos;

    public Equipo(List<Jugador> integrantes){
        this.integrantes = integrantes;
        this.puntos = 0;
    }

    public List<Jugador> obtenerIntegrantes(){
        return integrantes;
    }


    public Jugador obtenerMejorJugadorEquipo() {
       Jugador jugadorConCartaMasAltaEnJuego = integrantes.get(0);

        for(Jugador jugador : integrantes){
            jugadorConCartaMasAltaEnJuego = obtenerMejorJugador(jugadorConCartaMasAltaEnJuego,jugador);
        }
        return jugadorConCartaMasAltaEnJuego;
    }

    private Jugador obtenerMejorJugador(Jugador jugador1, Jugador jugador2){
        return (jugador1.obtenerCartaEnJuego().obtenerValorTruco() >= jugador2.obtenerCartaEnJuego().obtenerValorTruco()) ? jugador1 : jugador2;
    }

    public boolean contieneJugador(Jugador jugador) {
        return integrantes.contains(jugador);
    }

    public int obtenerValorMaximoEnvido() {
        int envidoMasAltoEquipo = integrantes.get(0).obtenerEnvido();

        for (Jugador jugador :integrantes){
            envidoMasAltoEquipo = Math.max(envidoMasAltoEquipo,jugador.obtenerEnvido());
        }
        return envidoMasAltoEquipo;
    }

    public void sumarPuntos(int puntos) {
        this.puntos += puntos;
    }

    public int obtenerPuntos() {
        return this.puntos;
    }
}
