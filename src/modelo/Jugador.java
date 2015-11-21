package modelo;

import modelo.Carta.Carta;
import modelo.Errores.CartaYaJugadaError;
import modelo.Errores.NoTieneFlorError;
import modelo.EstadoEnvido.EstadoNoSePuedeCantarEnvido;
import modelo.EstadoJugador.EstadoDeJugador;
import modelo.EstadoJugador.EstadoPie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Payas on 07/11/2015.
 */
public class Jugador {

    final int TANTO = 20;
    private List<Carta> cartas;
    private List<Carta> cartasEnJuego;
    private EstadoDeJugador estadoJugador;



    public Jugador(){
        this.cartas = new ArrayList<>();
        this.cartasEnJuego = new ArrayList<>();
        estadoJugador = new EstadoPie();

    }

    public void agregarCarta(Carta unaCarta) {
        this.cartas.add(unaCarta);
    }

    public int obtenerEnvido() {

        return Math.max(Math.max(sumarEnvido(0,1), sumarEnvido(0, 2)),sumarEnvido(1, 2));
    }

    public int obtenerFlor(){
        int valorFlor = TANTO;
        for(Carta carta:cartas){
            valorFlor += carta.obtenerValorEnvido();
        }
        return valorFlor;
    }

    public int sumarEnvido(int pos1, int pos2) {
        return this.cartas.get(pos1).sumarEnvido(this.cartas.get(pos2));
    }

    public void cantarFlor(Jugada jugada){
        jugada.cantarFlor(this);

    }

    public void juegaCarta(Carta unaCarta) {
       this.estadoJugador.jugarCarta();
        if (cartasEnJuego.contains(unaCarta)){
            throw new CartaYaJugadaError();
        }
        this.cartasEnJuego.add(unaCarta);
    }

    public Carta obtenerCartaEnJuego(){
        return this.cartasEnJuego.get(this.cartasEnJuego.size()-1);
    }

    public void cantarEnvido(Jugada jugada) {

        jugada.cantarEnvido();

        this.estadoJugador.cantarEnvido(jugada.obtenerEquipoQueContieneJugador(this), jugada.obtenerEquipoQueNoContieneJugador(this));
    }

    public void cantarRealEnvido(Jugada jugada) {
        jugada.cantarRealEnvido();
        this.estadoJugador.cantarEnvido(jugada.obtenerEquipoQueContieneJugador(this), jugada.obtenerEquipoQueNoContieneJugador(this));
    }

    public void aceptarEnvido(Jugada jugada) {
        this.estadoJugador.aceptar(jugada);
        jugada.aceptarEnvido();

    }

    public void cantarFaltaEnvido(Jugada jugada) {

        jugada.cantarFaltaEnvido();
        this.estadoJugador.cantarEnvido(jugada.obtenerEquipoQueContieneJugador(this), jugada.obtenerEquipoQueNoContieneJugador(this));
    }

    public void noAceptarEnvido(Jugada jugada) {
        this.estadoJugador.aceptar(jugada);
        jugada.jugadorNoAceptaElEnvido(this);

    }

    public void cantarTruco(Jugada jugada) {
        jugada.cantarTruco();
        this.estadoJugador.cantarTruco(jugada.obtenerEquipoQueContieneJugador(this), jugada.obtenerEquipoQueNoContieneJugador(this));
    }

    public void noAceptarTruco(Jugada jugada) { jugada.jugadorNoAceptaElTruco(this); }

    public void cantarReTruco(Jugada jugada) {
        jugada.cantarReTruco();
        this.estadoJugador.cantarTruco(jugada.obtenerEquipoQueContieneJugador(this), jugada.obtenerEquipoQueNoContieneJugador(this));
    }

    public void cantarValeCuatro(Jugada jugada) {
        jugada.cantarValeCuatro();
        this.estadoJugador.cantarTruco(jugada.obtenerEquipoQueContieneJugador(this), jugada.obtenerEquipoQueNoContieneJugador(this));
    }

    public void cambiarEstado(EstadoDeJugador estado) {
        this.estadoJugador = estado;
    }

    public void aceptarTruco(Jugada jugada) {
        this.estadoJugador.aceptar(jugada);
    }

    public void irseAlMazo(Jugada jugada) {
        jugada.irseAlMazo(jugada.obtenerEquipoQueNoContieneJugador(this));
    }

    public void noAceptarFlor(Jugada jugada){
        jugada.noAceptarFlor(this);
    }

    public void aceptarFlor(Jugada jugada) {
        jugada.aceptarFlor(this);
    }

    public void contraFlor(Jugada jugada) {
        jugada.contraFlor();
    }

    public void contraFlorAlResto(Jugada jugada) {
        jugada.contraFlorAlResto();
    }
}
