import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Ex7
        Scanner input = new Scanner(System.in);

        int num, count = 0;
         boolean x=false;

        System.out.println("Enter the positive number:");
        num = input.nextInt();
        for(int i=2;i<= num/2;i++)
        {if (num%i==0){
            x=true;
            break;}
        }

     if(! x)
         System.out.println(num+" is the prime number");
    else
        System.out.println(num+" is not prime number");

    }}