package modelo.Carta;

import modelo.ValoresTrucoYEnvido;

/**
 * Created by Payas on 07/11/2015.
 */
public class Copa extends Carta {

    final int POSICIONCARTASCOPA = 10;

    public Copa(int numeroDeCarta, ValoresTrucoYEnvido valoresTrucoYEnvido) {
        super(numeroDeCarta, valoresTrucoYEnvido);
    }

    public int buscarYObtenerValorEnvido(int numeroDeCarta, ValoresTrucoYEnvido valoresTrucoYEnvido) {
        return valoresTrucoYEnvido.devolverValorEnvido(numeroDeCarta + POSICIONCARTASCOPA);
    }

    public int buscarYObtenerValorTruco(int numeroDeCarta, ValoresTrucoYEnvido valoresTrucoYEnvido){
        return valoresTrucoYEnvido.devolverValorTruco(numeroDeCarta + POSICIONCARTASCOPA);
    }

    @Override
    public int sumarEnvido(Carta unaCarta) {

        return unaCarta.devolverEnvido(this);
    }

    public  int devolverEnvido(Copa carta) {
        return this.obtenerValorEnvido() + carta.obtenerValorEnvido() + TANTO;
    }

    public  int devolverEnvido(Basto carta){return super.sumarEnvido(carta);}
    public  int devolverEnvido(Oro carta){return super.sumarEnvido(carta);}
    public  int devolverEnvido(Espada carta){return super.sumarEnvido(carta);}

}


