
package benedicto_clases.Grupo_de_Estudios;

// Autor : Miguel Merino
public class Curso {
    private String codigo;
    private String nombre;

    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

}
