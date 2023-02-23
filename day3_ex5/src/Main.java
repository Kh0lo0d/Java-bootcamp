import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//Ex5
        Scanner input = new Scanner(System.in);
        int num1, num2 ,power=1;
        System.out.println("Enter first number: ");
        num1 = input.nextInt();
        System.out.println("Enter second number: ");
        num2 = input.nextInt();
        for (int i = 0; i <num2; i++) {
         power*=num1;
        }
        System.out.println(power);
    }
    }
