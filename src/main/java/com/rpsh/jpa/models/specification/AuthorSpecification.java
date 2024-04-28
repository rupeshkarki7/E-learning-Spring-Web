package com.rpsh.jpa.models.specification;

import com.rpsh.jpa.models.Author;
import org.springframework.data.jpa.domain.Specification;

public class AuthorSpecification {

    public static Specification<Author> hasAge(int age) {
        return (
                (root, query, cb) -> {
                    if (age < 0) {
                        return null;
                    }
                    return cb.equal(root.<Integer>get("age"), age);
                });
    }


    public static Specification<Author> firstNameContains(String firstName) {
        return (
                (root, query, criteriaBuilder) -> {
                    if (firstName != null && !firstName.isEmpty()) {
                        return criteriaBuilder.like(root.get("firstName"), "%" + firstName + "%");
                    }
                    return null;
                });
    }

}
