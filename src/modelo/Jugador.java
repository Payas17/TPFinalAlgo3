package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Payas on 07/11/2015.
 */
public class Jugador {
    private List<Carta> cartas;

    public Jugador(){
        this.cartas = new ArrayList<>();
    }

    public void agregarCarta(Carta unaCarta) {
        this.cartas.add(unaCarta);

    }

    public int cantarEnvido() {
        return Integer.max(Integer.max(sumarEnvido(0,1), sumarEnvido(0, 2)),sumarEnvido(1, 2));
    }

    private int sumarEnvido(int pos1, int pos2) {
        return this.cartas.get(pos1).sumarEnvido(this.cartas.get(pos2));
    }
}
