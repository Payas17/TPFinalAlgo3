package modelo.Partida;

import modelo.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Augusto on 18/11/2015.
 */
public class Partida {
   private Equipo equipo1;
    private Equipo equipo2;
    private Mazo mazoDeCartas;
    private List<Object> jugadas;
    private EstadoDePartida estadoDePartida;
    private boolean flor;
    private List<Jugador> ordenJugadores;

    public Partida(Equipo equipo1,Equipo equipo2){
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        jugadas = new ArrayList<>();
        mazoDeCartas = new Mazo(new ValoresTrucoYEnvido());
        flor = false;
        estadoDePartida = new EstadoPartidaNormal();
        ordenJugadores = new ArrayList();

        for (int i = 0; i < equipo1.obtenerIntegrantes().size(); i++) {
            ordenJugadores.add(this.equipo1.obtenerIntegrantes().get(i));
            ordenJugadores.add(this.equipo2.obtenerIntegrantes().get(i));
        }
    }

    public void jugarConFlor(){
        flor = true;
    }

    public Jugada crearJugada(){
        Jugada jugada = new Jugada(this,mazoDeCartas, ordenJugadores);

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
