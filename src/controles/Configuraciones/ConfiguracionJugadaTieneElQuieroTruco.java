package controles.Configuraciones;

import controles.ControlPantalla2Jugadores;
import modelo.EstadoTruco.EstadoTruco;

/**
 * Created by Payas on 30/11/2015.
 */
public class ConfiguracionJugadaTieneElQuieroTruco implements Configuracion {
    @Override
    public void setearConfiguaracionBotones(ControlPantalla2Jugadores control) {


        control.obtenerBotonTruco().setDisable(true);
        if (control.obtenerJugada().obtenerEstadoTruco().getClass() == EstadoTruco.class) {
            control.obtenerBotonReTruco().setDisable(false);
            control.obtenerBotonVale4().setDisable(true);
        }else{
            control.obtenerBotonReTruco().setDisable(true);
            control.obtenerBotonVale4().setDisable(false);
        }
        control.obtenerBotonAceptarTruco().setDisable(true);
        control.obtenerBotonNoAceptarTruco().setDisable(true);
        control.obtenerBotonIrseAlMazo().setDisable(false);
        control.desactivarBotonesCarta(false);
        control.obtenerBotonPasarTurno().setDisable(true);
    }
}
