package fiuba.algo3.tests;



import modelo.*;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by Lucio on 07/11/2015.
 */

public class PruebasEnvidoTest {

    @Test
    public void testTengo1DeOro7DeOroY7DeEspadaYCuenta28DeEnvido() {
        Jugador jugador = new Jugador();
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Carta oro7 = new Oro(7, valoresTrucoYEnvido);
        Carta oro1 = new Oro(1, valoresTrucoYEnvido);
        Carta espada1 = new Espada(7, valoresTrucoYEnvido);

        jugador.agregarCarta(oro7);
        jugador.agregarCarta(oro1);
        jugador.agregarCarta(espada1);

        jugador.calcularEnvido();

        Assert.assertEquals(jugador.cantarEnvido(), 28);

    }

    @Test
    public void testTengo1DeEspada10DeEspadaY5DeBastoYCuenta28DeEnvido() {
        Jugador jugador = new Jugador();
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Carta espada1 = new Espada(1, valoresTrucoYEnvido);
        Carta espada10 = new Espada(10, valoresTrucoYEnvido);
        Carta basto5 = new Basto(5, valoresTrucoYEnvido);

        jugador.agregarCarta(espada10);
        jugador.agregarCarta(basto5);
        jugador.agregarCarta(espada1);

        jugador.calcularEnvido();

        Assert.assertEquals(jugador.cantarEnvido(), 21);

    }

    @Test
    public void testTengo1DeCopa11DeBasto3DeCopaYCuenta24DeEnvido() {
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Jugador jugador = new Jugador();
        Carta copa1 = new Copa(1, valoresTrucoYEnvido);
        Carta basto11 = new Basto(11, valoresTrucoYEnvido);
        Carta copa3 = new Copa(3, valoresTrucoYEnvido);

        jugador.agregarCarta(copa1);
        jugador.agregarCarta(basto11);
        jugador.agregarCarta(copa3);

        jugador.calcularEnvido();

        Assert.assertEquals(jugador.cantarEnvido(), 24);

    }

    @Test
    public void testTengo12DeCopa7DeBasto6DeBastoYCuenta33DeEnvido() {
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Jugador jugador = new Jugador();
        Carta copa12 = new Copa(12, valoresTrucoYEnvido);
        Carta basto7 = new Basto(7, valoresTrucoYEnvido);
        Carta basto6 = new Basto(6, valoresTrucoYEnvido);

        jugador.agregarCarta(copa12);
        jugador.agregarCarta(basto7);
        jugador.agregarCarta(basto6);

        jugador.calcularEnvido();

        Assert.assertEquals(jugador.cantarEnvido(), 33);
    }
}
