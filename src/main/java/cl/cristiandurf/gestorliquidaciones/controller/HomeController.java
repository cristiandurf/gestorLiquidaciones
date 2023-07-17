package cl.cristiandurf.gestorliquidaciones.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Cristian Durán
 * @version 0.0.1
 * @since 13-07-2023
 */
@Controller //el @Controller se usa para las vistas
@RequestMapping("/")
public class HomeController {
    Log logger = LogFactory.getLog(HomeController.class);

    @GetMapping
    public String home() {
        logger.info("Estás en el home");
        return "home"; //el return redirige a las vistas(templates)
    }

    @GetMapping("/registro")
    public String registro() {
        return "registro";
    }

}
