package fr.diginamic.security.services;

import fr.diginamic.security.entities.UserApp;
import fr.diginamic.security.repositories.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService {

    @Autowired
    UserAppRepository repository;

    public void createUser(String username, String password){
        repository.save(
                new UserApp(
                        username,
                        password
                )
        );
    }
}
