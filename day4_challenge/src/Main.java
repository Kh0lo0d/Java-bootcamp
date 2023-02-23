import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int[] array = {11,15,2,7,6,9,1};
        int min=array[0];

        for(int i=0;i<array.length;i++)
        {

            if(array[i]< min)
                min=array[i];
        }

        int min_second=array[0];
        for(int i=0;i<array.length;i++) {
            if(array[i]!=min)
            {
                if(array[i]<min_second)
                    min_second=array[i];
            }

        }

        System.out.println(Arrays.toString(array));
        System.out.println( "The smallest number is :"+min);
        System.out.println("The second smallest number is :"+min_second);




    }
}



