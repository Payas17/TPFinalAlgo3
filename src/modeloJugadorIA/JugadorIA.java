package modeloJugadorIA;


import modelo.Jugador;

import java.util.Hashtable;

/**
 * Created by Augusto on 24/11/2015.
 */
public class JugadorIA extends Jugador {

    private Hashtable<Integer,EstadoEnvidoInteligente> contenedor;

    private EstadoEnvidoInteligente estadoEnvidoInteligente;

    public JugadorIA(){
        super();
        contenedor = new Hashtable<>();
        setearEstadoEnvido();
    }


    public EstadoEnvidoInteligente obtenerEstadoEnvido() {
        buscarEstadoEnvidoInteligente();
        return estadoEnvidoInteligente;
    }

    public void buscarEstadoEnvidoInteligente(){
         cambiarEstadoEnvidoInteligente((contenedor.get(this.obtenerEnvido())));
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
}
