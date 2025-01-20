package alura.chacon.forohub.controller;

import alura.chacon.forohub.domain.curso.Curso;
import alura.chacon.forohub.domain.curso.CursoRepository;
import alura.chacon.forohub.domain.curso.DatosListadoCurso;
import alura.chacon.forohub.domain.curso.DatosRegistroCurso;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")

public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public void registrarCurso(@RequestBody @Valid DatosRegistroCurso datosRegistroCurso) {
        cursoRepository.save(new Curso(datosRegistroCurso));
    }

   @GetMapping
       public List<DatosListadoCurso> listadoCursos(){
       return cursoRepository.findAll().stream().map(DatosListadoCurso::new).toList();
        }

}
