package com.example.final_project_training.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Order_table {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private Date start_Date;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private Date end_Date;
    @JsonFormat(pattern="HH:mm:ss")
    private Time time;

    @Positive(message="total_price must be Integer and grater than 0")
    private Double total_price;

    @NotEmpty(message="status should be not empty")
    @Pattern(regexp="^(PENDING|ACCEPT|IN PROGRESS|REJECT|COMPLETE)$",
            message="Wrong status ,status should be PENDING or ACCEPT or IN PROGRESS or REJECT or COMPLETE only")
    private String status;

    @ManyToOne
    @JoinColumn(name ="customer_id",referencedColumnName ="id" )
    @JsonIgnore
    private Customer customer;

    @ManyToOne
    @JoinColumn(name ="coach_id",referencedColumnName ="id" )
    @JsonIgnore
    private Coach coach;



    @OneToMany(cascade = CascadeType.ALL,mappedBy = "orderTable")
    private List<Training_Services>training_services;







    }

