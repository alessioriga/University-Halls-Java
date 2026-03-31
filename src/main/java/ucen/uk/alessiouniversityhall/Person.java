package ucen.uk.alessiouniversityhall;

public class Person {
    private String fullName;
    private String dob;
    private String nationality;
    private String gender;
    private String hall;

    public Person(String fullName, String dob, String nationality, String gender, String hall) {
        this.fullName = fullName;
        this.dob = dob;
        this.nationality = nationality;
        this.gender = gender;
        this.hall = hall;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDob() {
        return dob;
    }

    public String getNationality() {
        return nationality;
    }

    public String getGender() {
        return gender;
    }

    public String getHall() {
        return hall;
    }
}
