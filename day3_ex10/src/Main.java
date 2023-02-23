import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input =new Scanner(System.in);
        String s1,s2="";
        int len;
        System.out.println("Enter first word");
        s1=input.nextLine();
        len=s1.length();
       for(int i=len-1;i>=0;i--)
       {
           s2=s2+s1.charAt(i);}

          if(s1.equals(s2))
               System.out.println("the word is palindrome");
           else
               System.out.println("the word not palindrome ") ;




           }
       }



