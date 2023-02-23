package com.example.user_order_product.Controller;

import com.example.user_order_product.Model.Orders;
import com.example.user_order_product.Model.Product;
import com.example.user_order_product.Model.User;
import com.example.user_order_product.Service.OrderService;
import com.example.user_order_product.Service.ProductService;
import com.example.user_order_product.Service.UserService;
import com.example.user_order_product.dto.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {
private final UserService userService;
private final OrderService orderService;
private final ProductService productService;

    @GetMapping("/get")
    public ResponseEntity getAllUser() {
        List<User> users = userService.getAllUser();
        return ResponseEntity.status(200).body(users);

    }

    @PostMapping("/add")
    public ResponseEntity addNewUser(@Valid @RequestBody User user) {
        userService.addNewUser(user);
        return ResponseEntity.status(200).body("user added");

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @Valid @RequestBody User user) {
        userService.updateUser(id,user);
        return ResponseEntity.status(200).body("user updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.status(200).body("user deleted");
    }



    @PostMapping("/{user_id}/userOrder/{order_id}")
    public ResponseEntity assignUserToOrder(@PathVariable Integer user_id,@PathVariable Integer order_id )
    {
        orderService.assignUserToOrder(user_id,order_id);
        return ResponseEntity.status(200).body("Assign user");

    }



    @GetMapping("/getUser/{id}")
  public ResponseEntity Get_User(@PathVariable Integer id)
    {
        User users=userService.Get_User(id);
        return ResponseEntity.status(200).body(users);

    }
    @GetMapping("/getOrder/{id}")
    public ResponseEntity Get_order(@PathVariable Integer id)
    {
        Orders orders=orderService.Get_order(id);
        return ResponseEntity.status(200).body(orders);

    }

    @GetMapping("/getProduct/{id}")
    public ResponseEntity Get_Product(@PathVariable Integer id)
    {
        Product product=productService.Get_Product(id);
        return ResponseEntity.status(200).body(product);

    }
    @GetMapping("/allCustomer/{id}")
    public ResponseEntity Get_all_customer_orders(@PathVariable Integer id)
    {
        Set<Orders> orders=orderService.Get_all_customer_orders(id);
        return ResponseEntity.status(200).body(orders);

    }
    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody User newUser){
        userService.register(newUser);
        return ResponseEntity.status(201).body(new ApiResponse("User Created"));
    }



    @PostMapping("/login")
    public ResponseEntity login(){
        return ResponseEntity.status(200).body(new ApiResponse("Logged in successfully"));
    }







}
