import java.io.PrintStream;
import java.util.Scanner;

public class Book extends Product {
    private String author;


    public Book(String name, double price,String author) {
        super(name,price);
        this.author = author;
    }

    public String getAuther() {
        return author;
    }

    public void setAuther(String auther) {
        this.author = auther;
    }

    public  double getDiscount(){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the value of Discount :");
        double dis=input.nextInt();
        double result;
        result=getPrice()*(dis/100);
        System.out.println("Discount = "+result);
        System.out.println("The price Book  after discount: "+(getPrice()-result));
    return result;

    }
}
