package com.example.library_management.repository;

import java.time.LocalDate;

public interface BookAuthorDetails {
    String getTitle();
    String getAuthorName();
    LocalDate getPublishedDate();
    String getIsbn();
}