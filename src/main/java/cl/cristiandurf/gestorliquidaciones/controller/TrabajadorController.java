package cl.cristiandurf.gestorliquidaciones.controller;

import cl.cristiandurf.gestorliquidaciones.entity.*;
import cl.cristiandurf.gestorliquidaciones.service.IEmpleadorService;
import cl.cristiandurf.gestorliquidaciones.service.IInstPrevisionService;
import cl.cristiandurf.gestorliquidaciones.service.IInstSaludService;
import cl.cristiandurf.gestorliquidaciones.service.ITrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Cristian Durán
 * @version 0.0.1
 * @since 20-07-2023
 */
@Controller
@RequestMapping("/trabajador")
public class TrabajadorController {

    @Autowired
    ITrabajadorService objTrabajadorService;

    @Autowired//inyecta dependencias empleador
    IEmpleadorService objEmpleadorService;

    @Autowired //inyecta dependencias de salud
    IInstSaludService objInstSaludService;

    @Autowired //inyecta dependencias de prevision
    IInstPrevisionService objInstPrevisionService;

    @GetMapping("/crearTrabajador")
    public String formCrearTrabajador(Model model){
        List<Empleador> listaEmpleadores = objEmpleadorService.listarEmpleadores();
        List<InstitucionSalud> instSalud = objInstSaludService.listarInstSalud();
        List<InstitucionPrevision> insTPreviciones = objInstPrevisionService.listarInstPrevision();
        model.addAttribute("empleadores", listaEmpleadores);
        model.addAttribute("listaInstSalud", instSalud); //estructura(argumento1: nombre, argumento2: valor)
        model.addAttribute("listaPrevisiones", insTPreviciones);
        return "crearTrabajador";
    }

    @PostMapping("/crearTrabajador")
    public String crearUsuario(@ModelAttribute Trabajador trabajador){
        trabajador.setFechaCreacion(LocalDateTime.now().minusHours(4));
        objTrabajadorService.crearTrabajador(trabajador);
        return "redirect:/trabajador/lista";
    }

    @GetMapping("lista")
    public String listarTrabajador(Model model){
        List<Trabajador> listaTrabajadores = objTrabajadorService.listarTrabajadores();
        model.addAttribute("trabajadores", listaTrabajadores);
        return "listarTrabajadores";
    }

    @GetMapping("/buscar/{idTrabajador}")
    public String listarTrabajadorById(@PathVariable int idTrabajador, Model model){
        Trabajador trabajador = objTrabajadorService.buscarTrabajadorById(idTrabajador);
        model.addAttribute("trabajador", trabajador);
        return "trabajador";
    }

    @GetMapping("/editar/{idTrabajdor}")
    public String formEditarUsuario(@PathVariable int idTrabajdor, Model model){
        Trabajador trabajadorEditar = objTrabajadorService.buscarTrabajadorById(idTrabajdor);
        model.addAttribute("trabajador", trabajadorEditar);
        model.addAttribute("empleadores", objEmpleadorService.listarEmpleadores());
        model.addAttribute("listaInstSalud", objInstSaludService.listarInstSalud());
        model.addAttribute("listaInstPrevision", objInstPrevisionService.listarInstPrevision());
        return "editarTrabajador";
    }

    @PostMapping("/actualizar/{idTrabajdor}")
    public String actualizarTrabajador(@ModelAttribute Trabajador trabajador, @PathVariable int idTrabajador){
        objTrabajadorService.actualizarTrabajador(trabajador, idTrabajador);
        return "redirect:/trabajador/lista";
    }


    @GetMapping("/eliminar/{idTrabajador}")
    public String eliminarTrabajador(@PathVariable int idTrabajador){
        objTrabajadorService.eliminarTrabajador(idTrabajador);
        return "redirect:/trabajador/lista";
    }

}
