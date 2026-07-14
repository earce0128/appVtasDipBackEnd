package qtx.externo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:propiedadesMXD.properties")
public class PropEnvironment {
    @Autowired
    Environment env;

    private String empresa;
    private String correo;

    @Bean
    public String inicializarVariablesEnv() {
        this.empresa = env.getProperty("empresa");
        this.correo = env.getProperty("correo");
        return "empresa desde Env->" + this.empresa + ", correo desde Env-> " + this.correo;
    }

    public String getEmpresa() {
        return empresa;
    }
    public String getCorreo() {
        return correo;
    }

}