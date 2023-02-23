package com.example.user_order_product.Service;

import com.example.user_order_product.Exception.ApiExceptin;
import com.example.user_order_product.Model.Product;
import com.example.user_order_product.Model.User;
import com.example.user_order_product.Repositary.ProductRepsitary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepsitary productRepsitary;

    public List getAllProduct(){
        return productRepsitary.findAll();
    }

    public void addNewProduct(Product product){
        productRepsitary.save(product);
    }

    public void updateProuct(Integer id,Product product)
    {
        Product oldProduct=productRepsitary.getById(id);
        if(oldProduct==null){
            throw new ApiExceptin("product Not found !");
        }
        else{
            oldProduct.setName(product.getName());
            oldProduct.setPrice(product.getPrice());
            productRepsitary.save(product);

        }}

    public void deleteProduct(Integer id)
    {
        Product oldProduct=productRepsitary.getById(id);

        if(oldProduct==null){
            throw new ApiExceptin("product Not found !");
        }
        else
            productRepsitary.deleteById(id);

    }

    public Product Get_Product(Integer id)
    {
        Product product=productRepsitary.findProductById(id);
        if (product == null) {
            throw new ApiExceptin("product Not found !");    }
        else
            return product;}


}
