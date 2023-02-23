import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//Ex2
        Scanner input= new Scanner(System.in);
        int[]array={1,4,17,7,25,3,100};
        int max , max1,max2;
        max=array[0];
        max1=array[0];
        max2=array[0];
        for(int i=0;i<array.length;i++)
        {
            if(array[i]>max)
                max=array[i];
        }

        for(int i=0;i<array.length;i++)
        {
            if(array[i]>max)
                max=array[i];
        }


        for(int i=0;i<array.length;i++) {
            if(array[i]!=max)
            {
                if(array[i]>max1)
                    max1=array[i];
            }

        }

        for(int i=0;i<array.length;i++) {
            if(array[i]!=max && array[i]!=max1)
            {
                if(array[i]>max2)
                    max2=array[i];
            }

        }

        System.out.println(Arrays.toString(array));
        System.out.println( "The largest number is :"+max);
        System.out.println("The second largest number is :"+max1);
        System.out.println("The third largest number is :"+max2);
        System.out.println(" 3 largest elements of the side array are : "+max+" "+max1+" "+ max2);



    }
}