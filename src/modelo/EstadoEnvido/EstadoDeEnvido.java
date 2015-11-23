package modelo.EstadoEnvido;

import modelo.Equipo;
import modelo.Jugada.Jugada;
import modelo.Jugada.JugadaPicaPica;
import modelo.Partida.Partida;

/**
 * Created by Augusto on 14/11/2015.
 */
public interface EstadoDeEnvido {

    void cantarEnvido(Jugada jugada);

    void cantarRealEnvido(Jugada jugada);

    void cantarFaltaEnvido(Jugada jugada);

    int obtenerPuntos();

    void cantarFlor(Jugada jugada);

    void contraFlor(Jugada jugada);

    void contraFlorAlResto(Jugada jugada);

    void noAceptarFlor(Equipo equipo, Jugada jugada, Partida partida);

    void aceptarFlor(Equipo equipo1, Equipo equipo2,Jugada jugada, Partida partida);

    void aceptarEnvido(Jugada jugada, Partida partida);

    void noAceptarEnvido(Equipo equipoGanador, Jugada jugada, Partida partida);

    void cantarFaltaEnvidoPicaPica(JugadaPicaPica jugadaPicaPica);

    void cantarContraFlorAlRestoPicaPica(JugadaPicaPica jugadaPicaPica);
}
