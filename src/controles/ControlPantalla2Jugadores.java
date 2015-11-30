package controles;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import modelo.Equipo;
import modelo.Jugadas.Jugada;
import modelo.Jugador;
import modelo.Mazo;
import modelo.Partida.Partida;
import modelo.ValoresTrucoYEnvido;

import javax.swing.table.TableColumn;
import java.net.URL;
import java.util.*;

/**
 * Created by Augusto on 29/11/2015.
 */
public class ControlPantalla2Jugadores implements Initializable, ControladorDePantallas {

    @FXML public Button carta1;
    @FXML public Button carta2;
    @FXML public Button carta3;
    @FXML public Label cartaEnJuego3J1;
    @FXML public Label cartaEnJuego2J1;
    @FXML public Label cartaEnJuego1J1;
    @FXML public Label cartaEnJuego3J2;
    @FXML public Label cartaEnJuego2J2;
    @FXML public Label cartaEnJuego1J2;
    @FXML public VBox VboxJ1;
    @FXML public VBox VboxJ2;
    @FXML public Button botonPasarTurno;
    @FXML public Label lblMano;

    private ControladorPantallas miControlador;
    private List<Jugador> orden;

    @FXML private Label lblEquipo1;
    @FXML private Label lblEquipo2;
    @FXML private RadioButton rdJugador2;
    @FXML private RadioButton rdJugador1;

    private Partida partida;
    private Jugada jugada;
    private int turnoJugador;
    private HashMap<Jugador, RadioButton> diccionarioBotones;
    private Map<Jugador, VBox> diccionarioVBoxes;
    private Map<Jugador,String> diccionarioNombreJugadores;


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

        diccionarioVBoxes = new HashMap<>();
        diccionarioVBoxes.put(jugador1,VboxJ1);
        diccionarioVBoxes.put(jugador2,VboxJ2);

        diccionarioNombreJugadores = new HashMap<>();
        diccionarioNombreJugadores.put(jugador1, "Jugador 1");
        diccionarioNombreJugadores.put(jugador2,"Jugador 2");

        if (botonFlor.isSelected()) {
            partida.jugarConFlor();
        }

        lblEquipo1.setText(String.valueOf(equipo1.obtenerPuntos()));
        lblEquipo2.setText(String.valueOf(equipo2.obtenerPuntos()));
        rdJugador2.setDisable(true);

        jugada = partida.crearJugada();

        lblMano.setText(diccionarioNombreJugadores.get(jugada.obtenerOrdenJugadoresMano().get(0)));

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

        botonPasarTurno.setDisable(true);
    }

    @FXML
    public void irAPantallaInicial(ActionEvent actionEvent) {
        miControlador.setearPantalla(FrameworkDePantalla.obtenerPantallaInicial());
    }

    public void pasarElTurno(ActionEvent actionEvent) {

        carta1.setDisable(false);
        carta2.setDisable(false);
        carta3.setDisable(false);

        botonPasarTurno.setDisable(true);

        orden = jugada.obtenerOrdenJugadoresMano();
        turnoJugador++;


        if (turnoJugador >= orden.size()) {
            jugada.jugarMano();
            orden = jugada.obtenerOrdenJugadoresMano();
            turnoJugador = 0;
        }


        Jugador jugadorQueJuega = orden.get(turnoJugador);

        diccionarioBotones.get(jugadorQueJuega).setDisable(false);
        diccionarioBotones.get(jugadorQueJuega).setSelected(true);


        for (Jugador jugadorActual : orden) {
            if (jugadorActual != jugadorQueJuega) {
                diccionarioBotones.get(jugadorActual).setDisable(true);
            }
        }


        lblEquipo1.setText(String.valueOf(partida.obtenerEquipo1().obtenerPuntos()));
        lblEquipo2.setText(String.valueOf(partida.obtenerEquipo2().obtenerPuntos()));

        carta1.setText(String.valueOf(jugadorQueJuega.obtenerCartasEnMano().get(0).obtenerNumeroDeCarta()) + " de " + (jugadorQueJuega.obtenerCartasEnMano().get(0).getClass().getSimpleName()));
        carta2.setText(String.valueOf(jugadorQueJuega.obtenerCartasEnMano().get(1).obtenerNumeroDeCarta()) + " de " + (jugadorQueJuega.obtenerCartasEnMano().get(1).getClass().getSimpleName()));
        carta3.setText(String.valueOf(jugadorQueJuega.obtenerCartasEnMano().get(2).obtenerNumeroDeCarta()) + " de " + (jugadorQueJuega.obtenerCartasEnMano().get(2).getClass().getSimpleName()));


        if (jugada.estaTerminada()){
            jugada = partida.crearJugada();
            orden = jugada.obtenerOrdenJugadoresMesa();
            repartirCartas();

            limpiarLabels();

            jugadorQueJuega = orden.get(turnoJugador);

            diccionarioBotones.get(jugadorQueJuega).setDisable(false);
            diccionarioBotones.get(jugadorQueJuega).setSelected(true);

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

    private void limpiarLabels() {

        for (VBox vbox: diccionarioVBoxes.values()){
            for(Node label: vbox.getChildren()){
                ((Label) label).setText("?");
            }
        }

        lblMano.setText(diccionarioNombreJugadores.get(jugada.obtenerOrdenJugadoresMano().get(0)));

    }

    private void repartirCartas() {
        partida.obtenerMazo().mezclar();

        for (Jugador jugador : jugada.obtenerOrdenJugadoresMesa()){
            jugador.agregarCarta(partida.obtenerMazo().darCarta());
            jugador.agregarCarta(partida.obtenerMazo().darCarta());
            jugador.agregarCarta(partida.obtenerMazo().darCarta());
        }
    }

    public void jugarCarta1(ActionEvent actionEvent) {
        List<Jugador> orden = jugada.obtenerOrdenJugadoresMano();
        Jugador jugadorQueJuega = orden.get(turnoJugador);

        for (Node label : diccionarioVBoxes.get(jugadorQueJuega).getChildren()) {
            if(((Label)label).getText().equals("?")){
                jugadorQueJuega.juegaCarta(jugadorQueJuega.obtenerCartasEnMano().get(0));
                ((Label)label).setText(String.valueOf(jugadorQueJuega.obtenerCartaEnJuego().obtenerNumeroDeCarta()) + " de " + (jugadorQueJuega.obtenerCartaEnJuego().getClass().getSimpleName()));
            break;
            }

        }

        carta1.setDisable(true);
        carta2.setDisable(true);
        carta3.setDisable(true);

        botonPasarTurno.setDisable(false);
    }

    public void jugarCarta2(ActionEvent actionEvent) {
        List<Jugador> orden = jugada.obtenerOrdenJugadoresMano();
        Jugador jugadorQueJuega = orden.get(turnoJugador);

        for (Node label : diccionarioVBoxes.get(jugadorQueJuega).getChildren()) {
            if(((Label)label).getText().equals("?")){
                jugadorQueJuega.juegaCarta(jugadorQueJuega.obtenerCartasEnMano().get(1));
                ((Label)label).setText(String.valueOf(jugadorQueJuega.obtenerCartaEnJuego().obtenerNumeroDeCarta()) + " de " + (jugadorQueJuega.obtenerCartaEnJuego().getClass().getSimpleName()));
                break;
            }

        }
        carta1.setDisable(true);
        carta2.setDisable(true);
        carta3.setDisable(true);

        botonPasarTurno.setDisable(false);
    }

    public void jugarCarta3(ActionEvent actionEvent) {
        List<Jugador> orden = jugada.obtenerOrdenJugadoresMano();
        Jugador jugadorQueJuega = orden.get(turnoJugador);

        for (Node label : diccionarioVBoxes.get(jugadorQueJuega).getChildren()) {
            if(((Label)label).getText().equals("?")){
                jugadorQueJuega.juegaCarta(jugadorQueJuega.obtenerCartasEnMano().get(2));
                ((Label)label).setText(String.valueOf(jugadorQueJuega.obtenerCartaEnJuego().obtenerNumeroDeCarta()) + " de " + (jugadorQueJuega.obtenerCartaEnJuego().getClass().getSimpleName()));
                break;
            }

        }
        carta1.setDisable(true);
        carta2.setDisable(true);
        carta3.setDisable(true);

        botonPasarTurno.setDisable(false);
    }
}

