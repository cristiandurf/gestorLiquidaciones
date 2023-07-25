package cl.cristiandurf.gestorliquidaciones.controller;

import cl.cristiandurf.gestorliquidaciones.entity.InstitucionPrevision;
import cl.cristiandurf.gestorliquidaciones.entity.InstitucionSalud;
import cl.cristiandurf.gestorliquidaciones.entity.Liquidacion;
import cl.cristiandurf.gestorliquidaciones.entity.Trabajador;
import cl.cristiandurf.gestorliquidaciones.service.IInstPrevisionService;
import cl.cristiandurf.gestorliquidaciones.service.IInstSaludService;
import cl.cristiandurf.gestorliquidaciones.service.ILiquidacionService;
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
 * @since 24-07-2023
 */
@Controller
@RequestMapping("/liquidacion")
public class LiquidacionController {

    @Autowired
    ILiquidacionService objLiquidacionService;

    @Autowired
    ITrabajadorService objTrabajadorService;

    @Autowired
    IInstSaludService objInstSaludService;

    @Autowired
    IInstPrevisionService objInstPrevisionService;

    @GetMapping("/crearLiquidacion")
    public String crearLiquidacion(Model model){
        List<InstitucionSalud> instSalud = objInstSaludService.listarInstSalud();
        List<InstitucionPrevision> instPrevisiones = objInstPrevisionService.listarInstPrevision();
        model.addAttribute("listaInstSalud", instSalud);
        model.addAttribute("listaInstPrevisiones", instPrevisiones);
        return "crearLiquidacion";
    }

    @PostMapping("/crearLiquidacion")
    public String crearLiquidacion(@ModelAttribute Liquidacion liquidacion){
        liquidacion.setFechaCreacion(LocalDateTime.now().minusHours(4));
        objLiquidacionService.crearLiquidacion(liquidacion);
        return "redirect:/liquidacion/lista";
    }

    @GetMapping("/lista")
    public  String listarLiquidacion(Model model){
        List<Liquidacion> listaLiquidaciones = objLiquidacionService.listarLiquidaciones();
        model.addAttribute("liquidaciones", listaLiquidaciones);
        return "listarLiquidaciones";
    }

    @GetMapping("/buscar/{idLiquidacion}")
    public String listarLiquidacionesById(@PathVariable long idLiquidacion, Model model){
        Liquidacion liquidacion = objLiquidacionService.buscarLiquidacionById(idLiquidacion);
        model.addAttribute("liquidacion", liquidacion);
        return "liquidacion";
    }

    @GetMapping("/editar/{idLiquidacion}")
    public String editarLiquidacion(@PathVariable long idLiquidacion, Model model){
        Liquidacion liquidacionEditar = objLiquidacionService.buscarLiquidacionById(idLiquidacion);
        List<Trabajador> trabajadorEditar = objTrabajadorService.listarTrabajadores();
        List<InstitucionSalud> instSaludEditar = objInstSaludService.listarInstSalud();
        List<InstitucionPrevision> instPrevisionEditar = objInstPrevisionService.listarInstPrevision();
        model.addAttribute("liquidacion", liquidacionEditar);
        model.addAttribute("trabajadores", trabajadorEditar);
        model.addAttribute("listaInstSalud", instSaludEditar);
        model.addAttribute("listaInstprevision", instPrevisionEditar);
        return "editarLiquidacion";
    }

    @GetMapping("/eliminar/{idLiquidacion}")
    public String eliminarLiquidacion(@PathVariable long idLiquidacion){
        objLiquidacionService.eliminarLiquidacion(idLiquidacion);
        return "redirect:/liquidacion/lista";
    }
}
