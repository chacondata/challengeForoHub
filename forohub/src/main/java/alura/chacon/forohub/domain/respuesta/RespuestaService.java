package alura.chacon.forohub.domain.respuesta;

import alura.chacon.forohub.domain.ValidacionExcepcion;
import alura.chacon.forohub.domain.topico.TopicoRepository;
import alura.chacon.forohub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RespuestaService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RespuestaRepository respuestaRepository;

    public void responder(DatosRegistroRespuesta datos){

        if(!topicoRepository.existsById(datos.idTopico())){
            throw new ValidacionExcepcion("No existe un topico con este id");
        }

        if(!usuarioRepository.existsById(datos.idUsuario())){
            throw new ValidacionExcepcion("No existe un usuario con este id");
        }

        var usuario = usuarioRepository.findById(datos.idUsuario()).get();
        var topico= topicoRepository.findById(datos.idTopico()).get();
        var respuesta =new Respuesta(null, datos.mensajedesolucion(),datos.fechacreacion(),usuario,topico);
    respuestaRepository.save(respuesta);
    }
}
