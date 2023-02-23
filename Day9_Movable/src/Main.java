import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        try{

            Scanner input = new Scanner(System.in);
            int x, y, speedx, speedy;
            System.out.println("Enter value of x : ");
            x = input.nextInt();

            System.out.println("Enter value of y : ");
            y = input.nextInt();

            System.out.println("Enter value of xSpeed : ");
            speedx = input.nextInt();

            System.out.println("Enter value of ySpeed : ");
            speedy = input.nextInt();

            MovablePoint m = new MovablePoint(x, y, speedx, speedy);


            System.out.println("X=" + m.getX() + '\n' + "Y= " + m.getY() + '\n' + "xSpeed = " + m.getxSpeed() + '\n' + "ySpeed = " + m.getySpeed()
            );


            m.moveUp();
            m.moveDown();
            m.moveLeft();
            m.moveRight();
        }

catch (InputMismatchException exception)
{
    System.out.println("Error type of input :");
}
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

}