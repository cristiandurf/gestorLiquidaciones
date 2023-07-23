package cl.cristiandurf.gestorliquidaciones.service.serviceimpl;

import cl.cristiandurf.gestorliquidaciones.entity.Trabajador;
import cl.cristiandurf.gestorliquidaciones.repository.ITrabajadorRepository;
import cl.cristiandurf.gestorliquidaciones.service.ITrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("/usuarioImpl")
public class TrabajadorImpl implements ITrabajadorService {

    @Autowired
    ITrabajadorRepository objTrabajadorRepo;

    @Override //sobreescribir el cuerpo del método
    public Trabajador crearTrabajador(Trabajador trabajador) {
        return objTrabajadorRepo.save(trabajador);
    }

    @Override
    public List<Trabajador> listarTrabajadores() {
        return objTrabajadorRepo.findAll();
    }

    @Override
    public Trabajador buscarTrabajadorById(int idTrabajador) {
        return objTrabajadorRepo.findById(idTrabajador).orElseThrow(() -> new NoSuchElementException("Trabajador no encontrado"));
    }

    @Override
    public Trabajador actualizarTrabajador(Trabajador trabajadorActualizar, int idTrabajador) {
        Trabajador trabajador1 = objTrabajadorRepo.findById(idTrabajador).orElseThrow(() -> new NoSuchElementException("Trabajador no encontrado"));
        trabajador1.setNombre(trabajadorActualizar.getNombre());
        trabajador1.setApellido1(trabajadorActualizar.getApellido1());
        trabajador1.setApellido2(trabajadorActualizar.getApellido2());
        trabajador1.setRun(trabajadorActualizar.getRun());
        trabajador1.setEmail(trabajadorActualizar.getEmail());
        trabajador1.setInstSalud(trabajadorActualizar.getInstSalud());
        trabajador1.setInstPrevision(trabajadorActualizar.getInstPrevision());
        trabajador1.setTelefono(trabajadorActualizar.getTelefono());

        return objTrabajadorRepo.save(trabajador1);
    }

    @Override
    public void eliminarTrabajador(int idTrabajador) {
        objTrabajadorRepo.deleteById(idTrabajador);
    }
}
