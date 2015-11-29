package controles;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Augusto on 29/11/2015.
 */
public class FrameworkDePantalla extends Application {

    public static String pantallaInicial = "pantallaInicial";
    public static String pantallaInicialArchivo = "/vista/PantallaInicial.fxml";
    public static String pantalla2Jugadores = "pantalla2Jugadores";
    public static String pantalla2JugadoresArchivo = "/vista/Pantalla2Jugadores.fxml";
    public static String pantalla4Jugadores = "pantalla4Jugadores";
    public static String pantalla4JugadoresArchivo = "/vista/Pantalla4Jugadores.fxml";
    public static String pantalla6Jugadores = "pantalla6Jugadores";
    public static String pantalla6JugadoresArchivo = "/vista/Pantalla6Jugadores.fxml";
    private static Stage primaryStage;

   @Override
    public void start(Stage primaryStage) throws Exception {
       this.primaryStage = primaryStage;
        ControladorPantallas contenedorPrincipal = new ControladorPantallas();
       contenedorPrincipal.cargarPantalla(FrameworkDePantalla.pantallaInicial, FrameworkDePantalla.pantallaInicialArchivo);
        contenedorPrincipal.cargarPantalla(FrameworkDePantalla.pantalla2Jugadores, FrameworkDePantalla.pantalla2JugadoresArchivo);
        contenedorPrincipal.cargarPantalla(FrameworkDePantalla.pantalla4Jugadores, FrameworkDePantalla.pantalla4JugadoresArchivo);
        contenedorPrincipal.cargarPantalla(FrameworkDePantalla.pantalla6Jugadores, FrameworkDePantalla.pantalla6JugadoresArchivo);


        contenedorPrincipal.setearPantalla(FrameworkDePantalla.pantallaInicial);

        Group raiz = new Group();
        raiz.getChildren().addAll(contenedorPrincipal);
        Scene escena = new Scene(raiz);
        primaryStage.setScene(escena);
        primaryStage.show();
    }
    public static void redimensionar(){
        primaryStage.sizeToScene();
        primaryStage.centerOnScreen(); }


    public static void main(String[] args) {
        launch(args);
    }
}
