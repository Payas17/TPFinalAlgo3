package controles.Configuraciones;

import controles.ControlPantalla2Jugadores;
import controles.ControladorDePantallas;

/**
 * Created by Augusto on 30/11/2015.
 */
public class ConfiguarcionSinTruco implements Configuracion {
    @Override
    public void setearConfiguaracionBotones(ControladorDePantallas control) {

        control.obtenerBotonTruco().setDisable(false);
        control.obtenerBotonReTruco().setDisable(true);
        control.obtenerBotonVale4().setDisable(true);
        control.obtenerBotonAceptarTruco().setDisable(true);
        control.obtenerBotonNoAceptarTruco().setDisable(true);

    }
}
