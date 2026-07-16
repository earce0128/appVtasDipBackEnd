package qtx.externo.config.test;

import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import qtx.externo.config.ConexionProxy;
import qtx.externo.config.PropEnvironment;
import qtx.externo.config.PropiedadesGlobales;

//@Component
public class TestConfig implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(TestConfig.class);

    @Autowired
    PropiedadesGlobales pg;

    @Autowired
    ConexionProxy cProxy;

    @Autowired
    PropEnvironment pEnv;

    @Override
    public void run(String @NonNull ... args) throws Exception {
        testConfigPropiedadesExternas();
        testConfigPropiedadesPrefijo();
        testConfigPropiedadesEnvironment();
    }

    private void testConfigPropiedadesEnvironment() {
        log.info("testConfigPropiedadesEnvironment");
        pEnv.inicializarVariablesEnv();
        log.info("empresa desde Env: {}",pEnv.getEmpresa());
        log.info("correo desde Env: {}",pEnv.getCorreo());
    }

    private void testConfigPropiedadesPrefijo() {
        log.info("testConfigPropiedadesPrefijo");
        log.info("hostname: {}",cProxy.getHostname());
        log.info("puerto: {}",cProxy.getPuerto());
    }

    private void testConfigPropiedadesExternas() {
        log.info("testConfigPropiedadesExternas");
        log.info("empresa: {}",pg.getEmpresa());
        log.info("correo: {}",pg.getCorreo());
    }
}