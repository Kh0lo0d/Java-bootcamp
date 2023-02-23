package com.example.demo.Service;

import com.example.demo.Pojo.Blog;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class BlogService {
    ArrayList<Blog> blogs = new ArrayList<>();


    public ArrayList<Blog> getBlog() {
        return blogs;
    }

    public void addBlogs(Blog blog) {
        blogs.add(blog);
    }


    public boolean updateBlog(int id, Blog blog) {


        for (int i = 0; i < blogs.size(); i++) {
            if (blogs.get(i).getId() == id) {
                blogs.set(i, blog);
                return true;
            }
        }
        return false;
    }


    public boolean deleteBlog(int id) {
        for (int i = 0; i < blogs.size(); i++) {
            if (blogs.get(i).getId() == id) {
                blogs.remove(i);
                return true;
            }
        }
        return false;
    }
}