package cl.cristiandurf.gestorliquidaciones.service.serviceimpl;

import cl.cristiandurf.gestorliquidaciones.entity.Usuario;
import cl.cristiandurf.gestorliquidaciones.repository.IUsuarioRepository;
import cl.cristiandurf.gestorliquidaciones.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("usuarioImpl")
public class UsuarioImpl implements IUsuarioService {

    @Autowired//inyecta la dependencia del interfaz
    IUsuarioRepository objUsuarioRepo;

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return objUsuarioRepo.save(usuario);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return objUsuarioRepo.findAll();
    }

    @Override
    public Usuario buscarUsuarioById(int idUsuario) {
        return objUsuarioRepo.findById(idUsuario).orElseThrow(() -> new NoSuchElementException("Usuario no encontrado")); //se consulta el obj por su id en la tabla de la BD
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuarioActualizar, int idUsuario) {
        Usuario usuario1 = objUsuarioRepo.findById(idUsuario).orElseThrow(() -> new NoSuchElementException("Usuario no encontrado"));

        usuario1.setRun(usuarioActualizar.getRun());
        usuario1.setClave(usuarioActualizar.getClave());
        usuario1.setNombre(usuarioActualizar.getNombre());
        usuario1.setApellido1(usuarioActualizar.getApellido1());
        usuario1.setApellido2(usuarioActualizar.getApellido2());
        usuario1.setPerfil(usuarioActualizar.getPerfil());
        usuario1.setEmail(usuarioActualizar.getEmail());
        usuario1.setTelefono(usuarioActualizar.getTelefono());

        return objUsuarioRepo.save(usuario1);
    }

    @Override
    public void eliminarUsuario(int idUsuario) { //lleva void, porque al eliminar queda vacío, por lo que no retornaria nada (no lleva return)
        objUsuarioRepo.deleteById(idUsuario);
    }
}
