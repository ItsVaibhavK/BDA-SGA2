package com.example.library_management.entity;

import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BookID")
    private Integer bookId;

    @Column(name = "Title", nullable = false, length = 255)
    private String title;

    @ManyToMany
    @JoinTable(
        name = "Book_Author",
        joinColumns = @JoinColumn(name = "BookID"),
        inverseJoinColumns = @JoinColumn(name = "AuthorID")
    )
    private List<Author> authors;

    @Column(name = "PublishedDate")
    private LocalDate publishedDate;

    @Column(name = "ISBN", length = 13, unique = true)
    private String isbn;

    // Getters and Setters
    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // Constructors

    public Book() {}

    public Book(String title, List<Author> authors, LocalDate publishedDate, String isbn) {
        this.title = title;
        this.authors = authors;
        this.publishedDate = publishedDate;
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" + "bookId=" + bookId + ", title=" + title + ", publishedDate=" + publishedDate + ", isbn=" + isbn + "}";
    }

}
