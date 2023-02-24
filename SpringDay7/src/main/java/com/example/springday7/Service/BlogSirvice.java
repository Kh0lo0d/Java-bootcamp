package com.example.springday7.Service;

import com.example.springday7.Exception.ApiException;
import com.example.springday7.Model.Blog;
import com.example.springday7.Repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogSirvice {
    private final BlogRepository blogRepository;

    public List getBlog() {
        return blogRepository.findAll();
    }

    public void addBlog(Blog blog) {
        blogRepository.save(blog);
    }

    public boolean updataBlog(Integer id, Blog blog) {
        Blog oldBlog = blogRepository.findBlogById(id);
        if (oldBlog == null) {
            return false;
        }
        oldBlog.setTitle(blog.getTitle());
        oldBlog.setBody(blog.getBody());
        blogRepository.save(oldBlog);

        return true;


    }


    public boolean deleteBlog(Integer id) {
        Blog oldBlog = blogRepository.findBlogById(id);
        if (oldBlog == null) {
            return false;
        } else
            blogRepository.deleteById(id);
        return true;

    }

    public Blog finedBlogByTitle(String title)
    {
        Blog blog=blogRepository.findBlogByTitle(title);
        if(blog==null){
            throw new ApiException(("title not found"));}
        return blog;



    }

    public Blog finedById(Integer id)
    {
        Blog blog=blogRepository.findBlogById(id);
        if(blog==null){
            throw new ApiException(("id  not found"));}
        return blog;



    }
    public Blog finedIdfrom(Integer id)
    {
        Blog blog=blogRepository.finedIdFrom(id);
        if(blog==null){
            throw new ApiException(("id  not found"));}
        return blog;



    }

    public Blog findByidAndTitle(Integer id ,String title)
    {
        Blog blog=blogRepository.finedIdFrom(id);
        if(blog==null){
            throw new ApiException(("id  not found"));}
        return blog;



    }




}