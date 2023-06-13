package prob1;

import java.util.Arrays;

public class MyPersonList {
    private final int INITIAL_LENGTH = 4;
    private Person[] people;
    private int size;

    public MyPersonList() {
        people = new Person[INITIAL_LENGTH];
        size = 0;
    }

    public void add(Person person) {
        if (person == null) return;
        if (size == people.length) resize();
        people[size++] = person;
    }

    public Person get(String lastName) {
        if (lastName == null || lastName == "") return null;
        for (int i = 0; i < size; i++) {
            if (people[i].getLast().equals(lastName)) return people[i];
        }
        return null;
    }

    private void resize() {
        Person[] newPeople = new Person[people.length * 2];
        System.arraycopy(people, 0, newPeople, 0, people.length);
        people = newPeople;
    }

    public boolean find(String lastName) {
        if (lastName == null) return false;
        for (int i = 0; i < size; i++) {
            if (people[i].getLast().equals(lastName)) return true;
        }
        return false;
    }

    public void insert(Person person, int index) {
        if (index > size || size < 0) return;
        if (index == people.length || index + 1 > people.length) resize();
        Person[] temp = new Person[people.length + 1];
        System.arraycopy(people, 0, temp, 0, index);
        temp[index] = person;
        System.arraycopy(people, index, temp, index + 1, size - index);
        people = temp;
        ++size;

    }

    public boolean remove(String lastName) {
        if (size == 0) return false;
        if (lastName == null || lastName == "") return false;
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (people[i].getLast().equals(lastName)) {
                index = i;
                break;
            }
        }
        if (index == -1) return false;
        Person[] temp = new Person[people.length];
        System.arraycopy(people, 0, temp, 0, index);
        System.arraycopy(people, index + 1, temp, index, size - index - 1);
        people = temp;
        --size;
        return true;
    }
    public Object clone() {
        Person[] temp = Arrays.copyOf(people, size);
        return temp;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(people[i].getLast());
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    public static void main(String[] args) {

        Person person1 = new Person("Uynga", "Davaa", 25);
        Person person2 = new Person("Tsogtoo", "Bayaraa", 30);
        Person person3 = new Person("Amar", "Jargal", 23);
        Person person4 = new Person("Bold", "Dorj", 40);
        Person person5 = new Person("Nyam","Ganaa", 24);

        MyPersonList myPersonList = new MyPersonList();
        myPersonList.add(person1);
        myPersonList.add(person2);
        myPersonList.add(person3);
        myPersonList.add(person4);
        myPersonList.add(person5);

        System.out.println("Number of elements: " + myPersonList.size);
        System.out.println("Length of the current array: " + myPersonList.people.length);
        System.out.println(myPersonList.toString());

        Person person6 = new Person("Baatar","Dulam", 30);
        myPersonList.insert(person6, 2);

        myPersonList.remove("Nyam");
        myPersonList.remove("Bold");

        System.out.println("Number of elements: " + myPersonList.size);
        System.out.println("Length of the current array: " + myPersonList.people.length);
        System.out.println(myPersonList.toString());

        System.out.println(myPersonList.get("Amar"));

    }
}
