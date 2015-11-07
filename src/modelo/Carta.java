package modelo;



/**
 * Created by Payas on 07/11/2015.
 */
public abstract class Carta {
    private int valorEnvido;


    public Carta(int valorenvido) {
        this.valorEnvido = new Integer(valorenvido);
    }

    public int obtenerValorEnvido() {
        return this.valorEnvido;
    }


    public int sumarEnvido(Carta unaCarta){

        return Integer.max(this.obtenerValorEnvido(), unaCarta.obtenerValorEnvido());
    }


    public abstract int devolverEnvido(Oro carta);
    public abstract int devolverEnvido(Basto carta);
    public abstract int devolverEnvido(Copa carta);
    public abstract int devolverEnvido(Espada carta);
}
