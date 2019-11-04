package dao_approach;

import dao_approach.daojdbc.DAOImpl;
import dao_approach.model.Department;
import dao_approach.model.Person;

public class TestClient
{
    public static void main(String[] args) {
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
    }
}
