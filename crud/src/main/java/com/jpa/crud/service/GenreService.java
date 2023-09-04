package com.jpa.crud.service;

import com.jpa.crud.model.Author;
import com.jpa.crud.model.Genre;
import com.jpa.crud.repository.AuthorRepository;
import com.jpa.crud.repository.GenreRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@DependsOn("authorRepository")
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private AuthorRepository authorRepository;


    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }
}
