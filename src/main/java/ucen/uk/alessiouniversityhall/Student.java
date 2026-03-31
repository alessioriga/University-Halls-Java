package ucen.uk.alessiouniversityhall;

public class Student extends Person{
    private String studentId;
    private String phone;
    private String course;
    private int yearOfStudy;
    private String diet;
    private boolean groundFloor;
    private Payment payment;

    public Student(String fullName, String dob, String nationality, String gender, Hall hall, String studentId, String phone, String course, int yearOfStudy, String diet, boolean groundFloor, Payment payment) {
        super(fullName, dob, nationality, gender, hall);
        this.studentId = studentId;
        this.phone = phone;
        this.course = course;
        this.yearOfStudy = yearOfStudy;
        this.diet = diet;
        this.groundFloor = groundFloor;
        this.payment = payment;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getPhone() {
        return phone;
    }

    public String getCourse() {
        return course;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public String getDiet() {
        return diet;
    }

    public boolean isGroundFloor() {
        return groundFloor;
    }

    public Payment getPayment() {
        return payment;
    }

    @Override
    public String toString() {

        return  super.toString() +
                "\nStudent ID: " + studentId +
                "\nPhone: " + phone +
                "\nCourse: " + course +
                "\nYear: " + yearOfStudy +
                "\nDiet: " + diet +
                "\nGroundFloor: " + groundFloor +
                "\n" + payment.toString() +
                "\n--------------------------------------";

    }
}
