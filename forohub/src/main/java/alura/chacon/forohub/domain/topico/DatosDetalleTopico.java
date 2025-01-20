package alura.chacon.forohub.domain.topico;

import alura.chacon.forohub.domain.curso.DatosCursoTopico;
import alura.chacon.forohub.domain.usuario.DatosListadoUsuario;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosDetalleTopico(Long id,
                                 String titulo,
                                 String mensaje,
                                 LocalDateTime fechacreacion,
                                 Estatus estatus,
                                 DatosCursoTopico datosCursoTopico,
                                 DatosListadoUsuario datosListadoUsuario) {
    public DatosDetalleTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechacreacion(),topico.getEstatus(),
                new DatosCursoTopico(topico.getCurso().getNombrecurso()),
                new DatosListadoUsuario(topico.getUsuario().getNombre()));
    }


}