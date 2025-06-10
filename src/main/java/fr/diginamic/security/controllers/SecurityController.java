package fr.diginamic.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class SecurityController {

    @GetMapping("/public")
    public String getHelloPublic(){
        return "hello public";
    }

    @GetMapping("/private")
    public String getHelloPrivate(){
        return "hello private";
    }

    @GetMapping("/{name}")
    public String getHelloPrivate(@PathVariable String name) throws  Exception {
        return "hello " + name;
    }
}
