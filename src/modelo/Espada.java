package modelo;

/**
 * Created by Payas on 07/11/2015.
 */
public class Espada extends Carta {

    public Espada(int valorenvido, int valorTruco) {

        super(valorenvido, valorTruco);

    }

    @Override
    public int sumarEnvido(Carta unaCarta) {

        return unaCarta.devolverEnvido(this);
    }

    public  int devolverEnvido(Espada carta) {
        return this.obtenerValorEnvido() + carta.obtenerValorEnvido() + TANTO;
    }

    public  int devolverEnvido(Basto carta){return super.sumarEnvido(carta);}
    public  int devolverEnvido(Copa carta){return super.sumarEnvido(carta);}
    public  int devolverEnvido(Oro carta){return super.sumarEnvido(carta);}

}
