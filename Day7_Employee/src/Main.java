import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        try {
            Employee em = new Employee();
            String name, id;
            double salary;
            System.out.println(" Enter the name of employee :");
            name = input.nextLine();
            System.out.println(" Enter the ID of employee :");
            id = input.nextLine();
            System.out.println(" Enter the salary of employee :");
            salary = input.nextDouble();

            em.setName(name);
            em.setId(id);
            if(salary>0){
            em.setSalary(salary);
            System.out.println("Enter the present : ");
            int p = input.nextInt();
            double w = em.raisedSalary(p);

            System.out.println(em.toString());

            System.out.println("raised Salary :" + w);}
            else
                throw new Exception("error input ,the salary should more than 0");
        }
        catch ( InputMismatchException ex)
        {
            System.out.println("error of typ input !");
        }
catch (Exception ex )
{ System.out.println(ex.getMessage());}


    }
}