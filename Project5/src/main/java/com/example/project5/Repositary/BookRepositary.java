package com.example.project5.Repositary;

import com.example.project5.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface BookRepositary extends JpaRepository<Book,Integer> {
    Book findBookById(Integer id);
    Book findBookByName(String  name);

    List<Book> findBookByGenre(String genre);
}
