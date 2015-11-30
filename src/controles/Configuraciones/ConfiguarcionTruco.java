package controles.Configuraciones;

import controles.ControlPantalla2Jugadores;
import modelo.EstadoTruco.EstadoReTruco;
import modelo.EstadoTruco.EstadoSinTruco;
import modelo.EstadoTruco.EstadoTruco;
import modelo.EstadoTruco.EstadoValeCuatro;

/**
 * Created by Payas on 30/11/2015.
 */
public class ConfiguarcionTruco implements Configuracion {
    @Override
    public void setearConfiguaracionBotones(ControlPantalla2Jugadores control) {

        control.obtenerBotonTruco().setDisable(true);
        control.obtenerBotonReTruco().setDisable(false);
        control.obtenerBotonVale4().setDisable(true);
        control.obtenerBotonAceptarTruco().setDisable(false);
        control.obtenerBotonNoAceptarTruco().setDisable(false);
        control.obtenerBotonNoAceptarEnvido().setDisable(true);
        control.obtenerBotonIrseAlMazo().setDisable(false);
        control.desactivarBotonesCarta(true);
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
