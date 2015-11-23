package modelo.EstadoJugador;

import modelo.Equipo;
import modelo.Errores.NoSePuedeJugarCarta;
import modelo.Jugada.Jugada;
import modelo.Jugador;

/**
 * Created by Payas on 19/11/2015.
 */
public class EstadoPuedeCantarTruco implements EstadoDeJugador{
    @Override
     public void cantarEnvido(Equipo equipoCanta, Equipo equipoQuiere) {

        for (Jugador jugador : equipoCanta.obtenerIntegrantes()){
            jugador.cambiarEstado(new EstadoNoPuedeCantar());
        }

        for (Jugador jugador : equipoQuiere.obtenerIntegrantes()){
            jugador.cambiarEstado(new EstadoPuedeCantarEnvido());
        }
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
