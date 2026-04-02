package ucen.uk.alessiouniversityhall;

import java.io.Serializable;

public class Person  implements Serializable {
    private final String fullName;
    private final String dob;
    private final String nationality;
    private final String gender;
    private Hall hall;

    public Person(String fullName, String dob, String nationality, String gender, Hall hall) {
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

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    @Override
    public String toString() {
        return fullName +
                ", DOB: " + dob +
                ", Nationality: " + nationality +
                ", Gender: " + gender +
                ", Hall: " + hall.getHallName();
    }
}
