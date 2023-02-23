package com.example.user_order_product.Controller;

import com.example.user_order_product.Model.Orders;
import com.example.user_order_product.Model.User;
import com.example.user_order_product.Repositary.OrderReprositary;
import com.example.user_order_product.Service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/orders")
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/get")
    public ResponseEntity getAllOrder() {
        List<Orders> orders = orderService.getAllOrder();
        return ResponseEntity.status(200).body(orders);

    }

    @PostMapping("/add")
    public ResponseEntity addNewOrder(@Valid @RequestBody Orders orders) {
        orderService.addNewOrder(orders);
        return ResponseEntity.status(200).body("order added");

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateOrder(@PathVariable Integer id, @Valid @RequestBody Orders orders) {
        orderService.updateOrder(id,orders);
        return ResponseEntity.status(200).body("order updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteOrder(@PathVariable Integer id) {
        orderService.deleteOrder(id);
        return ResponseEntity.status(200).body("order deleted");
    }
/*
@PutMapping("/totalPrice/{id}/{price}")
    public ResponseEntity totalPrice(@PathVariable Integer id,@PathVariable Integer price)
{
    Integer totalPrice=orderService.totalPrice(id,price);
    return ResponseEntity.status(200).body("total price="+totalPrice);
}*/
/*
@PutMapping("/change/{id}/{status}")
    public ResponseEntity changeOrderStatus(@PathVariable Integer id,@PathVariable String status)
{
    orderService.changeOrderStatus(id, status);
    return ResponseEntity.status(200).body("changed");

}*/



}
