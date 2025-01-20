package alura.chacon.forohub.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(@NotNull Long id, String mensaje, Estatus estatus) {
}
