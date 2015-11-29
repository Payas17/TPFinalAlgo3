package modelo.EstadoTruco;

import modelo.Jugadas.Jugada;

/**
 * Created by Augusto on 14/11/2015.
 */
public interface EstadoDeTruco {
    void cantarTruco(Jugada jugada);

    int contarPuntosDeTruco();

    void cantarReTruco(Jugada jugada);

    void cantarValeCuatro(Jugada jugada);
}
