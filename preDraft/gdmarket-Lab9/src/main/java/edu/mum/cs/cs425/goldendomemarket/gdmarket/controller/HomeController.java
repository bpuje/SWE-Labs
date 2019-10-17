package edu.mum.cs.cs425.goldendomemarket.gdmarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/gdmarket", "/gdmarket/home"})
    public String home(){
        return "home/index";
    }
}
