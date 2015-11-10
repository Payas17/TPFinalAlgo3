package modelo;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucio on 08/11/2015.
 */
public class ValoresTrucoYEnvido {
    List<Tupla> listaValoresTrucoYEnvido;

    public ValoresTrucoYEnvido() {
        listaValoresTrucoYEnvido = new ArrayList<>();
        setearValoresBasto();
        setearValoresCopa();
        setearValoresEspada();
        setearValoresOro();
    }

    private void setearValoresBasto() {
        listaValoresTrucoYEnvido.add(new Tupla(1, 13));
        listaValoresTrucoYEnvido.add(new Tupla(2, 9));
        listaValoresTrucoYEnvido.add(new Tupla(3, 10));
        listaValoresTrucoYEnvido.add(new Tupla(4, 1));
        listaValoresTrucoYEnvido.add(new Tupla(5, 2));
        listaValoresTrucoYEnvido.add(new Tupla(6, 3));
        listaValoresTrucoYEnvido.add(new Tupla(7, 4));
        listaValoresTrucoYEnvido.add(new Tupla(0, 5));
        listaValoresTrucoYEnvido.add(new Tupla(0, 6));
        listaValoresTrucoYEnvido.add(new Tupla(0, 7));
    }

    private void setearValoresCopa() {
        listaValoresTrucoYEnvido.add(new Tupla(1, 8));
        listaValoresTrucoYEnvido.add(new Tupla(2, 9));
        listaValoresTrucoYEnvido.add(new Tupla(3, 10));
        listaValoresTrucoYEnvido.add(new Tupla(4, 1));
        listaValoresTrucoYEnvido.add(new Tupla(5, 2));
        listaValoresTrucoYEnvido.add(new Tupla(6, 3));
        listaValoresTrucoYEnvido.add(new Tupla(7, 4));
        listaValoresTrucoYEnvido.add(new Tupla(0, 5));
        listaValoresTrucoYEnvido.add(new Tupla(0, 6));
        listaValoresTrucoYEnvido.add(new Tupla(0, 7));
    }

    private void setearValoresEspada() {
        listaValoresTrucoYEnvido.add(new Tupla(1, 14));
        listaValoresTrucoYEnvido.add(new Tupla(2, 9));
        listaValoresTrucoYEnvido.add(new Tupla(3, 10));
        listaValoresTrucoYEnvido.add(new Tupla(4, 1));
        listaValoresTrucoYEnvido.add(new Tupla(5, 2));
        listaValoresTrucoYEnvido.add(new Tupla(6, 3));
        listaValoresTrucoYEnvido.add(new Tupla(7, 12));
        listaValoresTrucoYEnvido.add(new Tupla(0, 5));
        listaValoresTrucoYEnvido.add(new Tupla(0, 6));
        listaValoresTrucoYEnvido.add(new Tupla(0, 7));
    }

    private void setearValoresOro() {
        listaValoresTrucoYEnvido.add(new Tupla(1, 8));
        listaValoresTrucoYEnvido.add(new Tupla(2, 9));
        listaValoresTrucoYEnvido.add(new Tupla(3, 10));
        listaValoresTrucoYEnvido.add(new Tupla(4, 1));
        listaValoresTrucoYEnvido.add(new Tupla(5, 2));
        listaValoresTrucoYEnvido.add(new Tupla(6, 3));
        listaValoresTrucoYEnvido.add(new Tupla(7, 11));
        listaValoresTrucoYEnvido.add(new Tupla(0, 5));
        listaValoresTrucoYEnvido.add(new Tupla(0, 6));
        listaValoresTrucoYEnvido.add(new Tupla(0, 7));
    }


    public int devolverValorEnvido(int posicion){
        return (listaValoresTrucoYEnvido.get(posicion -1)).obtenerClave();
    }

    public int devolverValorTruco(int posicion){
        return listaValoresTrucoYEnvido.get(posicion -1).obtenerValor();
    }

    public int devolverTamanio() {
        return listaValoresTrucoYEnvido.size();
    }
}
