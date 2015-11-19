package modelo.EstadoEnvido;

import modelo.Equipo;
import modelo.Errores.NoSePuedeCantarEsoError;
import modelo.Jugada;

/**
 * Created by Augusto on 14/11/2015.
 */
public class EstadoFaltaEnvido implements EstadoDeEnvido{

    final int PUNTOS =30;
    @Override
    public void cantarEnvido(Jugada jugada) {throw new NoSePuedeCantarEsoError(); }

    @Override
    public void cantarRealEnvido(Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void cantarFaltaEnvido(Jugada jugada) {
        throw new NoSePuedeCantarEsoError();
    }

    @Override
    public void aceptarEnvido(Equipo equipoGanador, Equipo equipoPerdedor, int puntos) {
        if( equipoPerdedor.obtenerPuntos() > 15){
            int maxPuntaje = Math.max(equipoGanador.obtenerPuntos(), equipoPerdedor.obtenerPuntos());
            equipoGanador.sumarPuntos(30 - maxPuntaje);
        }
        else{
            equipoGanador.sumarPuntos(15 - equipoPerdedor.obtenerPuntos());
        }
    }

    @Override
    public int obtenerPuntos() {
        return PUNTOS;
    }

    @Override
    public void noAceptarEnvido(Equipo equipoGanador, int puntos) {
        equipoGanador.sumarPuntos(puntos);
    }

}
