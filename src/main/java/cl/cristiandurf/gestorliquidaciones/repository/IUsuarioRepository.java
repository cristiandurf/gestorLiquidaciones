package cl.cristiandurf.gestorliquidaciones.repository;

import cl.cristiandurf.gestorliquidaciones.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
}
