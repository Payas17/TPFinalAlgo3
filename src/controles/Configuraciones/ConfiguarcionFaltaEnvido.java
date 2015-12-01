package controles.Configuraciones;

import controles.ControlPantalla2Jugadores;

/**
 * Created by Payas on 01/12/2015.
 */
public class ConfiguarcionFaltaEnvido implements Configuracion {
    @Override
    public void setearConfiguaracionBotones(ControlPantalla2Jugadores control) {
        control.desactivarBotonesTruco();
        control.desactivarBotonesEnvido();
        control.obtenerBotonAceptarEnvido().setDisable(false);
        control.obtenerBotonNoAceptarEnvido().setDisable(false);
        control.desactivarBotonesCarta(true);
    }
}
