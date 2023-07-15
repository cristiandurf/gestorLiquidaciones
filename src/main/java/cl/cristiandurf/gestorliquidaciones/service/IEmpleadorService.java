package cl.cristiandurf.gestorliquidaciones.service;

import cl.cristiandurf.gestorliquidaciones.entity.Empleador;
import cl.cristiandurf.gestorliquidaciones.entity.Perfil;
import cl.cristiandurf.gestorliquidaciones.entity.Usuario;

import java.util.List;

public interface IEmpleadorService {

    Empleador crearEmpleador(Empleador empleador);

    List<Empleador> listarEmpleador();

    Empleador buscarEmpleadorById(int idEmpleador);

    Empleador actualizarEmpleador(Empleador empleador, int idEmpleador);

    void eliminarEmpleador(int idEmpleador);
}
