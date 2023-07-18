package cl.cristiandurf.gestorliquidaciones.controller;

import cl.cristiandurf.gestorliquidaciones.entity.Empleador;
import cl.cristiandurf.gestorliquidaciones.service.IEmpleadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Cristian Durán
 * @version 0.0.1
 * @since 17-07-2023
 */
@Controller
@RequestMapping("/empleador")
public class EmpleadorController {

    @Autowired
    IEmpleadorService objEmpleadorService;

    @GetMapping
    public String listarEmpleadores(Model model){
        List<Empleador> listaEmpleadores = objEmpleadorService.listarEmpleadores();
        model.addAttribute("empleadores", listaEmpleadores);
        return "listarEmpleadores";
    }


}
