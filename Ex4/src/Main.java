import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Exercise 4
        //The  program that checks the role of the user

        Scanner input =new Scanner(System.in);
        String role ,s1;
        System.out.println("Enter the role:");
        role=input.nextLine();
        s1=role.toLowerCase();
        if(s1.equals("admin")) {
            System.out.println("welcome admin");
        }
        else if (s1.equals("superuser"))
            System.out.println("welcome superuser");
        else
            System.out.println("not found");



    }

}