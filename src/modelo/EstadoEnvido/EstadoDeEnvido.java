package modelo.EstadoEnvido;

import modelo.Jugada;

/**
 * Created by Augusto on 14/11/2015.
 */
public interface EstadoDeEnvido {

    void cantarEnvido(Jugada jugada);

    int obtenerPuntos();


    void cantarRealEnvido(Jugada jugada);

    void cantarFaltaEnvido(Jugada jugada);
}
