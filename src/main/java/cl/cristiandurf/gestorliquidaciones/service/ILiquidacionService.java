package cl.cristiandurf.gestorliquidaciones.service;

import cl.cristiandurf.gestorliquidaciones.entity.Liquidacion;

import java.util.List;

public interface ILiquidacionService {

    Liquidacion crearLiquidacion (Liquidacion liquidacion);

    List<Liquidacion> listarLiquidaciones();

    Liquidacion buscarLiquidacionById(long idLiquidacion);

    Liquidacion actualizarLiquidacion(Liquidacion liquidacion, long idLiquidacion);

    void eliminarLiquidacion(long idLiquidacion);
}
