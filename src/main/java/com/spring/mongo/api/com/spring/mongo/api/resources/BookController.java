package com.spring.mongo.api.com.spring.mongo.api.resources;


import com.spring.mongo.api.model.Book;
import com.spring.mongo.api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    
    
    @PostMapping("/addbook")
    public String saveBook(@RequestBody Book book)
    {
        bookRepository.save(book);
        return "Added Book with id :"+book.getId();
    }

    @GetMapping("/findallbooks")
    public List<Book> getBook()
    {
        return bookRepository.findAll();
    }

    @GetMapping("/findallbooks/{id}")
    public Optional<Book> getBook(@PathVariable int id)
    {
       return bookRepository.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deletebook(@PathVariable int id)
    {
        bookRepository.deleteById(id);
        return "Deleted Book with id :"+id;
    }
}
