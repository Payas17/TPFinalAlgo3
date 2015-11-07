package modelo;

/**
 * Created by Payas on 07/11/2015.
 */
public class Copa extends Carta{

    public Copa(int valorenvido) {

        super(valorenvido);
    }


    @Override
    public int sumarEnvido(Carta unaCarta) {

        return unaCarta.devolverEnvido(this);
    }

    public  int devolverEnvido(Copa carta) {
        return this.obtenerValorEnvido() + carta.obtenerValorEnvido() + 20;
    }

    public  int devolverEnvido(Basto carta){return super.sumarEnvido(carta);}
    public  int devolverEnvido(Oro carta){return super.sumarEnvido(carta);}
    public  int devolverEnvido(Espada carta){return super.sumarEnvido(carta);}



}


