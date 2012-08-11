package benedicto_clases.AdministracionUsuarios;

/**
 * @author Miguel Merino
 */
public class Modulo {
    private String codigo;
    private String nombre;

    public String getCodigo() {
        return codigo;
    }

    public Modulo(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

}