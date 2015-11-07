package modelo;

/**
 * Created by Payas on 07/11/2015.
 */
public class Basto extends Carta{

    public Basto(int valorenvido) {

        super(valorenvido);
    }

    @Override
    public int sumarEnvido(Carta unaCarta) {

        return unaCarta.devolverEnvido(this);
    }

    public  int devolverEnvido(Basto carta) {
        return this.obtenerValorEnvido() + carta.obtenerValorEnvido() + 20;
    }

    public  int devolverEnvido(Oro carta){return super.sumarEnvido(carta);}
    public  int devolverEnvido(Copa carta){return super.sumarEnvido(carta);}
    public  int devolverEnvido(Espada carta){return super.sumarEnvido(carta);}


}

