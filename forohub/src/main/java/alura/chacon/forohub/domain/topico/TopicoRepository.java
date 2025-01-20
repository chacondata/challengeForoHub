package alura.chacon.forohub.domain.topico;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico,Long> {

    //List<Topico> findById(id);
    boolean existsByTitulo(String titulo);

    boolean existsByMensaje(String mensaje);
}
