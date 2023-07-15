package cl.cristiandurf.gestorliquidaciones.service;

import cl.cristiandurf.gestorliquidaciones.entity.Perfil;
import cl.cristiandurf.gestorliquidaciones.entity.Usuario;

import java.util.List;

public interface IPerfilService {

    Usuario crearPerfil(Perfil perfil);

    List<Perfil> listarPerfil();

    Perfil buscarPerfilById(int idPerfil);

    Perfil actualizarPerfil(Perfil perfil, int idPerfil);

    void eliminarPerfil(int idPerfil);

}
