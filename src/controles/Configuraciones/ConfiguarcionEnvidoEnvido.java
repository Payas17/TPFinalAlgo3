package controles.Configuraciones;

import controles.ControlPantalla2Jugadores;
import controles.ControladorDePantallas;

/**
 * Created by Payas on 01/12/2015.
 */
public class ConfiguarcionEnvidoEnvido implements Configuracion {
    @Override
    public void setearConfiguaracionBotones(ControladorDePantallas control) {

        control.obtenerBotonEnvido().setDisable(true);
        control.obtenerBotonRealEnvido().setDisable(false);
        control.obtenerBotonFaltaEnvido().setDisable(false);
        control.obtenerBotonAceptarEnvido().setDisable(false);
        control.obtenerBotonNoAceptarEnvido().setDisable(false);
        control.desactivarBotonesCarta(true);
        control.obtenerBotonFlor().setDisable(true);
        control.desactivarBotonesTruco();
    }
}
