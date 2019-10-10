package edu.mum.cs425.elibrary.elibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {

    @GetMapping(value = {"/", "/elibrary"})
    public String displayHomePage(){
        return "home/index";
    }

    @GetMapping(value = "elibrary/about")
    public String displayAboutpage(){
        return "home/about";
    }
}
