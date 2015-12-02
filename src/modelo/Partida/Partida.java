package modelo.Partida;

import modelo.*;
import modelo.Jugadas.Jugada;
import modelo.Jugadas.JugadaPicaPica;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Augusto on 18/11/2015.
 */
public class Partida {
    private final int MAX_PUNTAJE_PARTIDA = 30;
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


    public void calcularPuntosPicaPica(JugadaPicaPica jugada) {
        if (equipo1.contieneJugador(jugada.obtenerEquipo1().obtenerIntegrantes().get(0))) {
            equipo1.sumarPuntos(jugada.obtenerEquipo1().obtenerPuntos());
            equipo2.sumarPuntos(jugada.obtenerEquipo2().obtenerPuntos());
        }else{
            equipo2.sumarPuntos(jugada.obtenerEquipo1().obtenerPuntos());
            equipo1.sumarPuntos(jugada.obtenerEquipo2().obtenerPuntos());
        }

        if (equipo1.obtenerPuntos() >= MAX_PUNTAJE_PARTIDA || equipo2.obtenerPuntos() >= MAX_PUNTAJE_PARTIDA ){
            cambiarEstado(new EstadoPartidaTerminada());
        }
    }



    public void borrarPuntosPicaPica(Jugada jugada){
        jugada.obtenerEquipo1().borrarPuntos();
        jugada.obtenerEquipo2().borrarPuntos();

    }

    public JugadaPicaPica crearJugadaPicaPica() {
        return new JugadaPicaPica(this,ordenJugadores);
    }

    public Mazo obtenerMazo() {
        return mazoDeCartas;
    }

    public boolean estaTerminada(){
        return estadoDePartida.getClass() == EstadoPartidaTerminada.class;
    }

    public Equipo obtenerGanador(){
        return (equipo1.obtenerPuntos() >= 30) ? equipo1 : equipo2;
    }

    public boolean esConFlor(){
        return flor;
    }


}
