package controles.Configuraciones;

import controles.ControlPantalla2Jugadores;

/**
 * Created by Payas on 30/11/2015.
 */
public class ConfiguarcionReTruco implements Configuracion {
    @Override
    public void setearConfiguaracionBotones(ControlPantalla2Jugadores control) {

        control.obtenerBotonTruco().setDisable(true);
        control.obtenerBotonReTruco().setDisable(true);
    }
}
