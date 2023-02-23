import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        int num ,sum_Even=0,sum_odd=0;
        System.out.println("Enter the number:");
        num=input.nextInt();
        while(num !=-1)
        {
            if (num%2==0)
                sum_Even=sum_Even+num;
                        else
                            sum_odd=sum_odd+num;


            System.out.println("Enter the number:");
            num=input.nextInt();


    }

        System.out.println("the sum of even numbers ="+sum_Even);
        System.out.println("the sum of odd numbers ="+sum_odd);
    }}
