package dao_approach.daojdbc;

import dao_approach.DAO;
import dao_approach.DepartmentDAO;
import dao_approach.model.Department;
import dao_approach.model.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class DAOImpl implements DAO {
    DepartmentDAOImpl departmentDAO;
    PersonDAOImpl personDAO;
    Connection connection;

    public DAOImpl(){
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:..\\..\\pracownicy.db");
            personDAO = new PersonDAOImpl(this);
            departmentDAO = new DepartmentDAOImpl(this);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Department getDepartmentById(int id){
        return departmentDAO.getDepartmentById(id);
    }

    public Department getDepartmentByName(String name){
        return departmentDAO.getDepartmentByName(name);
    }

    public boolean updateDepartment(Department d) {
        return departmentDAO.updateDepartment(d);
    }

    public boolean deleteDepartment(Department d) {
        return departmentDAO.deleteDepartment(d);
    }

    public boolean insertDepartment(Department d) {
        return departmentDAO.insertDepartment(d);
    }

    public Person getPersonById(int id){
        return personDAO.getPersonById(id);
    }

    public List<Person> findPersonByName(String name){
        return personDAO.findPersonByName(name);
    }

    public List<Person> findPersonBySurname(String sname){
        return personDAO.findPersonBySurname(sname);
    }

    public List<Person> findPersonByPosition(String name){
        return personDAO.findPersonByPosition(name);
    }

    public boolean updatePerson(Person p) {
        return personDAO.updatePerson(p);
    }

    public boolean deletePerson(Person p) {
        return personDAO.deletePerson(p);
    }

    public boolean insertPerson(Person p) {
        return personDAO.insertPerson(p);
    }
}
