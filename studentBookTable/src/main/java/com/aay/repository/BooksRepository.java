package com.aay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aay.entities.books;

public interface BooksRepository extends JpaRepository<books, String> {

}