package cl.cristiandurf.gestorliquidaciones.service.serviceimpl;

import cl.cristiandurf.gestorliquidaciones.entity.Liquidacion;
import cl.cristiandurf.gestorliquidaciones.repository.ILiquidacionRepository;
import cl.cristiandurf.gestorliquidaciones.service.ILiquidacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("/liquidacionImpl")
public class LiquidacionImpl implements ILiquidacionService {

    @Autowired
    ILiquidacionRepository objLiquidacionRepo;

    @Override
    public Liquidacion crearLiquidacion(Liquidacion liquidacion) {
        return objLiquidacionRepo.save(liquidacion);
    }

    @Override
    public List<Liquidacion> listarLiquidaciones() {
        return objLiquidacionRepo.findAll();
    }

    @Override
    public Liquidacion buscarLiquidacionById(long idLiquidacion) {
        return objLiquidacionRepo.findById(idLiquidacion).orElseThrow(() -> new NoSuchElementException("Liquidación no encontrada"));
    }

    @Override
    public Liquidacion actualizarLiquidacion(Liquidacion liquidacionActualizar, long idLiquidacion) {
        Liquidacion liquidacion1 = objLiquidacionRepo.findById(idLiquidacion).orElseThrow(() -> new NoSuchElementException("Liquidación no encontrada"));
        liquidacion1.setTrabajador(liquidacionActualizar.getTrabajador());
        liquidacion1.setSueldoImponible(liquidacionActualizar.getSueldoImponible());
        liquidacion1.setInstSalud(liquidacionActualizar.getInstSalud());
        liquidacion1.setMontoInstSalud(liquidacionActualizar.getMontoInstSalud());
        liquidacion1.setInstPrevision(liquidacionActualizar.getInstPrevision());
        liquidacion1.setMontoInstPrevision(liquidacionActualizar.getMontoInstPrevision());
        liquidacion1.setTotalHaberes(liquidacionActualizar.getTotalDescuento());
        liquidacion1.setTotalHaberes(liquidacionActualizar.getTotalHaberes());
        liquidacion1.setAnticipo(liquidacionActualizar.getAnticipo());
        liquidacion1.setSueldoLiquido(liquidacionActualizar.getSueldoLiquido());
        return objLiquidacionRepo.save(liquidacion1);
    }

    @Override
    public void eliminarLiquidacion(long idLiquidacion) {
        objLiquidacionRepo.deleteById(idLiquidacion);
    }
}
