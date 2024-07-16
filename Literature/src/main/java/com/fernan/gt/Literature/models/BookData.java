package com.fernan.gt.Literature.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookData(
    @JsonAlias("title") String title,
    @JsonAlias("languages") List<String> languages,
    @JsonAlias("authors") List<DataAuthors> authors,
    @JsonAlias("download_count")  String donwloads
){}
