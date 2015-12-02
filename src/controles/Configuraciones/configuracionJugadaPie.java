package controles.Configuraciones;

import controles.ControlPantalla2Jugadores;
import controles.ControladorDePantallas;
import modelo.EstadoTruco.EstadoReTruco;
import modelo.EstadoTruco.EstadoSinTruco;
import modelo.EstadoTruco.EstadoTruco;
import modelo.EstadoTruco.EstadoValeCuatro;
import modelo.Jugador;

/**
 * Created by Payas on 30/11/2015.
 */
public class configuracionJugadaPie implements Configuracion{
    @Override
    public void setearConfiguaracionBotones(ControladorDePantallas control) {

        control.obtenerBotonTruco().setDisable(false);
        control.obtenerBotonReTruco().setDisable(false);
        control.obtenerBotonVale4().setDisable(false);
        control.obtenerBotonEnvido().setDisable(false);
        control.obtenerBotonRealEnvido().setDisable(false);
        control.obtenerBotonFaltaEnvido().setDisable(false);
        control.obtenerBotonAceptarTruco().setDisable(true);
        control.obtenerBotonNoAceptarTruco().setDisable(true);
        control.obtenerBotonAceptarEnvido().setDisable(true);
        control.obtenerBotonNoAceptarFlor().setDisable(true);
        control.obtenerBotonNoAceptarEnvido().setDisable(true);
        control.obtenerBotonIrseAlMazo().setDisable(false);
        control.desactivarBotonesCarta(false);
        control.obtenerBotonPasarTurno().setDisable(true);
        for(Jugador jugador: control.obtenerJugada().obtenerEquipoQueContieneJugador(control.obtenerJugadorQueContesta()).obtenerIntegrantes() ) {

            if (jugador.tieneFlor()) {
                control.obtenerBotonFlor().setDisable(false);
                control.obtenerBotonContraFlor().setDisable(false);
                control.obtenerBotonContraFlorAlResto().setDisable(false);
                control.obtenerBotonAceptarFlor().setDisable(false);
                break;
            } else {
                control.obtenerBotonFlor().setDisable(true);
                control.obtenerBotonContraFlor().setDisable(true);
                control.obtenerBotonContraFlorAlResto().setDisable(true);
                control.obtenerBotonAceptarFlor().setDisable(true);

            }
        }

    }

}
