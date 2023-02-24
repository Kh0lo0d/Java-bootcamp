package com.example.spring_securty;

import com.example.spring_securty.Model.MyUser;
import com.example.spring_securty.Model.Todo;
import com.example.spring_securty.Repositary.TodoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TodoRepostryTest {
    @Autowired
    TodoRepository todoRepository;

    MyUser user;
    Todo todo1,todo2,todo3;

    @BeforeEach
    void setUp()
    {
        user=new MyUser(null,"majed","123","Admin",null);
        todo1=new Todo(null,"tod1",user);
        todo2=new Todo(null,"todo2",user);
        todo3=new Todo(null,"todo3",user);


    }
    @Test
    public void findTodoByIdTest()
    {
        todoRepository.save(todo1);
        Todo todo=todoRepository.findTodoById(todo1.getId());
        Assertions.assertThat(todo).isEqualTo(todo1);
    }

    @Test
    public void finedAllByMyUserTest()
    {
        todoRepository.save(todo1);
        todoRepository.save(todo2);
        todoRepository.save(todo3);

        List<Todo>todoList=todoRepository.findAllByMyUser(user.getId());
Assertions.assertThat(todoList.get(0).getMyUser().getId()).isEqualTo(user.getId());
    }



}
