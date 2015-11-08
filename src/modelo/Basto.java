package modelo;

/**
 * Created by Payas on 07/11/2015.
 */
public class Basto extends Carta{

    public Basto(int valorenvido, int valorTruco) {

        super(valorenvido, valorTruco);
    }

    @Override
    public int sumarEnvido(Carta unaCarta) {

        return unaCarta.devolverEnvido(this);
    }

    public  int devolverEnvido(Basto carta){
        return this.obtenerValorEnvido() + carta.obtenerValorEnvido() + TANTO;
    }

    public  int devolverEnvido(Oro carta){return super.sumarEnvido(carta);}
    public  int devolverEnvido(Copa carta){return super.sumarEnvido(carta);}
    public  int devolverEnvido(Espada carta){return super.sumarEnvido(carta);}


}

