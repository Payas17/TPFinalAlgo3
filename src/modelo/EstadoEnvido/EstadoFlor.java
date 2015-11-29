package modelo.EstadoEnvido;

import modelo.Equipo;
import modelo.Errores.NoSePuedeCantarEsoError;
import modelo.Jugadas.Jugada;
import modelo.Jugadas.JugadaPicaPica;


/**
 * Created by Lucio on 21/11/2015.
 */
public class EstadoFlor implements EstadoDeEnvido {

    private final int PUNTOS_POR_GANAR_FLOR = 4;
    private final int PUNTOS_NO_QUIERO = 3 ;
    private final int PUNTOS_POR_CANTAR_FLOR = 2;

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
        return 3;
    }

    @Override
    public void cantarFlor(Jugada jugada){
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void cantarContraFlor(Jugada jugada) {
        jugada.cambiarEstadoEnvido(new EstadoContraFlor());
    }

    @Override
    public void cantarContraFlorAlResto(Jugada jugada) {
        jugada.cambiarEstadoEnvido(new EstadoContraFlorAlResto());
    }

    @Override
    public void noAceptarFlor(Equipo equipo, Jugada jugada) {
        equipo.sumarPuntos(PUNTOS_NO_QUIERO);
    }

    @Override
    public void aceptarFlor(Equipo equipoQueCantoFlor, Equipo equipoQueNoCantoFlor,Jugada jugada) {
        jugada.obtenerEquipoGanadorFlor(equipoQueCantoFlor, equipoQueNoCantoFlor).sumarPuntos(PUNTOS_POR_GANAR_FLOR);
        equipoQueCantoFlor.sumarPuntos(PUNTOS_POR_CANTAR_FLOR);
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
        jugadaPicaPica.cambiarEstadoEnvido(new EstadoContraFlorAlRestoPicaPica());
    }

}
