package modelo;

/**
 * Created by Payas on 07/11/2015.
 */
public class Oro extends Carta {

    public Oro(int valorenvido) {
        super(valorenvido);
    }


    public int sumarEnvido(Oro unaCarta) {

        return this.obtenerValorEnvido() + unaCarta.obtenerValorEnvido() + 20;
    }

}
