package modelo;

/**
 * Created by Payas on 07/11/2015.
 */
public class Espada extends Carta {

    public Espada(int valorenvido) {
        super(valorenvido);
        setearPalo("espada");
    }

    @Override
    public int sumarEnvido(Carta unaCarta) {

        if (unaCarta.obtenerPalo().equals("espada")){
            return this.obtenerValorEnvido() + unaCarta.obtenerValorEnvido() + 20;
        }
        return super.sumarEnvido(unaCarta);
    }


}
