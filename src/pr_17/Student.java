package pr_11;

public class Student {
    private int iDNumber;
    private double GPA;
    private String name;
    public Student(int iDNumber, String name, double GPA) {
        this.iDNumber = iDNumber;
        this.name = name;
        this.GPA = GPA;
    }
    public int getIDNumber() {
        return iDNumber;
    }
    public String getName() {
        return name;
    }
    public double getGPA() {
        return GPA;
    }
}
