package alura.chacon.forohub.domain.topico.validaciones;

import alura.chacon.forohub.domain.topico.DatosRegistroTopico;
import alura.chacon.forohub.domain.topico.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class ValidarTopicosDuplicadosMensaje implements ValidadorDeTopicos {

    private TopicoRepository topicoRepository;

    public ValidarTopicosDuplicadosMensaje(TopicoRepository topicoRepository){
        this.topicoRepository=topicoRepository;
    }

    public void validar(DatosRegistroTopico datos){
        var mensaje=datos.mensaje();
        if(topicoRepository.existsByMensaje(mensaje)){
            throw new ValidationException("Topico ya existe");
        }
    }
}
