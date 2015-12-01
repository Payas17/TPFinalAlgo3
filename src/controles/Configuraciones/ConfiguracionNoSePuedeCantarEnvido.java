package controles.Configuraciones;

import controles.ControlPantalla2Jugadores;

/**
 * Created by Payas on 01/12/2015.
 */
public class ConfiguracionNoSePuedeCantarEnvido implements Configuracion {
    @Override
    public void setearConfiguaracionBotones(ControlPantalla2Jugadores control) {
        control.desactivarBotonesEnvido();
    }
}
