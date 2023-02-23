public  class Teacher extends Person{
    private double Salary;

    public Teacher(String firstName, String lasName, String phoneNumber, String email, double salary) {
        super(firstName, lasName, phoneNumber, email);
        Salary = salary;
    }

    public double getSalary() {
        return Salary;
    }

    public final  void setSalary(double salary){

        this.Salary=salary;
    }
}
