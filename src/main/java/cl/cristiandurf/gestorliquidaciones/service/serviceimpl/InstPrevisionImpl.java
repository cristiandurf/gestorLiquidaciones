package cl.cristiandurf.gestorliquidaciones.service.serviceimpl;

import cl.cristiandurf.gestorliquidaciones.entity.InstitucionPrevision;
import cl.cristiandurf.gestorliquidaciones.repository.IInstPrevisionRepository;
import cl.cristiandurf.gestorliquidaciones.service.IInstPrevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("/instPrevisionImpl")
public class InstPrevisionImpl implements IInstPrevisionService {

    @Autowired
    IInstPrevisionRepository objInstPrevisionRepo;

    @Override
    public List<InstitucionPrevision> listarInstPrevision() {
        return objInstPrevisionRepo.findAll();
    }
}
