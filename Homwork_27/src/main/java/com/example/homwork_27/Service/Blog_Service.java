package com.example.homwork_27.Service;

import com.example.homwork_27.Exception.ApiException;
import com.example.homwork_27.Model.Blog;
import com.example.homwork_27.Model.User;
import com.example.homwork_27.Repositary.BlogRepositry;
import com.example.homwork_27.Repositary.UserRepsitary;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class Blog_Service {

    private final BlogRepositry blogRepositry;
    private final UserRepsitary userRepsitary;

    public List getAllBlog() {
        return blogRepositry.findAll();
    }


    public void addNewBlog(Blog blog, Integer id_user) {
        User user = userRepsitary.findUserById(id_user);
        blog.setUser(user);
        blogRepositry.save(blog);
    }


    public void updateBlog(Integer id, Blog blog, Integer user_id) {
        Blog oldBlog = blogRepositry.findBlogById(id);
        User user = userRepsitary.findUserById(user_id);
        if (oldBlog == null) {
            throw new ApiException("Blog not found");
        } else if (oldBlog.getUser().getId() != user_id) {
            throw new ApiException("Sorry , You do not have the user to update this blog!");
        }

        blog.setId(id);
        blog.setUser(user);
        blogRepositry.save(blog);

    }

    public void deleteBlog(Integer id, Integer user_id) {
        Blog blog = blogRepositry.findBlogById(id);
        if (blog == null) {
            throw new ApiException("blog not found");
        } else if (blog.getUser().getId() != user_id) {
            throw new ApiException("Sorry , You do not have the user to delete this blog!");
        }
        blogRepositry.delete(blog);
    }

    public void assignUserToBlog(Integer user_id, Integer blog_id) {
        User user = userRepsitary.findUserById(user_id);
        Blog blog = blogRepositry.findBlogById(blog_id);
        if (user == null || blog == null) {
            throw new ApiException("user Or blog not Found");

        } else {
            blog.setUser(user);
            blogRepositry.save(blog);
        }
    }

    public Blog getBlogById(Integer id) {
        Blog blog = blogRepositry.findBlogById(id);
        if (blog == null) {
            throw new ApiException("Blog not Found");
        } else

            return blog;
    }

    public Blog findBlogByTitle(String title)
    {
        Blog blog=blogRepositry.findBlogByTitle(title);
        if (blog == null) {
            throw new ApiException("Blog not Found");
        } else

            return blog;

    }

}