import java.util.Scanner;

public class Movie  extends Product {

    private String director;


    public Movie() {
    }

    public Movie(String name, double price, String director) {
        super(name, price);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public  double getDiscount(){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the value of Discount :");
        double dis=input.nextInt();
        double result;
        result=super.getPrice()*(dis/100);
        System.out.println("Discount = "+result);
        System.out.println("The price movie after discount: "+(getPrice()-result));
        return result;

    }
}
