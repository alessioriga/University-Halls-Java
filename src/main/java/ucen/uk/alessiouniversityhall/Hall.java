package ucen.uk.alessiouniversityhall;

import java.util.ArrayList;

public class Hall {
    private String hallName;
    private String dietType;
    private boolean groundFloorAvailable;
    private ArrayList<Person> residents;

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
        this.residents.add(p);
    }
}
