package modelo.EstadoEnvido;

import modelo.Equipo;
import modelo.Errores.NoSePuedeCantarEsoError;
import modelo.Jugadas.Jugada;
import modelo.Jugadas.JugadaPicaPica;


/**
 * Created by Augusto on 22/11/2015.
 */
public class EstadoContraFlorAlRestoPicaPica extends EstadoContraFlorAlResto {

    private final int MAX_CONTRA_FLOR_PICAPICA = 6;

    @Override
    public void cantarContraFlorAlRestoPicaPica(JugadaPicaPica jugadaPicaPica) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void aceptarFlor(Equipo equipo1, Equipo equipo2, Jugada jugada) {
        jugada.obtenerEquipoGanadorFlor(equipo1,equipo2).sumarPuntos(MAX_CONTRA_FLOR_PICAPICA);
    }
}
