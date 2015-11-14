package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucio on 08/11/2015.
 */
public class Jugada {
    private List<Mano> manos;
    private Turnos turnos;
    private Equipo equipo1;
    private Equipo equipo2;
    private Jugador ganadorManoAnterior;
    private Jugador mano;

    public Jugada(List<Jugador> ordenJugadoresEnMesa,Equipo equipo1,Equipo equipo2) {
        manos = new ArrayList<>();
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.turnos = new Turnos(ordenJugadoresEnMesa);
        ganadorManoAnterior = null;
    }

    public void crearNuevaMano() {
        if (ganadorManoAnterior == null) {
            manos.add(jugarMano());
        } else {
            turnos.actualizarTurnos(ganadorManoAnterior);
            manos.add(jugarMano());
        }
        ganadorManoAnterior = manos.get(manos.size() - 1).obtenerJugadorGanador();
    }

    private Mano jugarMano() {
        Mano mano = new Mano(turnos);
        mano.jugarMano();
        return mano;
    }

   /* private void ordenarJugadores() {
        List<Jugador> listaAuxiliar = ordenJugadores.subList(ordenJugadores.indexOf(ganadorManoAnterior), ordenJugadores.size() - 1);
        ordenJugadores.addAll(0, listaAuxiliar);
    }*/

    /*public Jugador obtenerGanador() {
        Jugador ganador = mano;
        for (Jugador jugadorActual : ordenJugadores) {
            if (jugadorActual.obtenerManosGanadas() == 2) {
                ganador = jugadorActual;
            }
        }
        return ganador;
    }*/
}



