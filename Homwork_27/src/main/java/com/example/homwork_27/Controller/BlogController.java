package com.example.homwork_27.Controller;

import com.example.homwork_27.Model.Blog;
import com.example.homwork_27.Model.User;
import com.example.homwork_27.Service.Blog_Service;
import com.example.homwork_27.dto.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/blog")
public class BlogController {
    private final Blog_Service blogService;
    @GetMapping("/getAllBlog")
    public ResponseEntity getAllBlog(){
        return ResponseEntity.status(200).body(blogService.getAllBlog());
    }

    @PostMapping("/add-blog")
    public ResponseEntity addNewBlog(@RequestBody @Valid Blog blog, @AuthenticationPrincipal User user){
        blogService.addNewBlog(blog, user.getId());
        return ResponseEntity.status(201).body(new ApiResponse("Blog Added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateBlog(@RequestBody @Valid Blog blog, @PathVariable Integer id, @AuthenticationPrincipal User user){
        blogService.updateBlog(id,blog, user.getId());
        return ResponseEntity.status(200).body(new ApiResponse("blog Updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBlog(@PathVariable Integer id, @AuthenticationPrincipal User user){
        blogService.deleteBlog(id, user.getId());
        return ResponseEntity.status(200).body(new ApiResponse("blog deleted"));
    }

    @GetMapping("/blogById/{id}")
    public ResponseEntity getBlogById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(blogService.getBlogById(id));
    }

    @GetMapping("/blogByTitle/{title}")
    public ResponseEntity findBlogByTitle(@PathVariable String title ){
        return ResponseEntity.status(200).body(blogService.findBlogByTitle(title));
    }



}
