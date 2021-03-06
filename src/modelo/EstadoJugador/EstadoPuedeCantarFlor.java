package modelo.EstadoJugador;

import modelo.Equipo;
import modelo.Errores.NoSePuedeCantarEsoError;
import modelo.Errores.NoSePuedeJugarCartaError;
import modelo.Jugadas.Jugada;
import modelo.Jugador;

/**
 * Created by Lucio on 27/11/2015.
 */
public class EstadoPuedeCantarFlor implements EstadoDeJugador {
    @Override
    public void cantarEnvido(Equipo equipoCanta, Equipo equipoQuiere) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void cantarFlor(Equipo equipoCanta, Equipo equipoQuiere) {
        for (Jugador jugador : equipoCanta.obtenerIntegrantes()){
            jugador.cambiarEstado(new EstadoNoPuedeCantar());
        }

        for (Jugador jugador : equipoQuiere.obtenerIntegrantes()){
            jugador.cambiarEstado(new EstadoPuedeCantarFlor());
        }
    }

    @Override
    public void cantarTruco(Equipo equipoCanta, Equipo equipoQuiere) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void aceptar(Equipo equipoCanta, Equipo equipoQuiere) {
        for (Jugador jugador :equipoCanta.obtenerIntegrantes()){
            jugador.cambiarEstado(new EstadoNoSeCantoNada());
        }

        for (Jugador jugador : equipoQuiere.obtenerIntegrantes()){
            jugador.cambiarEstado(new EstadoNoSeCantoNada());
        }

    }

   @Override
    public void jugarCarta(Jugador jugador) {
       throw new NoSePuedeJugarCartaError();
    }
}
