
package com.example.library_management.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.library_management.entity.Author;
import com.example.library_management.entity.Book;
import com.example.library_management.repository.AuthorRepository;
import com.example.library_management.repository.BookRepository;

@ExtendWith(MockitoExtension.class)
class LibraryServiceTest {

    @Mock
    private AuthorRepository authorRepository;

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private LibraryService libraryService;

    @Test
    void testGetAllAuthors() {
        when(authorRepository.findAll()).thenReturn(List.of(new Author()));
        assertEquals(1, libraryService.getAllAuthors().size());
    }

    @Test
    void testGetAllBooks() {
        when(bookRepository.findAll()).thenReturn(List.of(new Book()));
        assertEquals(1, libraryService.getAllBooks().size());
    }

    @Test
    void testAddAuthor() {
        Author author = new Author();
        libraryService.addAuthor(author);
        verify(authorRepository).saveAndFlush(author);
    }

    @Test
    void testAddBook() {
        Book book = new Book();
        Author author = new Author();

        when(authorRepository.findAllById(List.of(1))).thenReturn(List.of(author));
        libraryService.addBook(book, List.of(1));
        assertEquals(1, book.getAuthors().size());
        verify(bookRepository).saveAndFlush(book);
    }

    @Test
    void testUpdateAuthor() {
        Author author = new Author();
        author.setAuthorId(1);

        when(authorRepository.findById(1)).thenReturn(Optional.of(author));
        author.setName("Updated Author");
        assertTrue(libraryService.updateAuthor(author));
        verify(authorRepository).saveAndFlush(author);
    }

    @Test
    void testUpdateBook() {
        Book book = new Book();
        book.setBookId(1);

        when(bookRepository.findById(1)).thenReturn(Optional.of(book));
        when(authorRepository.findAllById(List.of(1))).thenReturn(List.of(new Author()));
        assertTrue(libraryService.updateBook(book, List.of(1)));
        verify(bookRepository).saveAndFlush(book);
    }
}
