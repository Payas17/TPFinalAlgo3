package modelo;

/**
 * Created by Payas on 09/11/2015.
 */
public class Tupla {
    private int clave;
    private int valor;

    public Tupla(int clave, int valor){
        this.clave = clave;
        this.valor = valor;
    }

    public int obtenerClave() {
        return clave;
    }

    public int obtenerValor() {
        return valor;
    }
}
