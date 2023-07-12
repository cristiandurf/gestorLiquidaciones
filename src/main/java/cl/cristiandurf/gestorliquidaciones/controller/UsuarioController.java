package cl.cristiandurf.gestorliquidaciones.controller;

import cl.cristiandurf.gestorliquidaciones.entity.Usuario;
import cl.cristiandurf.gestorliquidaciones.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //sirve para trabajar con una API
@RequestMapping("/usuario") //permite redireccionar a usuario
public class UsuarioController {
    @Autowired
    IUsuarioService objUsuarioService;

    @PostMapping //tipo de request(solicitud) //enviar informacion
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return objUsuarioService.crearUsuario(usuario);
    }

    @GetMapping("/{idUsuario}") //traer informacion
    public Usuario buscarUsuarioById(@PathVariable int idUsuario) { //va a recibir una variable, no un objeto (por eso se ocupa la anotación @PathVariable)
        return objUsuarioService.buscarUsuarioById(idUsuario);
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return objUsuarioService.listarUsuarios();
    }

    @PutMapping("/{idUsuario}") //actualizar informacion
    public Usuario actualizarUsuario(@RequestBody Usuario usuarioActualizar, @PathVariable int idUsuario) {
        return objUsuarioService.actualizarUsuario(usuarioActualizar, idUsuario);
    }

    @DeleteMapping("/{idUsuario}") //elimina usuario por el id
    public void eliminarUsuario(int idUsuario) {
        objUsuarioService.eliminarUsuario(idUsuario);

    }
}
