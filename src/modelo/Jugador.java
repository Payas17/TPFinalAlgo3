package modelo;

import modelo.Carta.Carta;
import modelo.Errores.CartaYaJugadaError;
import modelo.EstadoJugador.EstadoDeJugador;
import modelo.EstadoJugador.EstadoNoSeCantoNada;
import modelo.Jugadas.Jugada;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Payas on 07/11/2015.
 */
public class Jugador {

    final int TANTO = 20;
    private List<Carta> cartas;
    private Carta cartaEnJuego;
    private EstadoDeJugador estadoJugador;

    public Jugador() {
        this.cartas = new ArrayList<>();
        estadoJugador = new EstadoNoSeCantoNada();

    }

    public void agregarCarta(Carta unaCarta) {
        this.cartas.add(unaCarta);
    }

    public int obtenerEnvido() {

        return Math.max(Math.max(sumarEnvido(cartas.get(0), cartas.get(1)), sumarEnvido(cartas.get(0), cartas.get(2))), sumarEnvido(cartas.get(1), cartas.get(2)));
    }


    public int obtenerFlor() {
        int valorFlor = TANTO;
        for (Carta carta : cartas) {
            valorFlor += carta.obtenerValorEnvido();
        }
        return valorFlor;
    }

    public int sumarEnvido(Carta unaCarta, Carta otraCarta) {
        return unaCarta.sumarEnvido(otraCarta);
    }

    public void juegaCarta(Carta unaCarta) {
        this.estadoJugador.jugarCarta(this);

        this.cartaEnJuego = unaCarta;

    }


    public Carta obtenerCartaEnJuego() {
        return cartaEnJuego;
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

    public void noAceptarEnvido(Jugada jugada) {
        this.estadoJugador.aceptar(jugada);
        jugada.noAceptarEnvido(this);
    }

    public void cantarFaltaEnvido(Jugada jugada) {
        this.estadoJugador.cantarEnvido(jugada.obtenerEquipoQueContieneJugador(this), jugada.obtenerEquipoQueNoContieneJugador(this));
        jugada.cantarFaltaEnvido();
    }

    public void cantarTruco(Jugada jugada) {
        this.estadoJugador.cantarTruco(jugada.obtenerEquipoQueContieneJugador(this), jugada.obtenerEquipoQueNoContieneJugador(this));
        jugada.cantarTruco();
    }

    public void noAceptarTruco(Jugada jugada) {
        jugada.jugadorNoAceptaElTruco(this);
    }

    public void cantarReTruco(Jugada jugada) {
        this.estadoJugador.cantarTruco(jugada.obtenerEquipoQueContieneJugador(this), jugada.obtenerEquipoQueNoContieneJugador(this));
        jugada.cantarReTruco();
    }

    public void cantarValeCuatro(Jugada jugada) {
        this.estadoJugador.cantarTruco(jugada.obtenerEquipoQueContieneJugador(this), jugada.obtenerEquipoQueNoContieneJugador(this));
        jugada.cantarValeCuatro();
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

    public void aceptarFlor(Jugada jugada) {
        this.estadoJugador.aceptar(jugada);
        jugada.aceptarFlor(this);
    }

    public void noAceptarFlor(Jugada jugada) {
        this.estadoJugador.aceptar(jugada);
        jugada.noAceptarFlor(this);
    }

    public boolean tieneFlor() {

        return sumarEnvido(cartas.get(0), cartas.get(1)) >= TANTO && sumarEnvido(cartas.get(0), cartas.get(2)) >= TANTO;
    }

    public void cantarFlor(Jugada jugada) {
        this.estadoJugador.cantarFlor(jugada.obtenerEquipoQueContieneJugador(this), jugada.obtenerEquipoQueNoContieneJugador(this));
        jugada.cantarFlor(this);
    }

    public void cantarContraFlor(Jugada jugada) {
        this.estadoJugador.cantarFlor(jugada.obtenerEquipoQueContieneJugador(this), jugada.obtenerEquipoQueNoContieneJugador(this));
        jugada.cantarContraFlor();
    }

    public void cantarContraFlorAlResto(Jugada jugada) {
        this.estadoJugador.cantarFlor(jugada.obtenerEquipoQueContieneJugador(this), jugada.obtenerEquipoQueNoContieneJugador(this));
        jugada.cantarContraFlorAlResto();
    }

    public void cambiarCartas(Mazo mazo) {
        sacarCartas();
        cartas.add(mazo.darCarta());
        cartas.add(mazo.darCarta());
        cartas.add(mazo.darCarta());
    }

    public void sacarCartas() {
        cartaEnJuego = null;
        cartas.removeAll(cartas);
    }

    public List<Carta> obtenerCartasEnMano() {
        return cartas;
    }
}