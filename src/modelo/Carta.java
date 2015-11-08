package modelo;



/**
 * Created by Payas on 07/11/2015.
 */
public abstract class Carta {

    final int TANTO = 20;
    private int valorEnvido;
    private int valorTruco;


    public Carta(int valorenvido, int valorTruco) {
        this.valorEnvido = valorenvido;
        this.valorTruco = valorTruco;

    }

    public int obtenerValorEnvido() {
        return this.valorEnvido;
    }

    public int obtenerValorTruco() {
        return this.valorTruco;
    }

    public int sumarEnvido(Carta unaCarta){
        return Math.max(this.obtenerValorEnvido(), unaCarta.obtenerValorEnvido());
    }


    public abstract int devolverEnvido(Oro carta);
    public abstract int devolverEnvido(Basto carta);
    public abstract int devolverEnvido(Copa carta);
    public abstract int devolverEnvido(Espada carta);

}
