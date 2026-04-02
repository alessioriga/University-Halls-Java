package ucen.uk.alessiouniversityhall;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The class implements Serializable to allow saving and
 * loading the stored data from a text file.
 *
 * @author Alessio
 */
public class Store implements Serializable {

    private ArrayList<Person> people;
    private int index;

    /**
     * Initializes an empty list of people and sets the index
     * to zero for sequential access.
     */
    public Store() {
        people = new ArrayList<>();
        index = 0;
    }

    /**
     * Adds a person to the ArrayList.
     *
     * @param p the Person object (Student or Employee) to be added to the ArrayList
     */
    public void addPerson(Person p) {
        people.add(p);
    }

    /**
     * Returns the list of people stored in the system.
     *
     * @return ArrayList containing all Person objects
     */
    public ArrayList<Person> getPeople() {
        return people;
    }

    /**
     * Sets the list of people in the store.
     * This replaces the current list and resets the iteration index.
     *
     * @param people the new list of Person objects
     */
    public void setPeople(ArrayList<Person> people) {
        this.people = people;
        index = 0;
    }

    /**
     * Returns the next person in the list.
     * The method cycles through the list sequentially.
     * When the end of the list is reached, it starts again
     * from the beginning.
     *
     * @return the next Person in the store, or null if the list is empty
     */
    public Person getNextPerson() {

        if (people.isEmpty())
            return null;

        if (index >= people.size())
            index = 0;

        return people.get(index++);
    }

    /**
     * Returns the number of people stored.
     *
     * @return total number of Person objects in the ArrayList
     */
    public int size() {
        return people.size();
    }
}
