package com.fernan.gt.Literature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernan.gt.Literature.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findBooksByLanguage(String language);
}
