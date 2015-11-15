package modelo.Carta;

import modelo.ValoresTrucoYEnvido;

/**
 * Created by Payas on 07/11/2015.
 */
public class Espada extends Carta {

    final int POSICIONCARTASESPADA = 20;

    public Espada(int numeroDeCarta, ValoresTrucoYEnvido valoresTrucoYEnvido) {
        super(numeroDeCarta,valoresTrucoYEnvido);

    }

    public int buscarYObtenerValorEnvido(int numeroDeCarta,ValoresTrucoYEnvido valoresTrucoYEnvido) {
        return valoresTrucoYEnvido.devolverValorEnvido(numeroDeCarta + POSICIONCARTASESPADA);
    }

    public int buscarYObtenerValorTruco(int numeroDeCarta,ValoresTrucoYEnvido valoresTrucoYEnvido){
        return valoresTrucoYEnvido.devolverValorTruco(numeroDeCarta + POSICIONCARTASESPADA);
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
