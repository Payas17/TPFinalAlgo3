package controles;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Augusto on 29/11/2015.
 */
public class ControlPantallaInicial implements Initializable,ControladorDePantallas {

    private ControladorPantallas miControlador;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void setearPadreDePantalla(ControladorPantallas pantallaPadre) {
        miControlador=pantallaPadre;
    }

    @FXML
    public void irAPantalla2Jugadores(ActionEvent actionEvent) {
        miControlador.setearPantalla(FrameworkDePantalla.pantalla2Jugadores);
    }
    @FXML
    public void irAPantalla4Jugadores(ActionEvent actionEvent) {
        miControlador.setearPantalla(FrameworkDePantalla.pantalla4Jugadores);
    }
    @FXML
    public void irAPantalla6Jugadores(ActionEvent actionEvent) {
        miControlador.setearPantalla(FrameworkDePantalla.pantalla6Jugadores);
    }
}
