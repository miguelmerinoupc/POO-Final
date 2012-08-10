package benedicto_clases.Grupo_de_Estudios;

// Autor: Miguel Merino
import benedicto_clases.Grupo_de_Estudios.Academia;
import benedicto_Asociaciones.DetalleGrupo;
import java.util.ArrayList;
import org.joda.time.DateTime;

public class GrupoEstudio {

    private String grupoCodigo;
    private String nombre;

    public ArrayList<DetalleGrupo> getDetalle() {
        return detalle;
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
    private DateTime fechaInicio;
    private DateTime fechaFin;
    private Estadogrupo estado;
    private String linkWeb;
    private String localCodigo;
    private String coordenadasGoogle;
    
    private ArrayList<DetalleGrupo> detalle;
    private ArrayList<Academia> academia;

    public ArrayList<Academia> getAcademia() {
        return academia;
    }
    
}
