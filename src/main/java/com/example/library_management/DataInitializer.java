package com.example.library_management;

import java.time.LocalDate;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.library_management.entity.Author;
import com.example.library_management.entity.Book;
import com.example.library_management.repository.AuthorRepository;
import com.example.library_management.repository.BookRepository;

@Component 
public class DataInitializer implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public DataInitializer(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override 
    public void run(String... args) throws Exception {
        // To prevent duplicate inserts
        if (authorRepository.count() > 0 || bookRepository.count() > 0) {
            return;
        }

        // Create authors
        Author janeAusten = new Author("Jane Austen", LocalDate.of(1775, 12, 16));
        Author maryShelley = new Author("Mary Shelley", LocalDate.of(1797, 8, 30));
        Author arthurConanDoyle = new Author("Arthur Conan Doyle", LocalDate.of(1859, 5, 22));
        Author bramStoker = new Author("Bram Stoker", LocalDate.of(1847, 11, 8));
        Author fitzgerald = new Author("F. Scott Fitzgerald", LocalDate.of(1896, 9, 24));
        Author agathaChristie = new Author("Agatha Christie", LocalDate.of(1890, 9, 15));
        Author tolkien = new Author("J.R.R. Tolkien", LocalDate.of(1892, 1, 3));
        Author orwell = new Author("George Orwell", LocalDate.of(1903, 6, 25));
        Author pratchett = new Author("Terry Pratchett", LocalDate.of(1948, 4, 28));
        Author gaiman = new Author("Neil Gaiman", LocalDate.of(1960, 11, 10));

        // Save authors
        authorRepository.saveAll(List.of(
            janeAusten,
            maryShelley,
            arthurConanDoyle,
            bramStoker,
            fitzgerald,
            agathaChristie,
            tolkien,
            orwell,
            pratchett,
            gaiman
        ));

        // Create books and associate them with their authors
        Book prideAndPrejudice = new Book(
            "Pride and Prejudice",
            List.of(janeAusten),
            LocalDate.of(1813, 1, 28),
            "9780141439518"
        );

        Book frankenstein = new Book(
            "Frankenstein",
            List.of(maryShelley),
            LocalDate.of(1818, 1, 1),
            "9780199537167"
        );

        Book studyInScarlet = new Book(
            "A Study in Scarlet",
            List.of(arthurConanDoyle),
            LocalDate.of(1887, 12, 1),
            "9780199554775"
        );

        Book dracula = new Book(
            "Dracula",
            List.of(bramStoker),
            LocalDate.of(1897, 5, 26),
            "9789815293630"
        );

        Book greatGatsby = new Book(
            "The Great Gatsby",
            List.of(fitzgerald),
            LocalDate.of(1925, 4, 10),
            "9781471173936"
        );

        Book murderOnOrientExpress = new Book(
            "Murder on the Orient Express",
            List.of(agathaChristie),
            LocalDate.of(1934, 1, 1),
            "9780062693662"
        );

        Book theHobbit = new Book(
            "The Hobbit",
            List.of(tolkien),
            LocalDate.of(1937, 9, 21),
            "9780547928227"
        );

        Book nineteenEightyFour = new Book(
            "1984",
            List.of(orwell),
            LocalDate.of(1949, 6, 8),
            "9780451524935"
        );

        Book animalFarm = new Book(
            "Animal Farm",
            List.of(orwell),
            LocalDate.of(1945, 8, 17),
            "9789814867863"
        );

        Book goodOmens = new Book(
            "Good Omens",
            List.of(pratchett, gaiman),
            LocalDate.of(1990, 5, 10),
            "9780060853983"
        );

        // Save books
        bookRepository.saveAll(List.of(
            prideAndPrejudice,
            frankenstein,
            studyInScarlet,
            dracula,
            greatGatsby,
            murderOnOrientExpress,
            theHobbit,
            nineteenEightyFour,
            animalFarm,
            goodOmens
        ));

        System.out.println("Sample library data inserted successfully!");
    }
    
}
