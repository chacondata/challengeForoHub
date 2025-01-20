package alura.chacon.forohub.domain.respuesta;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosDetalleRespuesta(Long id,
                                    LocalDateTime fechacreacion,
                                    Long idTopico,
                                    @NotNull Long idUsuario) {
}
