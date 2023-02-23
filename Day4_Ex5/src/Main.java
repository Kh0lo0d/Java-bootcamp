import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //Ex5

        int []array={25,5,35,8,6,66,4,58};
        System.out.println(Arrays.toString(array));
        int swap=0;
        swap=array[0];
        array[0]=array[array.length-1];
        array[array.length-1]=swap;
        System.out.println("The array after Swapping between first and last elements :"+Arrays.toString(array));



    }
}