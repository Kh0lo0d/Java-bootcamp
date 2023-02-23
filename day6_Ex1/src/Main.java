import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Exercise 6
        Scanner input = new Scanner(System.in);
        int size_Array, index, element;
        char ch;
        try {
            System.out.println("Enter the number of size array");
            size_Array = input.nextInt();
            int[] array = new int[size_Array];


            for (int i = 0; i < array.length; i++) {
                System.out.println("Enter the value :");
                array[i] = input.nextInt();

            }

            System.out.println("choose charecter of menue: \n" + "A. Accept elements of an array\n" + "B.Display elements of an array\n" +

                    "C.Search the element within array\n" + "D.Sort the array\n");
            ch = input.next().charAt(0);


            switch (ch) {
                case 'A':
                case 'a':

                    for (int i = 0; i < array.length; i++) {
                        System.out.println("Enter the value :");
                        array[i] = input.nextInt();

                    }
                    System.out.println("A new array is  : " + Arrays.toString(array));
                    break;
                case 'B':
                case 'b':
                    System.out.println(Arrays.toString(array));
                    break;


                case 'C':
                case 'c':
                    System.out.println("Enter the  index of array :");
                    element = input.nextInt();
                   if(element<array.length)
                            System.out.println("the index is found");
                   else
                       throw new ArrayIndexOutOfBoundsException();
                    break;

                case 'D':
                case 'd':
                    Arrays.sort(array);
                    System.out.println(Arrays.toString(array));
                    break;

                default:
                    System.out.println(" the charecter is not found in menue .");
            }


        }
        catch(ArrayIndexOutOfBoundsException ex)
        {
            System.out.println("ArrayIndexOutOfBounds");

        }

        catch(InputMismatchException ex)
        {
            System.out.println("you entered wrong type");

        }

        catch(Exception ex)
        {
            System.out.println("error:"+ex.getMessage());

        }



    }


}





