package alura.chacon.forohub.domain.respuesta;

import alura.chacon.forohub.domain.curso.Curso;
import alura.chacon.forohub.domain.topico.Estatus;
import alura.chacon.forohub.domain.topico.Topico;
import alura.chacon.forohub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Entity
@Table(name="respuestas")
@EqualsAndHashCode(of="id")

public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensajedesolucion;
   private LocalDateTime fechacreacion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico_id")
    private Topico topico;

    public Respuesta() {
    }

    public Respuesta(Long id, String mensajedesolucion, LocalDateTime fechacreacion, Usuario usuario, Topico topico) {
        this.id = id;
        this.mensajedesolucion = mensajedesolucion;
        this.fechacreacion = fechacreacion;
        this.usuario = usuario;
        this.topico = topico;
    }

    public Long getId() {
        return id;
    }

    public String getMensajedesolucion() {
        return mensajedesolucion;
    }

    public LocalDateTime getFechacreacion() {
        return fechacreacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Topico getTopico() {
        return topico;
    }
}