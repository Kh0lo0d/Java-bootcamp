public class Main {
    public static void main(String[] args) {
        Person p=new Person("kholood","Ahmed","0553004011","koko.an@hotmail.com");
        Student s=new Student("Rana","Mohammed","05656595","ranaA@hotmail.com",5,3.5);
        //Teacher t=new Teacher("Dalia","khaled","0532546598","dalia_12@hotmail.com",8000);

FullTime f= new FullTime("latifa","faris","0553329991","latifa@hotmail.com",8000,2);
f.setMonth(12);
f.setSalary(7000);

PartTime pt =new PartTime("kother","Mubark","0500009015","kother@hotmail.com",4000,6,9);
System.out.println("the part time teacher :");
        pt.setSalary(10000);

    }
}