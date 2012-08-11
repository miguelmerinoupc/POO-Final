
package benedicto_clases.AdministracionUsuarios;

import org.joda.time.DateTime;

/**
 * @author Miguel Merino
 */
public class Historia {
    private String usuario;
    private String modulo;
    private String opcion;
    private DateTime fecha;

    public Historia(String usuario, String modulo, String opcion, DateTime fecha) {
        this.usuario = usuario;
        this.modulo = modulo;
        this.opcion = opcion;
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    


}
