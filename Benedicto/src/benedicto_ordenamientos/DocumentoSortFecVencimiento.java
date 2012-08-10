package benedicto_ordenamientos;

/**
 *
 * @author FRANKLIN
 */

import benedicto_clases.documentos.Documento;
import benedicto_clases.*;
import java.util.Comparator;

public class DocumentoSortFecVencimiento implements Comparator<Documento> {

    public int compare(Documento d1, Documento d2) {
        return d1.getFecVencimiento().compareTo(d2.getFecVencimiento());
    }
    
}