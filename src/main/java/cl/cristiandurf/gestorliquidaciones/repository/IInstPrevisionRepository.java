package cl.cristiandurf.gestorliquidaciones.repository;

import cl.cristiandurf.gestorliquidaciones.entity.InstitucionPrevision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInstPrevisionRepository extends JpaRepository<InstitucionPrevision, Integer> {
}
