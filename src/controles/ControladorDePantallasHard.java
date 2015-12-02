package controles;

import modelo.Carta.*;
import modelo.Jugadas.Jugada;
import modelo.Jugador;
import modelo.ValoresTrucoYEnvido;

/**
 * Created by Payas on 02/12/2015.
 */
public class ControladorDePantallasHard extends ControladorDePantallas {
    @Override
    void seteoDePartida() {

    }

    @Override
    public void repartirCartas() {

        ValoresTrucoYEnvido valoresTrucoYEnvido = new ValoresTrucoYEnvido();

        Carta copa10 = new Copa(10, valoresTrucoYEnvido);
        Carta copa4 = new Copa(4, valoresTrucoYEnvido);
        Carta copa5 = new Copa(5, valoresTrucoYEnvido);
        Carta espada12 = new Espada(12, valoresTrucoYEnvido);
        Carta espada6 = new Espada(6, valoresTrucoYEnvido);
        Carta espada7 = new Espada(7, valoresTrucoYEnvido);
        Carta oro11 = new Oro(11, valoresTrucoYEnvido);
        Carta oro4 = new Oro(4, valoresTrucoYEnvido);
        Carta oro5 = new Oro(5, valoresTrucoYEnvido);
        Carta basto5 = new Basto(5, valoresTrucoYEnvido);
        Carta basto4 = new Basto(4, valoresTrucoYEnvido);
        Carta basto3 = new Basto(3, valoresTrucoYEnvido);

        partida.obtenerEquipo1().obtenerIntegrantes().get(0).agregarCarta(copa10);
        partida.obtenerEquipo1().obtenerIntegrantes().get(0).agregarCarta(copa4);
        partida.obtenerEquipo1().obtenerIntegrantes().get(0).agregarCarta(oro4);

        partida.obtenerEquipo1().obtenerIntegrantes().get(1).agregarCarta(copa10);
        partida.obtenerEquipo1().obtenerIntegrantes().get(1).agregarCarta(copa4);
        partida.obtenerEquipo1().obtenerIntegrantes().get(1).agregarCarta(oro4);

        partida.obtenerEquipo1().obtenerIntegrantes().get(2).agregarCarta(copa10);
        partida.obtenerEquipo1().obtenerIntegrantes().get(2).agregarCarta(copa4);
        partida.obtenerEquipo1().obtenerIntegrantes().get(2).agregarCarta(copa5);

        partida.obtenerEquipo2().obtenerIntegrantes().get(0).agregarCarta(copa10);
        partida.obtenerEquipo2().obtenerIntegrantes().get(0).agregarCarta(copa4);
        partida.obtenerEquipo2().obtenerIntegrantes().get(0).agregarCarta(copa5);

        partida.obtenerEquipo2().obtenerIntegrantes().get(1).agregarCarta(copa10);
        partida.obtenerEquipo2().obtenerIntegrantes().get(1).agregarCarta(copa4);
        partida.obtenerEquipo2().obtenerIntegrantes().get(1).agregarCarta(oro4);

        partida.obtenerEquipo2().obtenerIntegrantes().get(2).agregarCarta(copa10);
        partida.obtenerEquipo2().obtenerIntegrantes().get(2).agregarCarta(copa4);
        partida.obtenerEquipo2().obtenerIntegrantes().get(2).agregarCarta(oro4);
    }
}
