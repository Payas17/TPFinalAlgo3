package modelo.Partida;

import modelo.Equipo;
import modelo.Jugada;
import modelo.Mazo;
import modelo.ValoresTrucoYEnvido;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Augusto on 18/11/2015.
 */
public class Partida {
    Equipo equipo1;
    Equipo equipo2;
    Mazo mazoDeCartas;
    List<Object> jugadas;
    EstadoDePartida estadoDePartida;
    boolean flor;

    public Partida(Equipo equipo1,Equipo equipo2){
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        jugadas = new ArrayList<>();
        mazoDeCartas = new Mazo(new ValoresTrucoYEnvido());
        flor = false;
        estadoDePartida = new EstadoPartidaNormal();
    }

    public void jugarConFlor(){
        flor = true;
    }

    public Jugada crearJugada(){
        Jugada jugada = new Jugada(this,mazoDeCartas);

        jugadas.add(jugada);
        return jugada;
    }

    public boolean seEstaJugandoConFlor(){
        return flor;
    }

    public void cambiarEstado(EstadoPartidaTerminada estadoPartidaTerminada) {
        estadoDePartida = estadoPartidaTerminada;
    }

    public EstadoDePartida obtenerEstado() {
        return estadoDePartida;
    }

    public Equipo obtenerEquipo1() {
        return equipo1;
    }

    public Equipo obtenerEquipo2() {
        return equipo2;
    }
}
