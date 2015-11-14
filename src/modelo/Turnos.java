package modelo;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lucio on 13/11/2015.
 */
public class Turnos {
    private List<Jugador> ordenJugadoresEnMesa;
    private List<Jugador> turnos;

    public Turnos(List<Jugador> ordenJugadoresEnMesa) {
        this.ordenJugadoresEnMesa = ordenJugadoresEnMesa;
        this.turnos = new LinkedList<>(ordenJugadoresEnMesa);
    }

    public Jugador obtenerJugadorQueJuega() {
        try {
            return turnos.remove(0);
        } catch (IndexOutOfBoundsException e) {
            throw new NoQuedanJugadoresPorJugarError();
        }
    }

    public boolean quedaJugadorPorJugar(){
        return !turnos.isEmpty();
    }

    public void actualizarTurnos(Jugador ganadorManoAnterior) {
        List<Jugador> listaAuxiliar = ordenJugadoresEnMesa.subList(ordenJugadoresEnMesa.indexOf(ganadorManoAnterior), ordenJugadoresEnMesa.size());
        turnos.addAll(0, listaAuxiliar);
        for(Jugador jugador: ordenJugadoresEnMesa){
            if (!turnos.contains(jugador)){
                turnos.add(jugador);
            }
        }
    }

}
