import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Ex4
        int[]array={200,5,6,8,9,4,5,78,5,150};
                int max=0;
        if(array[0]>array[array.length-1])
            max=array[0];
        else
            max=array[array.length-1];
        System.out.println(Arrays.toString(array));
        System.out.println("Larger value between first and last element : "+max);



    }
}