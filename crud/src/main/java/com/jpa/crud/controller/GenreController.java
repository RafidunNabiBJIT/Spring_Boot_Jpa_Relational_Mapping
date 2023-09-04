package com.jpa.crud.controller;

import com.jpa.crud.model.Genre;
import com.jpa.crud.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GenreController {
    @Autowired
    private GenreService genreService;

    @GetMapping("/genres")
    public String listGenres(Model model) {
        List<Genre> genres = genreService.getAllGenres();
        model.addAttribute("genres", genres);
        return "genre.html";
    }
}
