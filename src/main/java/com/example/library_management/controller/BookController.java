
package com.example.library_management.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.library_management.entity.Book;
import com.example.library_management.service.LibraryService;

@Controller
public class BookController {

    private final LibraryService libraryService;

    public BookController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/books/add")
    public String showAddBookForm(Model model) {
        model.addAttribute("authors", libraryService.getAllAuthors());
        return "addBook";
    }

    @PostMapping("/books/add")
    public String addBook(@ModelAttribute Book book, @RequestParam(required = false) List<Integer> authorIds, Model model) {
        try {
            if (authorIds == null || authorIds.isEmpty()) {
                model.addAttribute("authors", libraryService.getAllAuthors());
                model.addAttribute("errorMessage", "Please select at least one author.");
                return "addBook";
            }

            libraryService.addBook(book, authorIds);
            return "redirect:/books/add";

        } catch (DataIntegrityViolationException e) {
            model.addAttribute("authors", libraryService.getAllAuthors());
            model.addAttribute("errorMessage", "Book data not saved due to a database constraint.");
            return "addBook";
        }
    }

    @GetMapping("/books/edit/{id}")
    public String showEditBookForm(@PathVariable Integer id, Model model) {
        Optional<Book> book = libraryService.getBookById(id);

        if (book.isEmpty()) {
            return "redirect:/books";
        }

        model.addAttribute("book", book.get());
        model.addAttribute("authors", libraryService.getAllAuthors());
        return "editBook";
    }

    @PostMapping("/books/edit")
    public String updateBook(@ModelAttribute Book book, @RequestParam(required = false) List<Integer> authorIds, Model model) {
        try {
            if (authorIds == null || authorIds.isEmpty()) {
                model.addAttribute("book", book);
                model.addAttribute("authors", libraryService.getAllAuthors());
                model.addAttribute("errorMessage", "Please select at least one author.");
                return "editBook";
            }

            boolean updated = libraryService.updateBook(book, authorIds);

            if (!updated) {
                return "redirect:/books";
            }

            return "redirect:/books";

        } catch (DataIntegrityViolationException e) {
            model.addAttribute("book", book);
            model.addAttribute("authors", libraryService.getAllAuthors());
            model.addAttribute("errorMessage",
                    "Book data could not be updated due to a database constraint.");
            return "editBook";
        }
    }
}
