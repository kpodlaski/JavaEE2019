package dao_approach;

import dao_approach.model.Department;

import java.sql.SQLException;

public interface DepartmentDAO  {
    Department getDepartmentById(int id) ;

    Department getDepartmentByName(String name) ;

    boolean updateDepartment(Department d);

    boolean deleteDepartment(Department d);

    boolean insertDepartment(Department d);
}
