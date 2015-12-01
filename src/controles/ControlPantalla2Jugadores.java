package controles;

import controles.Configuraciones.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;
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
public class ControlPantalla2Jugadores implements Initializable, ControladorDePantallas {

    @FXML
    public Button carta1;
    @FXML
    public Button carta2;
    @FXML
    public Button carta3;
    @FXML
    public Label cartaEnJuego3J1;
    @FXML
    public Label cartaEnJuego2J1;
    @FXML
    public Label cartaEnJuego1J1;
    @FXML
    public Label cartaEnJuego3J2;
    @FXML
    public Label cartaEnJuego2J2;
    @FXML
    public Label cartaEnJuego1J2;
    @FXML
    public VBox VboxJ1;
    @FXML
    public VBox VboxJ2;
    @FXML
    public Button botonPasarTurno;
    @FXML
    public Label lblMano;
    @FXML
    public Button botonNoAceptarEnvido;
    @FXML
    public Button botonFlor;
    @FXML
    public Button botonIrseAlMazo;
    @FXML
    public Label estadoJugador;
    @FXML
    public Label estadoJugada;
    @FXML
    public Label tantoJugador2;
    @FXML
    public Label tantoJugador1;

    private ControladorPantallas miControlador;
    private List<Jugador> orden;

    @FXML
    private Label lblEquipo1;
    @FXML
    private Label lblEquipo2;
    @FXML
    private RadioButton rdJugador2;
    @FXML
    private RadioButton rdJugador1;
    @FXML
    private Button botonTruco;
    @FXML
    private Button botonReTruco;
    @FXML
    private Button botonValeCuatro;
    @FXML
    private Button botonEnvido;
    @FXML
    private Button botonRealEnvido;
    @FXML
    private Button botonFaltaEnvido;
    @FXML
    private Button botonContraFlor;
    @FXML
    private Button botonContraFlorAlResto;
    @FXML
    private Button botonAceptarTruco;
    @FXML
    private Button botonNoAceptarTruco;
    @FXML
    private Button botonAceptarEnvido;
    @FXML
    private Button botonAceptarFlor;
    @FXML
    private Button botonNoAceptarFlor;


    private Partida partida;
    private Jugada jugada;
    private int turnoJugador;
    private Jugador jugadorQueJuega;
    private Jugador jugadorQueContesta;
    private Jugador jugadorQueCanto;
    private HashMap<Jugador, RadioButton> diccionarioJugadores;
    private Map<Jugador, VBox> diccionarioVBoxes;
    private Map<Jugador, String> diccionarioNombreJugadores;
    private Map< String, Configuracion> diccionarioConfiguracion;


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


        setearDiccionarios(jugador1, jugador2);


        actualizarPuntos();
        rdJugador2.setDisable(true);

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

        if (botonFlor.isSelected()) {
            partida.jugarConFlor();
        }else{
            this.botonFlor.setDisable(true);
            botonContraFlor.setDisable(true);
            botonContraFlorAlResto.setDisable(true);
            botonAceptarFlor.setDisable(true);
            botonNoAceptarFlor.setDisable(true);
        }
        estadoJugada.setText(jugada.obtenerEstadoJugada().getClass().getSimpleName());
        estadoJugador.setText(jugador1.obtenerEstado().getClass().getSimpleName());
    }

    public Jugada obtenerJugada(){
        return jugada;
    }


    private void setearDiccionarios(Jugador jugador1, Jugador jugador2) {
        diccionarioJugadores = new HashMap<>();
        diccionarioJugadores.put(jugador1, rdJugador1);
        diccionarioJugadores.put(jugador2, rdJugador2);

        diccionarioVBoxes = new HashMap<>();
        diccionarioVBoxes.put(jugador1, VboxJ1);
        diccionarioVBoxes.put(jugador2, VboxJ2);

        diccionarioNombreJugadores = new HashMap<>();
        diccionarioNombreJugadores.put(jugador1, "Jugador 1");
        diccionarioNombreJugadores.put(jugador2, "Jugador 2");

        diccionarioConfiguracion = new HashMap<>();

        setearConfiguraciones();

    }

    private void setearConfiguraciones() {
        diccionarioConfiguracion.put("EstadoFaltaEnvido", new ConfiguarcionFaltaEnvido());
        diccionarioConfiguracion.put("EstadoRealEnvido", new ConfiguarcionRealEnvido());
        diccionarioConfiguracion.put("EstadoEnvidoEnvido", new ConfiguarcionEnvidoEnvido());
        diccionarioConfiguracion.put("EstadoSinEnvido", new ConfiguarcionSinEnvido());
        diccionarioConfiguracion.put("EstadoNoSePuedeCantarEnvido", new ConfiguracionNoSePuedeCantarEnvido());
        diccionarioConfiguracion.put("EstadoPuedeCantarEnvido", new ConfiguarcionPuedeCantarEnvido());
        diccionarioConfiguracion.put("EstadoEnvido", new ConfiguarcionEnvido());
        diccionarioConfiguracion.put("EstadoValeCuatro", new ConfiguarcionValeCuatro());
        diccionarioConfiguracion.put("EstadoReTruco", new ConfiguarcionReTruco());
        diccionarioConfiguracion.put("EstadoTieneElQuieroDelTruco", new ConfiguracionJugadaTieneElQuieroTruco());
        diccionarioConfiguracion.put("EstadoPuedeCantarTruco", new ConfiguracionJugadaPuedeCantarTruco());
        diccionarioConfiguracion.put("EstadoPuedeCantarTrucoPrimeraMano", new ConfiguracionJugadaPuedeCantarTrucoPriemraMano());
        diccionarioConfiguracion.put("EstadoNoSeCantoNada", new configuracionJugadaNoSeCantoNada());
        diccionarioConfiguracion.put("EstadoPie", new configuracionJugadaPie());
        diccionarioConfiguracion.put("EstadoNoPuedeCantar", new ConfiguaracionNoPuedeCantar());
        diccionarioConfiguracion.put("EstadoTruco", new ConfiguarcionTruco());
        diccionarioConfiguracion.put("EstadoPrimeraMano", new ConfiguracionPrimeraMano());
        diccionarioConfiguracion.put("EstadoSinTruco", new ConfiguarcionSinTruco());
    }

    @FXML
    public void irAPantallaInicial(ActionEvent actionEvent) {
        RadioButton botonFlor = miControlador.obtenerControlPantallaInicial().obtenerBotonFlor();
        seteoDePartida(botonFlor);
        miControlador.setearPantalla(FrameworkDePantalla.obtenerPantallaInicial());
    }

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
        terminaLaJugada();

        jugadorQueJuega = orden.get(turnoJugador);
        actualizarBotonesYLabels();


        actualizacionDeJugador(jugadorQueJuega);

        actualizarPuntos();

        mostrarCartasJugador(jugadorQueJuega);

    }

    private void actualizarBotonesYLabels() {
        diccionarioConfiguracion.get(jugadorQueJuega.obtenerEstado().getClass().getSimpleName()).setearConfiguaracionBotones(this);
        diccionarioConfiguracion.get(jugada.obtenerEstadoTruco().getClass().getSimpleName()).setearConfiguaracionBotones(this);
        diccionarioConfiguracion.get(jugada.obtenerEstadoEnvido().getClass().getSimpleName()).setearConfiguaracionBotones(this);
        estadoJugada.setText(jugada.obtenerEstadoTruco().getClass().getSimpleName());
        estadoJugador.setText(jugadorQueJuega.obtenerEstado().getClass().getSimpleName());
    }

    private void terminaLaJugada() {
        if (jugada.estaTerminada()) {
            jugada = partida.crearJugada();
            orden = jugada.obtenerOrdenJugadoresMesa();
            repartirCartas();

            limpiarLabels();
            turnoJugador = 0;

            jugadorQueJuega = orden.get(turnoJugador);
            actualizacionDeJugador(jugadorQueJuega);

            mostrarCartasJugador(jugadorQueJuega);
        }
    }

    private void actualizarPuntos() {
        lblEquipo1.setText(String.valueOf(partida.obtenerEquipo1().obtenerPuntos()));
        lblEquipo2.setText(String.valueOf(partida.obtenerEquipo2().obtenerPuntos()));
    }

    public void desactivarBotonesCarta(boolean value) {
        carta1.setDisable(value);
        carta2.setDisable(value);
        carta3.setDisable(value);
    }

    private void mostrarCartasJugador(Jugador jugadorQueJuega) {
        carta1.setText(String.valueOf(jugadorQueJuega.obtenerCartasEnMano().get(0).obtenerNumeroDeCarta()) + " de " + (jugadorQueJuega.obtenerCartasEnMano().get(0).getClass().getSimpleName()));
        carta2.setText(String.valueOf(jugadorQueJuega.obtenerCartasEnMano().get(1).obtenerNumeroDeCarta()) + " de " + (jugadorQueJuega.obtenerCartasEnMano().get(1).getClass().getSimpleName()));
        carta3.setText(String.valueOf(jugadorQueJuega.obtenerCartasEnMano().get(2).obtenerNumeroDeCarta()) + " de " + (jugadorQueJuega.obtenerCartasEnMano().get(2).getClass().getSimpleName()));
    }

    private void actualizacionDeJugador(Jugador jugadorQueJuega) {
        diccionarioJugadores.get(jugadorQueJuega).setDisable(false);
        diccionarioJugadores.get(jugadorQueJuega).setSelected(true);

        for (Jugador jugadorActual : orden) {
            if (jugadorActual != jugadorQueJuega) {
                diccionarioJugadores.get(jugadorActual).setDisable(true);
            }
        }
    }

    private void limpiarLabels() {
        for (VBox vbox : diccionarioVBoxes.values()) {
            for (Node label : vbox.getChildren()) {
                ((Label) label).setText("?");
            }
        }
        tantoJugador1.setText("");
        tantoJugador2.setText("");
        lblMano.setText(diccionarioNombreJugadores.get(jugada.obtenerOrdenJugadoresMano().get(0)));

    }

    public void repartirCartas() {
        partida.obtenerMazo().mezclar();

        for (Jugador jugador : jugada.obtenerOrdenJugadoresMesa()) {
            jugador.agregarCarta(partida.obtenerMazo().darCarta());
            jugador.agregarCarta(partida.obtenerMazo().darCarta());
            jugador.agregarCarta(partida.obtenerMazo().darCarta());
        }
    }

    public void jugarCarta1(ActionEvent actionEvent) {
        elegirCarta( jugadorQueJuega.obtenerCartasEnMano().get(0));
    }

    private void elegirCarta( Carta unaCarta) {
        List<Jugador> orden = jugada.obtenerOrdenJugadoresMano();
        jugadorQueJuega = orden.get(turnoJugador);

        for (Node label : diccionarioVBoxes.get(jugadorQueJuega).getChildren()) {
            if (((Label) label).getText().equals("?")) {
                jugadorQueJuega.juegaCarta(unaCarta);
                ((Label) label).setText(String.valueOf(jugadorQueJuega.obtenerCartaEnJuego().obtenerNumeroDeCarta()) + " de " + (jugadorQueJuega.obtenerCartaEnJuego().getClass().getSimpleName()));
                break;
            }

        }

        desactivarBotonesCarta(true);
        desactivarTodosLosBotones();
        botonPasarTurno.setDisable(false);
    }

    public void jugarCarta2(ActionEvent actionEvent) {
        elegirCarta( jugadorQueJuega.obtenerCartasEnMano().get(1));
    }

    public void jugarCarta3(ActionEvent actionEvent) {
        elegirCarta( jugadorQueJuega.obtenerCartasEnMano().get(2));
    }

    public void cantarTruco(ActionEvent actionEvent) {
        jugadorQueJuega.cantarTruco(jugada);
        jugadorQueCanto = jugadorQueJuega;
        jugadorQueContesta = jugada.obtenerEquipoQueNoContieneJugador(jugadorQueJuega).obtenerIntegrantes().get(0);
        diccionarioConfiguracion.get(jugadorQueContesta.obtenerEstado().getClass().getSimpleName()).setearConfiguaracionBotones(this);
        diccionarioConfiguracion.get(jugada.obtenerEstadoTruco().getClass().getSimpleName()).setearConfiguaracionBotones(this);
        diccionarioConfiguracion.get(jugada.obtenerEstadoEnvido().getClass().getSimpleName()).setearConfiguaracionBotones(this);
        estadoJugada.setText(jugada.obtenerEstadoTruco().getClass().getSimpleName());
        estadoJugador.setText(jugadorQueContesta.obtenerEstado().getClass().getSimpleName());
        actualizacionDeJugador(jugadorQueContesta);
        mostrarCartasJugador(jugadorQueContesta);

    }



    public Button obtenerBotonTruco(){
        return botonTruco;
    }
    public Button obtenerBotonReTruco(){
        return botonReTruco;
    }
    public Button obtenerBotonVale4(){
        return botonValeCuatro;
    }
    public Button obtenerBotonAceptarTruco(){
        return botonAceptarTruco;
    }
    public Button obtenerBotonNoAceptarTruco(){
        return botonNoAceptarTruco;
    }
    public Button obtenerBotonEnvido(){
        return botonEnvido;
    }
    public Button obtenerBotonRealEnvido(){
        return botonRealEnvido;
    }
    public Button obtenerBotonFaltaEnvido(){
        return botonFaltaEnvido;
    }
    public Button obtenerBotonAceptarEnvido(){
        return botonAceptarEnvido;
    }
    public Button obtenerBotonAceptarFlor(){
        return botonAceptarFlor;
    }
    public Button obtenerBotonNoAceptarEnvido(){
        return botonNoAceptarEnvido;
    }
    public Button obtenerBotonNoAceptarFlor(){
        return botonNoAceptarFlor;
    }
    public Button obtenerBotonFlor(){
        return botonFlor;
    }
    public Button obtenerBotonContraFlor(){
        return botonContraFlor;
    }
    public Button obtenerBotonContraFlorAlResto(){
        return botonContraFlorAlResto;
    }
    public Button obtenerBotonIrseAlMazo(){
        return botonIrseAlMazo;
    }
    public Button obtenerBotonPasarTurno(){
        return botonPasarTurno;
    }


    public void aceptarTruco(ActionEvent actionEvent) {
        if (jugadorQueJuega.obtenerEstado().getClass() == EstadoPuedeCantarTruco.class){
            jugadorQueJuega.aceptarTruco(jugada);
            estadoJugada.setText(jugada.obtenerEstadoTruco().getClass().getSimpleName());
            estadoJugador.setText(jugadorQueJuega.obtenerEstado().getClass().getSimpleName());
            actualizacionDeJugador(jugadorQueJuega);
            mostrarCartasJugador(jugadorQueJuega);
        }else{
            jugadorQueContesta.aceptarTruco(jugada);
            estadoJugada.setText(jugada.obtenerEstadoTruco().getClass().getSimpleName());
            estadoJugador.setText(jugadorQueJuega.obtenerEstado().getClass().getSimpleName());
            actualizacionDeJugador(jugadorQueJuega);
            mostrarCartasJugador(jugadorQueJuega);

        }
        diccionarioConfiguracion.get(jugadorQueJuega.obtenerEstado().getClass().getSimpleName()).setearConfiguaracionBotones(this);
        diccionarioConfiguracion.get(jugada.obtenerEstadoTruco().getClass().getSimpleName()).setearConfiguaracionBotones(this);
        desactivarBotonesCarta(false);
        desactivarBotonesEnvido();

    }

    public void desactivarBotonesEnvido(){

        botonEnvido.setDisable(true);
        botonRealEnvido.setDisable(true);
        botonFaltaEnvido.setDisable(true);
        botonContraFlor.setDisable(true);
        botonContraFlorAlResto.setDisable(true);
        botonAceptarEnvido.setDisable(true);
        botonAceptarFlor.setDisable(true);
        botonNoAceptarFlor.setDisable(true);
        botonFlor.setDisable(true);

    }

    public void desactivarBotonesTruco(){
        botonTruco.setDisable(true);
        botonReTruco.setDisable(true);
        botonValeCuatro.setDisable(true);
        botonAceptarTruco.setDisable(true);
        botonNoAceptarTruco.setDisable(true);
    }
    public void desactivarTodosLosBotones(){
        desactivarBotonesEnvido();
        desactivarBotonesTruco();
    }

    public void cantarReTruco(ActionEvent actionEvent) {

        if (jugadorQueJuega.obtenerEstado().getClass() == EstadoTieneElQuieroDelTruco.class){
            jugadorQueJuega.cantarReTruco(jugada);
            jugadorQueContesta = jugada.obtenerEquipoQueNoContieneJugador(jugadorQueJuega).obtenerIntegrantes().get(0);
            diccionarioConfiguracion.get(jugadorQueContesta.obtenerEstado().getClass().getSimpleName()).setearConfiguaracionBotones(this);
            diccionarioConfiguracion.get(jugada.obtenerEstadoTruco().getClass().getSimpleName()).setearConfiguaracionBotones(this);
            estadoJugada.setText(jugada.obtenerEstadoTruco().getClass().getSimpleName());
            estadoJugador.setText(jugadorQueContesta.obtenerEstado().getClass().getSimpleName());
            actualizacionDeJugador(jugadorQueContesta);
            mostrarCartasJugador(jugadorQueContesta);
        }else{
            jugadorQueContesta.cantarReTruco(jugada);
            diccionarioConfiguracion.get(jugadorQueJuega.obtenerEstado().getClass().getSimpleName()).setearConfiguaracionBotones(this);
            diccionarioConfiguracion.get(jugada.obtenerEstadoTruco().getClass().getSimpleName()).setearConfiguaracionBotones(this);
            estadoJugada.setText(jugada.obtenerEstadoTruco().getClass().getSimpleName());
            estadoJugador.setText(jugadorQueJuega.obtenerEstado().getClass().getSimpleName());
            actualizacionDeJugador(jugadorQueJuega);
            mostrarCartasJugador(jugadorQueJuega);
        }
        desactivarBotonesEnvido();
    }

    public void cantarVale4(ActionEvent actionEvent) {

        if (jugadorQueJuega.obtenerEstado().getClass() == EstadoPuedeCantarTruco.class || jugadorQueJuega.obtenerEstado().getClass() == EstadoTieneElQuieroDelTruco.class){
            jugadorQueJuega.cantarValeCuatro(jugada);
            jugadorQueContesta = jugada.obtenerEquipoQueNoContieneJugador(jugadorQueJuega).obtenerIntegrantes().get(0);
            diccionarioConfiguracion.get(jugadorQueContesta.obtenerEstado().getClass().getSimpleName()).setearConfiguaracionBotones(this);
            diccionarioConfiguracion.get(jugada.obtenerEstadoTruco().getClass().getSimpleName()).setearConfiguaracionBotones(this);
            estadoJugada.setText(jugada.obtenerEstadoTruco().getClass().getSimpleName());
            estadoJugador.setText(jugadorQueContesta.obtenerEstado().getClass().getSimpleName());
            actualizacionDeJugador(jugadorQueContesta);
            mostrarCartasJugador(jugadorQueContesta);
        }else{
            jugadorQueContesta.cantarValeCuatro(jugada);
            diccionarioConfiguracion.get(jugadorQueJuega.obtenerEstado().getClass().getSimpleName()).setearConfiguaracionBotones(this);
            diccionarioConfiguracion.get(jugada.obtenerEstadoTruco().getClass().getSimpleName()).setearConfiguaracionBotones(this);
            estadoJugada.setText(jugada.obtenerEstadoTruco().getClass().getSimpleName());
            estadoJugador.setText(jugadorQueJuega.obtenerEstado().getClass().getSimpleName());
            actualizacionDeJugador(jugadorQueJuega);
            mostrarCartasJugador(jugadorQueJuega);
        }

        desactivarBotonesEnvido();

    }

    public void noAceptarTruco(ActionEvent actionEvent) {
        if (jugadorQueJuega.obtenerEstado().getClass() == EstadoPuedeCantarTruco.class){
            jugadorQueJuega.noAceptarTruco(jugada);
        }else{
            jugadorQueContesta.noAceptarTruco(jugada);
        }

        terminaLaJugada();
        actualizarPuntos();
        jugadorQueJuega = orden.get(turnoJugador);
        diccionarioConfiguracion.get(jugadorQueJuega.obtenerEstado().getClass().getSimpleName()).setearConfiguaracionBotones(this);
        diccionarioConfiguracion.get(jugada.obtenerEstadoTruco().getClass().getSimpleName()).setearConfiguaracionBotones(this);
        estadoJugada.setText(jugada.obtenerEstadoTruco().getClass().getSimpleName());
        estadoJugador.setText(jugadorQueJuega.obtenerEstado().getClass().getSimpleName());



    }

    public void irseAlMazo(ActionEvent actionEvent) {
        jugadorQueJuega.irseAlMazo(jugada);
        terminaLaJugada();
        actualizarPuntos();
        jugadorQueJuega = orden.get(turnoJugador);
        diccionarioConfiguracion.get(jugadorQueJuega.obtenerEstado().getClass().getSimpleName()).setearConfiguaracionBotones(this);
        diccionarioConfiguracion.get(jugada.obtenerEstadoTruco().getClass().getSimpleName()).setearConfiguaracionBotones(this);
        estadoJugada.setText(jugada.obtenerEstadoTruco().getClass().getSimpleName());
        estadoJugador.setText(jugadorQueJuega.obtenerEstado().getClass().getSimpleName());
    }

    public void cantarEnvido(ActionEvent actionEvent) {
        if (jugadorQueJuega.obtenerEstado().getClass() == EstadoPie.class){
            jugadorQueJuega.cantarEnvido(jugada);
            jugadorQueContesta = jugada.obtenerEquipoQueNoContieneJugador(jugadorQueJuega).obtenerIntegrantes().get(0);
            diccionarioConfiguracion.get(jugadorQueContesta.obtenerEstado().getClass().getSimpleName()).setearConfiguaracionBotones(this);
            diccionarioConfiguracion.get(jugada.obtenerEstadoEnvido().getClass().getSimpleName()).setearConfiguaracionBotones(this);
            estadoJugada.setText(jugada.obtenerEstadoTruco().getClass().getSimpleName());
            estadoJugador.setText(jugadorQueContesta.obtenerEstado().getClass().getSimpleName());
            actualizacionDeJugador(jugadorQueContesta);
            mostrarCartasJugador(jugadorQueContesta);
        }else{
            jugadorQueContesta.cantarEnvido(jugada);
            jugadorQueContesta = jugada.obtenerEquipoQueNoContieneJugador(jugadorQueContesta).obtenerIntegrantes().get(0);
            diccionarioConfiguracion.get(jugadorQueContesta.obtenerEstado().getClass().getSimpleName()).setearConfiguaracionBotones(this);
            diccionarioConfiguracion.get(jugada.obtenerEstadoEnvido().getClass().getSimpleName()).setearConfiguaracionBotones(this);
            estadoJugada.setText(jugada.obtenerEstadoTruco().getClass().getSimpleName());
            estadoJugador.setText(jugadorQueContesta.obtenerEstado().getClass().getSimpleName());
            actualizacionDeJugador(jugadorQueContesta);
            mostrarCartasJugador(jugadorQueContesta);
        }

    }

    public void aceptarEnvido(ActionEvent actionEvent) {
        if (jugadorQueJuega.obtenerEstado().getClass() == EstadoPuedeCantarEnvido.class){
            jugadorQueJuega.aceptarEnvido(jugada);
        }else {
            jugadorQueContesta.aceptarEnvido(jugada);
        }
        actualizarBotonesYLabels();
        actualizacionDeJugador(jugadorQueJuega);
        mostrarCartasJugador(jugadorQueJuega);
        actualizarPuntos();
        tantoJugador1.setText(String.valueOf(jugada.obtenerEquipo1().obtenerIntegrantes().get(0).obtenerEnvido()));
        tantoJugador2.setText(String.valueOf(jugada.obtenerEquipo2().obtenerIntegrantes().get(0).obtenerEnvido()));
    }

    public void noAceptarEnvido(ActionEvent actionEvent) {
        if (jugadorQueJuega.obtenerEstado().getClass() == EstadoPuedeCantarEnvido.class) {
            jugadorQueJuega.noAceptarEnvido(jugada);
        }else {
            jugadorQueContesta.noAceptarEnvido(jugada);
        }
        actualizarBotonesYLabels();
        actualizacionDeJugador(jugadorQueJuega);
        mostrarCartasJugador(jugadorQueJuega);
        actualizarPuntos();
    }

    public void cantarRealEnvido(ActionEvent actionEvent) {
        if (jugadorQueJuega.obtenerEstado().getClass() == EstadoPie.class){
            jugadorQueJuega.cantarRealEnvido(jugada);
            jugadorQueContesta = jugada.obtenerEquipoQueNoContieneJugador(jugadorQueJuega).obtenerIntegrantes().get(0);
            diccionarioConfiguracion.get(jugadorQueContesta.obtenerEstado().getClass().getSimpleName()).setearConfiguaracionBotones(this);
            diccionarioConfiguracion.get(jugada.obtenerEstadoEnvido().getClass().getSimpleName()).setearConfiguaracionBotones(this);
            estadoJugada.setText(jugada.obtenerEstadoTruco().getClass().getSimpleName());
            estadoJugador.setText(jugadorQueContesta.obtenerEstado().getClass().getSimpleName());
            actualizacionDeJugador(jugadorQueContesta);
            mostrarCartasJugador(jugadorQueContesta);
        }else{
            jugadorQueContesta.cantarRealEnvido(jugada);
            jugadorQueContesta = jugada.obtenerEquipoQueNoContieneJugador(jugadorQueContesta).obtenerIntegrantes().get(0);
            diccionarioConfiguracion.get(jugadorQueContesta.obtenerEstado().getClass().getSimpleName()).setearConfiguaracionBotones(this);
            diccionarioConfiguracion.get(jugada.obtenerEstadoEnvido().getClass().getSimpleName()).setearConfiguaracionBotones(this);
            estadoJugada.setText(jugada.obtenerEstadoTruco().getClass().getSimpleName());
            estadoJugador.setText(jugadorQueContesta.obtenerEstado().getClass().getSimpleName());
            actualizacionDeJugador(jugadorQueContesta);
            mostrarCartasJugador(jugadorQueContesta);
        }

    }

    public void cantarFaltaEnvido(ActionEvent actionEvent) {
        if (jugadorQueJuega.obtenerEstado().getClass() == EstadoPie.class){
            jugadorQueJuega.cantarFaltaEnvido(jugada);
            jugadorQueContesta = jugada.obtenerEquipoQueNoContieneJugador(jugadorQueJuega).obtenerIntegrantes().get(0);
            diccionarioConfiguracion.get(jugadorQueContesta.obtenerEstado().getClass().getSimpleName()).setearConfiguaracionBotones(this);
            diccionarioConfiguracion.get(jugada.obtenerEstadoEnvido().getClass().getSimpleName()).setearConfiguaracionBotones(this);
            estadoJugada.setText(jugada.obtenerEstadoTruco().getClass().getSimpleName());
            estadoJugador.setText(jugadorQueContesta.obtenerEstado().getClass().getSimpleName());
            actualizacionDeJugador(jugadorQueContesta);
            mostrarCartasJugador(jugadorQueContesta);
        }else{
            jugadorQueContesta.cantarFaltaEnvido(jugada);
            jugadorQueContesta = jugada.obtenerEquipoQueNoContieneJugador(jugadorQueContesta).obtenerIntegrantes().get(0);
            diccionarioConfiguracion.get(jugadorQueContesta.obtenerEstado().getClass().getSimpleName()).setearConfiguaracionBotones(this);
            diccionarioConfiguracion.get(jugada.obtenerEstadoEnvido().getClass().getSimpleName()).setearConfiguaracionBotones(this);
            estadoJugada.setText(jugada.obtenerEstadoTruco().getClass().getSimpleName());
            estadoJugador.setText(jugadorQueContesta.obtenerEstado().getClass().getSimpleName());
            actualizacionDeJugador(jugadorQueContesta);
            mostrarCartasJugador(jugadorQueContesta);
        }

    }
}

