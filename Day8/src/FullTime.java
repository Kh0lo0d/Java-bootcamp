import java.util.Scanner;

public class FullTime extends Teacher{
    private int month;

    public FullTime(String firstName, String lasName, String phoneNumber, String email, double salary,int m) {
        super(firstName, lasName, phoneNumber, email, salary);
        month=m;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    /*public void setSalary(double salary) {
       System.out.println(" the number of month :"+getMonth());
        Scanner input=new Scanner(System.in);

       System.out.println("Enter the salary : "+salary);
       System.out.println("Enter percent");
       int p=input.nextInt();
       double p2=(double)p;
       System.out.println("the Annual Salary of Full time of teatcher ="+month*salary);
       System.out.println(" the percent :"+salary*(p2/100));

    }*/

}
