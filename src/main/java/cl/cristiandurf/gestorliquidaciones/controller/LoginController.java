package cl.cristiandurf.gestorliquidaciones.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    Log logger = LogFactory.getLog(HomeController.class);

    @GetMapping
    public String inicioSesion() {
        logger.info("Estás en el login");
        return "login";
    }
}
