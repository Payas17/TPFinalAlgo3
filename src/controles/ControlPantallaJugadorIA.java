package controles;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import modelo.Carta.*;
import modelo.Equipo;
import modelo.EstadoJugador.EstadoPuedeCantarEnvido;
import modelo.Jugador;
import modelo.Partida.Partida;
import modelo.ValoresTrucoYEnvido;
import modeloJugadorIA.JugadorIA;
import vista.FrameworkDePantalla;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Augusto on 02/12/2015.
 */
public class ControlPantallaJugadorIA extends ControladorDePantallas {

    private JugadorIA jugadorIA;

    @Override
    void seteoDePartida() {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        jugadorIA = new JugadorIA(jugador2);
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador2);
        Equipo equipo1 = new Equipo(jugadores);
        Equipo equipo2 = new Equipo(jugadores2);
        partida = new Partida(equipo1, equipo2);
        turnoJugador = 0;
        equipo1.setNombre("Equipo1");
        equipo2.setNombre("Maquina");


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

    @Override
    public void setearPadreDePantalla(ControladorPantallas pantallaPadre) {
        miControlador = pantallaPadre;
        seteoDePartida();
    }

    @FXML
    public void irAInfo(ActionEvent actionEvent) {
        miControlador.setearPantalla(FrameworkDePantalla.obtenerPantallaSobreNosotros());
    }

    @Override
    public void pasarElTurno(ActionEvent actionEvent) {

        desactivarBotonesCarta(false);
        botonPasarTurno.setDisable(true);
        orden = jugada.obtenerOrdenJugadoresMano();
        turnoJugador++;

        if (turnoJugador >= orden.size()) {
            jugada.jugarMano();
            orden = jugada.obtenerOrdenJugadoresMano();
            diccionarioConfiguracion.get(jugada.obtenerEstadoTruco().getClass().getSimpleName()).setearConfiguaracionBotones(this);
            turnoJugador = 0;
        }
        actualizarPuntos();
        terminaLaJugada(actionEvent);

        jugadorQueJuega = orden.get(turnoJugador);
        jugadorQueContesta = jugadorQueJuega;
        setearJugadorQueDebeMostrar(jugadorQueJuega);
        botonEsconderCartas.setDisable(true);
        if (jugadorIA.obtenerJugador() == jugadorQueJuega && jugadorIA.obtenerCartaEnJuego() == null){
           // jugadorIA.cantar(jugada,partida);
            //jugadorIACantarAlgo();
            jugadorIA.jugarCarta(jugada);
            for (Node label : diccionarioVBoxes.get(jugadorIA.obtenerJugador()).getChildren()) {
                if (((Label) label).getText().equals("?")) {
                    ((Label) label).setText(String.valueOf(jugadorIA.obtenerCartaEnJuego().obtenerNumeroDeCarta()) + " de " + (jugadorIA.obtenerCartaEnJuego().getClass().getSimpleName()));
                    break;
                }
            }
            pasarElTurno(actionEvent);

        }

    }

    @Override
    public void cantarTruco(ActionEvent actionEvent) {
        jugadorQueJuega.cantarTruco(jugada);
        jugadorIA.cantar(jugada, partida);
        setearJugadorQueDebeMostrar(jugadorQueJuega);
        desactivarBotonesCarta(false);
        desactivarBotonesEnvido();

    }
    @Override
    public void aceptarTruco(ActionEvent actionEvent) {

        jugadorQueContesta.aceptarTruco(jugada);
        setearJugadorQueDebeMostrar(jugadorQueJuega);
        desactivarBotonesCarta(false);
        desactivarBotonesEnvido();

    }

    @Override
    public void cantarReTruco(ActionEvent actionEvent) {
        jugadorQueContesta.cantarRealEnvido(jugada);
        jugadorIA.cantar(jugada, partida);

    }
    @Override
    public void cantarVale4(ActionEvent actionEvent) {
        jugadorQueContesta.cantarValeCuatro(jugada);
        jugadorIA.cantar(jugada, partida);

    }


    @Override
    public void noAceptarTruco(ActionEvent actionEvent) {
        jugadorQueContesta.noAceptarTruco(jugada);
        actualizarPuntos();
        terminaLaJugada(actionEvent);
        //  jugadorQueJuega = orden.get(turnoJugador);
        setearJugadorQueDebeMostrar(jugadorQueJuega);
    }

    @Override
    public void irseAlMazo(ActionEvent actionEvent) {
        jugadorQueJuega.irseAlMazo(jugada);
        actualizarPuntos();
        terminaLaJugada(actionEvent);
      jugadorQueJuega = jugada.obtenerEquipo1().obtenerIntegrantes().get(0);
        turnoJugador++;
        setearJugadorQueDebeMostrar(jugadorQueJuega);

        jugadorIA.jugarCarta(jugada);
        for (Node label : diccionarioVBoxes.get(jugadorIA.obtenerJugador()).getChildren()) {
            if (((Label) label).getText().equals("?")) {
                ((Label) label).setText(String.valueOf(jugadorIA.obtenerCartaEnJuego().obtenerNumeroDeCarta()) + " de " + (jugadorIA.obtenerCartaEnJuego().getClass().getSimpleName()));
                break;
            }
        }

    }

    @Override
    public void cantarEnvido(ActionEvent actionEvent) {
        jugadorQueContesta.cantarEnvido(jugada);
        jugadorIA.cantar(jugada, partida);
        actualizarPuntos();
        terminarPartida(actionEvent);
        setearJugadorQueDebeMostrar(jugadorQueJuega);


    }
    @Override
    public void aceptarEnvido(ActionEvent actionEvent) {

        jugadorQueContesta.aceptarEnvido(jugada);
        for(Jugador jugador: orden) {
            diccionarioLabels.get(jugador).setText(String.valueOf(jugador.obtenerEnvido()));
        }
        actualizarPuntos();
        terminarPartida(actionEvent);
        setearJugadorQueDebeMostrar(jugadorQueJuega);

    }
    @Override
    public void noAceptarEnvido(ActionEvent actionEvent) {

        jugadorQueContesta.noAceptarEnvido(jugada);
        actualizarPuntos();
        terminarPartida(actionEvent);
        setearJugadorQueDebeMostrar(jugadorQueJuega);

    }
    @Override
    public void cantarRealEnvido(ActionEvent actionEvent) {
        jugadorQueContesta.cantarRealEnvido(jugada);
        jugadorIA.cantar(jugada, partida);
        actualizarPuntos();
        terminarPartida(actionEvent);
        setearJugadorQueDebeMostrar(jugadorQueJuega);


    }
    @Override
    public void cantarFaltaEnvido(ActionEvent actionEvent) {

        jugadorQueContesta.cantarFaltaEnvido(jugada);
        jugadorIA.cantar(jugada, partida);
        actualizarPuntos();
        terminarPartida(actionEvent);
        setearJugadorQueDebeMostrar(jugadorQueJuega);


    }
    @Override
    public void cantarFlor(ActionEvent actionEvent) {

        if (jugadorQueJuega.tieneFlor()){

            jugadorQueJuega.cantarFlor(jugada);
        }
        jugadorIA.cantar(jugada, partida);
        actualizarPuntos();
        terminarPartida(actionEvent);
        setearJugadorQueDebeMostrar(jugadorQueJuega);


    }
    @Override
    public void cantarContraFlor(ActionEvent actionEvent) {
        jugadorIA.cantar(jugada, partida);

    }
    @Override
    public void cantarContraFlorAlResto(ActionEvent actionEvent) {
        jugadorIA.cantar(jugada, partida);

    }
    @Override
    public void aceptarFlor(ActionEvent actionEvent) {

        for (Jugador jugador : jugada.obtenerEquipoQueContieneJugador(jugadorQueContesta).obtenerIntegrantes()){
            if (jugador.tieneFlor()){
                jugador.cambiarEstado(new EstadoPuedeCantarEnvido());
                jugador.aceptarFlor(jugada);
                break;
            }
        }
        for(Jugador jugador: orden) {
            if(jugador.tieneFlor())
                diccionarioLabels.get(jugador).setText(String.valueOf(jugador.obtenerFlor()));
        }
        actualizarPuntos();
        terminarPartida(actionEvent);
        jugadorQueContesta = jugada.obtenerEquipoQueNoContieneJugador(jugadorQueContesta).obtenerIntegrantes().get(0);
        setearJugadorQueDebeMostrar(jugadorQueJuega);
    }
    @Override
    public void noAceptarFlor(ActionEvent actionEvent) {

        jugadorQueContesta.noAceptarFlor(jugada);
        actualizarPuntos();
        terminarPartida(actionEvent);
        jugadorQueContesta = jugada.obtenerEquipoQueNoContieneJugador(jugadorQueContesta).obtenerIntegrantes().get(0);
        setearJugadorQueDebeMostrar(jugadorQueJuega);

    }
    @Override
    public void repartirCartas() {
        jugadorIA.limpiarCartas();
        partida.obtenerMazo().mezclar();
        partida.obtenerEquipo1().obtenerIntegrantes().get(0).agregarCarta(partida.obtenerMazo().darCarta());
        partida.obtenerEquipo1().obtenerIntegrantes().get(0).agregarCarta(partida.obtenerMazo().darCarta());
        partida.obtenerEquipo1().obtenerIntegrantes().get(0).agregarCarta(partida.obtenerMazo().darCarta());
        jugadorIA.agregarCarta(partida.obtenerMazo().darCarta());
        jugadorIA.agregarCarta(partida.obtenerMazo().darCarta());
        jugadorIA.agregarCarta(partida.obtenerMazo().darCarta());

    }


    public void repartirCartasHardcode() {

        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();

        Carta copa10 = new Copa(10, valoresTrucoYEnvido);
        Carta copa4 = new Copa(4, valoresTrucoYEnvido);
        Carta copa5 = new Copa(5, valoresTrucoYEnvido);
        Carta copa6 = new Copa(6, valoresTrucoYEnvido);



        jugadorQueJuega.agregarCarta(copa10);
        jugadorQueJuega.agregarCarta(copa4);
        jugadorQueJuega.agregarCarta(copa5);

        jugadorIA.agregarCarta(copa6);
        jugadorIA.agregarCarta(copa4);
        jugadorIA.agregarCarta(copa5);

    }

}
