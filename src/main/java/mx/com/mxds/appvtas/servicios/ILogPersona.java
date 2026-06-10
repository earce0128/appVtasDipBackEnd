package mx.com.mxds.appvtas.servicios;

import mx.com.mxds.appvtas.entidades.Persona;

import java.util.List;

public interface ILogPersona {
    int guardarOperacion(String tipoOperacion, Persona persona);
    void consultarOperacion(int folioOperacion);
    List<Integer> getFolios();
}
