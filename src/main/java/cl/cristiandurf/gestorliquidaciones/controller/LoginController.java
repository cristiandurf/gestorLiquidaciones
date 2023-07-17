package cl.cristiandurf.gestorliquidaciones.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;

public class LoginController {
    Log logger = LogFactory.getLog(HomeController.class);

    @GetMapping("/login")
    public String inicioSesion() {
        logger.info("Estás en el login");
        return "login";
    }
}
