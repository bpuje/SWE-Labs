package mum.edu.swe.hcmcpatientsmgmtsystem.controller;

        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value={"/", "/home", "/patient", "/patient/home"})
    public String home(){
        return "index";
    }

}
