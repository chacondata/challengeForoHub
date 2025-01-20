package alura.chacon.forohub.domain.usuario;

public record DatosListadoUsuario(String nombre) {
    public DatosListadoUsuario(Usuario usuario){
        this(usuario.getNombre());
    }
}
