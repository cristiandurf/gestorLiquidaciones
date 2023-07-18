package cl.cristiandurf.gestorliquidaciones.service;

import cl.cristiandurf.gestorliquidaciones.entity.Empleador;

import java.util.List;

public interface IEmpleadorService {

    Empleador crearEmpleador(Empleador empleador);

    List<Empleador> listarEmpleadores();

    Empleador buscarEmpleadorById(int idEmpleador);

    Empleador actualizarEmpleador (Empleador empleador, int idEmpleador);

    void eliminarEmpleador(int idEmpleador);
}
