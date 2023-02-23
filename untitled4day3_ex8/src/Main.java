import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Ex8
        Scanner input = new Scanner(System.in);
        int num, count_positive = 0, count_negative = 0, count_zero = 0;
        char ch = 'y';

        do {
            System.out.println("Enter number:");
            num = input.nextInt();
            if (num > 0)
                count_positive += 1;
            if (num < 0)
                count_negative += 1;
            if (num == 0)
                count_zero += 1;
            System.out.println("Enter choise charecter :");
            ch = input.next().charAt(0);
        }
        while (ch == 'y' || ch=='Y');
        System.out.println("the count of positive number = " + count_positive);
        System.out.println("The count of negative numbers =" + count_negative);
        System.out.println("the count of zero numbers =" + count_zero);


    }

}