package ucen.uk.alessiouniversityhall;

import java.io.Serializable;
import java.util.ArrayList;

public class Hall implements Serializable {
    private final String hallName;
    private final String dietType;
    private final boolean groundFloorAvailable;
    private final ArrayList<Person> residents;

    public Hall(String hallName, String dietType, boolean groundFloorAvailable) {
        this.hallName = hallName;
        this.dietType = dietType;
        this.groundFloorAvailable = groundFloorAvailable;
        this.residents = new ArrayList<>();
    }

    public String getHallName() {
        return hallName;
    }

    public String getDietType() {
        return dietType;
    }

    public boolean isGroundFloorAvailable() {
        return groundFloorAvailable;
    }

    public ArrayList<Person> getResidents() {
        return residents;
    }

    public void addResident(Person p) {
        residents.add(p);
    }

    @Override
    public String toString() {
        return hallName + " (Diet: " + dietType + ", Ground Floor: " + groundFloorAvailable + ")";
    }
}
