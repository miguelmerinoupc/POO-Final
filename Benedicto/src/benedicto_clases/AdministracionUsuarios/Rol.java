package benedicto_clases.AdministracionUsuarios;

import java.util.ArrayList;

/**
 * Autor : Miguel Merino
 */
public class Rol {

    private String nombre;
    private String descripcion;
    private ArrayList<Permiso> listadopermiso = new ArrayList<Permiso>();

    public Rol(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public void AgregarPermiso(Permiso permiso) {
        this.listadopermiso.add(permiso);
    }

    public Rol() {
    }

    public boolean VerificarObligatorios() {

        if (this.nombre == null || this.nombre.trim().equals("")) {
            return false;
        }
        if (this.descripcion == null || this.descripcion.trim().equals("")) {
            return false;
        }
        if (this.listadopermiso.size() < 1) {
            return false;
        }
        return true;
    }

    public ArrayList<Permiso> getListadopermiso() {
        return listadopermiso;
    }

    public String getNombre() {
        return nombre;
    }
}
