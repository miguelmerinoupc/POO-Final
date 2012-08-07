package benedicto_CTRL;

// Autor : Miguel Merino
import benedicto_Asociaciones.DetalleGrupo;
import benedicto_clases.*;
import benedicto_ordenamientos.GrupoEstudioSortFecInicio;
import java.util.ArrayList;
import java.util.Collections;
import org.joda.time.DateTime;

public class GrupoEstudioCTRL {

    private ArrayList<Academia> listaAcademia = new ArrayList<Academia>();
    private ArrayList<GrupoEstudio> listaGrupo = new ArrayList<GrupoEstudio>();
    private DateTime fecha = new DateTime(2012, 1, 15, 0, 0);

    public ArrayList<GrupoEstudio> BuscarGrupo(String nomGrupo, String nomAcademia, String nomCurso,
            String fecInicio, String fecFin, String nomEstado) {

        GrupoEstudio grupoEstudio;
        ArrayList<GrupoEstudio> listaencontrada = new ArrayList<GrupoEstudio>();

        DetalleGrupo detalleGrupo;
        ArrayList<DetalleGrupo> listaDetalle;

        if (nomCurso.isEmpty()) {
            for (int i = 0; i < listaGrupo.size(); i++) {
                grupoEstudio = listaGrupo.get(i);

                if (grupoEstudio.getNombre().equals(nomGrupo)
                        || grupoEstudio.getAcademia().getNombre().equals(nomAcademia)
                        || grupoEstudio.getFechaInicio().equals(fecInicio)
                        || grupoEstudio.getFechaFin().equals(fecFin)
                        || grupoEstudio.getEstado().getNombre().equals(nomEstado)) {

                    listaencontrada.add(grupoEstudio);
                }
            }
        } else {
            for (int i = 0; i < listaGrupo.size(); i++) {
                grupoEstudio = listaGrupo.get(i);

                if (grupoEstudio.getNombre().equals(nomGrupo)
                        || grupoEstudio.getAcademia().getNombre().equals(nomAcademia)
                        || grupoEstudio.getFechaInicio().equals(fecInicio)
                        || grupoEstudio.getFechaFin().equals(fecFin)
                        || grupoEstudio.getEstado().getNombre().equals(nomEstado)) {

                    listaDetalle = grupoEstudio.getDetalle();

                    for (int j = 0; j < listaDetalle.size(); j++) {
                        detalleGrupo = listaDetalle.get(j);
                        if (detalleGrupo.getCurso().getNombre().equals(nomCurso)) {
                            listaencontrada.add(grupoEstudio);
                        }
                    }
                }
            }
        }

        Collections.sort(listaencontrada, new GrupoEstudioSortFecInicio());

        return listaencontrada;
    }
}
