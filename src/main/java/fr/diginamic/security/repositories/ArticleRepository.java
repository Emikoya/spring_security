package fr.diginamic.security.repositories;

import fr.diginamic.security.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
}
