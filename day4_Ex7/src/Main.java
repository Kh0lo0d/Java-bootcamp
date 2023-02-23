import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       //Ex7
        Scanner input= new Scanner(System.in);
        int size_Array,index ,element;
        char ch ;
        System.out.println("Enter the number of size array");
        size_Array=input.nextInt();
        int[]array=new int[size_Array];


        for(int i=0;i<array.length;i++)
        {
            System.out.println("Enter the value :");
            array[i]=input.nextInt();

        }

        System.out.println("choose charecter of menue: \n"+"A. Accept elements of an array\n" +"B.Display elements of an array\n" +

                "C.Search the element within array\n"+"D.Sort the array\n");
        ch=input.next().charAt(0);


        switch (ch)
        {
            case 'A' :
            case'a':

                for(int i=0;i<array.length;i++)
                {
                    System.out.println("Enter the value :");
                    array[i]=input.nextInt();

                }
                System.out.println("A new array is  : "+Arrays.toString(array));
                break;
            case'B':
            case 'b':
                       System.out.println(Arrays.toString(array));
                        break;



            case'C':
            case'c':
                System.out.println("Enter choise element :");
                element=input.nextInt();
                for (int i = 0; i <array.length ; i++) {

                    if(array[i]==element)
                        System.out.println("the number is found");

                }
                break;

            case 'D' :
            case 'd':
                Arrays.sort(array);
                System.out.println(Arrays.toString(array));
                break;

            default:
                System.out.println(" the charecter is not found in menue .");
                    }

                }

                }





