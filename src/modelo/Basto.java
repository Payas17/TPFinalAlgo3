package modelo;

/**
 * Created by Payas on 07/11/2015.
 */
public class Basto extends Carta{

    public Basto(int valorenvido) {

        super(valorenvido);
        setearPalo("basto");
    }


    public int sumarEnvido(Carta unaCarta) {

        if (unaCarta.obtenerPalo().equals("basto")){
            return this.obtenerValorEnvido() + unaCarta.obtenerValorEnvido() + 20;
        }
        return super.sumarEnvido(unaCarta);
    }




}

