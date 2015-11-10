package modelo;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucio on 08/11/2015.
 */
public class ValoresTrucoYEnvido {
    List<Pair> listaValoresTrucoYEnvido;

    public ValoresTrucoYEnvido() {
        listaValoresTrucoYEnvido = new ArrayList<>();
        setearValoresBasto();
        setearValoresCopa();
        setearValoresEspada();
        setearValoresOro();
    }

    private void setearValoresBasto() {
        listaValoresTrucoYEnvido.add(new Pair<>(1, 13));
        listaValoresTrucoYEnvido.add(new Pair<>(2, 9));
        listaValoresTrucoYEnvido.add(new Pair<>(3, 10));
        listaValoresTrucoYEnvido.add(new Pair<>(4, 1));
        listaValoresTrucoYEnvido.add(new Pair<>(5, 2));
        listaValoresTrucoYEnvido.add(new Pair<>(6, 3));
        listaValoresTrucoYEnvido.add(new Pair<>(7, 4));
        listaValoresTrucoYEnvido.add(new Pair<>(0, 5));
        listaValoresTrucoYEnvido.add(new Pair<>(0, 6));
        listaValoresTrucoYEnvido.add(new Pair<>(0, 7));
    }

    private void setearValoresCopa() {
        listaValoresTrucoYEnvido.add(new Pair<>(1, 8));
        listaValoresTrucoYEnvido.add(new Pair<>(2, 9));
        listaValoresTrucoYEnvido.add(new Pair<>(3, 10));
        listaValoresTrucoYEnvido.add(new Pair<>(4, 1));
        listaValoresTrucoYEnvido.add(new Pair<>(5, 2));
        listaValoresTrucoYEnvido.add(new Pair<>(6, 3));
        listaValoresTrucoYEnvido.add(new Pair<>(7, 4));
        listaValoresTrucoYEnvido.add(new Pair<>(0, 5));
        listaValoresTrucoYEnvido.add(new Pair<>(0, 6));
        listaValoresTrucoYEnvido.add(new Pair<>(0, 7));
    }

    private void setearValoresEspada() {
        listaValoresTrucoYEnvido.add(new Pair<>(1, 14));
        listaValoresTrucoYEnvido.add(new Pair<>(2, 9));
        listaValoresTrucoYEnvido.add(new Pair<>(3, 10));
        listaValoresTrucoYEnvido.add(new Pair<>(4, 1));
        listaValoresTrucoYEnvido.add(new Pair<>(5, 2));
        listaValoresTrucoYEnvido.add(new Pair<>(6, 3));
        listaValoresTrucoYEnvido.add(new Pair<>(7, 12));
        listaValoresTrucoYEnvido.add(new Pair<>(0, 5));
        listaValoresTrucoYEnvido.add(new Pair<>(0, 6));
        listaValoresTrucoYEnvido.add(new Pair<>(0, 7));
    }

    private void setearValoresOro() {
        listaValoresTrucoYEnvido.add(new Pair<>(1, 8));
        listaValoresTrucoYEnvido.add(new Pair<>(2, 9));
        listaValoresTrucoYEnvido.add(new Pair<>(3, 10));
        listaValoresTrucoYEnvido.add(new Pair<>(4, 1));
        listaValoresTrucoYEnvido.add(new Pair<>(5, 2));
        listaValoresTrucoYEnvido.add(new Pair<>(6, 3));
        listaValoresTrucoYEnvido.add(new Pair<>(7, 11));
        listaValoresTrucoYEnvido.add(new Pair<>(0, 5));
        listaValoresTrucoYEnvido.add(new Pair<>(0, 6));
        listaValoresTrucoYEnvido.add(new Pair<>(0, 7));
    }


    public int devolverValorEnvido(int posicion){
        return (int) (listaValoresTrucoYEnvido.get(posicion -1)).getKey();
    }

    public int devolverValorTruco(int posicion){
        return (int) listaValoresTrucoYEnvido.get(posicion -1).getValue();
    }

    public int devolverTamanio() {
        return listaValoresTrucoYEnvido.size();
    }
}
