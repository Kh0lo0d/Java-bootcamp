public class Person {

    private String FirstName;
    private String LasName;
    private String PhoneNumber;
    private String Email;

    public Person(String firstName, String lasName, String phoneNumber, String email) {
        FirstName = firstName;
        LasName = lasName;
        PhoneNumber = phoneNumber;
        Email = email;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLasName() {
        return LasName;
    }

    public void setLasName(String lasName) {
        LasName = lasName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }


}
