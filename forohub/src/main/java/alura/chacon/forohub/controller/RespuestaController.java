package alura.chacon.forohub.controller;

import alura.chacon.forohub.domain.respuesta.DatosDetalleRespuesta;
import alura.chacon.forohub.domain.respuesta.DatosRegistroRespuesta;
import alura.chacon.forohub.domain.respuesta.RespuestaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/respuesta")

public class RespuestaController {

    @Autowired
    private RespuestaService respuesta;

    @PostMapping
    @Transactional
    public ResponseEntity responder(@RequestBody @Valid DatosRegistroRespuesta datos){

respuesta.responder(datos);

        return ResponseEntity.ok(new DatosDetalleRespuesta(null,null,null,null));
    }
}
