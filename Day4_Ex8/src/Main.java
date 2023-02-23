import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Ex8

        Scanner input= new Scanner(System.in);
        int[]array={1,1,1,3,3,5,6,6,6,6,8};
        int count=0,num;
        System.out.println("Enter  number:");
        num=input.nextInt();
        for (int i = 0; i < array.length; i++)
        {
             if(array[i]==num)
                count++;


        }
        System.out.println(num+" occurs  "+count+" "+"times");
         }
}