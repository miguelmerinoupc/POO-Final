
package benedicto_clases.AdministracionUsuarios;

/**
 * Autor : Miguel Merino
 */
public class Permiso {
    private String modulo;
    private char acceso;
    private char adicionar;
    private char editar;
    private char eliminar;

    public Permiso(String modulo, char acceso, char adicionar, char editar, char eliminar) {
        this.modulo = modulo;
        this.acceso = acceso;
        this.adicionar = adicionar;
        this.editar = editar;
        this.eliminar = eliminar;
    }

    public String getModulo() {
        return modulo;
    }


}
