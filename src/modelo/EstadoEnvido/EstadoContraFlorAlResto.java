package modelo.EstadoEnvido;

import modelo.Equipo;
import modelo.Errores.NoSePuedeCantarEsoError;
import modelo.Jugadas.Jugada;
import modelo.Jugadas.JugadaPicaPica;


/**
 * Created by Payas on 21/11/2015.
 */
public class EstadoContraFlorAlResto implements EstadoDeEnvido {

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
    public int obtenerPuntos() {

        return 0;
    }

    @Override
    public void cantarFlor(Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
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
        jugada.obtenerEquipoGanadorFlor(equipo1,equipo2).sumarPuntos(30 - jugada.obtenerEquipoQueNoContieneJugador(jugada.obtenerJugadorGanadorFlor()).obtenerPuntos());
    }

    @Override
    public void noAceptarFlor(Equipo equipo, Jugada jugada) {
        equipo.sumarPuntos(jugada.obtenerPuntosEnvido());
    }

    @Override
    public void aceptarEnvido(Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void noAceptarEnvido(Equipo equipoGanador, Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void cantarFaltaEnvidoPicaPica(JugadaPicaPica jugadaPicaPica) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void cantarContraFlorAlRestoPicaPica(JugadaPicaPica jugadaPicaPica) {
        throw new NoSePuedeCantarEsoError();
    }
}
