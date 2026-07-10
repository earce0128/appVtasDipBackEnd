package qtx.externo.scope.test;

import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import qtx.externo.scope.core.Torneo;
import qtx.externo.scope.core.TorneoColision;

@Component
public class TorneoTest implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(TorneoTest.class);

    @Autowired
    Torneo torneo;

    @Autowired
    TorneoColision torneoColision;

    @Override
    public void run(String @NonNull ... args) throws Exception {
        testScope();
        testColision();
    }

    private void testColision() {
        log.info("Iniciando Torneo para resolver una colisión");
        log.info("Árbitros designados en Torneo Colisión: Principal->{} y Suplente->{}",
                torneoColision.getArbitroPrincipal(),
                torneoColision.getArbitroSuplente());
    }

    private void testScope() {
        log.info("Iniciando TorneoTest Scope");
        log.info("Árbitros designados: Principal->{} y Suplente->{}",
                torneo.getArbitroPrincipal(),
                torneo.getArbitroSuplente());
    }
}
