package alura.chacon.forohub.domain.topico.validaciones;

import alura.chacon.forohub.domain.topico.DatosRegistroTopico;
import alura.chacon.forohub.domain.topico.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class ValidarTopicosDuplicadosTitulo implements ValidadorDeTopicos {

    private TopicoRepository topicoRepository;

    public ValidarTopicosDuplicadosTitulo(TopicoRepository topicoRepository){
        this.topicoRepository=topicoRepository;
    }

    public void validar(DatosRegistroTopico datos){
        var titulo=datos.titulo();
        if(topicoRepository.existsByTitulo(titulo)){
            throw new ValidationException("Topico ya existe");
        }
    }
}
