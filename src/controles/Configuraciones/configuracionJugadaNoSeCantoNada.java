package controles.Configuraciones;

import controles.ControlPantalla2Jugadores;
import modelo.EstadoTruco.*;

/**
 * Created by Payas on 30/11/2015.
 */
public class configuracionJugadaNoSeCantoNada implements Configuracion {
    @Override
    public void setearConfiguaracionBotones(ControlPantalla2Jugadores control) {

        control.obtenerBotonTruco().setDisable(false);
        control.obtenerBotonReTruco().setDisable(true);
        control.obtenerBotonVale4().setDisable(true);
        control.desactivarBotonesEnvido();
        control.obtenerBotonIrseAlMazo().setDisable(false);
        control.desactivarBotonesCarta(false);
        control.obtenerBotonPasarTurno().setDisable(true);
    }
/*
    @Override
    public void botonesTruco(ControlPantalla2Jugadores control, EstadoTruco estado) {
        control.obtenerBotonTruco().setDisable(true);
        control.obtenerBotonReTruco().setDisable(false);
        control.obtenerBotonVale4().setDisable(true);
    }

    @Override
    public void botonesTruco(ControlPantalla2Jugadores control, EstadoSinTruco estado) {
        control.obtenerBotonTruco().setDisable(false);
        control.obtenerBotonReTruco().setDisable(true);
        control.obtenerBotonVale4().setDisable(true);

    }

    @Override
    public void botonesTruco(ControlPantalla2Jugadores control, EstadoReTruco estado) {
        control.obtenerBotonTruco().setDisable(true);
        control.obtenerBotonReTruco().setDisable(true);
        control.obtenerBotonVale4().setDisable(false);

    }

    @Override
    public void botonesTruco(ControlPantalla2Jugadores control, EstadoValeCuatro estado) {
        control.obtenerBotonTruco().setDisable(true);
        control.obtenerBotonReTruco().setDisable(true);
        control.obtenerBotonVale4().setDisable(true);

    }*/
}

