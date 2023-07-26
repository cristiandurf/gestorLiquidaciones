package cl.cristiandurf.gestorliquidaciones.restcontroller;

import cl.cristiandurf.gestorliquidaciones.entity.Trabajador;
import cl.cristiandurf.gestorliquidaciones.service.ITrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //devuelve un JSON  (objeto plano)
@RequestMapping("/api/trabajador")
public class TrabajorRestController {

    @Autowired
    ITrabajadorService objTrabajadorService;

    @GetMapping("/buscar/{idTrabajador}")
    public Trabajador listarTrabajadorById(@PathVariable int idTrabajador){
        return objTrabajadorService.buscarTrabajadorById(idTrabajador);
    }
}
