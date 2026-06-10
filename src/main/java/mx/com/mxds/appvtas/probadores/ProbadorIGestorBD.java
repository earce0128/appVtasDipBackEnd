package mx.com.mxds.appvtas.probadores;

import mx.com.mxds.appvtas.entidades.Persona;
import mx.com.mxds.appvtas.servicios.IGestorBD;
import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProbadorIGestorBD implements CommandLineRunner {
    private final static Logger log = LoggerFactory.getLogger(ProbadorIGestorBD.class);

    private final IGestorBD gestorBD;

    public ProbadorIGestorBD(IGestorBD gestorBD) {
        this.gestorBD = gestorBD;
        log.info("Se invocó al constructor de ProbadorIGestorBD");
    }

    public void saludar() {
        log.info("Hola a todos. Ha quedado registrada esta entrada histórica");
    }

    @Override
    public void run(String @NonNull ... args) throws Exception {
        this.saludar();
        Persona per = this.gestorBD.leerPersonaXID(1);
        log.info("Se ha leido a la persona con id = {} : {}", per.getIdPersona(), per);
    }
}
