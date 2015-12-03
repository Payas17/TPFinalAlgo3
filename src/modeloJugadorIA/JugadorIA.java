package modeloJugadorIA;

import modelo.Carta.Carta;

import modelo.EstadoJugador.*;
import modelo.Jugadas.Jugada;
import modelo.Jugador;
import modelo.Partida.Partida;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by Augusto on 24/11/2015.
 */
public class JugadorIA {

    private Hashtable<Integer, EstadoDeEnvidoInteligente> contenedor;

    private EstadoDeEnvidoInteligente estadoDeEnvidoInteligente;

    private Jugador jugador;

    private List<Carta> cartasPorJugar;

    private List<Carta> cartasEnJuego;

    private Partida partida;

    public JugadorIA(Jugador jugador){
        this.jugador = jugador;
        contenedor = new Hashtable<>();
        setearEstadoEnvido();
        cartasPorJugar = new ArrayList<>();

    }

    public EstadoDeEnvidoInteligente obtenerEstadoEnvido() {
        return estadoDeEnvidoInteligente;
    }

    public void asignarEstadoEnvidoInteligente(){
        if (jugador.tieneFlor()){
            cambiarEstadoEnvidoInteligente((contenedor.get(jugador.obtenerFlor())));
        }
        else{
            cambiarEstadoEnvidoInteligente((contenedor.get(jugador.obtenerEnvido())));
        }

    }

    public void cambiarEstadoEnvidoInteligente(EstadoDeEnvidoInteligente estadoDeEnvidoInteligente) {
        this.estadoDeEnvidoInteligente = estadoDeEnvidoInteligente;
    }

    public void setearEstadoEnvido(){
        for (int i=0; i<24; i++){
            contenedor.put (i, new EstadoSinEnvidoInteligente());
        }
        for (int i=24; i<27; i++){
            contenedor.put (i, new EstadoEnvidoInteligente());
        }
        contenedor.put(28, new EstadoRealEnvidoInteligente());
        contenedor.put(29, new EstadoRealEnvidoInteligente());
        contenedor.put(30, new EstadoRealEnvidoInteligente());
        contenedor.put(31, new EstadoEnvidoEnvidoInteligente());
        contenedor.put(32, new EstadoEnvidoEnvidoInteligente());
        contenedor.put(33, new EstadoFaltaEnvidoInteligente());

        for (int i=34; i < 37; i++){
            contenedor.put(i, new EstadoFlorInteligente());
        }

        contenedor.put(37, new EstadoContraFlorInteligente());
        contenedor.put(38, new EstadoContraFlorAlRestoInteligente());
    }

    public void cantar(Jugada jugada, Partida partida){
        if (jugador.obtenerEstado().getClass() == EstadoNoSeCantoNada.class ||jugador.obtenerEstado().getClass() == EstadoPuedeCantarTruco.class ||jugador.obtenerEstado().getClass() == EstadoPuedeCantarTrucoPrimeraMano.class ){
            decisionCantoTruco(jugada);
        }
        else{
            estadoDeEnvidoInteligente.cantar(jugador, jugada);
        }
    }

    private void decisionCantoTruco(Jugada jugada) {
        if (jugador.obtenerEstado().getClass() == EstadoPuedeCantarTruco.class || jugador.obtenerEstado().getClass() == EstadoPuedeCantarTrucoPrimeraMano.class) {
            List<Carta> cartas = obtenerCartasQueGananLaMano(obtenerMaxCartaEquipoRival(jugada));
            //if (cartas.size() == 2 && cartas.get(0).obtenerValorTruco() >= 9 && cartas.get(1).obtenerValorTruco() >= 9) {
                jugador.aceptarTruco(jugada);
           // } else {
            //    jugador.noAceptarTruco(jugada);
           // }
        } else {
            jugador.cantarTruco(jugada);
        }
    }


    public void agregarCarta(Carta carta) {
        jugador.agregarCarta(carta);
        cartasPorJugar.add(carta);
        if( cartasPorJugar.size() == 3){
            asignarEstadoEnvidoInteligente();
        }
    }

    public void jugarCarta(Jugada jugada){
        Carta maxCartaEquipoRival = obtenerMaxCartaEquipoRival(jugada);
        if (maxCartaEquipoRival != null){
            Carta cartaAJugar = obtenerCartaAJugar(maxCartaEquipoRival);
            jugador.juegaCarta(cartaAJugar);
            cartasPorJugar.remove(cartaAJugar);
        }else{
            Carta cartaAJugar = obtenerMinCarta(cartasPorJugar);
            jugador.juegaCarta(cartaAJugar);
            cartasPorJugar.remove(cartaAJugar);
        }
    }

    private Carta obtenerCartaAJugar(Carta maxCartaEquipoRival) {
        List<Carta> posiblesCartas = obtenerCartasQueGananLaMano(maxCartaEquipoRival);
        Carta cartaAJugar = obtenerMinCarta(cartasPorJugar);
        if (!posiblesCartas.isEmpty()){
            cartaAJugar = obtenerMinCarta(posiblesCartas);
        }
        return cartaAJugar;
    }

    private List<Carta> obtenerCartasQueGananLaMano(Carta maxCartaEquipoRival) {
        List<Carta> cartasQueGananLaMano = new ArrayList<>();
        for (Carta cartaActual : cartasPorJugar) {
            if ( maxCartaEquipoRival != null && cartaActual.obtenerValorTruco() > maxCartaEquipoRival.obtenerValorTruco() ) {
                cartasQueGananLaMano.add(cartaActual);
            }
        }
        return cartasQueGananLaMano;
    }

    private Carta obtenerMinCarta(List<Carta> cartas) {
        Carta cartaAJugar = cartas.get(0);
        for(Carta cartaActual: cartas) {
            if (cartaActual.obtenerValorTruco() < cartaAJugar.obtenerValorTruco()) {
                cartaAJugar = cartaActual;
            }
        }
        return cartaAJugar;
    }

    private Carta obtenerMaxCartaEnMano(List<Carta> cartas) {
        Carta cartaAJugar = cartas.get(0);
        for(Carta cartaActual: cartas) {
            if (cartaActual.obtenerValorTruco() > cartaAJugar.obtenerValorTruco()) {
                cartaAJugar = cartaActual;
            }
        }
        return cartaAJugar;
    }

    private Carta obtenerMaxCartaEquipoRival(Jugada jugada) {
        List<Jugador> jugadoresEquipoRival = jugada.obtenerEquipoQueNoContieneJugador(jugador).obtenerIntegrantes();
        Jugador jugadorAnterior = jugadoresEquipoRival.get(0);
        Carta maxCarta = null;
        for(Jugador jugadorActual : jugada.obtenerEquipoQueNoContieneJugador(jugador).obtenerIntegrantes()){
            if (jugadorActual.obtenerCartaEnJuego() != null && jugadorAnterior.obtenerCartaEnJuego() != null){
                maxCarta = obtenerMaxCarta(jugadorActual.obtenerCartaEnJuego(),jugadorAnterior.obtenerCartaEnJuego());
            }
        }
        return maxCarta;
    }

    private Carta obtenerMaxCarta(Carta carta1, Carta carta2) {
        return (carta1.obtenerValorTruco() >= carta2.obtenerValorTruco()) ? carta1 : carta2;
    }

    public Carta obtenerCartaEnJuego() {
        return jugador.obtenerCartaEnJuego();
    }

    public Jugador obtenerJugador (){return jugador;}

    public void limpiarCartas(){
        cartasPorJugar.removeAll(cartasPorJugar);
    }
}
