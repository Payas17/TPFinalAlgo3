package controles;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Augusto on 29/11/2015.
 */
public class FrameworkDePantalla extends Application {

    private static String pantallaInicial = "pantallaInicial";
    private static String pantallaInicialArchivo = "/vista/PantallaInicial.fxml";
    private static String pantalla2Jugadores = "pantalla2Jugadores";
    private static String pantalla2JugadoresArchivo = "/vista/Pantalla2Jugadores.fxml";
    private static String pantalla4Jugadores = "pantalla4Jugadores";
    private static String pantalla4JugadoresArchivo = "/vista/Pantalla4Jugadores.fxml";
    private static String pantalla6Jugadores = "pantalla6Jugadores";
    private static String pantalla6JugadoresArchivo = "/vista/Pantalla6Jugadores.fxml";
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

   @Override
    public void start(Stage primaryStage) throws Exception {
       this.primaryStage = primaryStage;
        ControladorPantallas contenedorPrincipal = new ControladorPantallas();
        contenedorPrincipal.cargarPantalla(pantallaInicial, pantallaInicialArchivo);
        contenedorPrincipal.cargarPantalla(pantalla2Jugadores, pantalla2JugadoresArchivo);
        contenedorPrincipal.cargarPantalla(pantalla4Jugadores, pantalla4JugadoresArchivo);
        contenedorPrincipal.cargarPantalla(pantalla6Jugadores, pantalla6JugadoresArchivo);


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
