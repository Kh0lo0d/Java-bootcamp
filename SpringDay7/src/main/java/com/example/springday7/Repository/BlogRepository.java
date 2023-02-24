package com.example.springday7.Repository;

import com.example.springday7.Model.Blog;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {


Blog findBlogByTitle(String title);
Blog findBlogById(Integer id);


@Query("select u from Blog u where u.id=?1")
Blog finedIdFrom(Integer id);









}
