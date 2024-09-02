package com.lekkss.jpa.repositories;

import com.lekkss.jpa.models.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface  AuthorRepository extends JpaRepository<Author, Integer> {

    @Transactional
    List<Author> findByNamedQuery(@Param("age") int age);

    @Modifying
    @Transactional
    void updateByNamedQuery(@Param("age") int age);

    // update author a set a.age = 2 where a.id = 1
    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age where a.id = :id")
    void updateAuthor(int age, int id);

    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age")
    void updateAllAuthorsAges(int age);
    //select * from author where first_name = 'ali'
    List<Author> findByFirstName(String firstName);

    //select * from author where first_name = 'al'
    List<Author> findByFirstNameIgnoreCase(String firstName);

    //select * from author where first_name like '%al%'
    List<Author> findByFirstNameContainingIgnoreCase(String firstName);

    //select * from author where first_name like 'al%'
    List<Author> findByFirstNameStartsWithIgnoreCase(String firstName);

    //select * from author where first_name like '%al'
    List<Author> findByFirstNameEndsWithIgnoreCase(String firstName);

    //select * from author where first_name in ('ali','bou','coding')
    List<Author> findByFirstNameInIgnoreCase(List<String> firstNames);

}
