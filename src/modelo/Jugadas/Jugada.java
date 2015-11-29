package modelo.Jugadas;

import modelo.Equipo;
import modelo.Errores.NoTieneFlorError;
import modelo.EstadoEnvido.EstadoDeEnvido;
import modelo.EstadoEnvido.EstadoNoSePuedeCantarEnvido;
import modelo.EstadoEnvido.EstadoSinEnvido;
import modelo.EstadoJugada.EstadoDeJugada;
import modelo.EstadoJugada.EstadoJugadaTerminada;
import modelo.EstadoJugada.EstadoPrimeraMano;
import modelo.EstadoJugador.EstadoNoSeCantoNada;
import modelo.EstadoJugador.EstadoPie;
import modelo.EstadoJugador.EstadoYaJugoCarta;
import modelo.EstadoTruco.EstadoDeTruco;
import modelo.EstadoTruco.EstadoSinTruco;
import modelo.Jugador;
import modelo.Mano;
import modelo.Partida.EstadoPartidaTerminada;
import modelo.Partida.Partida;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucio on 08/11/2015.
 */
public class Jugada {
    private final int MAX_PUNTAJE_PARTIDA = 30;
    final int TANTO = 20;

    private Partida partida;
    protected List<Jugador> ordenJugadoresMano;
    protected List<Jugador> ordenJugadores;
    private Equipo ganadorPrimerMano;
    private Jugador mano;

    protected Equipo equipo1;
    protected Equipo equipo2;
    protected Equipo equipoGanador;
    protected EstadoDeTruco estadoTruco;
    protected EstadoDeJugada estadoJugada;
    protected EstadoDeEnvido estadoEnvido;
    protected int puntosEnvido;

    public Jugada(Partida partida, List<Jugador> ordenJugadoresDePartida) {
        ordenJugadores = ordenJugadoresDePartida;
        estadoEnvido = new EstadoSinEnvido();
        estadoTruco = new EstadoSinTruco();
        estadoJugada = new EstadoPrimeraMano();
        puntosEnvido = 0;
        equipoGanador= null;
        this.partida = partida;

        this.equipo1 = partida.obtenerEquipo1();
        this.equipo2 = partida.obtenerEquipo2();

        inicializarJugadores();
        limpiarJugadores();
    }

    private void limpiarJugadores() {
        for (Jugador jugador : ordenJugadores){
            jugador.sacarCartas();
        }
    }

    public List<Jugador> obtenerOrdenJugadoresMano(){
        return ordenJugadoresMano;
    }


    private void inicializarJugadores() {

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

    public void jugarMano() {
        Mano mano = new Mano(ordenJugadoresMano);
        EstadoJugada(mano);
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
        this.estadoEnvido.aceptarEnvido(this);
        if (algunEquipoGano()) {
            terminarPartida();
        } else {
            cambiarEstadoEnvido(new EstadoNoSePuedeCantarEnvido());
        }
    }

    public void noAceptarEnvido(Jugador jugador) {
        this.estadoEnvido.noAceptarEnvido(obtenerEquipoQueNoContieneJugador(jugador),this);
        if (algunEquipoGano()) {
            terminarPartida();
        } else {
            cambiarEstadoEnvido(new EstadoNoSePuedeCantarEnvido());
        }
    }

    public void cantarFaltaEnvido() {
        this.estadoEnvido.cantarFaltaEnvido(this);
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

    public void sumarPuntosEnvido(int puntos) {
        puntosEnvido += puntos;
    }

    public void asignarGanadorPrimeraMano(Equipo equipo){
        ganadorPrimerMano = equipo;
    }

    public void asignarGanadorDeJugada(Equipo equipo) {
        equipoGanador = equipo;
        cambiarEstadoJugada(new EstadoJugadaTerminada());
        equipoGanador.sumarPuntos(estadoTruco.contarPuntosDeTruco());
        if ( algunEquipoGano()){
            terminarPartida();
        }
    }

    private Jugador asignarJugadorGanadorFlor(Jugador jugador1, Jugador jugador2) {
        return (jugador1.obtenerFlor() >= jugador2.obtenerFlor()) ? jugador1 : jugador2;
    }

    public Jugador asignarJugadorGanadorEnvido(Jugador jugador1, Jugador jugador2) {
        return (jugador1.obtenerEnvido() >= jugador2.obtenerEnvido()) ? jugador1 : jugador2;
    }

    public Equipo obtenerGanadorPrimeraMano(){
        return ganadorPrimerMano;
    }

    public int obtenerPuntosEnvido() {
        return puntosEnvido;
    }

    public Equipo obtenerEquipoJugadorMano() {
        return (equipo1.contieneJugador(mano)) ? equipo1 : equipo2;
    }

    public Equipo obtenerEquipoQueContieneJugador(Jugador jugador) {
        return (equipo1.contieneJugador(jugador)) ? equipo1 :equipo2;
    }

    public Equipo obtenerEquipoGanadorFlor(Equipo equipo1,Equipo equipo2) {
        return (equipo1.contieneJugador(obtenerJugadorGanadorFlor())) ? equipo1 : equipo2;
    }

    public Equipo obtenerEquipoQueNoContieneJugador(Jugador jugador) {
        return (!equipo1.contieneJugador(jugador)) ? equipo1 : equipo2;
    }

    public Equipo obtenerEquipoGanadorEnvido() {
        return (equipo1.contieneJugador(obtenerJugadorGanadorEnvido())) ? equipo1 : equipo2;
    }

    public Equipo obtenerEquipoGanadorDeJugada(){
        return equipoGanador;
    }

    public EstadoDeEnvido obtenerEstadoEnvido(){
        return this.estadoEnvido;
    }

    public Equipo obtenerEquipo1() {
        return equipo1;
    }

    public Equipo obtenerEquipo2() {
        return equipo2;
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

    public void irseAlMazo(Equipo equipo) {
        this.estadoJugada.irseAlMazo(equipo, this);
    }

    public void cantarContraFlor() {
        estadoEnvido.cantarContraFlor(this);
    }

    public void cantarContraFlorAlResto() {
        estadoEnvido.cantarContraFlorAlResto(this);
    }

    public void cantarFlor(Jugador jugador) {
        if (jugador.tieneFlor()){
            this.estadoEnvido.cantarFlor(this);
        }
        else{
            throw new NoTieneFlorError();
        }
    }

    public void aceptarFlor(Jugador jugador) {
        estadoEnvido.aceptarFlor(obtenerEquipoQueNoContieneJugador(jugador), obtenerEquipoQueContieneJugador(jugador), this);
        if (algunEquipoGano()) {
            terminarPartida();
        } else {
            cambiarEstadoEnvido(new EstadoNoSePuedeCantarEnvido());
        }
    }

    public void noAceptarFlor(Jugador jugador) {
        estadoEnvido.noAceptarFlor(obtenerEquipoQueNoContieneJugador(jugador),this);
        if (algunEquipoGano()) {
            terminarPartida();
        } else {
            cambiarEstadoEnvido(new EstadoNoSePuedeCantarEnvido());
        }
    }

    private boolean algunEquipoGano() {
        return (equipo1.obtenerPuntos() >= MAX_PUNTAJE_PARTIDA) || (equipo2.obtenerPuntos() >= MAX_PUNTAJE_PARTIDA);
    }

    private void cambiarEstadoAJugadores(Equipo equipo1, Equipo equipo2) {
        for (Jugador jugador : equipo1.obtenerIntegrantes()) {
            jugador.cambiarEstado(new EstadoYaJugoCarta());
        }
        for (Jugador jugador : equipo2.obtenerIntegrantes()) {
            jugador.cambiarEstado(new EstadoYaJugoCarta());
        }
    }

    private void terminarPartida() {
        cambiarEstadoJugada(new EstadoJugadaTerminada());
        partida.cambiarEstado(new EstadoPartidaTerminada());
        cambiarEstadoAJugadores(partida.obtenerEquipo1(), partida.obtenerEquipo2());
    }


}



