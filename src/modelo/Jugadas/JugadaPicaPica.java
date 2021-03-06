package modelo.Jugadas;

import modelo.Equipo;
import modelo.EstadoJugador.EstadoPie;
import modelo.Jugador;
import modelo.Partida.Partida;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Augusto on 22/11/2015.
 */
public class JugadaPicaPica extends Jugada {


    public JugadaPicaPica(Partida partida,List<Jugador> ordenJugadores){
        super(partida,new ArrayList<>(ordenJugadores));
        equipo1 = null;
        equipo2 = null;
    }

    @Override
    public void limpiarJugadores() {

    }

    @Override
    public void cantarFaltaEnvido() {
        this.estadoEnvido.cantarFaltaEnvidoPicaPica(this);
    }

    @Override
    public void cantarContraFlorAlResto() {
        this.estadoEnvido.cantarContraFlorAlRestoPicaPica(this);
    }


    public void armarEquiposParaPicaPica(Jugador jugador1, Jugador jugador6) {

        ordenJugadoresMano = new ArrayList<>();
        ordenJugadoresMano.add(jugador1);
        ordenJugadoresMano.add(jugador6);
        ordenJugadores = ordenJugadoresMano;

        ordenJugadores.get(ordenJugadores.size() - 1).cambiarEstado(new EstadoPie());
        ordenJugadores.get(ordenJugadores.size() - 2).cambiarEstado(new EstadoPie());

        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        List<Jugador> jugadores2 = new ArrayList<>();
        jugadores2.add(jugador6);

        this.equipo1 = new Equipo(jugadores);
        this.equipo2 = new Equipo(jugadores2);
    }
}
