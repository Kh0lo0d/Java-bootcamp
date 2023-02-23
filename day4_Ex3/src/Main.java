import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       //Ex3
        Scanner input = new Scanner (System.in);

        int[] array={1,4,17,7,25,3,100};
        double sum=0,average=0;
        for (int i = 0; i < array.length; i++) {

            sum=sum+array[i];

        }
        average=sum/ (double)array.length;
        System.out.println(Arrays.toString(array));
        System.out.println(" The average of the said array is : "+average);
        for (int i = 0; i < array.length; i++) {
            if(array[i]>average)
                System.out.println("The numbers in the side array that are" +
                        " greater than the average are "+ array[i]);

        }


}}