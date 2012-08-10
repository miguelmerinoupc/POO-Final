package benedicto_clases.Grupo_de_Estudios;

/**
 *
 * @author u201216787
 */
public class DetalleGrupo {
    private Local local;
    private Aula aula;
    private Curso curso;
    private Instructor instructor;

    public DetalleGrupo(Local local, Aula aula, Curso curso, Instructor instructor) {
        this.local = local;
        this.aula = aula;
        this.curso = curso;
        this.instructor = instructor;
    }

    public Curso getCurso() {
        return curso;
    }


}
