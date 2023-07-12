package cl.cristiandurf.gestorliquidaciones.service;

import cl.cristiandurf.gestorliquidaciones.entity.Usuario;

import java.util.List;

public interface IUsuarioService {

    Usuario crearUsuario(Usuario usuario);
    List<Usuario> listarUsuarios();
    Usuario buscarUsuarioById(int idUsuario);
    Usuario actualizarUsuario(Usuario usuario, int idUsuario);
    void eliminarUsuario (int idUsuario);

}
