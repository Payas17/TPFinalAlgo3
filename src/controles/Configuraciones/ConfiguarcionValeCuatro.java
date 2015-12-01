package controles.Configuraciones;

import controles.ControlPantalla2Jugadores;
import controles.ControladorDePantallas;

/**
 * Created by Payas on 30/11/2015.
 */
public class ConfiguarcionValeCuatro implements Configuracion {

    @Override
    public void setearConfiguaracionBotones(ControladorDePantallas control) {

        control.obtenerBotonTruco().setDisable(true);
        control.obtenerBotonReTruco().setDisable(true);
        control.obtenerBotonVale4().setDisable(true);

    }
}
