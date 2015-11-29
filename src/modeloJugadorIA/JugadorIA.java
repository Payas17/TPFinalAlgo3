package modeloJugadorIA;

import modelo.Carta.Carta;
import modelo.Jugada.Jugada;
import modelo.Jugador;
import modelo.Partida.Partida;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by Augusto on 24/11/2015.
 */
public class JugadorIA {

    private Hashtable<Integer,EstadoEnvidoInteligente> contenedor;

    private EstadoEnvidoInteligente estadoEnvidoInteligente;

    private Jugador jugador;

    private List<Carta> cartas;

    private List<Carta> cartasEnJuego;

    public JugadorIA(){
        jugador = new Jugador();
        contenedor = new Hashtable<>();
        setearEstadoEnvido();
        cartas = new ArrayList<>();
        cartasEnJuego = new ArrayList<>();
    }

    public EstadoEnvidoInteligente obtenerEstadoEnvido() {
        buscarEstadoEnvidoInteligente();
        return estadoEnvidoInteligente;
    }

    public void buscarEstadoEnvidoInteligente(){
         cambiarEstadoEnvidoInteligente((contenedor.get(jugador.obtenerEnvido())));
    }

    public void cambiarEstadoEnvidoInteligente(EstadoEnvidoInteligente estadoEnvidoInteligente) {
        this.estadoEnvidoInteligente = estadoEnvidoInteligente;
    }

    public void setearEstadoEnvido(){
        for (int i=0; i<24; i++){
            contenedor.put (i, new EstadoSinEnvidoInteligente());
        }
        for (int i=24; i<27; i++){
            contenedor.put (i, new EstadoConEnvidoInteligente());
        }
        contenedor.put(28, new EstadoRealEnvidoInteligente());
        contenedor.put(29, new EstadoEnvidoEnvidoInteligente());
        contenedor.put(30, new EstadoEnvidoRealEnvidoInteligente());
        contenedor.put(31, new EstadoEnvidoRealEnvidoInteligente());
        contenedor.put(32, new EstadoEnvidoEnvidoRealEnvidoInteligente());
        contenedor.put(33, new EstadoEnvidoEnvidoRealEnvidoInteligente());

        for (int i=34; i < 37; i++){
            contenedor.put(i, new EstadoFlorInteligente());
        }

        contenedor.put(37, new EstadoContraFlorInteligente());
        contenedor.put(38, new EstadoContraFlorAlRestoInteligente());

    }

    public void agregarCarta(Carta carta) {
        jugador.agregarCarta(carta);
        cartas.add(carta);
    }

    public void cantarEnvido(){

    }

    public void jugarCarta(Jugada jugada){

        for(Jugador jugadorActual : jugada.obtenerEquipoQueNoContieneJugador(jugador).obtenerIntegrantes()){
        }

    }
}
