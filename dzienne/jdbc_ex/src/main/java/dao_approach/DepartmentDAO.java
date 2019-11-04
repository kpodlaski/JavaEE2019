package dao_approach;

import dao_approach.model.Department;

public interface DepartmentDAO extends PersonDAO {
    Department getDepartmentById(int id);

    Department getDepartmentByName(String name);

    boolean updateDepartment(Department d);

    boolean deleteDepartment(Department d);

    boolean insertDepartment(Department d);
}
