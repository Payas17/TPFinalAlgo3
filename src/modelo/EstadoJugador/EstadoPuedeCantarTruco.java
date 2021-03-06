package modelo.EstadoJugador;

import modelo.Equipo;
import modelo.Errores.NoSePuedeCantarEsoError;
import modelo.Errores.NoSePuedeJugarCartaError;
import modelo.Jugador;

/**
 * Created by Payas on 19/11/2015.
 */
public class EstadoPuedeCantarTruco implements EstadoDeJugador{
    @Override
     public void cantarEnvido(Equipo equipoCanta, Equipo equipoQuiere) {

        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void cantarFlor(Equipo equipoCanta, Equipo equipoQuiere) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void cantarTruco(Equipo equipoCanta, Equipo equipoQuiere) {

        for (Jugador jugador : equipoCanta.obtenerIntegrantes()){
            jugador.cambiarEstado(new EstadoNoPuedeCantar());
        }

        for (Jugador jugador : equipoQuiere.obtenerIntegrantes()){
            jugador.cambiarEstado(new EstadoPuedeCantarTruco());
        }
    }

    @Override
    public void aceptar(Equipo equipoCanta, Equipo equipoQuiere) {
        for (Jugador jugador :equipoCanta.obtenerIntegrantes()){
            jugador.cambiarEstado(new EstadoTieneElQuieroDelTruco());
        }

        for (Jugador jugador : equipoQuiere.obtenerIntegrantes()){
            jugador.cambiarEstado(new EstadoNoPuedeCantar());
        }

    }

    @Override
    public void jugarCarta(Jugador jugador) {
        throw new NoSePuedeJugarCartaError();
    }
}
