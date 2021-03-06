package vista;

import controles.ControladorPantallas;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Augusto on 29/11/2015.
 */
public class FrameworkDePantalla extends Application {

    private static String pantallaInicial = "pantallaInicial";
    private static String pantallaInicialArchivo = "/vista/Pantallas/PantallaInicial.fxml";
    private static String pantalla2Jugadores = "pantalla2Jugadores";
    private static String pantalla2JugadoresArchivo = "/vista/Pantallas/Pantalla2Jugadores.fxml";
    private static String pantalla4Jugadores = "pantalla4Jugadores";
    private static String pantalla4JugadoresArchivo = "/vista/Pantallas/Pantalla4Jugadores.fxml";
    private static String pantalla6Jugadores = "pantalla6Jugadores";
    private static String pantalla6JugadoresArchivo = "/vista/Pantallas/Pantalla6Jugadores.fxml";
    private static String sobreNosotros = "sobreNosotros";
    private static String sobreNosotrosArchivo = "/vista/Pantallas/SobreNosotros.fxml";
    private static String pantallaGanador= "pantallaGanador";
    private static String pantallaGanadorArchivo= "/vista/Pantallas/PantallaGanador.fxml";
    private static String pantallaJugadorIA= "pantallaJugadorIA";
    private static String pantallaJugadorIAArchivo= "/vista/Pantallas/PantallaJugadorIA.fxml";



    private static Stage primaryStage;

    public static String obtenerPantallaInicial(){
        return pantallaInicial;
    }
    public static  String obtenerPantalla2Jugadores(){
        return pantalla2Jugadores;
    }
    public static String obtenerPantalla4Jugadores(){
        return pantalla4Jugadores;
    }
    public static String obtenerPantalla6Jugadores(){
        return pantalla6Jugadores;
    }
    public static String obtenerPantallaSobreNosotros() {return sobreNosotros;}
    public static String obtenerPantallaGanador() {return pantallaGanador;}
    public static String obtenerPantallaJugadorIA() {return pantallaJugadorIA;
    }


   @Override
    public void start(Stage primaryStage) throws Exception {
       this.primaryStage = primaryStage;
        ControladorPantallas contenedorPrincipal = new ControladorPantallas();
       contenedorPrincipal.cargarPantalla(pantallaInicial, pantallaInicialArchivo);
       contenedorPrincipal.cargarPantalla(pantalla2Jugadores, pantalla2JugadoresArchivo);
       contenedorPrincipal.cargarPantalla(pantalla4Jugadores, pantalla4JugadoresArchivo);
       contenedorPrincipal.cargarPantalla(pantalla6Jugadores, pantalla6JugadoresArchivo);
       contenedorPrincipal.cargarPantalla(sobreNosotros,sobreNosotrosArchivo);
       contenedorPrincipal.cargarPantalla(pantallaGanador, pantallaGanadorArchivo);
       contenedorPrincipal.cargarPantalla(pantallaJugadorIA, pantallaJugadorIAArchivo);

        contenedorPrincipal.setearPantalla(FrameworkDePantalla.pantallaInicial);

        Group raiz = new Group();
        raiz.getChildren().addAll(contenedorPrincipal);
        Scene escena = new Scene(raiz);
        primaryStage.setTitle("Truco");
        primaryStage.setScene(escena);
        primaryStage.show();
    }
    public static void redimensionar(){
        primaryStage.sizeToScene();
        primaryStage.centerOnScreen();
    }



    public static void main(String[] args) {
        launch(args);
    }



}
