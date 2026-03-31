package ucen.uk.alessiouniversityhall;

import java.util.ArrayList;

public class Store {
    private ArrayList<Person> people;
    private int index;

    public Store() {
        people = new ArrayList<>();
        index = 0;
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
        index = 0;
    }
}
