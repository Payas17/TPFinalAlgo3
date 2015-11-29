package modelo.EstadoEnvido;

import modelo.Equipo;
import modelo.Jugadas.Jugada;
import modelo.Jugadas.JugadaPicaPica;


/**
 * Created by Augusto on 14/11/2015.
 */
public interface EstadoDeEnvido {

    void cantarEnvido(Jugada jugada);

    void cantarRealEnvido(Jugada jugada);

    void cantarFaltaEnvido(Jugada jugada);

    int obtenerPuntos();

    void cantarFlor(Jugada jugada);

    void cantarContraFlor(Jugada jugada);

    void cantarContraFlorAlResto(Jugada jugada);

    void noAceptarFlor(Equipo equipo, Jugada jugada);

    void aceptarFlor(Equipo equipo1, Equipo equipo2,Jugada jugada);

    void aceptarEnvido(Jugada jugada);

    void noAceptarEnvido(Equipo equipoGanador, Jugada jugada);

    void cantarFaltaEnvidoPicaPica(JugadaPicaPica jugadaPicaPica);

    void cantarContraFlorAlRestoPicaPica(JugadaPicaPica jugadaPicaPica);
}
