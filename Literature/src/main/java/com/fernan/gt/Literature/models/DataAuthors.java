package com.fernan.gt.Literature.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown= true)
public record DataAuthors (
    @JsonAlias("name") String nombre,
    @JsonAlias("birth_year") Integer nacimiento,
    @JsonAlias("death_year") Integer muerte)
{}

