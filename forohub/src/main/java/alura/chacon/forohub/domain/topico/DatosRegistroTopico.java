package alura.chacon.forohub.domain.topico;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroTopico(
        @NotNull
        String titulo,
        @NotNull
        String mensaje,
        @NotNull
        LocalDateTime fechacreacion,
        @NotNull
        Estatus estatus,
        @NotNull
        Long idCurso,
        @NotNull
        Long idUsuario) {
}
