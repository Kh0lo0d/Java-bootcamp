public class Student {

    private String FirstName;
    private String LastName;
    private String ID;
    private String Phone;
    private String Email;

    public Student(){


    }

    public Student(String firstName, String lastName, String ID, String phone, String email) {
        FirstName = firstName;
        LastName = lastName;
        this.ID = ID;
        Phone = phone;
        Email = email;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getID() {
        return ID;
    }

    public String getPhone() {
        return Phone;
    }

    public String getEmail() {
        return Email;
    }
}
