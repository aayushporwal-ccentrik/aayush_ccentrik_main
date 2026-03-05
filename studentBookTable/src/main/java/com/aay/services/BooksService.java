package com.aay.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aay.entities.books;
import com.aay.repository.BooksRepository;

@Service
public class BooksService {

    @Autowired
    BooksRepository repo;

    public books saveBook(books b) {
        return repo.save(b);
    }

    public List<books> getAllBooks() {
        return repo.findAll();
    }
    
	/*
	 * public Optional<books> getBooksById(String bookId){ return
	 * repo.findById(bookId); }
	 */
}