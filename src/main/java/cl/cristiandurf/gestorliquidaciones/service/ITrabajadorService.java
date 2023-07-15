package cl.cristiandurf.gestorliquidaciones.service;

import cl.cristiandurf.gestorliquidaciones.entity.Trabajador;
import cl.cristiandurf.gestorliquidaciones.entity.Usuario;
import cl.cristiandurf.gestorliquidaciones.repository.ITrabajadorRepository;

import java.util.List;

public interface ITrabajadorService {

    Usuario crearTrabajador(Trabajador trabajador);

    List<Trabajador> listarTrabajadores();

    Trabajador buscarTrabajadorById(int idTrabajador);

    Trabajador actualizarTrabajador(Trabajador trabajador, int idTrabajador);

    void eliminarTrabajador(int idTrabajador);

}
