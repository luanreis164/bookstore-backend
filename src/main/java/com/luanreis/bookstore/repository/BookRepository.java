package com.luanreis.bookstore.repository;

import com.luanreis.bookstore.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    @Query("SELECT obj FROM Book obj WHERE obj.categorie.id = categorie_id ORDER BY title")
    List<Book> findByCategorie(@Param(value = "categorie_id") Integer categorie_id);

}
