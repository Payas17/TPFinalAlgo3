package modelo.EstadoJugador;

import modelo.Equipo;
import modelo.Errores.NoSePuedeCantarEsoError;
import modelo.Errores.NoSePuedeJugarCarta;
import modelo.Errores.NoTienElQuieroError;
import modelo.Jugada.Jugada;
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
        throw new NoTienElQuieroError();
    }

    @Override
    public void aceptar(Jugada jugada) {
        for (Jugador jugador :jugada.obtenerEquipo1().obtenerIntegrantes()){
            jugador.cambiarEstado(new EstadoPie());
        }

        for (Jugador jugador : jugada.obtenerEquipo2().obtenerIntegrantes()){
            jugador.cambiarEstado(new EstadoPie());
        }

    }

    @Override
    public void jugarCarta(Jugador jugador) {
        throw new NoSePuedeJugarCarta();
    }
}
