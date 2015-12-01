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
import java.net.URL;
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


    public boolean cargarPantalla(String nombre, String recurso) throws IOException {

        try {
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource(recurso));
            Parent loadScreen =  myLoader.load();
            ControladorDePantallas myScreenControler =  myLoader.getController();
            myScreenControler.setearPadreDePantalla(this);
            agregarPantalla(nombre, loadScreen);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean setearPantalla(String nombre){
        if (pantallas.get(nombre) != null) {
            return hacerFadeIn(nombre);
        } else {
            System.out.println("Pantalla no ha sido cargada \n");
            return false;
        }
    }

    private boolean hacerFadeIn(final String nombre) {
        final DoubleProperty opacity = opacityProperty();

        if (!getChildren().isEmpty()) {
            Timeline fade = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                    new KeyFrame(new Duration(100), new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent t) {
                            getChildren().remove(0);
                            getChildren().add(0, pantallas.get(nombre));
                            FrameworkDePantalla.redimensionar();
                            Timeline fadeIn = new Timeline(
                                    new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                                    new KeyFrame(new Duration(100), new KeyValue(opacity, 1.0)));
                            fadeIn.play();
                        }
                    }, new KeyValue(opacity, 0.0)));
            fade.play();

        } else {
            setOpacity(0.0);
            getChildren().add(pantallas.get(nombre));
            Timeline fadeIn = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                    new KeyFrame(new Duration(2500), new KeyValue(opacity, 1.0)));
            fadeIn.play();
        }
        return true;
    }

    public ControlPantallaInicial obtenerControlPantallaInicial(){
        URL lugar = getClass().getResource("/vista/PantallaInicial.fxml");
        FXMLLoader myLoader = new FXMLLoader();
        try{
            Parent raiz = myLoader.load(lugar.openStream());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return myLoader.getController();
    }

}
