package controles.Configuraciones;

import controles.ControlPantalla2Jugadores;

/**
 * Created by Augusto on 30/11/2015.
 */
public class ConfiguarcionSinTruco implements Configuracion {
    @Override
    public void setearConfiguaracionBotones(ControlPantalla2Jugadores control) {

        control.obtenerBotonTruco().setDisable(false);
        control.obtenerBotonReTruco().setDisable(true);
        control.obtenerBotonVale4().setDisable(true);
        control.obtenerBotonAceptarTruco().setDisable(true);
        control.obtenerBotonNoAceptarTruco().setDisable(true);
        control.obtenerBotonNoAceptarEnvido().setDisable(true);
        control.obtenerBotonIrseAlMazo().setDisable(false);
        control.desactivarBotonesCarta(false);
        control.obtenerBotonPasarTurno().setDisable(true);
        control.desactivarBotonesEnvido();
    }
}
