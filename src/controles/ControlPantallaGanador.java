package controles;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Created by Augusto on 01/12/2015.
 */
public class ControlPantallaGanador extends ControladorDePantallas{

@FXML
    public Label lblEquipoGanador;

    @Override
    void setearPadreDePantalla(ControladorPantallas unaPantalla) {
        miControlador = unaPantalla;
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
