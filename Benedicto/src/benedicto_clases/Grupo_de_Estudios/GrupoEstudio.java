package benedicto_clases.Grupo_de_Estudios;

// Autor: Miguel Merino
import benedicto_clases.Grupo_de_Estudios.Academia;
import benedicto_Asociaciones.DetalleGrupo;
import java.util.ArrayList;
import org.joda.time.DateTime;

public class GrupoEstudio {

    public GrupoEstudio(String nombre, DateTime fechaInicio, DateTime fechaFin) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
    private String grupoCodigo;
    private String nombre;
    private Academia academia;
    private DateTime fechaInicio;
    private DateTime fechaFin;
    private Estadogrupo estado;
    private String linkWeb;
    private String coordenadasGoogle;
    private ArrayList<DetalleGrupo> detalleGrupo;

    public GrupoEstudio() {
    }

    public ArrayList<DetalleGrupo> getDetalle() {
        return detalleGrupo;
    }

    public Estadogrupo getEstado() {
        return estado;
    }

    public DateTime getFechaFin() {
        return fechaFin;
    }

    public DateTime getFechaInicio() {
        return fechaInicio;
    }

    public String getNombre() {
        return nombre;
    }

    public Academia getAcademia() {
        return academia;
    }

    public boolean VerificarObligatorios() {
        if (this.nombre == null || this.nombre.isEmpty()) {
            return false;
        }

        if (this.fechaInicio == null) {
            return false;
        }

        if (this.fechaInicio == null) {
            return false;
        }

        return true;
    }

    public GrupoEstudio(String nombre, Academia academia, DateTime fecinicio, DateTime fecFin, String link, String coordenadas, ArrayList<DetalleGrupo> detalle) {
        this.nombre = nombre;
        this.academia = academia;
        this.fechaInicio = fecinicio;
        this.fechaFin = fecFin;
        this.linkWeb = link;
        this.coordenadasGoogle = coordenadas;
        this.detalleGrupo = detalle;
    }

    public void AltaGrupo(String nombre,
            Academia academia,
            DateTime fecinicio,
            DateTime fecFin,
            String link,
            String coordenadas,
            ArrayList<DetalleGrupo> detalle) {
//listaGrupo

        GrupoEstudio grupoEstudio = new GrupoEstudio(nombre,
                academia,
                fecinicio,
                fecFin,
                link,
                coordenadas,
                detalle);


    }
}
