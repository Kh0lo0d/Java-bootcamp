package com.example.project5.Service;

import com.example.project5.Exception.ApiException;
import com.example.project5.Model.Book;
import com.example.project5.Model.Customer;
import com.example.project5.Model.Store;
import com.example.project5.Repositary.BookRepositary;
import com.example.project5.Repositary.StroreRepositary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookSirvice {
    private final BookRepositary bookRepositary;
    private final StroreRepositary stroreRepositary;

    public List getAllBook(){
        return bookRepositary.findAll();
    }

    public void addNewBook(Book book){
        bookRepositary.save(book);
    }

    public void updateBook(Integer id,Book book)
    {
        Book oldBook=bookRepositary.getById(id);
        if(oldBook==null){
            throw new ApiException("Book Not found !");
        }
        else{
            oldBook.setName(book.getName());
            oldBook.setBookCount(book.getBookCount());
            oldBook.setGenre(book.getGenre());
            bookRepositary.save(oldBook);
        }}

    public void deleteBook(Integer id)
    {
        Book oldBook=bookRepositary.getById(id);

        if(oldBook==null){
            throw new ApiException("Book Not found !");
        }
        else
            bookRepositary.deleteById(id);

    }

    public void assignStoreToBook(Integer store_id,Integer book_id)
    {
        Store store=stroreRepositary.findStoreById(store_id);
        Book book=bookRepositary.findBookById(book_id);
        if(store==null|| book==null){
            throw new ApiException("Stor Or Book not Found");
        }
        else {
            book.setStore(store);
            bookRepositary.save(book);
        }
    }

    public Integer NumberOfBooks(Integer id)
    {
        Book book=bookRepositary.findBookById(id);
        if(book==null)
            throw  new ApiException("not found");
        Integer numOfBook= book.getBookCount();
        return numOfBook;

    }

    public Book InforamtionOfBook(String name)
    {
        Book book=bookRepositary.findBookByName(name);
        if(book==null)
            throw new ApiException("not found");
        return book;


    }

    public List<Book> specificGenre(String g)
    {
       List<Book>books=bookRepositary.findBookByGenre(g);
        if(books==null)
            throw new ApiException("not found");

        return books;
    }


}
