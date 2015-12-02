package controles.Configuraciones;

import controles.ControlPantalla2Jugadores;
import controles.ControladorDePantallas;
import modelo.Jugador;

/**
 * Created by Payas on 30/11/2015.
 */
public class ConfiguracionJugadaPuedeCantarTrucoPriemraMano implements Configuracion {
    @Override
    public void setearConfiguaracionBotones(ControladorDePantallas control) {

        control.obtenerBotonTruco().setDisable(false);
        control.obtenerBotonReTruco().setDisable(false);
        control.obtenerBotonVale4().setDisable(false);
        control.obtenerBotonEnvido().setDisable(false);
        control.obtenerBotonRealEnvido().setDisable(false);
        control.obtenerBotonFaltaEnvido().setDisable(false);
        control.obtenerBotonContraFlor().setDisable(true);
        control.obtenerBotonContraFlorAlResto().setDisable(true);
        control.obtenerBotonAceptarTruco().setDisable(false);
        control.obtenerBotonNoAceptarTruco().setDisable(false);
        control.obtenerBotonAceptarEnvido().setDisable(true);
        control.obtenerBotonAceptarFlor().setDisable(true);
        control.obtenerBotonNoAceptarFlor().setDisable(true);
        control.obtenerBotonNoAceptarEnvido().setDisable(true);
        control.obtenerBotonIrseAlMazo().setDisable(true);
        control.desactivarBotonesCarta(true);
        control.obtenerBotonPasarTurno().setDisable(true);
        for(Jugador jugador: control.obtenerJugada().obtenerEquipoQueContieneJugador(control.obtenerJugadorQueContesta()).obtenerIntegrantes() ) {

            if (jugador.tieneFlor()) {
                control.obtenerBotonFlor().setDisable(false);
                break;

            } else {
                control.obtenerBotonFlor().setDisable(true);

            }
        }
    }
}
