import java.util.Scanner;

public class PartTime extends Teacher{
    private int day;
    private double hours;

    public PartTime(String firstName, String lasName, String phoneNumber, String email, double salary, int day, double hours) {
        super(firstName, lasName, phoneNumber, email, salary);
        this.day = day;
        this.hours = hours;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    /*public void setSalary(double salary) {
        System.out.println(" the number of day: "+getDay());
        System.out.println("the number of hours : "+getHours());
        System.out.println(" the salary of part time teacther : "+salary*getDay()*getDay());


    }*/


    public double getSalary(double salary) {
        return salary;
    }
}
