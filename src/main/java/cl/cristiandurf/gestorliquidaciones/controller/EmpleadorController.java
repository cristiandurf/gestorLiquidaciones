package cl.cristiandurf.gestorliquidaciones.controller;

import cl.cristiandurf.gestorliquidaciones.entity.Empleador;
import cl.cristiandurf.gestorliquidaciones.entity.Usuario;
import cl.cristiandurf.gestorliquidaciones.service.IEmpleadorService;
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
 * @since 17-07-2023
 */
@Controller //se usa para las vistas (solita HTTP)
@RequestMapping("/empleador")
public class EmpleadorController {

    @Autowired //inyecta las dependencias de un objeto (empleador) y proporciona las instancias necesarias
    IEmpleadorService objEmpleadorService;

    @Autowired //inyecta dependencias de usuario
    IUsuarioService objUsuarioService;

    @GetMapping("/crearEmpleador")
    public String crearEmpleador(Model model){
        List<Usuario> usuarios = objUsuarioService.listarUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "crearEmpleador";
    }

    @PostMapping("/crearEmpleador")
    public String crearEmpleador(@ModelAttribute Empleador empleador){
        empleador.setFechaCreacion(LocalDateTime.now().minusHours(4));
        objEmpleadorService.crearEmpleador(empleador);
        return "redirect:/empleador/lista";
    }

    @GetMapping("/lista")
    public String listarEmpleadores(Model model){ //la clase "Model" sirve como un contenedor para datos que se envia a otras vistas, por el objeto model
        List<Empleador> listaEmpleadores = objEmpleadorService.listarEmpleadores();
        model.addAttribute("empleadores", listaEmpleadores);
        return "listarEmpleadores"; //el return, sirve para redirigir a la vista
    }

    @GetMapping("/buscar/{idEmpleador}")
    public String listarEmpleadorById(@PathVariable int idEmpleador, Model model){
        Empleador empleador = objEmpleadorService.buscarEmpleadorById(idEmpleador);
        model.addAttribute("empleador", empleador);
        return "empleador";
    }

    @GetMapping("/editar/{idEmpleador}")
    public String editarEmpleador(@PathVariable int idEmpleador, Model model){
        Empleador empleadorEditar = objEmpleadorService.buscarEmpleadorById(idEmpleador);
        List<Usuario> usuarioEditar = objUsuarioService.listarUsuarios();
        model.addAttribute("empleador", empleadorEditar);
        model.addAttribute("usuarios", usuarioEditar);
        return "editarEmpleador";
    }

    @PostMapping("/editar/{idEmpleador}")
    public String editarEmpleador(@ModelAttribute Empleador empleador, @PathVariable int idEmpleador){
        objEmpleadorService.actualizarEmpleador(empleador, idEmpleador);
        return "redirect:/empleador/lista";
    }

    @GetMapping("eliminar/{idEmpleador}")
    public String mostrarEliminarEmpleador(@PathVariable int idEmpleador){
        objEmpleadorService.eliminarEmpleador(idEmpleador);
        return "redirect:/empleador/lista";
    }
}
