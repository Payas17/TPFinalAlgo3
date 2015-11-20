package modelo;

import modelo.EstadoEnvido.EstadoDeEnvido;
import modelo.EstadoEnvido.EstadoSinEnvido;
import modelo.EstadoJugada.EstadoDeJugada;
import modelo.EstadoJugada.EstadoJugadaTerminada;
import modelo.EstadoJugada.EstadoPrimeraMano;
import modelo.EstadoJugador.EstadoNoSeCantoNada;
import modelo.EstadoJugador.EstadoPie;
import modelo.EstadoTruco.EstadoDeTruco;
import modelo.EstadoTruco.EstadoSinTruco;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucio on 08/11/2015.
 */
public class Jugada {

    private List<Jugador> ordenJugadores;
    private Equipo ganadorPrimerMano;
    private Jugador mano;
    private Equipo equipo1;
    private Equipo equipo2;
    private Equipo equipoGanador;
    private EstadoDeTruco estadoTruco;
    private EstadoDeJugada estadoJugada;
    private EstadoDeEnvido estadoEnvido;
    private int puntosEnvido;


    public Jugada(Equipo equipo1,Equipo equipo2) {
        ordenJugadores = new ArrayList<>();
        estadoEnvido = new EstadoSinEnvido();
        estadoTruco = new EstadoSinTruco();
        estadoJugada = new EstadoPrimeraMano();
        puntosEnvido = 0;
        equipoGanador= null;


        this.equipo1 = equipo1;
        this.equipo2 = equipo2;

        for(int i = 0; i < equipo1.obtenerIntegrantes().size() ;i++ ){
            if (i < equipo1.obtenerIntegrantes().size()-1){
                equipo1.obtenerIntegrantes().get(i).cambiarEstado(new EstadoNoSeCantoNada());
                equipo2.obtenerIntegrantes().get(i).cambiarEstado(new EstadoNoSeCantoNada());
            }
            else{
                equipo1.obtenerIntegrantes().get(i).cambiarEstado(new EstadoPie());
                equipo2.obtenerIntegrantes().get(i).cambiarEstado(new EstadoPie());
            }
            ordenJugadores.add(this.equipo1.obtenerIntegrantes().get(i));
            ordenJugadores.add(this.equipo2.obtenerIntegrantes().get(i));
        }
        mano = ordenJugadores.get(0);
    }

    private void EstadoJugada(Mano mano) {

        if (mano.hayParda(equipo1,equipo2)){
            this.estadoJugada.manoEmpardada(this);
        }else {

            Equipo equipo = mano.obtenerEquipoGanador(equipo1, equipo2);
            if (equipo == equipo2) {
                this.estadoJugada.ganoManoEquipo2(this);
            } else {
                this.estadoJugada.ganoManoEquipo1(this);
            }
        }
    }

    public void cambiarEstadoJugada (EstadoDeJugada jugada){
        this.estadoJugada = jugada;
    }

    public Mano jugarMano() {
        Mano mano = new Mano(ordenJugadores);
        EstadoJugada(mano);
        return mano;
    }


    public void cantarTruco(){
        this.estadoTruco.cantarTruco(this);
    }

    public int contarPuntosDeTruco(){
        return this.estadoTruco.contarPuntosDeTruco();
    }


    public void cantarEnvido() {
        this.estadoEnvido.cantarEnvido(this);
    }


    public void cambiarEstadoEnvido(EstadoDeEnvido estado){
        this.estadoEnvido = estado;
    }

    public void cantarRealEnvido() {
        this.estadoEnvido.cantarRealEnvido(this);

    }

    public void aceptarEnvido() {
        Equipo equipoPerdedorEnvido = obtenerEquipoQueNoContieneJugador(obtenerJugadorGanadorEnvido());
        this.estadoEnvido.aceptarEnvido(obtenerEquipoGanadorEnvido(),equipoPerdedorEnvido,this);
    }

    public Jugador obtenerJugadorGanadorEnvido() {
        Jugador jugadorGanadorEnvido = ordenJugadores.get(0);
        for (Jugador jugador: ordenJugadores){
            jugadorGanadorEnvido = asignarJugadorGanadorEnvido(jugadorGanadorEnvido ,jugador);
        }
        return jugadorGanadorEnvido;
    }

    public Jugador asignarJugadorGanadorEnvido(Jugador jugador1, Jugador jugador2) {
        return (jugador1.obtenerEnvido() >= jugador2.obtenerEnvido()) ? jugador1 : jugador2;
    }

    public Equipo obtenerEquipoGanadorEnvido() {
        return (equipo1.contieneJugador(obtenerJugadorGanadorEnvido())) ? equipo1 : equipo2;
    }

    public void cantarFaltaEnvido() {
        this.estadoEnvido.cantarFaltaEnvido(this);
    }

    public void jugadorNoAceptaElEnvido(Jugador jugador) {

        this.estadoEnvido.noAceptarEnvido(obtenerEquipoQueNoContieneJugador(jugador),this);

    }

    public Equipo obtenerEquipoQueNoContieneJugador(Jugador jugador) {
        return (!equipo1.contieneJugador(jugador)) ? equipo1 : equipo2;
    }

    public void jugadorNoAceptaElTruco(Jugador jugador) {
        obtenerEquipoQueNoContieneJugador(jugador).sumarPuntos(contarPuntosDeTruco() - 1);
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
        cambiarEstadoJugada(new EstadoJugadaTerminada());
        equipoGanador.sumarPuntos(estadoTruco.contarPuntosDeTruco());
    }

    public Equipo obtenerEquipoGanadorDeJugada(){
        return equipoGanador;
    }

    public EstadoDeEnvido obtenerEstadoEnvido(){
        return this.estadoEnvido;
    }

    public void asignarGanadorPrimeraMano(Equipo equipo){
        ganadorPrimerMano = equipo;
    }

    public Equipo obtenerGanadorPrimeraMano(){
        return ganadorPrimerMano;
    }

    public int obtenerPuntosEnvido() {
        return puntosEnvido;
    }


    public void sumarPuntosEnvido(int puntos) {
        puntosEnvido += puntos;
    }

    public Equipo obtenerEquipoJugadorMano() {
        return (equipo1.contieneJugador(mano)) ? equipo1 : equipo2;
    }

    public Equipo obtenerEquipoQueContieneJugador(Jugador jugador) {
        return (equipo1.contieneJugador(jugador)) ? equipo1 :equipo2;
    }

}



