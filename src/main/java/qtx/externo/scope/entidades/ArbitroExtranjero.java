package qtx.externo.scope.entidades;

import org.springframework.stereotype.Component;
import qtx.externo.scope.core.IArbitro;

import java.io.Serializable;

@Component
public class ArbitroExtranjero implements IArbitro, Serializable {
    @Override
    public String getNombreArbitro() {
        return "Soy un arbitro extranjero";
    }
}
