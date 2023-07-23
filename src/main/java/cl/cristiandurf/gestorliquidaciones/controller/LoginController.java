package cl.cristiandurf.gestorliquidaciones.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Cristian Durán
 * @version 0.0.3
 * @since 13-07-2023
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String inicioSesion() {
        return "iniciarSesion";
    }

    @GetMapping("/bienvenida")
    public String bienvenida (){
        return "bienvenida";
    }
}
