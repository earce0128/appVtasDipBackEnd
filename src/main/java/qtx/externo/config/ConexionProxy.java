package qtx.externo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="proxy")
public class ConexionProxy {
    private String hostname;
    private String puerto;

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    @Override
    public String toString() {
        return "ConexionProxy{" +
                "hostname='" + hostname + '\'' +
                ", puerto='" + puerto + '\'' +
                '}';
    }
}
