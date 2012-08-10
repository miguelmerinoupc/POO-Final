

package benedicto_clases;

import org.joda.time.DateTime;

/**
 * Autor : Miguel Merino
 */
public class AdmUsuario {

    private String dni;
    private String nombre;
    private String ap_Paterno;
    private String ap_Materno;
    private String usuario;
    private String email;
    private DateTime fechaIngreso;
    private String cargo;
    private String clave;
    private Rol rol;

    public AdmUsuario(String dni, String nombre, String ap_Paterno, String ap_Materno, String usuario, String email, DateTime fechaingreso, String cargo, String clave) {

        this.dni = dni;
        this.nombre = nombre;
        this.ap_Materno = ap_Materno;
        this.ap_Paterno = ap_Paterno;
        this.usuario = usuario;
        this.email = email;
        this.fechaIngreso = fechaingreso;
        this.cargo = cargo;
        this.clave = clave;
    }

    public boolean VerificarObligatorios() {
        if (this.dni == null || this.dni.trim().equals("")) {
            return false;
        }
        if (this.nombre == null || this.nombre.trim().equals("")) {
            return false;
        }
        if (this.ap_Paterno == null || this.ap_Paterno.trim().equals("")) {
            return false;
        }
        if (this.ap_Materno == null || this.ap_Materno.trim().equals("")) {
            return false;
        }
        if (this.usuario == null || this.usuario.trim().equals("")) {
            return false;
        }
        if (this.email == null || this.email.trim().equals("")) {
            return false;
        }
        if (this.cargo == null || this.cargo.trim().equals("")) {
            return false;
        }
        if (this.clave == null || this.clave.trim().equals("")) {
            return false;
        }
        return true;
    }

}
