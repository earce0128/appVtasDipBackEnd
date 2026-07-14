package qtx.externo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:propiedadesMXD.properties")
@ConfigurationProperties
public class PropiedadesGlobales {
    private String empresa;
    private String correo;

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getEmpresa() {
        return empresa;
    }

    @Override
    public String toString() {
        return "PropiedadesGlobales{" +
                "empresa='" + empresa + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}
