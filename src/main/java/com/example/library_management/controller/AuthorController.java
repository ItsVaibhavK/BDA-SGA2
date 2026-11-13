
package com.example.library_management.controller;

import java.util.Optional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.library_management.entity.Author;
import com.example.library_management.service.LibraryService;

@Controller
public class AuthorController {

    private final LibraryService libraryService;

    public AuthorController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/authors/add")
    public String showAddAuthorForm() {
        return "addAuthor";
    }

    @PostMapping("/authors/add")
    public String addAuthor(@ModelAttribute Author author, Model model) {
        try {
            libraryService.addAuthor(author);
            return "redirect:/authors/add";

        } catch (DataIntegrityViolationException e) {
            model.addAttribute("errorMessage","Author data not saved due to a database constraint.");
            return "addAuthor";
        }
    }

    @GetMapping("/authors/edit/{id}")
    public String showEditAuthorForm(@PathVariable Integer id, Model model) {
        Optional<Author> author = libraryService.getAuthorById(id);

        if (author.isEmpty()) {
            return "redirect:/authors";
        }

        model.addAttribute("author", author.get());
        return "editAuthor";
    }

    @PostMapping("/authors/edit")
    public String updateAuthor(@ModelAttribute Author author, Model model) {
        try {
            boolean updated = libraryService.updateAuthor(author);

            if (!updated) {
                return "redirect:/authors";
            }

            return "redirect:/authors";

        } catch (DataIntegrityViolationException e) {
            model.addAttribute("author", author);
            model.addAttribute("errorMessage","Author data could not be updated due to a database constraint.");
            return "editAuthor";
        }
    }
}
