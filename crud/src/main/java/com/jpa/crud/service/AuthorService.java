package com.jpa.crud.service;

import com.jpa.crud.model.Author;
import com.jpa.crud.model.Genre;
import com.jpa.crud.repository.AuthorRepository;
import com.jpa.crud.repository.GenreRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @PostConstruct
    public void initializeData() {
        // Create and save some sample data
        Genre fiction = new Genre();
        fiction.setName("Fiction");
        genreRepository.save(fiction);

        Genre mystery = new Genre();
        mystery.setName("Mystery");
        genreRepository.save(mystery);

        Genre horror = new Genre();
        horror.setName("Horror");
        genreRepository.save(horror);

        Genre adventure = new Genre();
        adventure.setName("Adventure");
        genreRepository.save(adventure);

        Genre thriller = new Genre();
        thriller.setName("Thriller");
        genreRepository.save(thriller);

        Author author1 = new Author();
        author1.setName("JK Rowling");
        author1.getGenres().add(fiction);
        author1.getGenres().add(thriller);
        authorRepository.save(author1);

        Author author2 = new Author();
        author2.setName("Grimm");
        author2.getGenres().add(fiction);
        author2.getGenres().add(mystery);
        author2.getGenres().add(thriller);
        author2.getGenres().add(horror);
        authorRepository.save(author2);

        Author author3 = new Author();
        author3.setName("Leo Tolstoy");
        author3.getGenres().add(fiction);
        author3.getGenres().add(mystery);
        author2.getGenres().add(adventure);
        author2.getGenres().add(horror);
        authorRepository.save(author3);
    }
}
