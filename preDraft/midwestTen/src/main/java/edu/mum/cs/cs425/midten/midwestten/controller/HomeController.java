package edu.mum.cs.cs425.midten.midwestten.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/midwest", "/midwest/home"})
    public String home(){
        return "home/index";
    }

}
