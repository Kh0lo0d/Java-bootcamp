import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Exercise 3
        //the  Program check the number is even or not

        Scanner input=new Scanner(System.in);
        int number;
        System.out.println("Enter the number :");
        number=input.nextInt();
        if(number%2==0)
            System.out.println(1);
        else
        System.out.println(0);



    }
}