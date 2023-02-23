import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Ex1:
        Scanner input = new Scanner(System.in);
        int n1, n2, n3;
        System.out.println("Enter first number :");
        n1 = input.nextInt();
        System.out.println("Enter second number :");
        n2 = input.nextInt();
        System.out.println("Enter third number :");
        n3 = input.nextInt();
        boolean b = cheeck(n1, n2, n3);


    }

    public static boolean cheeck(int n1, int n2, int n3)
    {

        if (n2 == n1 + 1 && n3 == n1 + 2)
        {
            System.out.println("True");
            return true;}
        else{
            System.out.println("False");
            return false;}

    }


}

