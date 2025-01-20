package alura.chacon.forohub.domain.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroCurso (
        @NotBlank String nombrecurso,
        @NotNull Categoria categoria) {

    }

