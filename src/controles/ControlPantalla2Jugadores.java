package controles;

import controles.Configuraciones.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Carta.Carta;
import modelo.Equipo;
import modelo.EstadoJugador.EstadoPie;
import modelo.EstadoJugador.EstadoPuedeCantarEnvido;
import modelo.EstadoJugador.EstadoPuedeCantarTruco;
import modelo.EstadoJugador.EstadoTieneElQuieroDelTruco;
import modelo.Jugadas.Jugada;
import modelo.Jugador;
import modelo.Partida.Partida;


import java.net.URL;
import java.util.*;

/**
 * Created by Augusto on 29/11/2015.
 */
public class ControlPantalla2Jugadores extends ControladorDePantallas {


    @Override
    public void setearPadreDePantalla(ControladorPantallas pantallaPadre) {
        miControlador = pantallaPadre;
        seteoDePartida();
    }

    public void seteoDePartida() {
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
        equipo1.setNombre("Equipo1");
        equipo2.setNombre("Equipo2");


        setearDiccionarios(jugador1, jugador2);


        actualizarPuntos();
        rdJugador2.setDisable(true);

        jugada = partida.crearJugada();
        jugadorQueJuega = jugador1;
        jugadorQueContesta = jugador1;
        orden = jugada.obtenerOrdenJugadoresMesa();

        limpiarLabels();
        listaDeCartasJugadas = new ArrayList<>();


        lblMano.setText(diccionarioNombreJugadores.get(jugada.obtenerOrdenJugadoresMano().get(0)));

        partida.obtenerMazo().mezclar();

        repartirCartas();

        desactivarBotonesCarta(false);
        mostrarCartasJugador(jugador1);

        botonPasarTurno.setDisable(true);
        setearJugadorQueDebeMostrar(jugador1);
        jugadorQueContesta = jugador1;
        botonEsconderCartas.setDisable(true);

    }



    @FXML
    public void irAInfo(ActionEvent actionEvent) {
        miControlador.setearPantalla(FrameworkDePantalla.obtenerPantallaSobreNosotros());
    }


}

