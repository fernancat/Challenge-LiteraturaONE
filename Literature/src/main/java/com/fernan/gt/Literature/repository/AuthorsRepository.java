package com.fernan.gt.Literature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fernan.gt.Literature.models.Authors;

public interface AuthorsRepository extends JpaRepository<Authors, Long>  {
    @Query("SELECT a FROM Authors a WHERE :year BETWEEN a.nacimiento AND a.muerte")
    List<Authors> findAuthorsByYears(@Param("year") int year);
}
