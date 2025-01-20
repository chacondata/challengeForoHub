package alura.chacon.forohub.domain.curso;

public record DatosListadoCurso(Long id,String nombrecurso,Categoria categoria) {


    public DatosListadoCurso(Curso curso) {
        this(curso.getId(), curso.getNombrecurso(),curso.getCategoria() );
    }
}
