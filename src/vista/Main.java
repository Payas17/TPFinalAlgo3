package vista;/**
 * Created by Augusto on 28/11/2015.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("PantallaInicial.fxml"));
        primaryStage.setTitle("Truco - Algoritmos III - Catedra Fontela - 2do Cuatrimestre 2015");
        primaryStage.setScene(new Scene(root, 400,300));


        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
