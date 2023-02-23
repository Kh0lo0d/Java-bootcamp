public class Employee {

    private String id;
    private String name;
    private double salary;
    public Employee()
    {}

    public Employee(String id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public double getAnnualSalary()
    {
      double annualSal;
      annualSal=getSalary()*12;
      return annualSal;
    }

    public double raisedSalary(int percent)
    {
        double p=(double)percent;
        return salary*(p/100);
    }

    public String toString()
    {
        String str="Employee name :"+getName()+'\n'+"Employee ID : "+getId()+'\n'+
                "Employee Salary : "+getSalary()+'\n'+"The employee's annual salary : "+getAnnualSalary();
        return str;

    }
}
