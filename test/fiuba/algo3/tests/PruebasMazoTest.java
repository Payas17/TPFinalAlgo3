package fiuba.algo3.tests;

import modelo.Carta.Carta;
import modelo.Mazo;
import modelo.ValoresTrucoYEnvido;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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



    @Test
    public void testMezclaDeMazoCon40Cartas(){
        tablaValores = new ValoresTrucoYEnvido();
        mazo= new Mazo (tablaValores);

        List<Carta> listaDeCartas= new ArrayList<>();
        List<Carta> listaDeCartasMezclada= new ArrayList<>();
        for (int i=0; i<40; i++){
            listaDeCartas.add(mazo.darCarta());
        }

        mazo.mezclar();

        for (int i=0; i<40; i++){
            listaDeCartasMezclada.add(mazo.darCarta());
        }


        Assert.assertTrue(listaDeCartas.get(0)!= listaDeCartasMezclada.get(0));

    }

}
