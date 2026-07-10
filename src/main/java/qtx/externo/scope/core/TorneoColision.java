package qtx.externo.scope.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TorneoColision {

    private static final Logger log = LoggerFactory.getLogger(TorneoColision.class);

    @Autowired
    @Qualifier("arbitroLocal")
    private IArbitro arbitroPrincipal;

    @Autowired
    @Qualifier("arbitroExtranjero")
    private IArbitro arbitroSuplente;

    public String getArbitroPrincipal() {
        return this.arbitroPrincipal.getNombreArbitro();
    }

    public String getArbitroSuplente() {
        return this.arbitroSuplente.getNombreArbitro();
    }
}