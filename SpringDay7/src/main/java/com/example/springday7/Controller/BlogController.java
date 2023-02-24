package com.example.springday7.Controller;

import com.example.springday7.Model.Blog;
import com.example.springday7.Service.BlogSirvice;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor

@RequestMapping("api/v1")
public class BlogController {
private final BlogSirvice blogSirvice;




    @GetMapping("/get")
    public ResponseEntity getBlog()
    {
        List<Blog>blogs=blogSirvice.getBlog();
        return ResponseEntity.status(200).body(blogs);

    }

@PostMapping("/add")
    public ResponseEntity addBlog(@Valid @RequestBody Blog blog, Errors errors)
    {
        /*if(errors.hasErrors())
        {
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }*/
       blogSirvice.addBlog(blog);
        return ResponseEntity.status(200).body("blog added");

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@PathVariable Integer id,@Valid@RequestBody Blog blog,Errors errors)
    {
       /* if(errors.hasErrors())
        {
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }*/

        boolean isUbdate= blogSirvice.updataBlog(id,blog);

        if(isUbdate==true)
            return ResponseEntity.status(200).body("blog updated");

        else
            return ResponseEntity.status(400).body("Wrong id");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBlog(@PathVariable Integer id){
        boolean isDeleted= blogSirvice.deleteBlog(id);
        if(isDeleted==true)
            return ResponseEntity.status(200).body("Blog deleted");
        else
            return ResponseEntity.status(400).body("Wrong id");

    }
    @GetMapping("/bytitle/{title}")
    public ResponseEntity getByTitle(@PathVariable String title)
    {
        Blog blog=blogSirvice.finedBlogByTitle(title);
        return ResponseEntity.status(200).body(blog);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity getById(@PathVariable Integer id)
    {
        Blog blog=blogSirvice.finedById(id);
        return ResponseEntity.status(200).body(blog);
    }


    @GetMapping("/byIdfrom/{id}")
    public ResponseEntity getByIdfrom(@PathVariable Integer id)
    {
        Blog blog=blogSirvice.finedById(id);
        return ResponseEntity.status(200).body(blog);
    }



}
