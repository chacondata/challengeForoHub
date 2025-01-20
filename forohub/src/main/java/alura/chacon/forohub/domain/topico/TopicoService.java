package alura.chacon.forohub.domain.topico;

import alura.chacon.forohub.domain.curso.CursoRepository;
import alura.chacon.forohub.domain.topico.validaciones.ValidadorDeTopicos;
import alura.chacon.forohub.domain.usuario.UsuarioRepository;
import alura.chacon.forohub.domain.ValidacionExcepcion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    @Autowired
    private List<ValidadorDeTopicos> validadores;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public TopicoService(CursoRepository  cursoRepository,UsuarioRepository usuarioRepository,
                         TopicoRepository topicoRepository,
                         List<ValidadorDeTopicos> validadores){
        this.cursoRepository=cursoRepository;
        this.topicoRepository=topicoRepository;
        this.usuarioRepository=usuarioRepository;
        this.validadores=validadores;
    }

    public DatosDetalleTopico registrar(DatosRegistroTopico datos){

        if(!cursoRepository.existsById(datos.idCurso())){
            throw new ValidacionExcepcion("No existe un curso con este id");
        }

        if(!usuarioRepository.existsById(datos.idUsuario())){
            throw new ValidacionExcepcion("No existe un usuario con este id");
        }

        //validaciones
        validadores.forEach(v->v.validar(datos));

        var curso=cursoRepository.findById(datos.idCurso()).get();
        var usuario=usuarioRepository.findById(datos.idUsuario()).get();


        Topico topico=new Topico(null, datos.titulo(), datos.mensaje(), datos.fechacreacion(),datos.estatus(),usuario,curso);
        topicoRepository.save(topico);

        return new DatosDetalleTopico(topico);

    }
}
