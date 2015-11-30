package controles.Configuraciones;

import controles.ControlPantalla2Jugadores;
import modelo.EstadoTruco.EstadoReTruco;
import modelo.EstadoTruco.EstadoSinTruco;
import modelo.EstadoTruco.EstadoTruco;
import modelo.EstadoTruco.EstadoValeCuatro;

/**
 * Created by Payas on 30/11/2015.
 */
public class configuracionJugadaPie implements Configuracion{
    @Override
    public void setearConfiguaracionBotones(ControlPantalla2Jugadores control) {

        control.obtenerBotonTruco().setDisable(false);
        control.obtenerBotonReTruco().setDisable(false);
        control.obtenerBotonVale4().setDisable(false);
        control.obtenerBotonEnvido().setDisable(false);
        control.obtenerBotonRealEnvido().setDisable(false);
        control.obtenerBotonFaltaEnvido().setDisable(false);
        control.obtenerBotonContraFlor().setDisable(true);
        control.obtenerBotonContraFlorAlResto().setDisable(true);
        control.obtenerBotonAceptarTruco().setDisable(true);
        control.obtenerBotonNoAceptarTruco().setDisable(true);
        control.obtenerBotonAceptarEnvido().setDisable(true);
        control.obtenerBotonAceptarFlor().setDisable(true);
        control.obtenerBotonNoAceptarFlor().setDisable(true);
        control.obtenerBotonNoAceptarEnvido().setDisable(true);
        control.obtenerBotonIrseAlMazo().setDisable(false);
        control.obtenerBotonFlor().setDisable(false);
        control.desactivarBotonesCarta(false);
        control.obtenerBotonPasarTurno().setDisable(true);
    }
/*
    @Override
    public void botonesTruco(ControlPantalla2Jugadores control, EstadoTruco estado) {

    }

    @Override
    public void botonesTruco(ControlPantalla2Jugadores control, EstadoSinTruco estado) {

    }

    @Override
    public void botonesTruco(ControlPantalla2Jugadores control, EstadoReTruco estado) {

    }

    @Override
    public void botonesTruco(ControlPantalla2Jugadores control, EstadoValeCuatro estado) {

    }*/
}
