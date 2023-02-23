package com.example.project5.Controller;

import com.example.project5.Model.Book;
import com.example.project5.Model.Customer;
import com.example.project5.Service.BookSirvice;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/book")
public class BookController {
    private final BookSirvice bookSirvice;
    @GetMapping("/get")
    public ResponseEntity getAllBook() {
        List<Book> books = bookSirvice.getAllBook();
        return ResponseEntity.status(200).body(books);

    }

    @PostMapping("/add")
    public ResponseEntity addNewBook(@Valid @RequestBody Book book) {
        bookSirvice.addNewBook(book);
        return ResponseEntity.status(200).body("Book added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBook(@PathVariable Integer id, @Valid @RequestBody Book book) {
        bookSirvice.updateBook(id, book);
        return ResponseEntity.status(200).body("customer updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable Integer id) {
        bookSirvice.deleteBook(id);
        return ResponseEntity.status(200).body("Book deleted");
    }
}
