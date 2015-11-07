package modelo;

/**
 * Created by Payas on 07/11/2015.
 */
public class Oro extends Carta {

    public Oro(int valorenvido) {

        super(valorenvido);
        setearPalo("oro");
    }

    @Override
    public int sumarEnvido(Carta unaCarta) {

        if (unaCarta.obtenerPalo().equals("oro")){
            return this.obtenerValorEnvido() + unaCarta.obtenerValorEnvido() + 20;
        }
        return super.sumarEnvido(unaCarta);
    }



}
