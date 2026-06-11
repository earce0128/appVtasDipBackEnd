package mx.com.mxds.appvtas.audit;

import mx.com.mxds.appvtas.entidades.Persona;
import mx.com.mxds.appvtas.servicios.ILogPersona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//@Component
public class AuditorOperPersona implements ILogPersona {

    private final static Logger log = LoggerFactory.getLogger(AuditorOperPersona.class);

    // TreeMap para que conserve el orden de las llaves como se van agregando
    Map<Integer, Operacion> mapOperaciones = new TreeMap<>();

    @Override
    public int guardarOperacion(String tipoOperacion, Persona persona) {
        int nFolio = this.mapOperaciones.size() + 1;
        Operacion operI = new Operacion(nFolio, tipoOperacion, persona);
        this.mapOperaciones.put(nFolio, operI);
        return nFolio;
    }

    @Override
    public void consultarOperacion(int folioOperacion) {
        Operacion oper = mapOperaciones.get(folioOperacion);
        if (oper != null) log.info(oper.toString());
        else log.warn("No existe operacion con el folio {} ", folioOperacion);
    }

    @Override
    public List<Integer> getFolios() {
        return new ArrayList<>(this.mapOperaciones.keySet());
    }

    private record Operacion(int folioOperacion, String tipoOperacion, Persona persona){}
}
