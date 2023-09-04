package com.jpa.crud.controller;

import com.jpa.crud.exception.BookAlreadyExistsCustomException;
import com.jpa.crud.model.Book;
import com.jpa.crud.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Book> bookList = bookService.getAllBooks();

        // Add the book list to the model for the Thymeleaf template to access
        model.addAttribute("bookList", bookList);
        return "home.html";
    }

    @GetMapping("/book")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/addbook")
    public String addBookPage() {
        return "addBook.html";
    }

    @PostMapping("/add-book")
    public String addBook(@RequestParam String title, @RequestParam String author, @RequestParam String publishedDate, @RequestParam String image_url, @RequestParam String description, Model model) throws BookAlreadyExistsCustomException{
        try {
            bookService.addBook(title, author, publishedDate, image_url, description);

        } catch (BookAlreadyExistsCustomException e) {
            model.addAttribute("error", e.getMessage());
            return "addbook";
        }
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editPostForm(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);
        if (book == null) {

        }
        model.addAttribute("book", book);
        return "edit.html";
    }

    @PostMapping("/edit/{id}")
    public String editBookSubmit(@PathVariable Long id, @ModelAttribute Book editedBook) {
        Book book = bookService.getBookById(id);

        book.setTitle(editedBook.getTitle());
        book.setPublicationDate(editedBook.getPublicationDate());
        book.setImageUrl(editedBook.getImageUrl());
        book.setAuthor(editedBook.getAuthor());
        book.setDescription(editedBook.getDescription());
        bookService.saveBook(book);

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return "redirect:/";
    }


}
