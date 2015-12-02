package controles.Configuraciones;

import controles.Configuraciones.Configuracion;
import controles.ControladorDePantallas;
import modelo.Jugador;

/**
 * Created by Payas on 01/12/2015.
 */
public class ConfiguarcionJugadoPuedeCantarFlor implements Configuracion {
    @Override
    public void setearConfiguaracionBotones(ControladorDePantallas control) {


        for(Jugador jugador: control.obtenerJugada().obtenerEquipoQueContieneJugador(control.obtenerJugadorQueContesta()).obtenerIntegrantes() ) {

            if (jugador.tieneFlor()) {

                control.obtenerBotonContraFlor().setDisable(false);
                control.obtenerBotonContraFlorAlResto().setDisable(false);
                control.obtenerBotonAceptarFlor().setDisable(false);
                break;
            } else {

                control.obtenerBotonContraFlor().setDisable(true);
                control.obtenerBotonContraFlorAlResto().setDisable(true);
                control.obtenerBotonAceptarFlor().setDisable(true);

            }
        }
        control.obtenerBotonFlor().setDisable(true);
        control.obtenerBotonNoAceptarFlor().setDisable(false);
        control.obtenerBotonTruco().setDisable(true);
        control.desactivarBotonesCarta(true);
        control.obtenerBotonIrseAlMazo().setDisable(true);
        control.desactivarBotonesTruco();

    }
}
