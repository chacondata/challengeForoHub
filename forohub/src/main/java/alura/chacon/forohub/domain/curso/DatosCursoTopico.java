package alura.chacon.forohub.domain.curso;

public record DatosCursoTopico(String nombrecurso) {


    public DatosCursoTopico(Curso curso) {
        this(curso.getNombrecurso());
    }
}
