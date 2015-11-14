package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucio on 08/11/2015.
 */
public class Jugada implements EstadoDeJugada, EstadoDeTruco  {
    private List<Mano> manos;
    private List<Jugador> ordenJugadores;
    private Jugador ganadorManoAnterior;
    private Jugador mano;
    private Equipo equipo1;
    private Equipo equipo2;
    private EstadoDeTruco estadoDeTruco;
    private EstadoDeJugada estadoDeJugada;


    public Jugada(List<Jugador> jugadores) {
        manos = new ArrayList<>();
        ordenJugadores = jugadores;
        ganadorManoAnterior = null;
        mano = jugadores.get(0);
        //this.setearEstado(PrimeraMano)
    }

    public void crearNuevaMano() {
        if (ganadorManoAnterior == null) {
            manos.add(jugarMano());
        } else {
            ordenarJugadores();
            manos.add(jugarMano());
        }
        ganadorManoAnterior = manos.get(manos.size() - 1).obtenerJugadorGanador();
    }

    private Mano jugarMano() {
        Mano mano = new Mano(ordenJugadores);
        mano.buscarGanador();
        return mano;
    }

    private void ordenarJugadores() {
        List<Jugador> listaAuxiliar = ordenJugadores.subList(ordenJugadores.indexOf(ganadorManoAnterior), ordenJugadores.size() - 1);
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

    public EstadoDeJugada obtenerEstadoDeJugadaActual(){
        return this.estadoDeJugada;
    }

    public void setearEstado(EstadoDeJugada estadoDeJugada){
        this.estadoDeJugada = estadoDeJugada;
    }

    @Override
    public void jugarUnaMano(){
        this.estadoDeJugada.jugarUnaMano();
    }

    @Override
    public void cantarTruco(){
        this.estadoDeTruco.cantarTruco();
    }

    @Override
    public int contarPuntosDeTruco(){
        return this.estadoDeTruco.contarPuntosDeTruco();
    }


}



