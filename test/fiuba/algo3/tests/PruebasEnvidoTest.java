package fiuba.algo3.tests;


import modelo.Carta;
import modelo.Espada;
import modelo.Jugador;
import modelo.Oro;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Lucio on 07/11/2015.
 */

public class PruebasEnvidoTest {

    @Test
    public void testTengo1DeEspada7DeEspadaY5DeBastoYCuenta28DeEnvido(){
        Jugador jugador = new Jugador();
        Carta oro7 = new Oro(7);
        Carta oro1 = new Oro(1);
        Carta espada1 = new Espada(1);

        jugador.agregarCarta(oro7);
        jugador.agregarCarta(oro1);
        jugador.agregarCarta(espada1);

        Assert.assertEquals(jugador.cantarEnvido(), 28);

    }
    @Test
    public void testDEMIERDA(){

    }
}
