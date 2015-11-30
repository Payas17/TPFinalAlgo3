package controles.Configuraciones;

import controles.ControlPantalla2Jugadores;
import modelo.EstadoTruco.EstadoReTruco;
import modelo.EstadoTruco.EstadoSinTruco;
import modelo.EstadoTruco.EstadoTruco;
import modelo.EstadoTruco.EstadoValeCuatro;

/**
 * Created by Payas on 30/11/2015.
 */
public interface Configuracion {

    void setearConfiguaracionBotones(ControlPantalla2Jugadores control);
/*
    void botonesTruco(ControlPantalla2Jugadores control,EstadoTruco estado);

    void botonesTruco(ControlPantalla2Jugadores control,EstadoSinTruco estado);

    void botonesTruco(ControlPantalla2Jugadores control,EstadoReTruco estado);

    void botonesTruco(ControlPantalla2Jugadores control,EstadoValeCuatro estado);
   */
}
