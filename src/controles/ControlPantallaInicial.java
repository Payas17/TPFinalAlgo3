package controles;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import vista.FrameworkDePantalla;

/**
 * Created by Augusto on 29/11/2015.
 */
public class ControlPantallaInicial extends ControladorDePantallas {

    public RadioButton rdSinFlor;
    private ControladorPantallas miControlador;

    @FXML private RadioButton rdFlor;



    @Override
    public void setearPadreDePantalla(ControladorPantallas pantallaPadre) {

        miControlador = pantallaPadre;

    }

    @Override
    void seteoDePartida() {

    }

    @FXML
    public void irAPantalla2Jugadores(ActionEvent actionEvent) {
        miControlador.setearPantalla(FrameworkDePantalla.obtenerPantalla2Jugadores());
    }
    @FXML
    public void irAPantalla4Jugadores(ActionEvent actionEvent) {
        miControlador.setearPantalla(FrameworkDePantalla.obtenerPantalla4Jugadores());
    }
    @FXML
    public void irAPantalla6Jugadores(ActionEvent actionEvent) {
        miControlador.setearPantalla(FrameworkDePantalla.obtenerPantalla6Jugadores());
    }

    public void partidaConFlor(ActionEvent actionEvent) {

        miControlador.obtenerControlPantalla2Jugadores().setearConFlor();
        miControlador.obtenerControlPantalla4Jugadores().setearConFlor();
        miControlador.obtenerControlPantalla6Jugadores().setearConFlor();
        miControlador.obtenerControlPantallaJugadorIA().setearConFlor();

    }

    public void partidaSinFlor(ActionEvent actionEvent) {

        miControlador.obtenerControlPantalla2Jugadores().setearSinFlor();
        miControlador.obtenerControlPantalla4Jugadores().setearSinFlor();
        miControlador.obtenerControlPantalla6Jugadores().setearSinFlor();
        miControlador.obtenerControlPantallaJugadorIA().setearSinFlor();
    }

    @FXML
    public void irASobreNosotros(ActionEvent actionEvent) {
        miControlador.setearPantalla(FrameworkDePantalla.obtenerPantallaSobreNosotros());
    }

    public void setearBotonEnSinFlor(){
        rdSinFlor.setSelected(true);
        rdFlor.setSelected(false);
    }

    public void irAPantallaJugadorIA(ActionEvent actionEvent) {
        miControlador.setearPantalla(FrameworkDePantalla.obtenerPantallaJugadorIA());
    }
}
