package alura.chacon.forohub.controller;

import alura.chacon.forohub.domain.curso.DatosCursoTopico;
import alura.chacon.forohub.domain.topico.*;
import alura.chacon.forohub.domain.usuario.DatosListadoUsuario;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topico")

public class TopicoController {

    @Autowired
    private TopicoService registro;

    @Autowired
    private TopicoRepository topicoRepository;


    @PostMapping
    @Transactional
    public ResponseEntity<DatosDetalleTopico> registrar(@RequestBody @Valid DatosRegistroTopico datos,UriComponentsBuilder uriComponentsBuilder){
       DatosDetalleTopico topico =registro.registrar(datos);
       URI url  = uriComponentsBuilder.path("/topico/{id}").buildAndExpand(topico.id()).toUri();
       return ResponseEntity.created(url).body(topico);
    }

    @GetMapping
    public ResponseEntity<List<DatosListadoTopico>> listadoTopicos(){
        return ResponseEntity.ok(topicoRepository.findAll().stream().map(DatosListadoTopico::new).toList());
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico =topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico);
        return ResponseEntity.ok(new DatosListadoTopico(topico.getId(), topico.getTitulo(), topico.getEstatus(),
                new DatosCursoTopico(topico.getCurso().getNombrecurso()),
                new DatosListadoUsuario(topico.getUsuario().getNombre())));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity obtenerTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DatosListadoTopico(topico.getId(), topico.getTitulo(), topico.getEstatus(),
                new DatosCursoTopico(topico.getCurso().getNombrecurso()),
                new DatosListadoUsuario(topico.getUsuario().getNombre())));
    }




}
