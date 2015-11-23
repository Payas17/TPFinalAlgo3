package modelo;

import modelo.EstadoEnvido.EstadoSinEnvido;
import modelo.EstadoJugada.EstadoPrimeraMano;
import modelo.EstadoJugador.EstadoPie;
import modelo.EstadoTruco.EstadoSinTruco;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Augusto on 22/11/2015.
 */
public class JugadaPicaPica extends Jugada {


    public JugadaPicaPica(){
        super();
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


       /* this.equipo1.obtenerIntegrantes().removeAll(equipo1.obtenerIntegrantes());
        this.equipo2.obtenerIntegrantes().removeAll(equipo2.obtenerIntegrantes());
        ordenJugadores.removeAll(ordenJugadores);
        */

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
