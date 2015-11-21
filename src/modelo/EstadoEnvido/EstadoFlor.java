package modelo.EstadoEnvido;

import modelo.Equipo;
import modelo.Errores.NoSePuedeCantarEsoError;
import modelo.Errores.NoTieneFlorError;
import modelo.Jugada;
import modelo.Jugador;

/**
 * Created by Lucio on 21/11/2015.
 */
public class EstadoFlor implements EstadoDeEnvido {

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
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void aceptarEnvido(Equipo equipoGanador, Equipo equipoPerdedor, Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public int obtenerPuntos() {
        return 0;
    }

    @Override
    public void noAceptarEnvido(Equipo equipoGanador, Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }

    public void cantarFlor(Jugada jugada){
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void noAceptarFlor(Equipo equipo, Jugada jugada) {
        jugada.cambiarEstadoEnvido(new EstadoNoSePuedeCantarEnvido());
        equipo.sumarPuntos(3);
    }

    @Override
    public void aceptarFlor(Equipo equipoQueCantoFlor, Equipo equipoQueNoCantoFlor,Jugada jugada) {
        jugada.obtenerEquipoGanadorFlor(equipoQueCantoFlor,equipoQueNoCantoFlor).sumarPuntos(4);
        equipoQueCantoFlor.sumarPuntos(2);
        jugada.cambiarEstadoEnvido(new EstadoNoSePuedeCantarEnvido());
    }
}
