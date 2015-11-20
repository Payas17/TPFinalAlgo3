package modelo.EstadoEnvido;

import modelo.Equipo;
import modelo.Errores.NoSePuedeCantarEsoError;
import modelo.Jugada;

/**
 * Created by Lucio on 18/11/2015.
 */
public class EstadoNoSePuedeCantarEnvido implements EstadoDeEnvido {
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
    public void noAceptarEnvido(Equipo equipoGanador,Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }
}
