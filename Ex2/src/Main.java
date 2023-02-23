import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Exercise 2
        // The program to convert a given string into lowercase

        Scanner input=new Scanner(System.in);

        String str , s,str2;
        System.out.println("Enter any String:");
        str=input.nextLine();
        s=str.toUpperCase();
        str2=s.toLowerCase();
        System.out.println("The String in lowercase : \n "+str2);


    }
}