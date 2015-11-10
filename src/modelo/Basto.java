package modelo;

/**
 * Created by Payas on 07/11/2015.
 */
public class Basto extends Carta {
    ValoresTrucoYEnvido valoresTrucoYEnvido;
    final int POSICIONCARTASBASTO = 0;

    public Basto(int numeroDeCarta, ValoresTrucoYEnvido valoresTrucoYEnvido) {
        super(numeroDeCarta);

        this.valoresTrucoYEnvido = valoresTrucoYEnvido;
        this.valoresTrucoYEnvido = valoresTrucoYEnvido;
        if (numeroDeCarta >7){
            numeroDeCarta -= 2;
        }
        super.setearValorEnvido(buscarYObtenerValorEnvido(numeroDeCarta));
        super.setearValorTruco(buscarYObtenerValorTruco(numeroDeCarta));
    }

    private int buscarYObtenerValorEnvido(int numeroDeCarta) {
        return valoresTrucoYEnvido.devolverValorEnvido(numeroDeCarta + POSICIONCARTASBASTO);
    }

    private int buscarYObtenerValorTruco(int numeroDeCarta){
        return valoresTrucoYEnvido.devolverValorTruco(numeroDeCarta + POSICIONCARTASBASTO);
    }

    @Override
    public int sumarEnvido(Carta unaCarta) {

        return unaCarta.devolverEnvido(this);
    }

    public  int devolverEnvido(Basto carta){
        return this.obtenerValorEnvido() + carta.obtenerValorEnvido() + TANTO;
    }

    public  int devolverEnvido(Oro carta){return super.sumarEnvido(carta);}
    public  int devolverEnvido(Copa carta){return super.sumarEnvido(carta);}
    public  int devolverEnvido(Espada carta){return super.sumarEnvido(carta);}


}

