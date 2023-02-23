package com.example.project5.Controller;

import com.example.project5.DTO.LocationStoreDTO;
import com.example.project5.Model.Book;
import com.example.project5.Model.Customer;
import com.example.project5.Model.Store;
import com.example.project5.Service.BookSirvice;
import com.example.project5.Service.LocationSirvice;
import com.example.project5.Service.StoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/store")
public class StoreController {

    private final StoreService storeService;
    private final LocationSirvice locationSirvice;
    private final BookSirvice bookSirvice;

    @GetMapping("/get")
    public ResponseEntity getAllStore() {
        List<Store> stores = storeService.getAllStore();
        return ResponseEntity.status(200).body(stores);

    };

    @PostMapping("/add")
    public ResponseEntity addNewStore(@Valid @RequestBody Store store) {
        storeService.addNewStore(store);
        return ResponseEntity.status(200).body("store added");

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStore(@PathVariable Integer id, @Valid @RequestBody Store store) {
        storeService.updateStore(id,store);
        return ResponseEntity.status(200).body("store updated");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStore(@PathVariable Integer id) {
        storeService.deleteStore(id);
        return ResponseEntity.status(200).body("store deleted");
    }
    @PostMapping("/addLocationStore")//Store To Location (One To One)
    public ResponseEntity addLocationStore(@RequestBody LocationStoreDTO locationStoreDTO) {
        locationSirvice.addLocationStore(locationStoreDTO);

        return ResponseEntity.status(200).body("store location  added");
    }

    @PutMapping("/updateStoreLocation/{id}")
    public ResponseEntity updateStoreLocation(@PathVariable Integer id, @Valid @RequestBody LocationStoreDTO locationStoreDTO) {
        locationSirvice.updateStoreLocation(locationStoreDTO);
        return ResponseEntity.status(200).body("store location updated");}

    @DeleteMapping("/deleteStoreLocation/{id}")
    public ResponseEntity deleteStoreLocation(@PathVariable Integer id) {

        locationSirvice.deleteStoreLocation(id);

        return ResponseEntity.status(200).body("Store deleted");

    }

    @GetMapping("/getAllLocationr/{id}")
    public ResponseEntity AllLocationById(@PathVariable Integer id) {
        LocationStoreDTO locationStoreDTO=locationSirvice.AllLocationById(id);
        return ResponseEntity.status(200).body(locationStoreDTO);

    }

    @PostMapping("/{store_id}/storetoBook/{book_id}")//Store To Book(One To Many)
    public ResponseEntity assignStoreToBook(@PathVariable Integer store_id,@PathVariable Integer book_id)
    {
        bookSirvice.assignStoreToBook(store_id,book_id);
        return ResponseEntity.status(200).body("Assign store");

    }


    @PostMapping("/{store_id}/storeCustomer/{customer_id}")//Store To Customer(Many To Many)
    public ResponseEntity assignStoreToCustomer(@PathVariable Integer store_id,@PathVariable Integer customer_id){
        storeService.assignStoreToCustomer(store_id,customer_id);
        return ResponseEntity.status(200).body("assign store with customer");
    }

    @GetMapping("/ReturnAllBooksByStoreid/{id}")//Create endpoint that takes storeid and return all the books
    public ResponseEntity ReturnAllBooksByStoreid(@PathVariable Integer id)
    {
        Set<Book> books=storeService.ReturnAllBooksByStoreid(id);
        return ResponseEntity.status(200).body(books);

    }
    @GetMapping("/ReturnAllCustomerById/{id}")//Create endpoint thar takes storeid and return all customers

    public ResponseEntity ReturnAllCustomerById(@PathVariable Integer id)
    {
        Set<Customer>customers=storeService.ReturnAllCustomerById(id);
        return ResponseEntity.status(200).body(customers);}

    @GetMapping("/InforamtionOfBookById/{id}")//Create endpoint that takes bookId and return number of books available
    public ResponseEntity NumberOfBooks(@PathVariable Integer id)
    {
        Integer num= bookSirvice.NumberOfBooks(id);
        return ResponseEntity.status(200).body(num);}

    @GetMapping("/InforamtionOfBookByName/{name}")//Create endpoint that takes a book name and return all book information
    public ResponseEntity InforamtionOfBook(@PathVariable String name){
        Book book=bookSirvice.InforamtionOfBook(name);
        return ResponseEntity.status(200).body(book);}


    @GetMapping("/specificGenre/{genre}")//Create endpoint that return all books under a specific genre
    public ResponseEntity specificGenre(@PathVariable String genre){
        List<Book> books=bookSirvice.specificGenre(genre);
        return ResponseEntity.status(200).body(books);}

}








