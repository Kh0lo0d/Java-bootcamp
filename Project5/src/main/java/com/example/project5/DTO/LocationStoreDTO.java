package com.example.project5.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LocationStoreDTO {

    private Integer store_Id;

    @NotEmpty(message="area should be not empty")
    @Column(columnDefinition = "varchar(10)  not null ")
    private String area;
    @NotEmpty(message="area should be not empty")
    @Column(columnDefinition = "varchar(10)  not null ")
    private String street;

}
