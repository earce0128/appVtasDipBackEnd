package mx.com.mxds.appvtas.probadores;

import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Temporizador implements CommandLineRunner {
    private static final int PAUSA_SEGUNDOS = 30;
    private long contador = 0;
    private static final Logger log = LoggerFactory.getLogger(Temporizador.class);

    public void contar(){
        log.info("{}",contador);
        muestraHiloEjecucion();
        contador += 30;
        hacerPausa();
    }

    private static void muestraHiloEjecucion() {
        log.info("Corriendo en el Hilo {}", Thread.currentThread());
    }

    private void hacerPausa() {
        try {
            Thread.sleep(Temporizador.PAUSA_SEGUNDOS * 1000);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run(String @NonNull ... args) {
        muestraHiloEjecucion();
        this.contar();
    }
}

