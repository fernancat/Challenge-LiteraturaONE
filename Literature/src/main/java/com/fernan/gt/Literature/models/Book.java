package com.fernan.gt.Literature.models;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String Language;

    @ManyToMany
    private List<Authors> authors;

    private String downloads;
    

    public Book(String title, List<DataAuthors> dataAuthorsList, String downloads, String Language) {
        this.title = title;
        this.downloads = downloads;
        this.authors = dataAuthorsList.stream()
                .map(dataAuthors -> new Authors(dataAuthors.nombre()))
                .collect(Collectors.toList());
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Authors> getAuthors() {
        return authors;
    }

   
    public String getDownloads() {
        return downloads;
    }

    public void setDownloads(String downloads) {
        this.downloads = downloads;
    }

    @Override
    public String toString() {
        return "\n*********Libro encontrado******** \n----------------------\nAutores = " + authors +
               "\nNombre Libro= " + title + '\'' + "\n Lenguajes: " + Language + 
               "\nDescargas=" + downloads + "\n----------------------\n";
    }
}
