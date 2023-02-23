public class Main {
    public static void main(String[] args) {

        //Ex10
        int[] array1 = {10, 20, 30, 40, 90, 50};
        int[] array2 = {10, 20, 30, 40, 90, 50};
        boolean r = false;

        if (array1.length == array2.length) {
            if (array1[0] == array2[0] &&
                    array1[1] == array2[1] &&
                    array1[2] == array2[2] &&
                    array1[3] == array2[3] &&
                    array1[4] == array2[4] &&
                    array1[5] == array2[5])
                System.out.println("True");
            else
                System.out.println("False");

        }

        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == array2[i])
                continue;
            else
                break;
        }


        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == array2[i])
                System.out.println(array1[i] + "= " + array2[i]);
            else
                System.out.println(array1[i] + " != " + array2[i]);

        }

    }
}