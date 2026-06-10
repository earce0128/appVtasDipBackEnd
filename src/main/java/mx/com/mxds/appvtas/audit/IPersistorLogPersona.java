package mx.com.mxds.appvtas.audit;

import mx.com.mxds.appvtas.audit.file.AuditorOperPersonaFile;
import org.slf4j.Logger;

import java.util.List;

public interface IPersistorLogPersona {
    void guardarOperaciones(Logger log, List<AuditorOperPersonaFile.Operacion> operaciones);
}
