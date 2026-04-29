package ucen.uk.alessiouniversityhall;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * This class serves as a base class for Student and Employee,
 * allowing shared attributes to be reused.
 * The class implements Serializable to allow saving and
 * loading person data from a text file.
 *
 * @author Alessio
 */
public class Person implements Serializable {

    private final String fullName;
    private final String dob;
    private final String nationality;
    private final String gender;
    private final String phone;
    private Hall hall;
    private final LocalDateTime dateTimeStamp;

    /**
     * Constructs a new Person with basic personal information.
     *
     * @param fullName the full name of the person
     * @param dob the date of birth in format DD/MM/YYYY
     * @param nationality the nationality of the person
     * @param gender the gender of the person
     * @param phone  the phone number of the person
     * @param hall the hall assigned to the person
     * @param dateTimeStamp the date and time that the record was entered
     */
    public Person(String fullName, String dob, String nationality, String gender, String phone, Hall hall, LocalDateTime dateTimeStamp) {
        this.fullName = fullName;
        this.dob = dob;
        this.nationality = nationality;
        this.gender = gender;
        this.phone = phone;
        this.hall = hall;
        this.dateTimeStamp = dateTimeStamp;
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
     * Returns phone number of the person.
     *
     * @return phone number
     */
    public String getPhone() {
        return phone;
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
     * Returns the date and time the record was created.
     *
     * @return timestamp
     */
    public LocalDateTime getDateTimeStamp() {
        return dateTimeStamp;
    }

    /**
     * Returns formatted timestamp.
     *
     * @return formatted timestamp
     */
    public String getFormattedDateTimeStamp() {
        DateTimeFormatter formattedStamp = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return dateTimeStamp.format(formattedStamp);
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
                ", Phone: " + phone +
                ", Hall: " + hall.getHallName() +
                ", Created: " + getFormattedDateTimeStamp();
    }
}
