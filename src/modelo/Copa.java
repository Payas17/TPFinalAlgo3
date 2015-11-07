package modelo;

/**
 * Created by Payas on 07/11/2015.
 */
public class Copa extends Carta{

    public Copa(int valorenvido) {

        super(valorenvido);
        setearPalo("copa");
    }


    @Override
    public int sumarEnvido(Carta unaCarta) {

        if (unaCarta.obtenerPalo().equals("copa")){
            return this.obtenerValorEnvido() + unaCarta.obtenerValorEnvido() + 20;
        }
        return super.sumarEnvido(unaCarta);
    }



}


