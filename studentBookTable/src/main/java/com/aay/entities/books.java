


package com.aay.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class books {

    @Id
    private String bookId;

    private String bookName;
    private String publisher;

    @OneToOne
    @JoinColumn(name = "student_id")
    private student student;

    public books() {}

    public books(String bookId, String bookName, String publisher, student student) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.publisher = publisher;
        this.student = student;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public student getStudent() {
        return student;
    }

    public void setStudent(student student) {
        this.student = student;
    }
}