package controles;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import modelo.Equipo;
import modelo.Jugador;
import modelo.Partida.Partida;
import vista.FrameworkDePantalla;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Augusto on 29/11/2015.
 */
public class ControlPantalla4Jugadores extends ControladorDePantallas {





    public void seteoDePartida() {
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


