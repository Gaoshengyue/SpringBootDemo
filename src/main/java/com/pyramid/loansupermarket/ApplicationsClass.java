package com.pyramid.loansupermarket;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class ApplicationsClass {


    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("newt", "symoon");
        return "index";
    }


    public static void main(String[] args) {

        SpringApplication.run(ApplicationsClass.class, args);
    }
}


