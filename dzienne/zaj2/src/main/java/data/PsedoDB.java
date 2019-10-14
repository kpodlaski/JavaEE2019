package data;

import java.util.ArrayList;
import java.util.List;

public class PsedoDB {
    private List<Person> persons = new ArrayList<Person>();

    public PsedoDB(){
        persons.add(new Person());
        persons.add(new Person("Adam","Adamski","https://icon-library.net/images/anonymous-person-icon/anonymous-person-icon-3.jpg"));
        persons.add(new Person("James","Bond","https://avatars3.githubusercontent.com/u/2147533?s=460&v=4"));
    }

    public Person getPersonById(int id){
        return persons.get(id % persons.size());
    }

    public List<Person> getPersons(){
        return persons;
    }
    public int size(){
        return persons.size();
    }
}
