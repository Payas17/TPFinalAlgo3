package controles.Configuraciones;

import controles.ControlPantalla2Jugadores;
import controles.ControladorDePantallas;

/**
 * Created by Payas on 30/11/2015.
 */
public class ConfiguracionJugadaPuedeCantarTruco implements Configuracion {

    @Override
    public void setearConfiguaracionBotones(ControladorDePantallas control) {

        control.obtenerBotonTruco().setDisable(true);
        control.obtenerBotonReTruco().setDisable(false);
        control.obtenerBotonVale4().setDisable(false);
        control.obtenerBotonEnvido().setDisable(true);
        control.obtenerBotonRealEnvido().setDisable(true);
        control.obtenerBotonFaltaEnvido().setDisable(true);
        control.obtenerBotonContraFlor().setDisable(true);
        control.obtenerBotonContraFlorAlResto().setDisable(true);
        control.obtenerBotonAceptarTruco().setDisable(false);
        control.obtenerBotonNoAceptarTruco().setDisable(false);
        control.obtenerBotonAceptarEnvido().setDisable(true);
        control.obtenerBotonAceptarFlor().setDisable(true);
        control.obtenerBotonNoAceptarFlor().setDisable(true);
        control.obtenerBotonNoAceptarEnvido().setDisable(true);
        control.obtenerBotonIrseAlMazo().setDisable(true);
        control.obtenerBotonFlor().setDisable(true);
        control.desactivarBotonesCarta(true);
        control.obtenerBotonPasarTurno().setDisable(true);
    }
}
