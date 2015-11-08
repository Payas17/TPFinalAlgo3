package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Payas on 07/11/2015.
 */
public class Jugador {

    final int TANTO = 20;
    private List<Carta> cartas;
    private int cantidadEnvido;

    public Jugador(){
        this.cartas = new ArrayList<>();
    }

    public void agregarCarta(Carta unaCarta) {
        this.cartas.add(unaCarta);

    }

    public int cantarEnvido() {
        return this.cantidadEnvido;
    }

    public void calcularEnvido(){
        this.cantidadEnvido = Integer.max(Integer.max(sumarEnvido(0,1), sumarEnvido(0, 2)),sumarEnvido(1, 2));
    }

    private int sumarEnvido(int pos1, int pos2) {
        return this.cartas.get(pos1).sumarEnvido(this.cartas.get(pos2));
    }

    public int cantarFlor(){

        if(sumarEnvido(0,1) > TANTO && sumarEnvido(0,2) > TANTO){
            calcularEnvido();
            return cantarEnvido();
        }

        throw new NoTieneFlorError();

    }
}
