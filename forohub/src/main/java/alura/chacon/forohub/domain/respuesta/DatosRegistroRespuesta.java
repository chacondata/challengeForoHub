package alura.chacon.forohub.domain.respuesta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroRespuesta(
        @NotBlank String mensajedesolucion,
        @NotNull LocalDateTime fechacreacion,
        @NotNull Long idTopico,
        @NotNull Long idUsuario) {
}
