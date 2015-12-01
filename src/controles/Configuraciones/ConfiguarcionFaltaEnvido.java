package controles.Configuraciones;

import controles.ControlPantalla2Jugadores;
import controles.ControladorDePantallas;

/**
 * Created by Payas on 01/12/2015.
 */
public class ConfiguarcionFaltaEnvido implements Configuracion {
    @Override
    public void setearConfiguaracionBotones(ControladorDePantallas control) {
        control.desactivarBotonesTruco();
        control.desactivarBotonesEnvido();
        control.obtenerBotonAceptarEnvido().setDisable(false);
        control.obtenerBotonNoAceptarEnvido().setDisable(false);
        control.desactivarBotonesCarta(true);
    }
}
