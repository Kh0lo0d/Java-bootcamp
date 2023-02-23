public class Main {
    public static void main(String[] args) {

       Student s1=new Student();
        Student s2=new Student();
        Student s3=new Student();
        Student s4=new Student();
        Student s5=new Student();

        s1.setFirstName("kholood");
        s1.setLastName(" Ahmed");
        s1.setID("10756566");
        s1.setPhone("0553004011");
        s1.setEmail("koko.an@hotmail.com");

     System.out.println("The information of first Student :");
        System.out.println("first name  :"+s1.getFirstName());
        System.out.println("last name : "+s1.getLastName());
        System.out.println(" ID  :"+s1.getID());
        System.out.println(" phone number : "+s1.getPhone());
        System.out.println("Email: "+s1.getEmail());
     System.out.println("*********************************************************8");
        //***************************************************************************************

     s2.setFirstName("Kother");
     s2.setLastName(" Al-Mubark");
     s2.setID("20145656");
     s2.setPhone("055248970");
     s2.setEmail("kother@hotmail.com");

System.out.println("The information of Second Student :");
     System.out.println("first name: "+s2.getFirstName());
     System.out.println(" last name: "+s2.getLastName());
     System.out.println(" ID : "+s2.getID());
     System.out.println("phone number: "+s2.getPhone());
     System.out.println(" Email : "+s2.getEmail());
     System.out.println("*********************************************************8");

//***************************************************************************************************

     s3.setFirstName("Rana");
     s3.setLastName(" Mohammed");
     s3.setID("20145687");
     s3.setPhone("0553129227");
     s3.setEmail("rana.Mohammmed@hotmail.com");
     System.out.println("The information of third Student :");
     System.out.println("first name : "+s3.getFirstName());
     System.out.println("last name : "+s3.getLastName());
     System.out.println("ID : "+s3.getID());
     System.out.println("phone number : "+s3.getPhone());
     System.out.println("Email : "+s3.getEmail());

//***************************************************************************************


    }
}