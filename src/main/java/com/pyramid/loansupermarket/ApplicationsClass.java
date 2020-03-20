package com.pyramid.loansupermarket;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller //控制，调用@service等
@EnableJpaAuditing //审计，自动创建时间，更新时间等
@SpringBootApplication  //启动项注解
public class ApplicationsClass {


    @RequestMapping("/") //路由Mapping
    public String index(ModelMap map) {
        map.addAttribute("newt", "symoon");              //模板添加字段
        map.addAttribute("loansupermarket", "贷款超市");
        return "index"; //返回模板位置
    }


    public static void main(String[] args) {

        SpringApplication.run(ApplicationsClass.class, args);  //启动项
    }
}


