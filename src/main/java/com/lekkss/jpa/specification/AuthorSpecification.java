package com.lekkss.jpa.specification;

import com.lekkss.jpa.models.Author;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class AuthorSpecification {
    public static Specification<Author> hasAge(int age) {
        return (
                Root<Author> root,
                CriteriaQuery<?> query,
                CriteriaBuilder cb
        ) -> {
            if (age < 0) {
                return null;
            }
            return cb.equal(root.get("age"), age);
        };
    }

    public static Specification<Author> firstNameLike(String firstname) {
        return (
                Root<Author> root,
                CriteriaQuery<?> query,
                CriteriaBuilder cb
        ) -> {
            if (firstname == null) {
                return null;
            }
            return cb.like(root.get("firstName"), "%" + firstname + "%");
        };
    }
}
