package modelo;

import modelo.Errores.NoTieneFlorError;
import modelo.EstadoEnvido.EstadoDeEnvido;
import modelo.EstadoEnvido.EstadoSinEnvido;
import modelo.EstadoJugada.EstadoDeJugada;
import modelo.EstadoJugada.EstadoJugadaTerminada;
import modelo.EstadoJugada.EstadoPrimeraMano;
import modelo.EstadoJugador.EstadoNoSeCantoNada;
import modelo.EstadoJugador.EstadoPie;
import modelo.EstadoTruco.EstadoDeTruco;
import modelo.EstadoTruco.EstadoSinTruco;
import modelo.Partida.Partida;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucio on 08/11/2015.
 */
public class Jugada {
    final int TANTO = 20;

    private Partida partida;
    private List<Jugador> ordenJugadoresMano;
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


    public Jugada(Equipo equipo1, Equipo equipo2, Mazo mazoDeCartas) {
        ordenJugadores = new ArrayList<>();
        estadoEnvido = new EstadoSinEnvido();
        estadoTruco = new EstadoSinTruco();
        estadoJugada = new EstadoPrimeraMano();
        puntosEnvido = 0;
        equipoGanador= null;

        this.equipo1 = equipo1;
        this.equipo2 = equipo2;

        inicializarJugadores2(equipo1, equipo2, mazoDeCartas);
    }



    public Jugada(Partida partida,Mazo mazoDeCartas, List<Jugador> ordenJugadoresDePartida) {
        ordenJugadores = ordenJugadoresDePartida;
        estadoEnvido = new EstadoSinEnvido();
        estadoTruco = new EstadoSinTruco();
        estadoJugada = new EstadoPrimeraMano();
        puntosEnvido = 0;
        equipoGanador= null;
        this.partida = partida;

        this.equipo1 = partida.obtenerEquipo1();
        this.equipo2 = partida.obtenerEquipo2();

        inicializarJugadores(mazoDeCartas);
    }

    public Jugada(){
        estadoEnvido = new EstadoSinEnvido();
        estadoTruco = new EstadoSinTruco();
        estadoJugada = new EstadoPrimeraMano();
        puntosEnvido = 0;
        equipoGanador= null;
        this.equipo1 = null;
        this.equipo2 = null;
    }

    private void inicializarJugadores2(Equipo equipo1, Equipo equipo2, Mazo mazoDeCartas) {

        for (int i = 0; i < equipo1.obtenerIntegrantes().size(); i++) {
            //mazoDeCartas.mezclar();
            //equipo1.obtenerIntegrantes().get(i).cambiarCartas(mazoDeCartas);
            //equipo2.obtenerIntegrantes().get(i).cambiarCartas(mazoDeCartas);


            ordenJugadores.add(this.equipo1.obtenerIntegrantes().get(i));
            ordenJugadores.add(this.equipo2.obtenerIntegrantes().get(i));
        }

        if (equipo1.obtenerPuntos() != 0 || equipo2.obtenerPuntos() != 0) {
            Jugador jugadorQuePongoUltimo = ordenJugadores.remove(0);
            ordenJugadores.add(jugadorQuePongoUltimo);
        }

        ordenJugadores.get(ordenJugadores.size() - 1).cambiarEstado(new EstadoPie());
        ordenJugadores.get(ordenJugadores.size() - 2).cambiarEstado(new EstadoPie());
        ordenJugadoresMano = new ArrayList<>(ordenJugadores);
        mano = ordenJugadores.get(0);
    }

    private void inicializarJugadores(Mazo mazoDeCartas) {
        if (equipo1.obtenerPuntos() != 0 || equipo2.obtenerPuntos() != 0) {
            Jugador jugadorQuePongoUltimo = ordenJugadores.remove(0);
            ordenJugadores.add(jugadorQuePongoUltimo);
        }
        for (int i =0; i < ordenJugadores.size() -2;i++){
            ordenJugadores.get(i).cambiarEstado(new EstadoNoSeCantoNada());
        }
        ordenJugadores.get(ordenJugadores.size()-1).cambiarEstado(new EstadoPie());
        ordenJugadores.get(ordenJugadores.size()-2).cambiarEstado(new EstadoPie());
        ordenJugadoresMano = new ArrayList<>(ordenJugadores);
        //mazoDeCartas.mezclar();
        for (Jugador jugadorActual: ordenJugadores) {
            //jugadorActual.cambiarCartas(mazoDeCartas);
        }
        mano = ordenJugadores.get(0);
    }

    private void EstadoJugada(Mano mano) {
        for (Jugador jugador: ordenJugadores){
            jugador.cambiarEstado(new EstadoNoSeCantoNada());
        }
        if (mano.hayParda(equipo1,equipo2)){
            this.estadoJugada.manoEmpardada(this);
        }else {
            int i=0;
            while (ordenJugadoresMano.get(i) != mano.obtenerJugadorGanador()){

                ordenJugadoresMano.add(ordenJugadoresMano.remove(i));
            }
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
        Mano mano = new Mano(ordenJugadoresMano);
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
        this.estadoEnvido.aceptarEnvido(this,partida);
    }

    public Jugador obtenerJugadorGanadorEnvido() {
        Jugador jugadorGanadorEnvido = ordenJugadores.get(0);
        for (Jugador jugador: ordenJugadores){
            jugadorGanadorEnvido = asignarJugadorGanadorEnvido(jugadorGanadorEnvido ,jugador);
        }
        return jugadorGanadorEnvido;
    }

    public Jugador obtenerJugadorGanadorFlor() {
        Jugador jugadorGanadorFlor = ordenJugadores.get(0);
        for (Jugador jugador: ordenJugadores){
            jugadorGanadorFlor = asignarJugadorGanadorFlor(jugadorGanadorFlor, jugador);
        }
        return jugadorGanadorFlor;
    }

    private Jugador asignarJugadorGanadorFlor(Jugador jugador1, Jugador jugador2) {
        return (jugador1.obtenerFlor() >= jugador2.obtenerFlor()) ? jugador1 : jugador2;
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

        this.estadoEnvido.noAceptarEnvido(obtenerEquipoQueNoContieneJugador(jugador),this,partida);

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

    public void irseAlMazo(Equipo equipo) {
        this.estadoJugada.irseAlMazo(equipo, this);
    }

    public void cantarFlor(Jugador jugador) {
        if (jugador.sumarEnvido(0,1) >= TANTO && jugador.sumarEnvido(0,2) >= TANTO){
            this.estadoEnvido.cantarFlor(this);
        }
        else{
            throw new NoTieneFlorError();
        }

    }

    public void noAceptarFlor(Jugador jugador) {
        estadoEnvido.noAceptarFlor(obtenerEquipoQueNoContieneJugador(jugador),this,partida);

    }

    public Equipo obtenerEquipoGanadorFlor(Equipo equipo1,Equipo equipo2) {
        return (equipo1.contieneJugador(obtenerJugadorGanadorFlor())) ? equipo1 : equipo2;
    }

    public void aceptarFlor(Jugador jugador) {
        estadoEnvido.aceptarFlor(obtenerEquipoQueNoContieneJugador(jugador), obtenerEquipoQueContieneJugador(jugador), this,partida);
    }

    public void contraFlor() {
        estadoEnvido.contraFlor(this);
    }

    public void contraFlorAlResto() {
        estadoEnvido.contraFlorAlResto(this);
    }

    public void armarEquiposParaPicaPica(Jugador jugador1, Jugador jugador6) {


       /* this.equipo1.obtenerIntegrantes().removeAll(equipo1.obtenerIntegrantes());
        this.equipo2.obtenerIntegrantes().removeAll(equipo2.obtenerIntegrantes());
        ordenJugadores.removeAll(ordenJugadores);
        */

        ordenJugadoresMano = new ArrayList<>();
        ordenJugadoresMano.add(jugador1);
        ordenJugadoresMano.add(jugador6);
        ordenJugadores = ordenJugadoresMano;

        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador6);

        this.equipo1 = new Equipo(jugadores);
        this.equipo2 = new Equipo(jugadores2);
    }
}



