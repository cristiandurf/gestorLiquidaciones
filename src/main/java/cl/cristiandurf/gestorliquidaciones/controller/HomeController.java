package cl.cristiandurf.gestorliquidaciones.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Cristian Durán
 * @version 0.0.2
 * @since 13-07-2023
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home() {
        return "home";
    }
}
