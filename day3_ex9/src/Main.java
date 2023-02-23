import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

      //ex9
        Scanner input=new Scanner(System.in);
        int num;
        System.out.println("Enter the number of Week:");
        num=input.nextInt();
        for(int i=1;i<=num;i++)
        {System.out.println("the week"+i);
            for(int j=1;j<=7;j++) {
                System.out.println("day"+j);

            }
        }
    }
}