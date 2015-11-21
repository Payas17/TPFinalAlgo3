package modelo.EstadoEnvido;

import modelo.Equipo;
import modelo.Jugada;
import modelo.Jugador;

/**
 * Created by Augusto on 14/11/2015.
 */
public interface EstadoDeEnvido {

    void cantarEnvido(Jugada jugada);

    void cantarRealEnvido(Jugada jugada);

    void cantarFaltaEnvido(Jugada jugada);

    void aceptarEnvido(Jugada jugada);

    int obtenerPuntos();

    void noAceptarEnvido(Equipo equipoGanador,Jugada jugada);

    void cantarFlor(Jugada jugada);

    void noAceptarFlor(Equipo equipo, Jugada jugada);

    void aceptarFlor(Equipo equipo1, Equipo equipo2,Jugada jugada);

    void contraFlor(Jugada jugada);

    void contraFlorAlResto(Jugada jugada);
}
