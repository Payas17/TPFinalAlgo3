package controles;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;
import modelo.Equipo;
import modelo.EstadoJugador.EstadoPuedeCantarEnvido;
import modelo.Jugadas.Jugada;
import modelo.Jugadas.JugadaPicaPica;
import modelo.Jugador;
import modelo.Partida.Partida;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Augusto on 28/11/2015.
 */
public class ControlPantalla6Jugadores extends ControladorDePantallas {


    private int cantidadDePicaPica;

    public void seteoDePartida() {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Jugador jugador3 = new Jugador();
        Jugador jugador4 = new Jugador();
        Jugador jugador5 = new Jugador();
        Jugador jugador6 = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador3);
        jugadores.add(jugador5);
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        jugadores2.add(jugador4);
        jugadores2.add(jugador6);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        partida = new Partida(equipo1, equipo2);
        turnoJugador = 0;
        equipo1.setNombre("Equipo1");
        equipo2.setNombre("Equipo2");


        setearDiccionarios(jugador1, jugador2,jugador3,jugador4,jugador5,jugador6);


        actualizarPuntos();
        rdJugador2.setDisable(true);
        rdJugador3.setDisable(true);
        rdJugador4.setDisable(true);
        rdJugador5.setDisable(true);
        rdJugador6.setDisable(true);

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
        setearJugadorQueDebeMostrar(jugador1);
        jugadorQueContesta = jugador1;
        cantidadDePicaPica =0;


    }


    @FXML
    public void irAInfo(ActionEvent actionEvent) {
        miControlador.setearPantalla(FrameworkDePantalla.obtenerPantallaSobreNosotros());
    }

    @Override
    public void terminaLaJugada(ActionEvent actionEvent) {
        terminarPartida(actionEvent);
        if (jugada.estaTerminada()) {

            if(jugada.obtenerEquipo1().obtenerIntegrantes().size() == 1) {
                partida.calcularPuntosPicaPica((JugadaPicaPica)jugada);
                actualizarPuntos();
            }
            jugada.limpiarJugadores();
            if ((partida.obtenerEquipo1().obtenerPuntos() >= 5 || (partida.obtenerEquipo2()).obtenerPuntos() >= 5) && (partida.obtenerEquipo1().obtenerPuntos() < 25 || (partida.obtenerEquipo2()).obtenerPuntos() < 25) && cantidadDePicaPica < 3) {

                jugada = partida.crearJugadaPicaPica();
                orden = jugada.obtenerOrdenJugadoresMano();
                if (cantidadDePicaPica == 0){
                    repartirCartas();
                }
                ((JugadaPicaPica) jugada).armarEquiposParaPicaPica(orden.get(cantidadDePicaPica), orden.get(cantidadDePicaPica + 3));
                jugadorQueJuega = orden.get(cantidadDePicaPica);
                orden = jugada.obtenerOrdenJugadoresMano();

                cantidadDePicaPica ++;

            } else {

                jugada = partida.crearJugada();
                if (cantidadDePicaPica == 3) {
                    Jugador jugadorQuePongoUltimo = jugada.obtenerOrdenJugadoresMesa().remove(0);
                    jugada.obtenerOrdenJugadoresMesa().add(jugadorQuePongoUltimo);
                }
                orden = jugada.obtenerOrdenJugadoresMesa();
                turnoJugador = 0;
                jugadorQueJuega = orden.get(turnoJugador);
                repartirCartas();
                cantidadDePicaPica = 0;
            }


            jugadorQueContesta = jugadorQueJuega;
            limpiarLabels();

            actualizacionDeJugador(jugadorQueJuega);
            mostrarCartasJugador(jugadorQueJuega);

        }
    }

    @Override
    public void aceptarEnvido(ActionEvent actionEvent) {

        super.aceptarEnvido(actionEvent);
        if(jugada.obtenerEquipo1().obtenerIntegrantes().size() == 1) {
            partida.calcularPuntosPicaPica((JugadaPicaPica)jugada);
            actualizarPuntos();
        }
        //partida.borrarPuntosPicaPica(jugada);

    }

    public void noAceptarEnvido(ActionEvent actionEvent) {

        super.noAceptarEnvido(actionEvent);
        if(jugada.obtenerEquipo1().obtenerIntegrantes().size() == 1) {
            partida.calcularPuntosPicaPica((JugadaPicaPica)jugada);
            actualizarPuntos();
        }
       // partida.borrarPuntosPicaPica( jugada);

    }

    public void aceptarFlor(ActionEvent actionEvent) {

        super.aceptarFlor(actionEvent);
        if(jugada.obtenerEquipo1().obtenerIntegrantes().size() == 1) {
            partida.calcularPuntosPicaPica((JugadaPicaPica)jugada);
            actualizarPuntos();
        }
       // partida.borrarPuntosPicaPica( jugada);
    }

    public void noAceptarFlor(ActionEvent actionEvent) {

        super.noAceptarFlor(actionEvent);
        if(jugada.obtenerEquipo1().obtenerIntegrantes().size() == 1) {
            partida.calcularPuntosPicaPica((JugadaPicaPica)jugada);
            actualizarPuntos();
        }
       // partida.borrarPuntosPicaPica( jugada);

    }





}
