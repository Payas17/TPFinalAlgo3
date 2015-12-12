package controles;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import vista.FrameworkDePantalla;

/**
 * Created by Augusto on 01/12/2015.
 */
public class ControlPantallaGanador extends ControladorDePantallas{

@FXML
    public Label lblEquipoGanador;


    @Override
    void seteoDePartida() {

    }

    @FXML
    @Override
    public void irAPantallaInicial(ActionEvent actionEvent) {

        miControlador.setearPantalla(FrameworkDePantalla.obtenerPantallaInicial());
    }

    @FXML
    public void setearGanador(String nombre) {

        lblEquipoGanador.setText(nombre);
    }
}
