package cl.cristiandurf.gestorliquidaciones.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author El Piero tiene sueño
 * @version 0.0.1
 * @since 28-06-2022
 */
@Controller
@RequestMapping("/")
public class InicioController {
    Log logger = LogFactory.getLog(InicioController.class);

    @GetMapping
    public String inicio() {

        logger.info("Estás en el home");
        return "Home";
    }
}
