package alura.chacon.forohub.domain.topico;

import alura.chacon.forohub.domain.curso.Curso;
import alura.chacon.forohub.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Entity
@Table(name="topicos")
@EqualsAndHashCode(of="id")

public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechacreacion;
    @Enumerated(EnumType.STRING)
    private Estatus estatus;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="usuario_id")
    private Usuario  usuario;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="curso_id")
    private Curso curso;

    public Topico() {
    }

    public Topico(Long id, String titulo, String mensaje, LocalDateTime fechacreacion, Estatus estatus, Usuario usuario, Curso curso) {
        this.id = id;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fechacreacion = fechacreacion;
        this.estatus = estatus;
        this.usuario = usuario;
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFechacreacion() {
        return fechacreacion;
    }

    public Estatus getEstatus() {
        return estatus;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Curso getCurso() {
        return curso;
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        if(datosActualizarTopico.mensaje() != null){
        this.mensaje=datosActualizarTopico.mensaje();}
        if (datosActualizarTopico.estatus() != null){
        this.estatus=datosActualizarTopico.estatus();}

    }
}
