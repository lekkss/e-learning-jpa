package com.lekkss.jpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@NamedQueries({
        @NamedQuery(
                name = "Author.findByNamedQuery",
                query = "select a from Author a where a.age >= :age"
        ),
        @NamedQuery(
                name="Author.updateByNamedQuery",
                query = "update Author a set a.age = :age"
        )

})


public class Author extends BaseEntity {
    private String firstName;
    private String lastName;
    @Column(
            unique = true,
            nullable = false
    )
    private String email;
    private Integer age;
    @ManyToMany(mappedBy = "authors")
    private List<Course> courses;
}
