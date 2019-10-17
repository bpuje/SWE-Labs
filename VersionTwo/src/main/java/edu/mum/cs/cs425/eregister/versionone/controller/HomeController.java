package edu.mum.cs.cs425.eregister.versionone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = {"/srm", "/srm/home"})
    //@GetMapping(value = {"/"})
    public String home(){
        return "home/index";
    }
}
