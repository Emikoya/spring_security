package fr.diginamic.security.controllers;

import fr.diginamic.security.entities.Article;
import fr.diginamic.security.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleRepository repository;

    @PostMapping("/new")
    public String registerUser(@ModelAttribute Article article) throws Exception {
        repository.save(
                new Article(
                        article.getTitre(),
                        article.getContenu()
                )
        );
        return "article créé";
    }
}
