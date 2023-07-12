package cl.cristiandurf.gestorliquidaciones.repository;

import cl.cristiandurf.gestorliquidaciones.entity.InstitucionSalud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInstitucionSaludRepository extends JpaRepository<InstitucionSalud, Integer> {
}
