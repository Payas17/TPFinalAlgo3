package fiuba.algo3.tests;

import modelo.ValoresTrucoYEnvido;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Lucio on 09/11/2015.
 */
public class PruebasValoresTrucoYEnvido {
    @Test
    public void testValorEnvido1DeCopaIgualA1(){
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Assert.assertEquals(valoresTrucoYEnvido.devolverValorEnvido(11), 1);
    }

    @Test
    public void testValorEnvido3DeCopaIgualA3(){
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Assert.assertEquals(valoresTrucoYEnvido.devolverValorEnvido(13), 3);
    }

    @Test
    public void testValorEnvido7DeOroIgualA7(){
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Assert.assertEquals(valoresTrucoYEnvido.devolverValorEnvido(37), 7);
    }

    @Test
    public void testValorEnvido12DeOroIgualA0(){
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Assert.assertEquals(valoresTrucoYEnvido.devolverValorEnvido(40), 0);
    }

    @Test
    public void testValoresTrucoYEnvidoSeCreaConUnTamanioDe40(){
        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();
        Assert.assertEquals(valoresTrucoYEnvido.devolverTamanio(), 40);
    }
}
