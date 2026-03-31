package ucen.uk.alessiouniversityhall;

import java.io.Serializable;
import java.util.ArrayList;

public class Store implements Serializable {
    private ArrayList<Person> people;
    private int index;

    public Store() {
        people = new ArrayList<>();
        index = 0;
    }

    public void addPerson(Person p) {
        people.add(p);
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
        index = 0;
    }

    public Person getNextPerson() {

        if (people.isEmpty())
            return null;

        if (index >= people.size())
            index = 0;

        return people.get(index++);
    }

    public int size() {
        return people.size();
    }
}
