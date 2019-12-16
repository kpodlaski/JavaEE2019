package dao_approach;

import dao_approach.model.Person;

import java.sql.SQLException;
import java.util.List;

public interface PersonDAO {
    Person getPersonById(int id);

    List<Person> findPersonByName(String name);

    List<Person> findPersonBySurname(String sname);

    List<Person> findPersonByPosition(String name);

    boolean updatePerson(Person p);

    boolean deletePerson(Person p);

    boolean insertPerson(Person p);
}
