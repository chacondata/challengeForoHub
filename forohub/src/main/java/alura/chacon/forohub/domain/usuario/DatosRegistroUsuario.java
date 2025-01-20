package alura.chacon.forohub.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroUsuario(
        @NotBlank
        String nombre,
        @NotNull
        @Email
        String email,
        @NotNull
        String contraseña,
        @NotNull
        Perfil perfil
) {
}
