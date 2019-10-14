package data;

import java.util.ArrayList;
import java.util.List;

public class PsedoDB {
    private List<Person> persons = new ArrayList<Person>();

    public PsedoDB(){
        persons.add(new Person());
        persons.add(new Person("Adam","Adamski"," "));
        persons.add(new Person("James","Bond",""));
    }

    public Person getPersonById(int id){
        return persons.get(id % persons.size());
    }
}
