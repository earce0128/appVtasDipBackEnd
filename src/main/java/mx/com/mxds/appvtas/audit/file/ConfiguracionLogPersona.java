package mx.com.mxds.appvtas.audit.file;

import jakarta.annotation.PostConstruct;
import mx.com.mxds.appvtas.audit.AuditorOperPersona;
import mx.com.mxds.appvtas.audit.IPersistorLogPersona;
import mx.com.mxds.appvtas.servicios.ILogPersona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.List;

@Configuration
public class ConfiguracionLogPersona {
    private final static Logger log = LoggerFactory.getLogger(ConfiguracionLogPersona.class);
    private static final String PROP_FORMATO_LOG_PERSONA = "qtx.com.logpersona.formato";
    private static final String PROP_TIPO_LOG_PERSONA = "qtx.com.logpersona.tipo";

    // Enviroment es utilizado para inyectar un componente especial
    private final Environment env;

    public ConfiguracionLogPersona(Environment env) {
        this.env = env;
    }
    
    @PostConstruct
    public void checarConfiguracion() {
        String propBuscada = PROP_FORMATO_LOG_PERSONA;
        String valorFormatoLogPersona = this.env.getProperty(propBuscada);
        log.info("{} = {}",propBuscada, valorFormatoLogPersona);
        propBuscada = PROP_TIPO_LOG_PERSONA;
        valorFormatoLogPersona = this.env.getProperty(propBuscada);
        log.info("{} = {}", propBuscada,valorFormatoLogPersona);
    }

    @Bean
    public IPersistorLogPersona getIPersistorLogPersona() {
        log.info("creando bean IPersistorLogPersona");
        String valorFormatoLogPersona =  this.env.getProperty(PROP_FORMATO_LOG_PERSONA);

        if(valorFormatoLogPersona == null){
            return new IPersistorLogPersona() {
                @Override
                public void guardarOperaciones(Logger log, List<AuditorOperPersonaFile.Operacion> operaciones) {}
            };
        }

        switch(valorFormatoLogPersona){
            case "json" -> { return new PersistorLogPersonaFileJson(); }
            case "txt" -> { return new PersistorLogPersonaFile(); }
            case null -> throw new RuntimeException("No se encontró la propiedad " + PROP_FORMATO_LOG_PERSONA);
            default -> throw new IllegalArgumentException("Unexpected value: " + valorFormatoLogPersona);
        }
    }

    @Bean
    public ILogPersona getILogPersona(IPersistorLogPersona persistorLogPersona){
        log.info("creando bean ILogPersona");
        String tipoLogPersona = this.env.getProperty(PROP_TIPO_LOG_PERSONA);
        switch(tipoLogPersona){
            case "consola"-> { return new AuditorOperPersona(); }
            case "archivo"-> { return new AuditorOperPersonaFile(persistorLogPersona); }
            case null -> throw new RuntimeException("No se encontró la propiedad " + PROP_FORMATO_LOG_PERSONA);
            default -> throw new IllegalStateException("Unexpected value: " + tipoLogPersona);
        }
    }

}