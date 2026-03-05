/*
 * package com.aay.entities;
 * 
 * import jakarta.persistence.Entity; import jakarta.persistence.Id; import
 * jakarta.persistence.GeneratedValue; import
 * jakarta.persistence.GenerationType;
 * 
 * @Entity public class student {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
 * 
 * private String name; private String className; private String mobileNo;
 * private String email; private String age;
 * 
 * // Default constructor (required by JPA) public student() { }
 * 
 * // Parameterized constructor public student(Long id, String name, String
 * className, String mobileNo, String email, String age) { this.id = id;
 * this.name = name; this.className = className; this.mobileNo = mobileNo;
 * this.email = email; this.age = age; }
 * 
 * public Long getId() { return id; }
 * 
 * public void setId(Long id) { this.id = id; }
 * 
 * public String getName() { return name; }
 * 
 * public void setName(String name) { this.name = name; }
 * 
 * public String getClassName() { return className; }
 * 
 * public void setClassName(String className) { this.className = className; }
 * 
 * public String getMobileNo() { return mobileNo; }
 * 
 * public void setMobileNo(String mobileNo) { this.mobileNo = mobileNo; }
 * 
 * public String getEmail() { return email; }
 * 
 * public void setEmail(String email) { this.email = email; }
 * 
 * public String getAge() { return age; }
 * 
 * public void setAge(String age) { this.age = age; } }
 */



package com.aay.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String className;
    private String mobileNo;
    private String email;
    private String age;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<books> books;

    public student() {}

    public student(Long id, String name, String className, String mobileNo,
                   String email, String age, List<books> books) {
        this.id = id;
        this.name = name;
        this.className = className;
        this.mobileNo = mobileNo;
        this.email = email;
        this.age = age;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<books> getBooks() {
        return books;
    }

    public void setBooks(List<books> books) {
        this.books = books;
    }
}