package cl.cristiandurf.gestorliquidaciones.service;

import cl.cristiandurf.gestorliquidaciones.entity.InstitucionPrevision;
import cl.cristiandurf.gestorliquidaciones.entity.InstitucionSalud;

public interface IInstitucionPrevisionService {

    InstitucionPrevision buscarInstitucionPrevisionById(int idInstPrevision);
}
