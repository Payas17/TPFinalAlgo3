package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucio on 08/11/2015.
 */
public class Jugada {
    List<Mano> manos;
    List<Jugador> ordenJugadores;
    Jugador ganadorManoAnterior;

    public Jugada(List<Jugador> jugadores) {
        manos = new ArrayList<>();
        ordenJugadores = jugadores;
        ganadorManoAnterior = null;
    }

    public void crearNuevaMano() {
        if (ganadorManoAnterior == null) {
            manos.add(new Mano(ordenJugadores));
        } else {
            List<Jugador> listaAuxiliar = ordenJugadores.subList(ordenJugadores.indexOf(ganadorManoAnterior), ordenJugadores.size() - 1);
            ordenJugadores.removeAll(listaAuxiliar);
            ordenJugadores.addAll(0, listaAuxiliar);
            manos.add(new Mano(ordenJugadores));
        }
    }

    public Jugador obtenerGanador() {
        Jugador ganador = ordenJugadores.get(0);
        for (Jugador jugadorActual : ordenJugadores) {
            if (jugadorActual.obtenerManosGanadas() == 2) {
                ganador = jugadorActual;
            }
        }
        return ganador;
    }
}



