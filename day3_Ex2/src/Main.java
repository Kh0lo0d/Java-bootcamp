import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Ex2
        Scanner input =new Scanner(System.in);

String s1,s2="";
int len;
System.out.println("Enter the string :");
s1=input.nextLine();
len=s1.length();
        for(int i=len-1;i>=0;i--)
        {
            s2=s2+s1.charAt(i);}

        System.out.println(" The string is : " +s1);
        System.out.println(" the string after reverse is : "+s2);



    }
}