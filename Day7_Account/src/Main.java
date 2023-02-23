import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        try{
        Account a1 ;
        String name ,id;
        int balance , amount,de,num;

        System.out.println("Enter ID:");
        id=input.nextLine();
        System.out.println("Enter the name :");
        name=input.next();
        System.out.println("Enter balance :");
        balance=input.nextInt();


       a1=new Account(id,name,balance ) ;
       System.out.println(a1.toString());

       System.out.println(" Enter the number of the operation you want to perform : "+'\n'+
       "Enter 1 for credit "+'\n'+"Enter 2 for the amount you want to deposit "+'\n'+"Enter 3 for trnsfer to another account");
       num=input.nextInt();
       switch (num) {
           case 1: {
               System.out.println("enter the amount you want : ");
               amount = input.nextInt();
               a1.credit(amount);
               break;
           }

           case 2: {
               System.out.println("Enter the amount you want to deposit :");
               de = input.nextInt();
               a1.debit(de);
               break;
           }
           case 3: {

               int am;
               Account a2;
               System.out.println(" Enter the amount of you want transfer :");
               am = input.nextInt();
               a2 = new Account("12598765432", "khaled Mohammed", am);
               a1.TranseferTo(a2, am);
               break;
           }
           default: {
               System.out.println("Erorr input of number operation !");
           }

       }






       }
        catch (InputMismatchException ex)
        {
            System.out.println(" error of type input !");
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }



































    }
}