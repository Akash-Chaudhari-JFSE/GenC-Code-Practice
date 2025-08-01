package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    // POST /books - create a new book
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    // GET /books - get all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // GET /books/{id} - get a book by ID
    @GetMapping("/{id}") 
    public Book getBookById(@PathVariable Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return "Book with ID " + id + " deleted successfully.";
    }

    @DeleteMapping
    public String deleteAllBooks() {
        bookRepository.deleteAll();
        return "All books deleted successfully.";
    }

    @GetMapping("/count")
    public long countBooks() {
        return bookRepository.count();
    }

    @GetMapping("/exists/{id}")
    public boolean bookExists(@PathVariable Long id) {
        return bookRepository.existsById(id);
    }
}