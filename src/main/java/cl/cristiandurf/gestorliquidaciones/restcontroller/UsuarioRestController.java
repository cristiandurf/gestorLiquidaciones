package cl.cristiandurf.gestorliquidaciones.restcontroller;

import cl.cristiandurf.gestorliquidaciones.entity.Usuario;
import cl.cristiandurf.gestorliquidaciones.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Cristian Durán
 * @version 0.0.1
 * @since 13-07-2023
 */

//El RestController, permite enviar y recibir la data como API con JSON
@RestController
@RequestMapping("/api/usuario")
public class UsuarioRestController {

    @Autowired
    IUsuarioService objUsuarioService;

    @PostMapping //enviar solicitud
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return objUsuarioService.crearUsuario(usuario);
    }

    @GetMapping("/{idUsuario}") //traer informacion
    public Usuario buscarUsuarioById(@PathVariable int idUsuario) { //va a recibir una variable, no un objeto (por eso se ocupa la anotación @PathVariable)
        return objUsuarioService.buscarUsuarioById(idUsuario);
    }

    @GetMapping("/lista")
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
