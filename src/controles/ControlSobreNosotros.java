package controles;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Augusto on 01/12/2015.
 */
public class ControlSobreNosotros extends ControladorDePantallas implements Initializable {
    ControladorPantallas miControlador;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    @Override
    void irAPantallaInicial(ActionEvent actionEvent) {

        miControlador.setearPantalla(FrameworkDePantalla.obtenerPantallaInicial());
    }

    @Override
    public void setearPadreDePantalla(ControladorPantallas unaPantalla) {
        miControlador = unaPantalla;
    }
}
