package dao_approach.daojdbc;

import dao_approach.DepartmentDAO;
import dao_approach.model.Department;
import dao_approach.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {
    private Connection connection;
    private DAOImpl daoImpl;

    public DepartmentDAOImpl(DAOImpl daoImpl) {
        this.connection = daoImpl.connection;
        this.daoImpl = daoImpl;
    }

    public Department getDepartmentById(int id){
        try {
            String jednostkasql = "SELECT * From Jednostka WHERE id=" + id;
            Statement st = connection.createStatement();
            st.execute(jednostkasql);
            ResultSet rs = st.getResultSet();
            if (rs.next()) {
                Department d = createDepartmentFromResultset(rs);
                rs.close();
                return d;
            }
            rs.close();
            return null;
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
            return null;
        }
    }


    public Department getDepartmentByName(String name){
        try{
        String jednostkasql = "SELECT * From Jednostka WHERE nazwa='"+name+"'";
        Statement st = connection.createStatement();
        st.execute(jednostkasql);
        ResultSet rs = st.getResultSet();
        if (rs.next()) {
            Department d = createDepartmentFromResultset(rs);
            rs.close();
            return d;
        }
        rs.close();
        return null;
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public boolean updateDepartment(Department d) {
        int rows =0;
        try {
            String sql = "UPDATE Pracownik SET imie = ? , nazwisko= ?, stanowisko = ? WHERE id =?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,d.getName());
            pst.setInt(2,d.getId());
            rows = pst.executeUpdate();
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
            return false;
        }

        return rows > 0;
    }

    public boolean deleteDepartment(Department d) {
        return false;
    }

    public boolean insertDepartment(Department d) {
        return false;
    }

    private Department createDepartmentFromResultset(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("nazwa");
        Department d = new Department(id,name, new ArrayList<Person>());
        String pracownicysql = "SELECT Pracownik.id as id, imie, nazwisko, nazwa as stanowisko, id_jedn from Pracownik, Stanowisko, PracJednLnk WHERE Pracownik.stanowisko=Stanowisko.id AND PracJednLnk.id_prac=Pracownik.id  AND PracJednLnk.id_jedn=" + d.getId();
        Statement st = connection.createStatement();
        st.execute(pracownicysql);
        ResultSet rs2 = st.getResultSet();
        while(rs2.next()){
            d.getMembers().add(daoImpl.personDAO.createPersonFromResultSet(rs2));
        }
        rs2.close();
        st.close();
        return d;
    }

}
