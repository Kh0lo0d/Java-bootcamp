package com.example.user_order_product.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @NotNull(message="quantity should be not empty")
    @PositiveOrZero(message="quantity must be Integer")
    private Integer quantity;

    @NotNull(message="price should be not empty")
    @Positive(message="price must be Integer and grater than 0")
    private Integer price;


    @NotEmpty(message="status should be not Empty ")
    @Pattern(regexp="^(new|inProgress|completed)$",
            message="Wrong status ,status should be completed or inProgress or new only")
    private String status;



    @ManyToOne
    @JoinColumn(name ="user_id",referencedColumnName ="id" )
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name ="product_id",referencedColumnName ="id" )
    @JsonIgnore
    private Product product;

}
