package com.pyramid.loansupermarket;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableJpaAuditing
@SpringBootApplication
public class ApplicationsClass {


    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("newt", "symoon");
        map.addAttribute("loansupermarket", "贷款超市");
        return "index";
    }


    public static void main(String[] args) {

        SpringApplication.run(ApplicationsClass.class, args);
    }
}


