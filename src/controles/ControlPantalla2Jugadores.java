package controles;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import modelo.Equipo;
import modelo.Jugador;
import modelo.Mazo;
import modelo.Partida.Partida;
import modelo.ValoresTrucoYEnvido;

import javax.swing.table.TableColumn;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Augusto on 29/11/2015.
 */
public class ControlPantalla2Jugadores implements Initializable, ControladorDePantallas{

    private ControladorPantallas miControlador;
    @FXML private Label lblEquipo1;
    @FXML private Label lblEquipo2;
    @FXML private RadioButton rdJugador2;


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
        inicializarPantalla2Jugadores();
    }

    private void inicializarPantalla2Jugadores() {
        seteoDePartida();

    }

    private void seteoDePartida() {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        Partida partida = new Partida(equipo1, equipo2);
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Mazo mazoDeCartas = new Mazo(valoresTrucoYEnvido);
        lblEquipo1.setText(String.valueOf(equipo1.obtenerPuntos()));
        lblEquipo2.setText(String.valueOf(equipo1.obtenerPuntos()));
        rdJugador2.setDisable(true);
    }

    @FXML
    public void irAPantallaInicial(ActionEvent actionEvent) {
        miControlador.setearPantalla(FrameworkDePantalla.pantallaInicial);
    }
}

