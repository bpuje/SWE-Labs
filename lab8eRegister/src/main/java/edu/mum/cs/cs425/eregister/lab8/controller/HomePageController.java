package edu.mum.cs.cs425.eregister.lab8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping(value = {"/", "/eregistrar", "/eregistrar/home"})
    public String displayHomePage(){
        return "home/index";
    }
}
