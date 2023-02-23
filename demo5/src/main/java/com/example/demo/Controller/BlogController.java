package com.example.demo.Controller;

import com.example.demo.Pojo.Blog;
import com.example.demo.Service.BlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PutExchange;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/vi/blog")
@RequiredArgsConstructor
public class BlogController {


 private final BlogService blogService;

    /*public BlogController(BlogService blogService)
    {
        this.blogService=blogService;
    }*/
@GetMapping("/get")
    public ResponseEntity getBlog()
{
    ArrayList<Blog>blog=blogService.getBlog();
    return ResponseEntity.status(200).body(blog);
}

@PostMapping("/add")
    public ResponseEntity addBlog(@Valid@RequestBody Blog blog, Errors errors)
{
    if(errors.hasErrors())
    {
        String message =errors.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(message);
    }
    blogService.addBlogs(blog);
    return ResponseEntity.status(200).body("blog added");

}

@PutMapping("/update/{id}")
    public ResponseEntity updateBlog(@PathVariable int id,@Valid@RequestBody Blog blog,Errors errors)
{
    if(errors.hasErrors())
    {
        String message =errors.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(message);
    }

    boolean isUbdate= blogService.updateBlog(id,blog);

    if(isUbdate==true)
        return ResponseEntity.status(200).body("blog updated");

   else
    return ResponseEntity.status(400).body("Wrong id");
}

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBlog(@PathVariable int id){
    boolean isDeleted= blogService.deleteBlog(id);
if(isDeleted==true)
    return ResponseEntity.status(200).body("blog deleted");
else
    return ResponseEntity.status(400).body("Wrong id");

    }

}