package modelo;

/**
 * Created by Payas on 09/11/2015.
 */
public class Tupla {
    private Object clave;
    private Object valor;

    public Tupla(Object clave, Object valor){
        this.clave = clave;
        this.valor = valor;
    }

    public Object obtenerClave() {
        return clave;
    }

    public Object obtenerValor() {
        return valor;
    }
}
