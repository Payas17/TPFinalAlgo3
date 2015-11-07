package fiuba.algo3.tests;



import modelo.*;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by Lucio on 07/11/2015.
 */

public class PruebasEnvidoTest {

    @Test
    public void testTengo1DeOro7DeOroY7DeEspadaYCuenta28DeEnvido(){
        Jugador jugador = new Jugador();
        Carta oro7 = new Oro(7);
        Carta oro1 = new Oro(1);
        Carta espada1 = new Espada(7);

        jugador.agregarCarta(oro7);
        jugador.agregarCarta(oro1);
        jugador.agregarCarta(espada1);

        Assert.assertEquals(jugador.cantarEnvido(), 28);

    }


    @Test
    public void testTengo1DeEspada10DeEspadaY5DeBastoYCuenta28DeEnvido(){
        Jugador jugador = new Jugador();
        Carta espada1 = new Espada(1);
        Carta espada10 = new Espada(0);
        Carta basto5 = new Basto(5);

        jugador.agregarCarta(espada10);
        jugador.agregarCarta(basto5);
        jugador.agregarCarta(espada1);

        Assert.assertEquals(jugador.cantarEnvido(), 21);

    }
}