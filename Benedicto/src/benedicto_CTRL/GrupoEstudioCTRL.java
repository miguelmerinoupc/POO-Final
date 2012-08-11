package benedicto_CTRL;

// Autor : Miguel Merino
import benedicto_clases.Grupo_de_Estudios.GrupoEstudio;
import benedicto_clases.Grupo_de_Estudios.Academia;
import benedicto_Asociaciones.*;
import benedicto_ordenamientos.*;
import java.lang.String;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import org.joda.time.DateTime;

public class GrupoEstudioCTRL {

    private ArrayList<Academia> listaAcademia = new ArrayList<Academia>();
    private ArrayList<GrupoEstudio> listaGrupo = new ArrayList<GrupoEstudio>();
    private DateTime fecha = new DateTime(2012, 1, 15, 0, 0);

    public Boolean ValidoCamposObligatorios(GrupoEstudio grupoEstudio) {
        return grupoEstudio.VerificarObligatorios();
    }

    public Boolean AltaGrupo(GrupoEstudio grupoEstudio) {
        listaGrupo.add(grupoEstudio);
        return true;
    }

    public ArrayList<GrupoEstudio> BuscarGrupo(String nomGrupo, String nomAcademia, String nomCurso,
            DateTime fecInicio, DateTime fecFin, String nomEstado) {

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

    public void ListarResultado() {
        GrupoEstudio grupo;
        for (int i = 0; i < listaGrupo.size(); i++) {
            grupo = listaGrupo.get(i);

            System.out.println("Grupo: " + grupo.getNombre());
            System.out.println("\tAcademia: " + grupo.getAcademia().getNombre());
            System.out.println("\tFecha Inicio: " + grupo.getFechaInicio().toString());
            System.out.println("\tFecha Fin: " + grupo.getFechaFin().toString());
            System.out.println("\tLink Sillabus: " + grupo.getLinkWeb());
            System.out.println("\tCoordenadas Google: " + grupo.getCoordenadasGoogle());
            System.out.println("Grupo: " + grupo.getNombre());


            System.out.println("-");
        }
    }
}
