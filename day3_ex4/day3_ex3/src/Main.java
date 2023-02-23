import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

     //Ex3

        Scanner input = new Scanner(System.in)  ;
        int num;
        System.out.println("Enter the number");
        num=input.nextInt();
        int i=1;

        while(num>0){
            System.out.println(num+"*"+i+"="+num*i);
          i++;
          if(i>10)
              break;
        }



    }
}