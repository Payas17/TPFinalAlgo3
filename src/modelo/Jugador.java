package modelo;

import modelo.Carta.Carta;
import modelo.Errores.NoTieneFlorError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Payas on 07/11/2015.
 */
public class Jugador {

    final int TANTO = 20;
    private List<Carta> cartas;
    private int cantidadEnvido;
    private Carta cartaEnJuego;
    private int manosGanadas;

    public Jugador(){
        this.cartas = new ArrayList<>();
        this.manosGanadas = 0;
    }

    public void agregarCarta(Carta unaCarta) {
        this.cartas.add(unaCarta);
    }

    public int obtenerManosGanadas(){
        return manosGanadas;
    }

    public void sumarManosGanadas(){
        this.manosGanadas++;
    }

    public int obtenerEnvido() {

        return Math.max(Math.max(sumarEnvido(0,1), sumarEnvido(0, 2)),sumarEnvido(1, 2));
    }

    private int sumarEnvido(int pos1, int pos2) {
        return this.cartas.get(pos1).sumarEnvido(this.cartas.get(pos2));
    }

    public int cantarFlor(){

        if(sumarEnvido(0,1) >= TANTO && sumarEnvido(0,2) >= TANTO){
            return obtenerEnvido();
        }
        throw new NoTieneFlorError();
    }

    public void juegaCarta(Carta unaCarta) {
        this.cartaEnJuego = unaCarta;
    }

    public Carta obtenerCartaEnJuego(){
        return this.cartaEnJuego;
    }

    public void cantarEnvido(Jugada jugada) {
        jugada.cantarEnvido();
    }

    public void cantarRealEnvido(Jugada jugada) {
        jugada.cantarRealEnvido();
    }

    public void aceptarEnvido(Jugada jugada) {
        jugada.aceptarEnvido();
    }

    public void cantarFaltaEnvido(Jugada jugada) {
        jugada.cantarFaltaEnvido();
    }

    public void noAceptarEnvido(Jugada jugada) {
        jugada.jugadorNoAceptaElEnvido(this);
    }

    public void cantarTruco(Jugada jugada) {
        jugada.cantarTruco();
    }

    public void noAceptarTruco(Jugada jugada) { jugada.jugadorNoAceptaElTruco(this); }

    public void cantarReTruco(Jugada jugada) {
        jugada.cantarReTruco();
    }

    public void cantarValeCuatro(Jugada jugada) {
        jugada.cantarValeCuatro();
    }
}
