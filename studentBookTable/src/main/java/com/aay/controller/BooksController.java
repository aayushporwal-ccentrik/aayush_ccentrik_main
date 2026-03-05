package com.aay.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.aay.entities.books;
import com.aay.services.BooksService;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    BooksService service;

    @PostMapping
    public books createBook(@RequestBody books b) {
        return service.saveBook(b);
    }

    @GetMapping
    public List<books> getBooks() {
        return service.getAllBooks();
    }
	/*
	 * @GetMapping({"/{bookId}") public Optional<books> getBooksById(@PathVariable
	 * String bookId){ return service.getBooksById(bookId); }
	 */
}