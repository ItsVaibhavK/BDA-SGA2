package com.example.library_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.library_management.service.LibraryService;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class ReadController {
    private final LibraryService libraryService;

    public ReadController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/authors")
    public String viewAuthors(Model model) {
        model.addAttribute("authors", libraryService.getAllAuthors());
        return "viewAuthors";
    }

    @GetMapping("/books")
    public String viewBooks(Model model) {
        model.addAttribute("books", libraryService.getAllBooks());
        return "viewBooks";
    }

    @GetMapping("/books/authors")
    public String viewBookAuthorDetails(Model model) {
        model.addAttribute("bookAuthorDetails", libraryService.getBookAuthorDetails());
        return "viewBookAuthorDetails";
    }
    
    
    
    
}
