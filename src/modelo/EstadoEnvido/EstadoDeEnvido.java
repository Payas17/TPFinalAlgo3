package modelo.EstadoEnvido;

import modelo.Equipo;
import modelo.Jugada;

/**
 * Created by Augusto on 14/11/2015.
 */
public interface EstadoDeEnvido {

    void cantarEnvido(Jugada jugada);

    void cantarRealEnvido(Jugada jugada);

    void cantarFaltaEnvido(Jugada jugada);

    void aceptarEnvido(Equipo equipoGanador, Equipo equipoPerdedor, Jugada jugada);

    int obtenerPuntos();

    void noAceptarEnvido(Equipo equipoGanador,Jugada jugada);
}
