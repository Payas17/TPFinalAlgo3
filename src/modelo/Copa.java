package modelo;

/**
 * Created by Payas on 07/11/2015.
 */
public class Copa extends Carta{

    public Copa(int valorenvido) {
        super(valorenvido);
    }


    public int sumarEnvido(Copa unaCarta) {

        return this.obtenerValorEnvido() + unaCarta.obtenerValorEnvido() + 20;
    }

}


