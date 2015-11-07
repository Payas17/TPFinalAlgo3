package modelo;

/**
 * Created by Payas on 07/11/2015.
 */
public class Basto extends Carta{

    public Basto(int valorenvido) {
        super(valorenvido);
    }


    public int sumarEnvido(Basto unaCarta) {

        return this.obtenerValorEnvido() + unaCarta.obtenerValorEnvido() + 20;
    }



}

