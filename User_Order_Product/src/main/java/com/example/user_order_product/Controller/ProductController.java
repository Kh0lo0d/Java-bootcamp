package com.example.user_order_product.Controller;

import com.example.user_order_product.Model.Product;
import com.example.user_order_product.Model.User;
import com.example.user_order_product.Service.OrderService;
import com.example.user_order_product.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/product")
public class ProductController {

    private final ProductService productService;
    private final OrderService orderService;
    @GetMapping("/get")
    public ResponseEntity getAllProduct() {
        List<Product> products = productService.getAllProduct();
        return ResponseEntity.status(200).body(products);

    }

    @PostMapping("/add")
    public ResponseEntity addNewProduct(@Valid @RequestBody Product product) {
        productService.addNewProduct(product);
        return ResponseEntity.status(200).body("product added");

    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateProuct(@PathVariable Integer id, @Valid @RequestBody Product product) {
        productService.updateProuct(id,product);
        return ResponseEntity.status(200).body("product updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return ResponseEntity.status(200).body("product deleted");
    }

    @PostMapping("/{product_id}/productOrder/{order_id}")
    public ResponseEntity assignProductToOrder(@PathVariable Integer product_id,@PathVariable Integer order_id )
    {
        orderService.assignProductToOrder(product_id,order_id);
        return ResponseEntity.status(200).body("Assign product");

    }
}
