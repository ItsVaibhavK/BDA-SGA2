
package com.example.library_management.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.library_management.entity.Author;
import com.example.library_management.entity.Book;
import com.example.library_management.repository.AuthorRepository;
import com.example.library_management.repository.BookAuthorDetails;
import com.example.library_management.repository.BookRepository;

@Service
public class LibraryService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public LibraryService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    // READ operations
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<BookAuthorDetails> getBookAuthorDetails() {
        return bookRepository.findBookAuthorDetails();
    }

    public Optional<Author> getAuthorById(Integer id) {
        return authorRepository.findById(id);
    }

    public Optional<Book> getBookById(Integer id) {
        return bookRepository.findById(id);
    }

    // CREATE operations
    public void addAuthor(Author author) {
        authorRepository.saveAndFlush(author);
    }

    public void addBook(Book book, List<Integer> authorIds) {
        List<Author> authors = authorRepository.findAllById(authorIds);
        book.setAuthors(authors);
        bookRepository.saveAndFlush(book);
    }

    // UPDATE operations
    public boolean updateAuthor(Author author) {
        Optional<Author> existing = authorRepository.findById(author.getAuthorId());

        if (existing.isEmpty()) {
            return false;
        }

        existing.get().setName(author.getName());
        existing.get().setBirthdate(author.getBirthdate());

        authorRepository.saveAndFlush(existing.get());
        return true;
    }

    public boolean updateBook(Book book, List<Integer> authorIds) {
        Optional<Book> existing = bookRepository.findById(book.getBookId());

        if (existing.isEmpty()) {
            return false;
        }

        List<Author> authors = authorRepository.findAllById(authorIds);
        existing.get().setTitle(book.getTitle());
        existing.get().setPublishedDate(book.getPublishedDate());
        existing.get().setIsbn(book.getIsbn());
        existing.get().setAuthors(authors);
        bookRepository.saveAndFlush(existing.get());
        return true;
    }
}
