package modelo;

import java.util.*;

/**
 * Created by Lucio on 07/11/2015.
 */
public class Mazo {
    private List<Carta> cartas;

    public Mazo() {
        this.cartas = new LinkedList<>();
        crearCartas();
    }

    private void crearCartas() {

        setearLosDosYTres();
        setearLosSiete();
        setearLosUno();
        setearLasFiguras();
        setearLosCuatroCincoYSeis();
    }

    private void setearLosCuatroCincoYSeis() {
        int i;
        int j;
        for (i = 4, j = 1; j < 4 ; i++, j++) {

            cartas.add(new Oro(i,j));
            cartas.add(new Espada(i,j));
            cartas.add(new Basto(i,j));
            cartas.add(new Copa(i,j));
        }
    }

    private void setearLosDosYTres() {
        int i;
        int j;
        for (i = 2, j = 9; i < 4; i++,j++){
            cartas.add(new Oro(i ,j));
            cartas.add(new Espada(i, j));
            cartas.add(new Basto(i, j));
            cartas.add(new Copa(i, j));
        }
    }

    private void setearLasFiguras() {
        int i;
        for (i = 5; i < 8; i++) {

            cartas.add(new Oro(0,i));
            cartas.add(new Espada(0,i));
            cartas.add(new Basto(0,i));
            cartas.add(new Copa(0,i));
        }
    }

    private void setearLosUno() {
        cartas.add(new Oro(1 ,8));
        cartas.add(new Copa(1, 8));
        cartas.add(new Espada(1, 14));
        cartas.add(new Basto(1, 13));

    }

    private void setearLosSiete() {
        cartas.add(new Oro(7 ,11));
        cartas.add(new Espada(7, 12));
        cartas.add(new Basto(7, 4));
        cartas.add(new Copa(7, 4));
    }


    public int cantidadDeCartas(){
        return cartas.size();
    }
}
