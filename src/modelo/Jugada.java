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
    private Equipo equipo1;
    private Equipo equipo2;
    private EstadoDeTruco estadoDeTruco;
    private EstadoDeJugada estadoDeJugada;

    public Jugada(Equipo equipo1,Equipo equipo2) {
        manos = new ArrayList<>();
        ordenJugadores = new ArrayList<>();
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        for(int i = 0; i < equipo1.obtenerIntegrantes().size();i++ ){
            ordenJugadores.add(this.equipo1.obtenerIntegrantes().get(i));
            ordenJugadores.add(this.equipo2.obtenerIntegrantes().get(i));
        }
        ganadorManoAnterior = null;
        mano = ordenJugadores.get(0);
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
        Mano mano = new Mano(equipo1, equipo2);
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


    public void jugarUnaMano(){
        this.estadoDeJugada.jugarUnaMano();
    }

    public void cantarTruco(){
        this.estadoDeTruco.cantarTruco();
    }

    public int contarPuntosDeTruco(){
        return this.estadoDeTruco.contarPuntosDeTruco();
    }
}



