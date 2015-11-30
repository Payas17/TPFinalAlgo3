package modelo.EstadoJugador;

import modelo.Equipo;
import modelo.Errores.NoSePuedeCantarEsoError;
import modelo.Errores.SoloJugadorPiePuedeCantarError;
import modelo.Jugador;

/**
 * Created by Lucio on 20/11/2015.
 */
public class EstadoNoSeCantoNada implements EstadoDeJugador {
    @Override
    public void cantarEnvido(Equipo equipoCanta, Equipo equipoQuiere) {
        throw new SoloJugadorPiePuedeCantarError();
    }

    @Override
    public void cantarFlor(Equipo equipoCanta, Equipo equipoQuiere) {
        throw new SoloJugadorPiePuedeCantarError();
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
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void jugarCarta(Jugador jugador) {
        jugador.cambiarEstadoNormal(new EstadoYaJugoCarta());
    }
}
