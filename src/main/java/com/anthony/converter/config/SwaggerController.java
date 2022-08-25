package com.anthony.converter.config;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwaggerController {

    @GetMapping(value = {"/", "/swagger", "/sandbox"})
    public String index(Model model) {
        return "api-docs";
    }
}
