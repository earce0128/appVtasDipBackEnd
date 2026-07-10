package qtx.externo.scope.entidades;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import qtx.externo.scope.core.IArbitro;

@Scope("prototype")
@Component
public class ArbitroLocal implements IArbitro {

    private static final Logger log = LoggerFactory.getLogger(ArbitroLocal.class);

    private static final String[] nombres = {"Ramiro","Juan Carlos","Miguel Ángel","Mariano","Lucas"};
    private static final String[] apellidos = {"Yañez","Juménez Mora","Gutiérrez","López","Martínez"};

    private final String nombreArbitro;

    public ArbitroLocal() {
        int numAleatorio = (int) (Math.random() * 10000);
        this.nombreArbitro = nombres[numAleatorio % nombres.length] + " "
                + apellidos[numAleatorio % apellidos.length];
        log.debug("Arbitro local: {}",this.nombreArbitro);
    }

    @Override
    public String getNombreArbitro() {
        return this.nombreArbitro;
    }

    @Override
    public String toString() {
        return "ArbitroLocal{" +
                "nombreArbitro='" + nombreArbitro + '\'' +
                '}';
    }
}