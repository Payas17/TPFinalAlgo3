package controles.Configuraciones;

import controles.Configuraciones.Configuracion;
import controles.ControlPantalla2Jugadores;
import controles.ControladorDePantallas;
import modelo.Jugador;

/**
 * Created by Payas on 01/12/2015.
 */
public class ConfiguarcionPuedeCantarEnvido implements Configuracion {
    @Override
    public void setearConfiguaracionBotones(ControladorDePantallas control) {

        control.obtenerBotonEnvido().setDisable(false);
        control.obtenerBotonRealEnvido().setDisable(false);
        control.obtenerBotonFaltaEnvido().setDisable(false);
        control.obtenerBotonAceptarEnvido().setDisable(false);
        control.obtenerBotonNoAceptarEnvido().setDisable(false);

        for(Jugador jugador: control.obtenerJugada().obtenerEquipoQueContieneJugador(control.obtenerJugadorQueContesta()).obtenerIntegrantes() ) {

            if (jugador.tieneFlor()) {
                control.obtenerBotonFlor().setDisable(false);
                control.obtenerBotonContraFlor().setDisable(false);
                control.obtenerBotonContraFlorAlResto().setDisable(false);
                control.obtenerBotonAceptarFlor().setDisable(false);
                break;
            } else {
                control.obtenerBotonFlor().setDisable(true);
                control.obtenerBotonContraFlor().setDisable(true);
                control.obtenerBotonContraFlorAlResto().setDisable(true);
                control.obtenerBotonAceptarFlor().setDisable(true);

            }
        }
    }
}
