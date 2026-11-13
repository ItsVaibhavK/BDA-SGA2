package com.example.library_management.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Author {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AuthorID")
    private Integer authorId;

    @Column(name = "Name", nullable = false, length = 255)
    private String name;

    @Column(name = "Birthdate")
    private LocalDate birthdate;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

    // Constructors

    public Author() {}

    public Author(String name, LocalDate birthdate) {
        this.name = name;
        this.birthdate= birthdate;
    }

    // Getters and Setters
    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" + "authorId=" + authorId + ", name=" + name + ", birthdate=" + birthdate + "}";
    }
}
