import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       //Ex1
        Scanner input = new Scanner(System.in);

        int[] array = {50,-20,0,30,40,60,10};
        System.out.println(Arrays.toString(array));

if(array.length>2)
       if(array[0]==array[array.length-1])
           System.out.println("True");
       else
           System.out.println("false");


 }
}



