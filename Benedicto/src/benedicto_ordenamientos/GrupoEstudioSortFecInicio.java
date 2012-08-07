package benedicto_ordenamientos;

import benedicto_clases.GrupoEstudio;
import java.util.Comparator;

// Autor : Miguel Merino
public class GrupoEstudioSortFecInicio implements Comparator<GrupoEstudio> {

    public int compare(GrupoEstudio g1, GrupoEstudio g2) {
        return g1.getFechaInicio().compareTo(g2.getFechaInicio());
    }
}
