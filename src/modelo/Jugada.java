package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucio on 08/11/2015.
 */
public class Jugada {
    private List<Mano> manos;
    private List<Jugador> ordenJugadores;
    private Jugador ganadorManoAnterior;
    private Jugador mano;

    public Jugada(List<Jugador> jugadores) {
        manos = new ArrayList<>();
        ordenJugadores = jugadores;
        ganadorManoAnterior = null;
        mano = jugadores.get(0);
    }

    public void crearNuevaMano() {
        if (ganadorManoAnterior == null) {
            manos.add(new Mano(ordenJugadores));
        } else {
            ordenarJugadores();
            manos.add(new Mano(ordenJugadores));
        }
    }

    private void ordenarJugadores() {
        List<Jugador> listaAuxiliar = ordenJugadores.subList(ordenJugadores.indexOf(ganadorManoAnterior), ordenJugadores.size() - 1);
        ordenJugadores.removeAll(listaAuxiliar);
        ordenJugadores.addAll(0, listaAuxiliar);
    }

    public Jugador obtenerGanador() {
        Jugador ganador = mano;
        for (Jugador jugadorActual : ordenJugadores) {
            if (jugadorActual.obtenerManosGanadas() == 2) {
                ganador = jugadorActual;
            }
        }
        return ganador;
    }
}



