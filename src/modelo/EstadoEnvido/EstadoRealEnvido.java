package modelo.EstadoEnvido;

import modelo.Equipo;
import modelo.Errores.NoSePuedeCantarEsoError;
import modelo.Jugadas.Jugada;
import modelo.Jugadas.JugadaPicaPica;


/**
 * Created by Augusto on 14/11/2015.
 */
public class EstadoRealEnvido implements EstadoDeEnvido {

    private final int PUNTOS = 3;

    @Override
    public void cantarEnvido(Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }


    @Override
    public void cantarRealEnvido(Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void cantarFaltaEnvido(Jugada jugada) {
        jugada.sumarPuntosEnvido(jugada.obtenerEstadoEnvido().obtenerPuntos());
        jugada.cambiarEstadoEnvido(new EstadoFaltaEnvido());
    }

    @Override
    public int obtenerPuntos() {
        return PUNTOS;
    }

    @Override
    public void cantarFlor(Jugada jugada) {
        jugada.cambiarEstadoEnvido(new EstadoFlor());
    }

    @Override
    public void cantarContraFlor(Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void cantarContraFlorAlResto(Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void aceptarFlor(Equipo equipo1, Equipo equipo2, Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void noAceptarFlor(Equipo equipo, Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void aceptarEnvido(Jugada jugada) {
        jugada.obtenerEquipoGanadorEnvido().sumarPuntos(jugada.obtenerPuntosEnvido() + PUNTOS);
    }

    @Override
    public void noAceptarEnvido(Equipo equipoGanador, Jugada jugada) {
       if(jugada.obtenerPuntosEnvido() == 0){
           equipoGanador.sumarPuntos(1);
       }
        equipoGanador.sumarPuntos(jugada.obtenerPuntosEnvido());

    }

    @Override
    public void cantarFaltaEnvidoPicaPica(JugadaPicaPica jugadaPicaPica) {
        jugadaPicaPica.sumarPuntosEnvido(jugadaPicaPica.obtenerEstadoEnvido().obtenerPuntos());
        jugadaPicaPica.cambiarEstadoEnvido(new EstadoFaltaEnvidoPicaPica());
    }

    @Override
    public void cantarContraFlorAlRestoPicaPica(JugadaPicaPica jugadaPicaPica) {
        throw new NoSePuedeCantarEsoError();
    }
}