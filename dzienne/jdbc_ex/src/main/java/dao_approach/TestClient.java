package dao_approach;

import dao_approach.daojdbc.DAOImpl;
import dao_approach.model.Department;
import dao_approach.model.Person;

import java.sql.SQLException;

public class TestClient
{
    public static void main(String[] args){
        DAO dao = new DAOImpl();

        for (Person p : dao.findPersonByName("Tomasz")){
            System.out.print(p.getId());
            System.out.print(" ");
            System.out.print(p.getName());
            System.out.print(" ");
            System.out.print(p.getSurname());
            System.out.print(" ");
            System.out.println(p.getPosition());
            Department d = dao.getDepartmentById(p.getDepartmentId());
            System.out.println(d.getName());
            System.out.println("Ilość pracowników "+d.getMembers().size());
        }

        System.out.println("------------------");

        Person person = dao.getPersonById(1);
        person.setPosition("dyrektor");
        System.out.println(dao.updatePerson(person));

        person = new Person(13,"Stefan","Stefanowski","kierownik",1);
        dao.insertPerson(person);
        System.out.println(person.getId());
        for (Person p : dao.findPersonByName("Tomasz")){
            System.out.print(p.getId());
            System.out.print(" ");
            System.out.print(p.getName());
            System.out.print(" ");
            System.out.print(p.getSurname());
            System.out.print(" ");
            System.out.println(p.getPosition());
            Department d = dao.getDepartmentById(p.getDepartmentId());
            System.out.println(d.getName());
            System.out.println("Ilość pracowników "+d.getMembers().size());
        }

    }
}
