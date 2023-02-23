public class Student extends Person{

    private int level;
    private double GBA;

    public Student(String firstName, String lasName, String phoneNumber, String email, int level, double GBA) {
        super(firstName, lasName, phoneNumber, email);
        this.level = level;
        this.GBA = GBA;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getGBA() {
        return GBA;
    }

    public void setGBA(double GBA) {
        this.GBA = GBA;
    }
}
