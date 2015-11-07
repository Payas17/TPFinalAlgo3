package modelo;

/**
 * Created by Payas on 07/11/2015.
 */
public class Espada extends Carta {

    public Espada(int valorenvido) {
        super(valorenvido);
    }

    public int sumarEnvido(Espada unaCarta) {

        return this.obtenerValorEnvido() + unaCarta.obtenerValorEnvido() + 20;

    }
}
