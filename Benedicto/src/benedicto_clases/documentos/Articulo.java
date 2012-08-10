package benedicto_clases.documentos;

/**
 *
 * @author FRANKLIN
 */
public class Articulo {

    private String codigo;
    private String nombre;

    public Articulo(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}

