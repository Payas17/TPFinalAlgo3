package modelo;



/**
 * Created by Payas on 07/11/2015.
 */
public abstract class Carta {
    private int valorEnvido;
    private String palo;

    public Carta(int valorenvido) {
        this.valorEnvido = valorenvido;
    }

    public int obtenerValorEnvido() {
        return this.valorEnvido;
    }


    public int sumarEnvido(Carta unaCarta){

        return Integer.max(this.obtenerValorEnvido(), unaCarta.obtenerValorEnvido());
    }

    public String obtenerPalo() {
        return this.palo;
    }

    public void setearPalo(String palo) {
        this.palo = palo;
    }
}
