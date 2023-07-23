package cl.cristiandurf.gestorliquidaciones.service;

import cl.cristiandurf.gestorliquidaciones.entity.Trabajador;

import java.util.List;

public interface ITrabajadorService {
    //estructura de métodos:
    //tipo de dato que devuelve   //nombre  //(tipo de dato, nombre de parámetro)
    Trabajador crearTrabajador(Trabajador trabajador);

    List<Trabajador> listarTrabajadores();

    Trabajador buscarTrabajadorById(int idTrabajador);

    Trabajador actualizarTrabajador(Trabajador trabajador, int idTrabajador);

    void eliminarTrabajador(int idTrabajador);
    // recibe paramétro : idTrabajor
    //¿de qué tipo?: int
}
