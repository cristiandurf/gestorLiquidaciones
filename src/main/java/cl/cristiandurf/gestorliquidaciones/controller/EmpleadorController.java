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
 * @version 0.0.2
 * @since 17-07-2023
 */
@Controller //se usa para las vistas (solita HTTP)
@RequestMapping("/empleador")
public class EmpleadorController {

    @Autowired //inyecta las dependencias de un objeto y proporciona las instancias necesarias
    IEmpleadorService objEmpleadorService;

    @GetMapping
    public String listarEmpleadores(Model model){ //la clase Model sirve como un contenedor para datos que se envia a otras vistas, por el objeto model
        List<Empleador> listaEmpleadores = objEmpleadorService.listarEmpleadores();
        model.addAttribute("empleadores", listaEmpleadores);
        return "listarEmpleadores"; //el return, sirve para redirigir a la vista
    }


}
