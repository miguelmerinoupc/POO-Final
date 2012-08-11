package benedicto_Asociaciones;

// Autor : Miguel Merino
import benedicto_clases.Grupo_de_Estudios.Aula;
import benedicto_clases.Grupo_de_Estudios.Curso;
import benedicto_clases.Grupo_de_Estudios.Instructor;

public class DetalleGrupo {

    private Curso curso;
    private Instructor instructor;
    private Aula aula;

    public DetalleGrupo(Curso curso, Instructor instructor, Aula aula) {
        this.curso = curso;
        this.instructor = instructor;
        this.aula = aula;
    }

    public Curso getCurso() {
        return curso;
    }

    public Aula getAula() {
        return aula;
    }

    public Instructor getInstructor() {
        return instructor;
    }


}