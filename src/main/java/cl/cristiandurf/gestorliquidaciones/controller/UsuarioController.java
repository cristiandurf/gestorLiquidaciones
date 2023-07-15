package cl.cristiandurf.gestorliquidaciones.controller;

import cl.cristiandurf.gestorliquidaciones.entity.Usuario;
import cl.cristiandurf.gestorliquidaciones.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    IUsuarioService objIUsuarioService;

    @GetMapping("/crearUsuario")
    public String mostrarFormularioCrearUsuario(Model model) {
        return "crearUsuario";
    }

    @PostMapping("/crearUsuario")
    public String crearUsuario(@ModelAttribute Usuario usuario) {
        objIUsuarioService.crearUsuario(usuario);
        return "redirect:/usuario";
    }

    @GetMapping
    public String listarUsuarios(Model model) {
        List<Usuario> listaUsuarios = objIUsuarioService.listarUsuarios();
        model.addAttribute("usuarios", listaUsuarios);
        return "listarUsuarios";
    }

    @GetMapping("{idUsuario}")
    public String listarUsuarioPorid(@PathVariable int idUsuario, Model model) {
        Usuario usuario = objIUsuarioService.buscarUsuarioById(idUsuario);
        model.addAttribute("usuario", usuario);
        return "usuario";
    }

    @GetMapping("/editar")
    public String mostrarFormularioEditarUsuario(@PathVariable Usuario usuario, Model model){
        Usuario usuarioEditar = objIUsuarioService.buscarUsuarioById(usuario.getIdUsuario());
        model.addAttribute("usuario", usuarioEditar);
        return "editarUsuario";
    }

    @PostMapping("/{idUsuario}/editar")
    public String actualizarUsuario(@PathVariable int idUsuario, @ModelAttribute Usuario usuario){
        objIUsuarioService.actualizarUsuario(usuario, idUsuario);
        return "redirect:/usuario";
    }

    @GetMapping("/{idUsuario}/eliminar")
    public String mostrarEliminarUsuario(@PathVariable int idUsuario, Model model){
        Usuario usuarioEliminar = objIUsuarioService.buscarUsuarioById(idUsuario);
        model.addAttribute("usuario", usuarioEliminar);
        return "eliminarUsuario";
    }

}
