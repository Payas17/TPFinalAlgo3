package modelo.EstadoJugador;

import modelo.Equipo;
import modelo.Jugador;

/**
 * Created by Payas on 19/11/2015.
 */
public class EstadoPuedeCantar implements EstadoDeJugador{
    @Override
    public void cantar(Equipo equipoCanta, Equipo equipoQuiere) {

        for (Jugador jugador : equipoCanta.obtenerIntegrantes()){
            jugador.cambiarEstado(new EstadoNoPuedeCantar());
        }

        for (Jugador jugador : equipoQuiere.obtenerIntegrantes()){
            jugador.cambiarEstado(new EstadoPuedeCantar());
        }
    }

    @Override
    public void aceptar() {

    }
}
