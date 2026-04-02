package ucen.uk.alessiouniversityhall;

import java.io.Serializable;

/**
 * This class serves as a base class for Student and Employee,
 * allowing shared attributes to be reused.
 * The class implements Serializable to allow saving and
 * loading person data from a text file.
 *
 * @author Alessio
 */
public class Person  implements Serializable {

    private final String fullName;
    private final String dob;
    private final String nationality;
    private final String gender;
    private Hall hall;

    /**
     * Constructs a new Person with basic personal information.
     *
     * @param fullName the full name of the person
     * @param dob the date of birth in format DD/MM/YYYY
     * @param nationality the nationality of the person
     * @param gender the gender of the person
     * @param hall the hall assigned to the person
     */
    public Person(String fullName, String dob, String nationality, String gender, Hall hall) {
        this.fullName = fullName;
        this.dob = dob;
        this.nationality = nationality;
        this.gender = gender;
        this.hall = hall;
    }

    /**
     * Returns the full name of the person.
     *
     * @return full name
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Returns the date of birth of the person.
     *
     * @return date of birth
     */
    public String getDob() {
        return dob;
    }

    /**
     * Returns nationality of the person.
     *
     * @return nationality
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * Returns gender of the person.
     *
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Returns the hall assigned to the person.
     *
     * @return hall
     */
    public Hall getHall() {
        return hall;
    }

    /**
     * Updates the hall assigned to the person.
     *
     * @param hall new hall to assign
     */
    public void setHall(Hall hall) {
        this.hall = hall;
    }
    /**
     *
     * Returns a formatted string representation of the person.
     * Includes basic personal information and assigned hall.
     *
     * @return formatted person information
     */
    @Override
    public String toString() {
        return fullName +
                ", DOB: " + dob +
                ", Nationality: " + nationality +
                ", Gender: " + gender +
                ", Hall: " + hall.getHallName();
    }
}
