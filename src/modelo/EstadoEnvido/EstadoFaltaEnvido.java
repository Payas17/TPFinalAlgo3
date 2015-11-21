package modelo.EstadoEnvido;

import modelo.Equipo;
import modelo.Errores.NoSePuedeCantarEsoError;
import modelo.Jugada;
import modelo.Jugador;

/**
 * Created by Augusto on 14/11/2015.
 */
public class EstadoFaltaEnvido implements EstadoDeEnvido{

    final int PUNTOS =30;
    @Override
    public void cantarEnvido(Jugada jugada) {throw new NoSePuedeCantarEsoError(); }

    @Override
    public void cantarRealEnvido(Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void cantarFaltaEnvido(Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void aceptarEnvido(Jugada jugada) {
        Equipo equipoPerdedor = jugada.obtenerEquipoQueNoContieneJugador(jugada.obtenerJugadorGanadorEnvido());
        jugada.cambiarEstadoEnvido(new EstadoNoSePuedeCantarEnvido());
        if( equipoPerdedor.obtenerPuntos() > 15){
            int maxPuntaje = Math.max(jugada.obtenerEquipoGanadorEnvido().obtenerPuntos(), equipoPerdedor.obtenerPuntos());
            jugada.obtenerEquipoGanadorEnvido().sumarPuntos(30 - maxPuntaje);

        }
        else{
            jugada.obtenerEquipoGanadorEnvido().sumarPuntos(15 - equipoPerdedor.obtenerPuntos());
        }
    }

    @Override
    public int obtenerPuntos() {
        return PUNTOS;
    }

    @Override
    public void noAceptarEnvido(Equipo equipoGanador,Jugada jugada) {
        equipoGanador.sumarPuntos(jugada.obtenerPuntosEnvido());
        jugada.cambiarEstadoEnvido(new EstadoNoSePuedeCantarEnvido());
    }

    @Override
    public void cantarFlor(Jugada jugada) {
        jugada.cambiarEstadoEnvido(new EstadoFlor());
    }

    @Override
    public void noAceptarFlor(Equipo equipo, Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void aceptarFlor(Equipo equipoQueCantoFlor, Equipo equipoQueNoCantoFlor,Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void contraFlor(Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void contraFlorAlResto(Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }


}
