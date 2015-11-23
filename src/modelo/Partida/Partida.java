package modelo.Partida;

import modelo.*;
import modelo.Jugada.Jugada;
import modelo.Jugada.JugadaPicaPica;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Augusto on 18/11/2015.
 */
public class Partida {
   private Equipo equipo1;
    private Equipo equipo2;
    private Mazo mazoDeCartas;
    private List<Jugada> jugadas;
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
        ordenJugadores = new ArrayList<>();

        for (int i = 0; i < equipo1.obtenerIntegrantes().size(); i++) {
            ordenJugadores.add(this.equipo1.obtenerIntegrantes().get(i));
            ordenJugadores.add(this.equipo2.obtenerIntegrantes().get(i));
        }
    }

    public void jugarConFlor(){
        flor = true;
    }

    public Jugada crearJugada(){
        Jugada jugada;

        jugada = new Jugada(this,ordenJugadores);
        jugadas.add(jugada);
        return jugada;
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


    public void calcularPuntosPicaPica(Jugada jugada) {
        obtenerEquipo1().sumarPuntos(jugada.obtenerEquipo1().obtenerPuntos());
        obtenerEquipo2().sumarPuntos(jugada.obtenerEquipo2().obtenerPuntos());
    }

    public JugadaPicaPica crearJugadaPicaPica() {
        return new JugadaPicaPica(this,ordenJugadores);
    }

    public Mazo obtenerMazo() {
        return mazoDeCartas;
    }
}
