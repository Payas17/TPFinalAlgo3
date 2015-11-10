package fiuba.algo3.tests;

import modelo.Mazo;
import modelo.ValoresTrucoYEnvido;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Lucio on 07/11/2015.
 */
public class PruebasMazoTest {
    private Mazo mazo;
    private ValoresTrucoYEnvido tablaValores;


    @Test
    public void testMazoSeCreaCon40Cartas(){
        tablaValores = new ValoresTrucoYEnvido();
        mazo = new Mazo(tablaValores);
        Assert.assertEquals(mazo.cantidadDeCartas(), 40);
    }


}
