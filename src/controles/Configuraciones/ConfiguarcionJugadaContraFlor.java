package controles.Configuraciones;

import controles.Configuraciones.Configuracion;
import controles.ControladorDePantallas;

/**
 * Created by Payas on 01/12/2015.
 */
public class ConfiguarcionJugadaContraFlor implements Configuracion {
    @Override
    public void setearConfiguaracionBotones(ControladorDePantallas control) {
        control.obtenerBotonNoAceptarEnvido().setDisable(true);
        control.obtenerBotonAceptarEnvido().setDisable(true);
        control.obtenerBotonEnvido().setDisable(true);
        control.obtenerBotonRealEnvido().setDisable(true);
        control.obtenerBotonFaltaEnvido().setDisable(true);
        control.obtenerBotonFlor().setDisable(true);
        control.obtenerBotonContraFlor().setDisable(true);
    }
}
