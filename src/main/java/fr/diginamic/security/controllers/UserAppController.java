package fr.diginamic.security.controllers;

import fr.diginamic.security.entities.UserApp;
import fr.diginamic.security.services.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-app")
public class UserAppController {
    @Autowired
    CustomUserDetailService customUserDetailService;

    @GetMapping("/register")
    public String registerUser(@ModelAttribute UserApp userApp) throws Exception{
        customUserDetailService.createUser(
                userApp.getEmail(),
                userApp.getPassword()
        );
        return "utilisateur créé";
    }
}
