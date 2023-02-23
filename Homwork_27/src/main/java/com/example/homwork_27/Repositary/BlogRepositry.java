package com.example.homwork_27.Repositary;

import com.example.homwork_27.Model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepositry extends JpaRepository<Blog,Integer> {
    Blog findBlogById(Integer id);
    Blog findBlogByTitle(String title);
}
