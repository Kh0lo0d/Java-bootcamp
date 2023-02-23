import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       //Ex4

        Scanner input =new Scanner(System.in);
        int num ,factorial=1;
        System.out.println("Enter the number :");
        num=input.nextInt();
        for(int i=1 ;i <= num; i++)
        {
            factorial =factorial*i;
    }
        System.out.println("factorial of number"+num +"= "+factorial);

    }
}