package cl.cristiandurf.gestorliquidaciones.controller;

import cl.cristiandurf.gestorliquidaciones.entity.Usuario;
import cl.cristiandurf.gestorliquidaciones.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Cristian Durán
 * @version 0.0.2
 * @since 16-07-2023
 */
@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    IUsuarioService objUsuarioService;

    @GetMapping("/registro")
    public String registro() {
        return "registrarse";
    }

    @GetMapping("/crearUsuario")
    public String formCrearUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "crearUsuario";
    }

    @PostMapping("/crearUsuario")
    public String crearUsuario(@ModelAttribute Usuario usuario) {
        usuario.setFechaCreacion(LocalDateTime.now().minusHours(4));
        objUsuarioService.crearUsuario(usuario);
        return "redirect:/usuario/lista";
    }

    @GetMapping("/lista")
    public String listarUsuarios(Model model) {
        List<Usuario> listaUsuarios = objUsuarioService.listarUsuarios();
        model.addAttribute("usuarios", listaUsuarios);
        return "listarUsuarios";
    }

    @GetMapping("/buscar/{idUsuario}")
    public String listarUsuarioById(@PathVariable int idUsuario, Model model) {
        Usuario usuario = objUsuarioService.buscarUsuarioById(idUsuario);
        model.addAttribute("usuario", usuario);
        return "usuario";
    }

    @GetMapping("/editar/{idUsuario}")
    public String formEditarUsuario(@PathVariable int idUsuario, Model model){
        Usuario usuarioEditar = objUsuarioService.buscarUsuarioById(idUsuario);
        model.addAttribute("usuario", usuarioEditar);
        return "editarUsuario";
    }

    @PostMapping("/editar/{idUsuario}")
    public String editarUsuario(@ModelAttribute Usuario usuario, @PathVariable int idUsuario){
        objUsuarioService.actualizarUsuario(usuario, idUsuario);
        return "redirect:/usuario/lista";
    }

    @GetMapping("/eliminar/{idUsuario}")
    public String mostrarEliminarUsuario(@PathVariable int idUsuario){
        objUsuarioService.eliminarUsuario(idUsuario);
        return "redirect:/usuario/lista";
    }

}
