package edu.mum.cs425.cs.goldendome.goldendome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = {"/gdm", "/gdm/home"})
    //@GetMapping(value = {"/"})
    public String home(){
        return "home/index";
    }
}
