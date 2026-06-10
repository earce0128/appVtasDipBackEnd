package mx.com.mxds.appvtas.probadores;

import jakarta.annotation.PostConstruct;
import mx.com.mxds.appvtas.entidades.Persona;
import mx.com.mxds.appvtas.servicios.IGestorBD;
import mx.com.mxds.appvtas.servicios.ILogPersona;
import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProbadorIGestorBD implements CommandLineRunner {
    private final static Logger log = LoggerFactory.getLogger(ProbadorIGestorBD.class);

    private final IGestorBD gestorBD;
    private final ILogPersona auditorPersona;

    public ProbadorIGestorBD(IGestorBD gestorBD, ILogPersona auditorPersona) {
        this.gestorBD = gestorBD;
        this.auditorPersona = auditorPersona;
        log.info("Se invocó al constructor de ProbadorIGestorBD");
    }

    @PostConstruct
    public void reportarFinConstruccionBean(){
        log.info("Spring ha terminado de construir este bean " + this.hashCode());
    }

    public void saludar() {
        log.info("Hola a todos. Ha quedado registrada esta entrada histórica");
    }

    @Override
    public void run(String @NonNull ... args) throws Exception {
        log.info("Corriendo en el Hilo {}", Thread.currentThread());
        this.saludar();
        for (int i = 1; i < 15 ; i++) {
            Persona per = this.gestorBD.leerPersonaXID(i);
            if(per != null)
                log.info("Se ha leido a la persona con id = {} : {}", per.getIdPersona(), per);
            else
                log.warn("La persona con id = {} : no existe", i);
        }

        // Utilizando el auditor de persona para mostrar las operaciones registradas
        List<Integer> folios = auditorPersona.getFolios();
        folios.forEach(this.auditorPersona::consultarOperacion);

    }
}
