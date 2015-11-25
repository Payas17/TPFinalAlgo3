package fiuba.algo3.tests.JugadorIATest;


import modelo.Carta.Carta;
import modelo.Carta.Espada;
import modelo.Carta.Oro;

import modelo.ValoresTrucoYEnvido;
import modeloJugadorIA.EstadoRealEnvidoInteligente;
import modeloJugadorIA.JugadorIA;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by Augusto on 24/11/2015.
 */
public class PruebasJugadorIAEnvidoTest {

     @Test
    public void testSiJugadorIAtiene26SePonEnEstadoEnvido(){

         JugadorIA jugador = new JugadorIA();

         ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();

         Carta oro7 = new Oro(7, valoresTrucoYEnvido);
         Carta oro1 = new Oro(1, valoresTrucoYEnvido);
         Carta espada1 = new Espada(7, valoresTrucoYEnvido);

         jugador.agregarCarta(oro7);
         jugador.agregarCarta(oro1);
         jugador.agregarCarta(espada1);


         Assert.assertEquals(jugador.obtenerEstadoEnvido().getClass(), EstadoRealEnvidoInteligente.class);
     }



}
