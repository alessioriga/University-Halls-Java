package ucen.uk.alessiouniversityhall;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class implements Serializable so hall data can be saved
 * and loaded from a text file.
 *
 * @author Alessio
 */
public class Hall implements Serializable {

    private final String hallName;
    private final String dietType;
    private final boolean groundFloorAvailable;
    private final ArrayList<Person> residents;

    /**
     * Constructs a Hall with a name, diet type, and ground floor availability.
     *
     * @param hallName the name of the hall
     * @param dietType the supported diet type
     * @param groundFloorAvailable true if ground floor rooms are available, false otherwise
     */
    public Hall(String hallName, String dietType, boolean groundFloorAvailable) {
        this.hallName = hallName;
        this.dietType = dietType;
        this.groundFloorAvailable = groundFloorAvailable;
        this.residents = new ArrayList<>();
    }

    /**
     * Returns the name of the hall.
     *
     * @return hall name
     */
    public String getHallName() {
        return hallName;
    }

    /**
     * Returns the supported diet type of the hall.
     *
     * @return diet type (e.g., Vegetarian, Vegan, Halal, Mixed)
     */
    public String getDietType() {
        return dietType;
    }

    /**
     * Checks if ground floor accommodation is available.
     *
     * @return true if ground floor is available, false otherwise
     */
    public boolean isGroundFloorAvailable() {
        return groundFloorAvailable;
    }

    /**
     * Returns the list of residents living in the hall.
     *
     * @return list of Person objects (students and employees)
     */
    public ArrayList<Person> getResidents() {
        return residents;
    }

    /**
     * Adds a resident to the hall.
     * The resident can be either a Student or an Employee.
     *
     * @param p the person to add to the hall
     */
    public void addResident(Person p) {
        residents.add(p);
    }

    /**
     * Returns a formatted string representation of the hall.
     * Includes hall name, diet type, and ground floor availability.
     *
     * @return formatted hall information
     */
    @Override
    public String toString() {
        return hallName + " (Diet: " + dietType + ", Ground Floor: " + groundFloorAvailable + ")";
    }
}
