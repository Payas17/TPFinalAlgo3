package modelo.Carta;


import modelo.ValoresTrucoYEnvido;

/**
 * Created by Payas on 07/11/2015.
 */
public abstract class Carta {

    final int TANTO = 20;

    private int valorEnvido;
    private int valorTruco;
    private int numeroDeCarta;


    public Carta(int numeroDeCarta, ValoresTrucoYEnvido valoresTrucoYEnvido) {

        this.numeroDeCarta = numeroDeCarta;

        if (numeroDeCarta >7){
            numeroDeCarta -= 2;
        }
        setearValorEnvido(buscarYObtenerValorEnvido(numeroDeCarta,valoresTrucoYEnvido));
        setearValorTruco(buscarYObtenerValorTruco(numeroDeCarta,valoresTrucoYEnvido));

    }

    public abstract int buscarYObtenerValorEnvido(int numeroDeCarta,ValoresTrucoYEnvido valoresTrucoYEnvido);

    public abstract int buscarYObtenerValorTruco(int numeroDeCarta,ValoresTrucoYEnvido valoresTrucoYEnvido);

    public void setearValorEnvido(int valorEnvido) { this.valorEnvido = valorEnvido;}

    public void setearValorTruco(int valorTruco) { this.valorTruco = valorTruco;}

    public int obtenerValorEnvido() {
        return valorEnvido;
    }

    public int obtenerValorTruco() {
        return valorTruco;
    }

    public int sumarEnvido(Carta unaCarta){
        return Math.max(this.obtenerValorEnvido(), unaCarta.obtenerValorEnvido());
    }


    public abstract int devolverEnvido(Oro carta);
    public abstract int devolverEnvido(Basto carta);
    public abstract int devolverEnvido(Copa carta);
    public abstract int devolverEnvido(Espada carta);

}
