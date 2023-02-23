import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //Ex9

        int[] array = {2, 3, 40, 1, 5, 9, 4, 10, 7};
        int cont_odd = 0, count_even = 0;


        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0)
                count_even++;

             else
                cont_odd++;

            }
            System.out.println("even number :" + count_even);
            System.out.println("odd number :" + cont_odd);

            for (int j = 0; j < array.length; j++) {
                if (array[j] % 2 != 0)
                    System.out.println(array[j]);
            }

            int[]a=new int[count_even];
            for (int k = 0; k < array.length; k++) {
                if (array[k] % 2 == 0)
                    System.out.println(array[k]);
            }




        }
            }









