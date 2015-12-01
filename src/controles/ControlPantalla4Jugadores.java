package controles;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;
import modelo.Equipo;
import modelo.Jugador;
import modelo.Partida.Partida;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Augusto on 29/11/2015.
 */
public class ControlPantalla4Jugadores extends ControladorDePantallas {




    @Override
    public void setearPadreDePantalla(ControladorPantallas pantallaPadre) {

        miControlador=pantallaPadre;
        seteoDePartida();
    }

    private void seteoDePartida() {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Jugador jugador3 = new Jugador();
        Jugador jugador4 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador3);
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        jugadores2.add(jugador4);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        partida = new Partida(equipo1, equipo2);
        turnoJugador = 0;
        equipo1.setNombre("Equipo1");
        equipo2.setNombre("Equipo2");


        setearDiccionarios(jugador1, jugador2,jugador3,jugador4);


        actualizarPuntos();
        rdJugador2.setDisable(true);
        rdJugador3.setDisable(true);
        rdJugador4.setDisable(true);

        jugada = partida.crearJugada();
        jugadorQueJuega = jugador1;
        orden = jugada.obtenerOrdenJugadoresMesa();

        limpiarLabels();
        desactivarBotonesCarta(false);

        lblMano.setText(diccionarioNombreJugadores.get(jugada.obtenerOrdenJugadoresMano().get(0)));

        partida.obtenerMazo().mezclar();

        repartirCartas();

        mostrarCartasJugador(jugador1);

        botonPasarTurno.setDisable(true);
        diccionarioConfiguracion.get(jugada.obtenerEstadoJugada().getClass().getSimpleName()).setearConfiguaracionBotones(this);
        diccionarioConfiguracion.get(jugador1.obtenerEstado().getClass().getSimpleName()).setearConfiguaracionBotones(this);

        // if (botonFlor.isSelected()) {
        //      partida.jugarConFlor();
        // }else{
        //      this.botonFlor.setDisable(true);
        //     botonContraFlor.setDisable(true);
        //     botonContraFlorAlResto.setDisable(true);
        //      botonAceptarFlor.setDisable(true);
        //      botonNoAceptarFlor.setDisable(true);
        // }
        estadoJugada.setText(jugada.obtenerEstadoJugada().getClass().getSimpleName());
        estadoJugador.setText(jugador1.obtenerEstado().getClass().getSimpleName());
    }

    @FXML
    @Override
    public void irAPantallaInicial(ActionEvent actionEvent) {
        seteoDePartida();
        miControlador.setearPantalla(FrameworkDePantalla.obtenerPantallaInicial());
    }
    @FXML
    public void irAInfo(ActionEvent actionEvent) {
        miControlador.setearPantalla(FrameworkDePantalla.obtenerPantallaSobreNosotros());
    }






}


