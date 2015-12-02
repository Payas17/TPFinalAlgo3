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
import modelo.EstadoJugador.EstadoPie;
import modelo.EstadoJugador.EstadoPuedeCantarEnvido;
import modelo.EstadoJugador.EstadoPuedeCantarTruco;
import modelo.EstadoJugador.EstadoTieneElQuieroDelTruco;
import modelo.Jugadas.Jugada;
import modelo.Jugador;
import modelo.Partida.Partida;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by Augusto on 29/11/2015.
 */
public abstract class ControladorDePantallas implements Initializable {

    @FXML
    protected RadioButton rdJugador4;
    @FXML
    protected RadioButton rdJugador3;
    @FXML
    protected RadioButton rdJugador5;
    @FXML
    protected RadioButton rdJugador6;
    @FXML
    protected Button carta1;
    @FXML
    protected Button carta2;
    @FXML
    protected Button carta3;
    @FXML
    protected Label cartaEnJuego3J1;
    @FXML
    protected Label cartaEnJuego2J1;
    @FXML
    protected Label cartaEnJuego1J1;
    @FXML
    protected Label cartaEnJuego3J2;
    @FXML
    protected Label cartaEnJuego2J2;
    @FXML
    protected Label cartaEnJuego1J2;
    @FXML
    protected VBox VboxJ1;
    @FXML
    protected VBox VboxJ2;
    @FXML
    protected Button botonPasarTurno;
    @FXML
    protected Label lblMano;
    @FXML
    protected Button botonNoAceptarEnvido;
    @FXML
    protected Button botonFlor;
    @FXML
    protected Button botonIrseAlMazo;
    @FXML
    protected Label estadoJugador;
    @FXML
    protected Label estadoJugada;
    @FXML
    protected Label tantoJugador2;
    @FXML
    protected Label tantoJugador1;

    protected ControladorPantallas miControlador;
    protected List<Jugador> orden;

    @FXML
    protected Label lblEquipo1;
    @FXML
    protected Label lblEquipo2;
    @FXML
    protected RadioButton rdJugador2;
    @FXML
    protected RadioButton rdJugador1;
    @FXML
    protected Button botonTruco;
    @FXML
    protected Button botonReTruco;
    @FXML
    protected Button botonValeCuatro;
    @FXML
    protected Button botonEnvido;
    @FXML
    protected Button botonRealEnvido;
    @FXML
    protected Button botonFaltaEnvido;
    @FXML
    protected Button botonContraFlor;
    @FXML
    protected Button botonContraFlorAlResto;
    @FXML
    protected Button botonAceptarTruco;
    @FXML
    protected Button botonNoAceptarTruco;
    @FXML
    protected Button botonAceptarEnvido;
    @FXML
    protected Button botonAceptarFlor;
    @FXML
    protected Button botonNoAceptarFlor;
    @FXML
    protected VBox VboxJ4;
    @FXML
    protected VBox VboxJ3;
    @FXML
    public Label tantoJugador4;
    @FXML
    public Label tantoJugador3;
    @FXML
    protected VBox VboxJ5;
    @FXML
    protected VBox VboxJ6;
    @FXML
    public Label tantoJugador5;
    @FXML
    public Label tantoJugador6;



    protected Partida partida;
    protected Jugada jugada;
    protected int turnoJugador;
    protected Jugador jugadorQueJuega;
    protected Jugador jugadorQueContesta;
    protected HashMap<Jugador, RadioButton> diccionarioJugadores;
    protected Map<Jugador, VBox> diccionarioVBoxes;
    protected Map<Jugador, Label> diccionarioLabels;
    protected Map<Jugador, String> diccionarioNombreJugadores;
    protected Map< String, Configuracion> diccionarioConfiguracion;


    public void setearPadreDePantalla(ControladorPantallas unaPantalla){
        miControlador = unaPantalla;
        seteoDePartida();
    }

    abstract void seteoDePartida();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void accionSalir(ActionEvent event) {
        Platform.exit();
    }public Jugada obtenerJugada(){
        return jugada;
    }



    protected void setearDiccionarios(Jugador jugador1, Jugador jugador2) {
        diccionarioJugadores = new HashMap<>();
        diccionarioJugadores.put(jugador1, rdJugador1);
        diccionarioJugadores.put(jugador2, rdJugador2);

        diccionarioVBoxes = new HashMap<>();
        diccionarioVBoxes.put(jugador1, VboxJ1);
        diccionarioVBoxes.put(jugador2, VboxJ2);

        diccionarioNombreJugadores = new HashMap<>();
        diccionarioNombreJugadores.put(jugador1, "Jugador 1");
        diccionarioNombreJugadores.put(jugador2, "Jugador 2");

        diccionarioLabels = new HashMap<>();
        diccionarioLabels.put(jugador1,tantoJugador1);
        diccionarioLabels.put(jugador2,tantoJugador2);

        diccionarioConfiguracion = new HashMap<>();

        setearConfiguraciones();

    }

    protected void setearDiccionarios(Jugador jugador1, Jugador jugador2, Jugador jugador3,Jugador jugador4) {
        diccionarioJugadores = new HashMap<>();
        diccionarioJugadores.put(jugador1, rdJugador1);
        diccionarioJugadores.put(jugador2, rdJugador2);
        diccionarioJugadores.put(jugador3, rdJugador3);
        diccionarioJugadores.put(jugador4, rdJugador4);

        diccionarioVBoxes = new HashMap<>();
        diccionarioVBoxes.put(jugador1, VboxJ1);
        diccionarioVBoxes.put(jugador2, VboxJ2);
        diccionarioVBoxes.put(jugador3, VboxJ3);
        diccionarioVBoxes.put(jugador4, VboxJ4);

        diccionarioNombreJugadores = new HashMap<>();
        diccionarioNombreJugadores.put(jugador1, "Jugador 1");
        diccionarioNombreJugadores.put(jugador2, "Jugador 2");
        diccionarioNombreJugadores.put(jugador3, "Jugador 3");
        diccionarioNombreJugadores.put(jugador4, "Jugador 4");

        diccionarioLabels = new HashMap<>();
        diccionarioLabels.put(jugador1,tantoJugador1);
        diccionarioLabels.put(jugador2,tantoJugador2);
        diccionarioLabels.put(jugador3,tantoJugador3);
        diccionarioLabels.put(jugador4,tantoJugador4);

        diccionarioConfiguracion = new HashMap<>();

        setearConfiguraciones();

    }

    protected void setearDiccionarios(Jugador jugador1, Jugador jugador2, Jugador jugador3,Jugador jugador4,Jugador jugador5, Jugador jugador6) {
        diccionarioJugadores = new HashMap<>();
        diccionarioJugadores.put(jugador1, rdJugador1);
        diccionarioJugadores.put(jugador2, rdJugador2);
        diccionarioJugadores.put(jugador3, rdJugador3);
        diccionarioJugadores.put(jugador4, rdJugador4);
        diccionarioJugadores.put(jugador5, rdJugador5);
        diccionarioJugadores.put(jugador6, rdJugador6);

        diccionarioVBoxes = new HashMap<>();
        diccionarioVBoxes.put(jugador1, VboxJ1);
        diccionarioVBoxes.put(jugador2, VboxJ2);
        diccionarioVBoxes.put(jugador3, VboxJ3);
        diccionarioVBoxes.put(jugador4, VboxJ4);
        diccionarioVBoxes.put(jugador5, VboxJ5);
        diccionarioVBoxes.put(jugador6, VboxJ6);

        diccionarioNombreJugadores = new HashMap<>();
        diccionarioNombreJugadores.put(jugador1, "Jugador 1");
        diccionarioNombreJugadores.put(jugador2, "Jugador 2");
        diccionarioNombreJugadores.put(jugador3, "Jugador 3");
        diccionarioNombreJugadores.put(jugador4, "Jugador 4");
        diccionarioNombreJugadores.put(jugador5, "Jugador 5");
        diccionarioNombreJugadores.put(jugador6, "Jugador 6");

        diccionarioLabels = new HashMap<>();
        diccionarioLabels.put(jugador1,tantoJugador1);
        diccionarioLabels.put(jugador2,tantoJugador2);
        diccionarioLabels.put(jugador3,tantoJugador3);
        diccionarioLabels.put(jugador4,tantoJugador4);
        diccionarioLabels.put(jugador5,tantoJugador5);
        diccionarioLabels.put(jugador6,tantoJugador6);

        diccionarioConfiguracion = new HashMap<>();

        setearConfiguraciones();

    }
    protected void setearConfiguraciones() {

        diccionarioConfiguracion.put("EstadoSeCantoTrucoPrimeraMano", new ConfiguarcionNoSeCantoNadaPrimeraMano());
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
        seteoDePartida();
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
        actualizarPuntos();
        terminaLaJugada(actionEvent);

        jugadorQueJuega = orden.get(turnoJugador);
        jugadorQueContesta = jugadorQueJuega;
        setearJugadorQueDebeMostrar(jugadorQueJuega);


    }

    private void terminaLaJugada(ActionEvent actionEvent) {
        terminarPartida(actionEvent);
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

    private void terminarPartida(ActionEvent actionEvent) {
        if (partida.estaTerminada()){

            desactivarTodosLosBotones();
            desactivarBotonesCarta(true);
            botonPasarTurno.setDisable(true);

            miControlador.obtenerControlPantallaGanador().setearGanador(partida.obtenerGanador().getNombre());
            miControlador.setearPantalla(FrameworkDePantalla.obtenerPantallaGanador());
            seteoDePartida();
        }
    }


    public void jugarCarta1(ActionEvent actionEvent) {
        elegirCarta( jugadorQueJuega.obtenerCartasEnMano().get(0));
    }

    public void jugarCarta2(ActionEvent actionEvent) {
        elegirCarta(jugadorQueJuega.obtenerCartasEnMano().get(1));
    }

    public void jugarCarta3(ActionEvent actionEvent) {
        elegirCarta( jugadorQueJuega.obtenerCartasEnMano().get(2));
    }

    public void cantarTruco(ActionEvent actionEvent) {
        jugadorQueJuega.cantarTruco(jugada);
        jugadorQueContesta = jugada.obtenerEquipoQueNoContieneJugador(jugadorQueJuega).obtenerIntegrantes().get(0);
        setearJugadorQueDebeMostrar(jugadorQueContesta);

    }

    public void aceptarTruco(ActionEvent actionEvent) {

        jugadorQueContesta.aceptarTruco(jugada);
        setearJugadorQueDebeMostrar(jugadorQueJuega);
        desactivarBotonesCarta(false);
        desactivarBotonesEnvido();

    }


    public void cantarReTruco(ActionEvent actionEvent) {

        jugadorQueContesta.cantarReTruco(jugada);
        jugadorQueContesta = jugada.obtenerEquipoQueNoContieneJugador(jugadorQueContesta).obtenerIntegrantes().get(0);
        setearJugadorQueDebeMostrar(jugadorQueContesta);
        desactivarBotonesEnvido();
    }

    public void cantarVale4(ActionEvent actionEvent) {

        jugadorQueContesta.cantarValeCuatro(jugada);
        jugadorQueContesta = jugada.obtenerEquipoQueNoContieneJugador(jugadorQueContesta).obtenerIntegrantes().get(0);
        setearJugadorQueDebeMostrar(jugadorQueContesta);
        desactivarBotonesEnvido();

    }



    public void noAceptarTruco(ActionEvent actionEvent) {
        jugadorQueContesta.noAceptarTruco(jugada);
        actualizarPuntos();
        terminaLaJugada(actionEvent);
        jugadorQueJuega = orden.get(turnoJugador);
        setearJugadorQueDebeMostrar(jugadorQueJuega);



    }

    public void irseAlMazo(ActionEvent actionEvent) {
        jugadorQueJuega.irseAlMazo(jugada);
        actualizarPuntos();
        terminaLaJugada(actionEvent);
        jugadorQueJuega = orden.get(turnoJugador);
        setearJugadorQueDebeMostrar(jugadorQueJuega);
    }


    public void cantarEnvido(ActionEvent actionEvent) {

        jugadorQueContesta.cantarEnvido(jugada);
        jugadorQueContesta = jugada.obtenerEquipoQueNoContieneJugador(jugadorQueContesta).obtenerIntegrantes().get(0);
        setearJugadorQueDebeMostrar(jugadorQueContesta);

    }

    public void aceptarEnvido(ActionEvent actionEvent) {

        jugadorQueContesta.aceptarEnvido(jugada);
        for(Jugador jugador: orden) {
            diccionarioLabels.get(jugador).setText(String.valueOf(jugador.obtenerEnvido()));
        }
        actualizarPuntos();
        terminarPartida(actionEvent);
        setearJugadorQueDebeMostrar(jugadorQueJuega);

    }

    public void noAceptarEnvido(ActionEvent actionEvent) {

        jugadorQueContesta.noAceptarEnvido(jugada);
        actualizarPuntos();
        terminarPartida(actionEvent);
        setearJugadorQueDebeMostrar(jugadorQueJuega);

    }

    public void cantarRealEnvido(ActionEvent actionEvent) {

        jugadorQueContesta.cantarRealEnvido(jugada);
        jugadorQueContesta = jugada.obtenerEquipoQueNoContieneJugador(jugadorQueContesta).obtenerIntegrantes().get(0);
        setearJugadorQueDebeMostrar(jugadorQueContesta);

    }

    public void cantarFaltaEnvido(ActionEvent actionEvent) {

        jugadorQueContesta.cantarFaltaEnvido(jugada);
        jugadorQueContesta = jugada.obtenerEquipoQueNoContieneJugador(jugadorQueContesta).obtenerIntegrantes().get(0);
        setearJugadorQueDebeMostrar(jugadorQueContesta);

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

    public void setearJugadorQueDebeMostrar(Jugador jugador) {
        actualizacionDeJugador(jugador);
        diccionarioConfiguracion.get(jugador.obtenerEstado().getClass().getSimpleName()).setearConfiguaracionBotones(this);
        diccionarioConfiguracion.get(jugada.obtenerEstadoTruco().getClass().getSimpleName()).setearConfiguaracionBotones(this);
        diccionarioConfiguracion.get(jugada.obtenerEstadoEnvido().getClass().getSimpleName()).setearConfiguaracionBotones(this);
        if (!partida.esConFlor()){
            setearSinFlor();
        }
        estadoJugada.setText(jugada.obtenerEstadoTruco().getClass().getSimpleName());
        estadoJugador.setText(jugador.obtenerEstado().getClass().getSimpleName());
        mostrarCartasJugador(jugador);
    }

    public void setearConFlor() {
        partida.jugarConFlor();
        this.botonFlor.setDisable(false);

    }

    public void setearSinFlor(){
        this.botonFlor.setDisable(true);
        botonContraFlor.setDisable(true);
        botonContraFlorAlResto.setDisable(true);
        botonAceptarFlor.setDisable(true);
        botonNoAceptarFlor.setDisable(true);

    }

    protected void actualizarPuntos() {
        lblEquipo1.setText(String.valueOf(partida.obtenerEquipo1().obtenerPuntos()));
        lblEquipo2.setText(String.valueOf(partida.obtenerEquipo2().obtenerPuntos()));
    }

    public void desactivarBotonesCarta(boolean value) {
        carta1.setDisable(value);
        carta2.setDisable(value);
        carta3.setDisable(value);
    }

    protected void mostrarCartasJugador(Jugador jugadorQueJuega) {
        carta1.setText(String.valueOf(jugadorQueJuega.obtenerCartasEnMano().get(0).obtenerNumeroDeCarta()) + " de " + (jugadorQueJuega.obtenerCartasEnMano().get(0).getClass().getSimpleName()));
        carta2.setText(String.valueOf(jugadorQueJuega.obtenerCartasEnMano().get(1).obtenerNumeroDeCarta()) + " de " + (jugadorQueJuega.obtenerCartasEnMano().get(1).getClass().getSimpleName()));
        carta3.setText(String.valueOf(jugadorQueJuega.obtenerCartasEnMano().get(2).obtenerNumeroDeCarta()) + " de " + (jugadorQueJuega.obtenerCartasEnMano().get(2).getClass().getSimpleName()));
    }

    protected void limpiarLabels() {
        for (VBox vbox : diccionarioVBoxes.values()) {
            for (Node label : vbox.getChildren()) {
                ((Label) label).setText("?");
            }
        }

        lblMano.setText(diccionarioNombreJugadores.get(jugada.obtenerOrdenJugadoresMano().get(0)));
        for (Label label : diccionarioLabels.values()) {
            label.setText("");

        }
    }
    public void repartirCartas() {
        partida.obtenerMazo().mezclar();

        for (Jugador jugador : jugada.obtenerOrdenJugadoresMesa()) {
            jugador.agregarCarta(partida.obtenerMazo().darCarta());
            jugador.agregarCarta(partida.obtenerMazo().darCarta());
            jugador.agregarCarta(partida.obtenerMazo().darCarta());
        }
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
}
