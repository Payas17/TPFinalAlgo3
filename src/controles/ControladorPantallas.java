package controles;

import com.sun.javafx.css.StyleCache;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Augusto on 29/11/2015.
 */
public class ControladorPantallas extends StackPane{

    private HashMap<String,Node> pantallas = new HashMap<>();

    public ControladorPantallas(){
        super();
    }

    public void agregarPantalla(String nombre, Node pantalla){
        pantallas.put(nombre,pantalla);
    }

    public Node obtenerPantalla(String nombre){
        return pantallas.get(nombre);
    }

    public boolean cargarPantalla(String nombre, String recurso) throws IOException {
        /*FXMLLoader cargador = new FXMLLoader(getClass().getResource(recurso));
        Parent cargarPantalla = ((Parent)cargador.load());
        ControladorDePantallas miControladorDePantallas = ((ControladorDePantallas)cargador.getController());
        miControladorDePantallas.setearPadreDePantalla(this);
        agregarPantalla(nombre,cargarPantalla);
        return true;*/

        try {
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource(recurso));
            Parent loadScreen = (Parent) myLoader.load();
            ControladorDePantallas myScreenControler = ((ControladorDePantallas) myLoader.getController());
            myScreenControler.setearPadreDePantalla(this);
            agregarPantalla(nombre, loadScreen);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean setearPantalla(String nombre){
        if (pantallas.get(nombre) != null) {   //screen loaded
            final DoubleProperty opacity = opacityProperty();

            if (!getChildren().isEmpty()) {    //if there is more than one screen
                Timeline fade = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                        new KeyFrame(new Duration(1000), new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent t) {
                                getChildren().remove(0);                    //remove the displayed screen
                                getChildren().add(0, pantallas.get(nombre));
                                FrameworkDePantalla.redimensionar();
                                Timeline fadeIn = new Timeline(
                                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                                        new KeyFrame(new Duration(800), new KeyValue(opacity, 1.0)));
                                fadeIn.play();
                            }
                        }, new KeyValue(opacity, 0.0)));
                fade.play();

            } else {
                setOpacity(0.0);
                getChildren().add(pantallas.get(nombre));       //no one else been displayed, then just show
                Timeline fadeIn = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                        new KeyFrame(new Duration(2500), new KeyValue(opacity, 1.0)));
                fadeIn.play();
            }
            return true;
        } else {
            System.out.println("Pantalla no ha sido cargada \n");
            return false;
    }

    }

}
