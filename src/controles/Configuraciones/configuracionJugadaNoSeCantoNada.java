package controles.Configuraciones;

import controles.ControlPantalla2Jugadores;
import controles.ControladorDePantallas;
import modelo.EstadoTruco.*;

/**
 * Created by Payas on 30/11/2015.
 */
public class configuracionJugadaNoSeCantoNada implements Configuracion {
    @Override
    public void setearConfiguaracionBotones(ControladorDePantallas control) {

        control.obtenerBotonTruco().setDisable(false);
        control.obtenerBotonReTruco().setDisable(true);
        control.obtenerBotonVale4().setDisable(true);
        control.desactivarBotonesEnvido();
        control.obtenerBotonIrseAlMazo().setDisable(false);
        control.desactivarBotonesCarta(false);
        control.obtenerBotonPasarTurno().setDisable(true);
    }

}

