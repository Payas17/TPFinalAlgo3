package controles;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Augusto on 29/11/2015.
 */
public class ControlPantallaInicial implements Initializable,ControladorDePantallas {

    private ControladorPantallas miControlador;

    @FXML private RadioButton rdFlor;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void setearPadreDePantalla(ControladorPantallas pantallaPadre) {

        miControlador = pantallaPadre;

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

    public RadioButton obtenerBotonFlor() {
        return rdFlor;
    }

}
