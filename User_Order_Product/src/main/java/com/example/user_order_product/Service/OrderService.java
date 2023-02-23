package com.example.user_order_product.Service;

import com.example.user_order_product.Exception.ApiExceptin;
import com.example.user_order_product.Model.Orders;
import com.example.user_order_product.Model.Product;
import com.example.user_order_product.Model.User;
import com.example.user_order_product.Repositary.OrderReprositary;
import com.example.user_order_product.Repositary.ProductRepsitary;
import com.example.user_order_product.Repositary.UserRepsitary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderReprositary orderReprositary;
    private final UserRepsitary userRepsitary;
    private final ProductRepsitary productRepsitary;

    public List getAllOrder() {
        return orderReprositary.findAll();
    }


    public void addNewOrder(Orders orders) {
        orderReprositary.save(orders);
    }

    public void updateOrder(Integer id, Orders orders) {
        Orders oldOrder = orderReprositary.getById(id);
        if (oldOrder == null) {
            throw new ApiExceptin("order Not found !");
        } else {
            oldOrder.setQuantity(orders.getQuantity());
            oldOrder.setPrice(orders.getPrice());
            oldOrder.setStatus(orders.getStatus());
            orderReprositary.save(oldOrder);
        }
    }

    public void deleteOrder(Integer id) {
        Orders oldOrder = orderReprositary.getById(id);

        if (oldOrder == null) {
            throw new ApiExceptin("order Not found !");}

        if(oldOrder.getStatus()=="progress "|| oldOrder.getStatus()=="complete")
            throw new ApiExceptin(" can not delete");
           else
            orderReprositary.deleteById(id);

    }


    public void assignUserToOrder(Integer user_id, Integer order_id) {
        User user = userRepsitary.findUserById(user_id);
        Orders orders = orderReprositary.findOrdersById(order_id);
        if (user == null || orders == null) {
            throw new ApiExceptin("user Or order not Found");
        } else {
            orders.setUser(user);
            orderReprositary.save(orders);
        }

    }

    public void assignProductToOrder(Integer product_id, Integer order_id) {
        Product product = productRepsitary.findProductById(product_id);
        Orders orders = orderReprositary.findOrdersById(order_id);

        if (product == null || orders == null) {
            throw new ApiExceptin("product Or order not Found");
        } else {
            orders.setProduct(product);
            orderReprositary.save(orders);
        }
    }

/*
    public Integer totalPrice( Integer id,Integer PriceNew)
    {
        Orders orders=orderReprositary.findOrdersById(id);
        Integer total_price=orders.getPrice()+PriceNew;
        orders.setPrice(total_price);
        orderReprositary.save(orders);
        return total_price;
    }*/

/*
        public void changeOrderStatus(Integer user_id,String status )
        {
            User user=userRepsitary.findUserById(user_id);
            Orders orders=orderReprositary.findOrdersByUser(user_id);
            String role=user.getRole();

            if(role=="ADMIN"||role=="admin" )
            {orders.setStatus(status);

            }
            else
                throw new ApiExceptin("can not change status");}*/


    public Orders Get_order(Integer id)
    {
        Orders orders=orderReprositary.findOrdersById(id);
        if (orders == null) {
            throw new ApiExceptin("order Not found !");    }
        else
            return orders;}




    public Set<Orders>Get_all_customer_orders(Integer user_id)
    {
        User user=userRepsitary.findUserById(user_id);

        if (user == null) {
            throw new ApiExceptin("user Not found !");    }
        else
            return user.getOrders();

    }




}

