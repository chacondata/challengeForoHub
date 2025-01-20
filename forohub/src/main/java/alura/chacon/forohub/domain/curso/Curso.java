package alura.chacon.forohub.domain.curso;

import jakarta.persistence.*;
import lombok.*;



@Table(name = "cursos" )
@Entity(name = "curso")
@EqualsAndHashCode(of="id")

public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombrecurso;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Curso(DatosRegistroCurso datosRegistroCurso) {
        this.nombrecurso =datosRegistroCurso.nombrecurso() ;
        this.categoria=datosRegistroCurso.categoria();
    }


    public Curso() {
    }

    public Long getId() {
        return id;
    }

    public String getNombrecurso() {
        return nombrecurso;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
