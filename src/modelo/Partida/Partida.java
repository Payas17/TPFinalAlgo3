package modelo.Partida;

import modelo.Equipo;
import modelo.Jugada;
import modelo.Mazo;

import java.util.List;

/**
 * Created by Augusto on 18/11/2015.
 */
public class Partida {
    Equipo equipo1;
    Equipo equipo2;
    Mazo mazoDeCartas;
    List<Jugada> jugadas;
    Partida EstadoDePartida;
    boolean flor;

    public Partida(){
        flor = false;
    }

    public void jugarConFlor(){
        flor = true;
    }

    public boolean seEstaJugandoConFlor(){
        return flor;
    }
}
