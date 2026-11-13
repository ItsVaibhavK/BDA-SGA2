package com.example.library_management.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.library_management.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("SELECT b.title AS title, a.name AS authorName, b.publishedDate AS publishedDate, b.isbn AS isbn FROM Book b INNER JOIN b.authors a")
    List<BookAuthorDetails> findBookAuthorDetails();
}
