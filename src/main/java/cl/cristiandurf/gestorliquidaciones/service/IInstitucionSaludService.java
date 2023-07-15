package cl.cristiandurf.gestorliquidaciones.service;

import cl.cristiandurf.gestorliquidaciones.entity.InstitucionSalud;
import cl.cristiandurf.gestorliquidaciones.entity.Usuario;

public interface IInstitucionSaludService {

    InstitucionSalud buscarInstitucionSaludById(int idInstSalud);
}
