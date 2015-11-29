package controles;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Augusto on 29/11/2015.
 */
public class ControlPantalla2Jugadores implements Initializable, ControladorDePantallas{

    private ControladorPantallas miControlador;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void accionSalir(ActionEvent event){
        Platform.exit();
    }

    @Override
    public void setearPadreDePantalla(ControladorPantallas pantallaPadre) {
        miControlador=pantallaPadre;
    }

    @FXML
    public void irAPantallaInicial(ActionEvent actionEvent) {
        miControlador.setearPantalla(FrameworkDePantalla.pantallaInicial);
    }
}

