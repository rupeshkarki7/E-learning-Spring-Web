package com.rpsh.jpa.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@NamedQuery(

        name = "Author.updateByNamedQuery", query = "update Author a set a.age = :age")
/*
@Table(
        name = "AUTHOR_TBL"
)*/

public class Author extends BaseEntity {

    private String firstName;

    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    private int age;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "authors")
    private List<Course> courses;

}

