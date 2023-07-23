package cl.cristiandurf.gestorliquidaciones.service.serviceimpl;

import cl.cristiandurf.gestorliquidaciones.entity.InstitucionSalud;
import cl.cristiandurf.gestorliquidaciones.repository.IInstSaludRepository;
import cl.cristiandurf.gestorliquidaciones.service.IInstSaludService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("/instSaludImpl")
public class InstSaludImpl implements IInstSaludService {

    @Autowired
    IInstSaludRepository objInstSaludRepo;

    @Override
    public List<InstitucionSalud> listarInstSalud() {
        return objInstSaludRepo.findAll();
    }
}
