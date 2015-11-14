package modelo;

import java.util.List;

/**
 * Created by Lucio on 13/11/2015.
 */
public class Equipo {
    private List<Jugador> integrantes;

    public Equipo(List<Jugador> integrantes){
        this.integrantes = integrantes;
    }

    public List<Jugador> obtenerIntegrantes(){
        return integrantes;
    }

}
