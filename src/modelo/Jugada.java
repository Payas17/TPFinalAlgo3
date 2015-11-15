package modelo;

import modelo.EstadoEnvido.EstadoDeEnvido;
import modelo.EstadoEnvido.EstadoEnvido;
import modelo.EstadoEnvido.SinEnvido;
import modelo.EstadoJugada.EstadoDeJugada;
import modelo.EstadoJugada.EstadoPrimeraMano;
import modelo.EstadoTruco.EstadoDeTruco;

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
    private EstadoDeTruco estadoTruco;
    private EstadoDeJugada estadoJugada;
    private EstadoDeEnvido estadoEnvido;
    private int puntosEnvido;
    private int puntosTruco;


    public Jugada(Equipo equipo1,Equipo equipo2) {
        manos = new ArrayList<>();
        ordenJugadores = new ArrayList<>();
        estadoEnvido = new SinEnvido();
        estadoJugada = new EstadoPrimeraMano();
        puntosEnvido = 0;
        puntosTruco = 1;


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

    private void cambiarEstadoJugada(Equipo equipo) {

    }

    public Mano jugarMano() {
        Mano mano = new Mano(ordenJugadores);
        mano.buscarGanador(equipo1,equipo2);

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
        this.estadoJugada.jugarUnaMano();
    }

    public void cantarTruco(){
        this.estadoTruco.cantarTruco();
    }

    public int contarPuntosDeTruco(){
        return this.estadoTruco.contarPuntosDeTruco();
    }


    public void cantarEnvido() {
        this.estadoEnvido.cantarEnvido(this);
        this.puntosEnvido += estadoEnvido.obtenerPuntos();
    }


    public void cambiarEstadoEnvido(EstadoDeEnvido estado){
        this.estadoEnvido = estado;
    }

    public void cantarRealEnvido() {
        this.estadoEnvido.cantarRealEnvido(this);
        this.puntosEnvido += estadoEnvido.obtenerPuntos();

    }

    public void aceptarEnvido() {
        obtenerEquipoGanadorEnvido().sumarPuntos(obtenerPuntosEnvido());
    }

    private int obtenerPuntosEnvido() {
        return puntosEnvido;
    }

    public Jugador obtenerJugadorGanadorEnvido() {
        Jugador jugadorGanadorEnvido = ordenJugadores.get(0);
        for (Jugador jugador: ordenJugadores){
            jugadorGanadorEnvido = asignarJugadorGanadorEnvido(jugadorGanadorEnvido ,jugador);
        }
        return jugadorGanadorEnvido;
    }

    public Jugador asignarJugadorGanadorEnvido(Jugador jugador1, Jugador jugador2){
        return (jugador1.obtenerEnvido() >= jugador2.obtenerEnvido()) ? jugador1 : jugador2;
    }

    public Equipo obtenerEquipoGanadorEnvido() {
        return (equipo1.contieneJugador(obtenerJugadorGanadorEnvido())) ? equipo1 : equipo2;
    }

    public void cantarFaltaEnvido() {
        this.estadoEnvido.cantarFaltaEnvido(this);
        this.puntosEnvido = estadoEnvido.obtenerPuntos();

    }

    public void jugadorNoAceptaElEnvido(Jugador jugador) {
        obtenerEquipoQueNoContieneJugador(jugador).sumarPuntos(obtenerPuntosEnvido()-estadoEnvido.obtenerPuntos());

    }

    public Equipo obtenerEquipoQueNoContieneJugador(Jugador jugador) {
        return (!equipo1.contieneJugador(jugador)) ? equipo1 : equipo2;
    }


}



