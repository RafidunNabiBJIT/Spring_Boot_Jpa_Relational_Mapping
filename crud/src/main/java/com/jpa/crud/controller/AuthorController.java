package com.jpa.crud.controller;


import com.jpa.crud.model.Author;
import com.jpa.crud.model.Genre;
import com.jpa.crud.repository.AuthorRepository;
import com.jpa.crud.repository.GenreRepository;
import com.jpa.crud.service.AuthorService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AuthorController {
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    public AuthorController(AuthorRepository authorRepository, GenreRepository genreRepository) {
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
    }



    @GetMapping("/authors")
    public String showAuthors(Model model) {
        model.addAttribute("authors", authorRepository.findAll());
        return "author.html";
    }

}
