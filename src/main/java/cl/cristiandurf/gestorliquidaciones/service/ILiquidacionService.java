package cl.cristiandurf.gestorliquidaciones.service;

import cl.cristiandurf.gestorliquidaciones.entity.Liquidacion;
import cl.cristiandurf.gestorliquidaciones.entity.Usuario;

import java.util.List;

public interface ILiquidacionService {
    Usuario crearLiquidacion(Liquidacion liquidacion);

    List<Liquidacion> listarLiquidacion();

    Liquidacion buscarLiquidacionById(int idLiquidacion);

    Liquidacion actualizarLiquidacion(Liquidacion liquidacion, int idLiquidacion);

    void eliminarLiquidacion(int idLiquidacion);

}
