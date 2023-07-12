package cl.cristiandurf.gestorliquidaciones.repository;

import cl.cristiandurf.gestorliquidaciones.entity.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrabajadorRepository extends JpaRepository<Trabajador, Integer> {
}
