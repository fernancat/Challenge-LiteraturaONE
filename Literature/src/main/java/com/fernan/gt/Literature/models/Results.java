package com.fernan.gt.Literature.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Results (
    @JsonAlias("results")  List<BookData> bookData

) {
    
}
