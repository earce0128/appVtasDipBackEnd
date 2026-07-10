package qtx.externo.scope.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Torneo {

    private static final Logger log = LoggerFactory.getLogger(Torneo.class);

    @Autowired
    private IArbitro arbitroLocal;

    @Autowired
    private IArbitro arbitroExtranjero;

    public String getArbitroPrincipal() {
        return this.arbitroLocal.getNombreArbitro();
    }

    public String getArbitroSuplente() {
        return this.arbitroExtranjero.getNombreArbitro();
    }
}