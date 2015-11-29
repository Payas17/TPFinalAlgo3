package controles;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import modelo.Equipo;
import modelo.Jugadas.Jugada;
import modelo.Jugador;
import modelo.Mazo;
import modelo.Partida.Partida;
import modelo.ValoresTrucoYEnvido;

import javax.swing.table.TableColumn;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Augusto on 29/11/2015.
 */
public class ControlPantalla2Jugadores implements Initializable, ControladorDePantallas {


    @FXML public Button carta1;
    @FXML public Button carta2;
    @FXML public Button carta3;

    private ControladorPantallas miControlador;

    @FXML private Label lblEquipo1;
    @FXML private Label lblEquipo2;
    @FXML private RadioButton rdJugador2;
    @FXML private RadioButton rdJugador1;

    private Partida partida;
    private Jugada jugada;
    private int turnoJugador;
    private HashMap<Jugador, RadioButton> diccionarioBotones;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void accionSalir(ActionEvent event) {
        Platform.exit();
    }

    @Override
    public void setearPadreDePantalla(ControladorPantallas pantallaPadre) {
        miControlador = pantallaPadre;
        RadioButton botonFlor = miControlador.obtenerControlPantallaInicial().obtenerBotonFlor();
        inicializarPantalla2Jugadores(botonFlor);
    }

    private void inicializarPantalla2Jugadores(RadioButton botonFlor) {
        seteoDePartida(botonFlor);

    }

    private void seteoDePartida(RadioButton botonFlor) {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        partida = new Partida(equipo1, equipo2);
        turnoJugador = 0;

        diccionarioBotones = new HashMap<>();
        diccionarioBotones.put(jugador1, rdJugador1);
        diccionarioBotones.put(jugador2, rdJugador2);

        if (botonFlor.isSelected()) {
            partida.jugarConFlor();
        }

        lblEquipo1.setText(String.valueOf(equipo1.obtenerPuntos()));
        lblEquipo2.setText(String.valueOf(equipo1.obtenerPuntos()));
        rdJugador2.setDisable(true);

        jugada = partida.crearJugada();
        partida.obtenerMazo().mezclar();

        jugador1.agregarCarta(partida.obtenerMazo().darCarta());
        jugador1.agregarCarta(partida.obtenerMazo().darCarta());
        jugador1.agregarCarta(partida.obtenerMazo().darCarta());

        jugador2.agregarCarta(partida.obtenerMazo().darCarta());
        jugador2.agregarCarta(partida.obtenerMazo().darCarta());
        jugador2.agregarCarta(partida.obtenerMazo().darCarta());

        carta1.setText(String.valueOf(jugador1.obtenerCartasEnMano().get(0).obtenerNumeroDeCarta()) + " de " + (jugador1.obtenerCartasEnMano().get(0).getClass().getSimpleName()));
        carta2.setText(String.valueOf(jugador1.obtenerCartasEnMano().get(1).obtenerNumeroDeCarta()) + " de " + (jugador1.obtenerCartasEnMano().get(1).getClass().getSimpleName()));
        carta3.setText(String.valueOf(jugador1.obtenerCartasEnMano().get(2).obtenerNumeroDeCarta()) + " de " + (jugador1.obtenerCartasEnMano().get(2).getClass().getSimpleName()));

    }

    @FXML
    public void irAPantallaInicial(ActionEvent actionEvent) {
        miControlador.setearPantalla(FrameworkDePantalla.obtenerPantallaInicial());
    }

    public void pasarElTurno(ActionEvent actionEvent) {

        List<Jugador> orden = jugada.obtenerOrdenJugadoresMano();
        turnoJugador++;

        Jugador jugadorQueJuega = orden.get(turnoJugador);

        diccionarioBotones.get(jugadorQueJuega).setDisable(false);
        diccionarioBotones.get(jugadorQueJuega).setSelected(true);

      //  if (turnoJugador > orden.size()) {
            // jugada.jugarMano();
      //  }

        for (Jugador jugadorActual : orden) {
            if (jugadorActual != jugadorQueJuega) {
                diccionarioBotones.get(jugadorActual).setDisable(true);
            }
        }

        carta1.setText(String.valueOf(jugadorQueJuega.obtenerCartasEnMano().get(0).obtenerNumeroDeCarta()) + " de " + (jugadorQueJuega.obtenerCartasEnMano().get(0).getClass().getSimpleName()));
        carta2.setText(String.valueOf(jugadorQueJuega.obtenerCartasEnMano().get(1).obtenerNumeroDeCarta()) + " de " + (jugadorQueJuega.obtenerCartasEnMano().get(1).getClass().getSimpleName()));
        carta3.setText(String.valueOf(jugadorQueJuega.obtenerCartasEnMano().get(2).obtenerNumeroDeCarta()) + " de " + (jugadorQueJuega.obtenerCartasEnMano().get(2).getClass().getSimpleName()));

    }
}

