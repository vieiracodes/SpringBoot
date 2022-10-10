package gabriel.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import gabriel.io.entity.*;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
}
