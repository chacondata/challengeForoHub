package alura.chacon.forohub.domain.topico;


import alura.chacon.forohub.domain.curso.DatosCursoTopico;

import alura.chacon.forohub.domain.usuario.DatosListadoUsuario;


import java.time.LocalDateTime;

public record DatosListadoTopico(Long  id,
                                 String titulo,
                                 Estatus estatus,
                                 DatosCursoTopico datosCursoTopico,
                                 DatosListadoUsuario datosListadoUsuario) {
    public DatosListadoTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getEstatus(),
                new DatosCursoTopico(topico.getCurso().getNombrecurso()),
                new DatosListadoUsuario(topico.getUsuario().getNombre()));
    }
}