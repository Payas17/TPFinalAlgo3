package modelo;

import modelo.EstadoEnvido.EstadoDeEnvido;
import modelo.EstadoEnvido.EstadoSinEnvido;
import modelo.EstadoJugada.EstadoDeJugada;
import modelo.EstadoJugada.EstadoPrimeraMano;
import modelo.EstadoTruco.EstadoDeTruco;
import modelo.EstadoTruco.EstadoSinTruco;

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
    private Equipo equipoGanador;
    private EstadoDeTruco estadoTruco;
    private EstadoDeJugada estadoJugada;
    private EstadoDeEnvido estadoEnvido;
    private int puntosEnvido;
    private int puntosTruco;


    public Jugada(Equipo equipo1,Equipo equipo2) {
        manos = new ArrayList<>();
        ordenJugadores = new ArrayList<>();
        estadoEnvido = new EstadoSinEnvido();
        estadoTruco = new EstadoSinTruco();
        estadoJugada = new EstadoPrimeraMano();
        puntosEnvido = 0;
        puntosTruco = 1;
        equipoGanador= null;


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

    private void MagicMike(Equipo equipo) {
        if (equipo == equipo1){
            this.estadoJugada.ganoManoEquipo1(this);
        }
        if (equipo == equipo2){
            this.estadoJugada.ganoManoEquipo2(this);
        }
        if (equipo == null){
            this.estadoJugada.manoEmpardada(this);
        }
    }

    public void cambiarEstadoJugada (EstadoDeJugada jugada){
        this.estadoJugada = jugada;
    }
    public Mano jugarMano() {
        Mano mano = new Mano(ordenJugadores);
        mano.buscarGanador(equipo1, equipo2);
        MagicMike(mano.obtenerEquipoGanador());
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


    public void cantarTruco(){
        this.estadoTruco.cantarTruco(this);
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

    public void aceptarFaltaEnvido() {
        Equipo equipoPerdedorEnvido = obtenerEquipoQueNoContieneJugador(obtenerJugadorGanadorEnvido());
        if( equipoPerdedorEnvido.obtenerPuntos() > 15){
            int maxPuntaje = Math.max(equipo1.obtenerPuntos(), equipo2.obtenerPuntos());
            obtenerEquipoGanadorEnvido().sumarPuntos(30 - maxPuntaje);
        }
        else{
            obtenerEquipoGanadorEnvido().sumarPuntos(15 - equipoPerdedorEnvido.obtenerPuntos() );
        }
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
    }

    public void jugadorNoAceptaElEnvido(Jugador jugador) {
        if (obtenerPuntosEnvido()-estadoEnvido.obtenerPuntos() == 0) {
            obtenerEquipoQueNoContieneJugador(jugador).sumarPuntos(1);
        }else{
            obtenerEquipoQueNoContieneJugador(jugador).sumarPuntos(obtenerPuntosEnvido()-estadoEnvido.obtenerPuntos());
        }
    }

    public void jugadorNoAceptaElFaltaEnvido(Jugador jugador) {
        obtenerEquipoQueNoContieneJugador(jugador).sumarPuntos(obtenerPuntosEnvido());
    }

    public Equipo obtenerEquipoQueNoContieneJugador(Jugador jugador) {
        return (!equipo1.contieneJugador(jugador)) ? equipo1 : equipo2;
    }


    public void cambiarEstadoTruco(EstadoDeTruco estadoTruco) {
        this.estadoTruco = estadoTruco;
    }

    public void cantarReTruco() {
        this.estadoTruco.cantarReTruco(this);
    }

    public void cantarValeCuatro() {
        this.estadoTruco.cantarValeCuatro(this);
    }

    public Equipo obtenerEquipo1() {
        return equipo1;
    }

    public Equipo obtenerEquipo2() {
        return equipo2;
    }

    public void asignarGanadorDeJugada(Equipo equipo) {
        equipoGanador = equipo;
    }
}



