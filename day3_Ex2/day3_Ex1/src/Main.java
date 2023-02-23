import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         //Ex1
        //a program that prints the numbers from 1 to 100

        int num;
        for(int i=1;i<=100;i++) {
            System.out.println(i);
            if(i%3==0)
                System.out.println("Fizz");
            if(i%5==0)
                System.out.println("Buzz");
            if(i%5==0 && i%3==0 )
                System.out.println("FizzBuzz");




        }
    }

    }







