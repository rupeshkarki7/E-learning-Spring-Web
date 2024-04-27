package com.rpsh.jpa.repositories;

import com.rpsh.jpa.models.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface AuthorRepository extends JpaRepository<Author, Integer>, JpaSpecificationExecutor<Author> {


    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age where a.id = :id")
    void updateAuthor(int age, int id);

    List<Author> findAllByFirstName(String fN);

    List<Author> findAllByFirstNameIgnoreCase(String fN);

    List<Author> findAllByFirstNameContainingIgnoreCase(String fN);

    List<Author> findAllByFirstNameStartsWithIgnoreCase(String fN);

    List<Author> findAllByFirstNameEndsWithIgnoreCase(String fN);

    List<Author> findAllByFirstNameInIgnoreCase(List<String> firstNames);

}