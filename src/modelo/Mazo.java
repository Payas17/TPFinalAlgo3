package modelo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lucio on 09/11/2015.
 */
public class Mazo {
    private List<Carta> cartas;
    private ValoresTrucoYEnvido tablaValores;

    public Mazo(ValoresTrucoYEnvido tablaValores){
        cartas = new LinkedList<>();
        this.tablaValores = tablaValores;

        int i;
        for (i = 1; i < 13; i++){
            if (i == 8){
                i = 10;
            }
            cartas.add(new Oro(i,tablaValores));
            cartas.add(new Espada(i,tablaValores));
            cartas.add(new Basto(i,tablaValores));
            cartas.add(new Copa(i,tablaValores));
        }
    }

    public int cantidadDeCartas(){
        return cartas.size();
    }

    public void mezclar() {
        Collections.shuffle(cartas);
    }


}
