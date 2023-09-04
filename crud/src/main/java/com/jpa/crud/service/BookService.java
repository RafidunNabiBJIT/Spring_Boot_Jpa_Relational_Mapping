package com.jpa.crud.service;

import com.jpa.crud.exception.BookAlreadyExistsCustomException;
import com.jpa.crud.model.Book;
import com.jpa.crud.repository.BookRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    List<Book> books = new ArrayList<>();
    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void initializeBooks() {
        books.add(new Book(1L, "James", "2023-01-15", "Book1.jpg", "Roald Dahl", "The plot centers on a young English orphan boy who enters a gigantic, magical peach, and has a wild and surreal cross-world adventure with seven magically-altered garden bugs he meets"));
        books.add(new Book(2L, "Grimm's Fairy Tales", "2023-02-20", "Book2.jpg","Grimm", "Grimms' Fairy Tales, is a collection of fairy tales by the Grimm brothers or \"Brothers Grimm\", Jakob and Wilhelm, first published on 20 December 1812. The first edition contained 86 stories, and by the seventh edition in 1857, had 211 unique fairy tales."));
        books.add(new Book(3L, "The Last Unicorn", "2023-03-10", "Book3.jpg","Beagle", "The Last Unicorn (1968) by Peter S. Beagle is a fictional novel about a unicorn who goes out on a quest to find other unicorns and ensure she is not the last of her kind. Along the way, she makes friends with a sorcerer named Schmendrick and a woman named Molly Grue."));
        books.add(new Book(4L, "The Jungle Book", "2023-04-05", "Book4.jpg","Rudyard Kipling", "The Jungle Book by Rudyard Kipling is an adventure story about a man-cub named Mowgli. Mowgli is hunted by an evil tiger named Shere Khan. Mowgli tries to live a peaceful life with other humans, but is too wild for them and too human for the wolves. Eventually Mowgli finds a home in the jungle with a pack of his own."));
        books.add(new Book(5L, "Harry Potter", "2023-05-10", "Book5.jpg","JK Rowling", "Harry Potter is a series of seven fantasy novels written by British author J. K. Rowling. The novels chronicle the lives of a young wizard, Harry Potter, and his friends Hermione Granger and Ron Weasley, all of whom are students at Hogwarts School of Witchcraft and Wizardry."));
        bookRepository.saveAll(books);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void addBook(String title, String author, String publishedDate,String image_url, String description) throws BookAlreadyExistsCustomException{
        if (bookRepository.existsByTitle(title)) {
            throw new BookAlreadyExistsCustomException("Book already exists.");
        }
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublicationDate(publishedDate);
        book.setImageUrl(image_url);
        book.setDescription(description);

        bookRepository.save(book);
    }
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    public Book getBookById(Long id) {
        Book book = bookRepository.getById(id);
        return book;
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }
}
