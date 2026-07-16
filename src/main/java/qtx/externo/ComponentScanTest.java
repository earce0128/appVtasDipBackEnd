package qtx.externo;

import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public class ComponentScanTest implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(ComponentScanTest.class);

    @Value("${qtx.com.saludo.externo:No hay saludo externo}")
    private String saludoExterno;

    @Value("#{{'Deportivo Oceanía','Ciudad Deportiva','Deportivo Chapultepec'}}")
    private List<String> deportivos;

    @Override
    public void run(String @NonNull ... args) throws Exception {
        log.info("Saludo externo @Value:{}", saludoExterno);
        log.info("Deportivos @Value:{}", deportivos);
    }
}
