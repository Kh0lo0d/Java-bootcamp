package com.example.day14_ex.Pojo;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.RejectedExecutionException;

@Data
@AllArgsConstructor
public class Employees {

    //Id:
    @NotEmpty(message="ID should be not Empty ")
    @Size(min=2,message="ID should be more than 2 ")
    private String id;

    //Name
    @NotEmpty(message="The name should be not Empty ")
    @Size(min=4,message="The length of the name should be more than 4 ")
    private String name;

    //Age:
    @NotNull(message="The Age should be not Empty ")
    @Positive(message="The Age should be over than 0")
    @Min(value=25,message="The Age should be over than 25 ")
    private int age;

    //location
    @NotEmpty(message="location should be not Empty ")
    @Pattern(regexp="^(Supervisor|Coordinator)$",
            message="Wrong role ,location should be supervisor or coordinator only")

    private String role;
    //ON leave
@AssertFalse(message = "the on leave should false")
    private boolean onLeave;


    //Employment Year
    @NotNull(message="employment Year should be not Empty ")
    @Positive(message=" Employment Year should be number and  more than 0")
    @Min(value = 2017,message="The Employment Year should valid year ")
    @Max(value = 2055,message="The Employment Year should valid year ")

    // @Past@PastOrPresent(message = "must be a valid year")
    private int employmentYear;

    //annualLeave
    @NotNull(message="annual Leave  should be not Empty ")
    @PositiveOrZero(message="The annual Leave should be equal or  more than 0")
    private int annualLeave;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isOnLeave() {
        return onLeave;
    }

    public void setOnLeave(boolean onLeave) {
        this.onLeave = onLeave;
    }

    public int getEmploymentYear() {
        return employmentYear;
    }

    public void setEmploymentYear(int employmentYear) {
        this.employmentYear = employmentYear;
    }

    public int getAnnualLeave() {
        return annualLeave;
    }

    public void setAnnualLeave(int annualLeave) {
        this.annualLeave = annualLeave;
    }
}
