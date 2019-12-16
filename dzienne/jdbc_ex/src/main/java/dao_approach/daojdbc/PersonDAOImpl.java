package dao_approach.daojdbc;

import dao_approach.PersonDAO;
import dao_approach.model.Department;
import dao_approach.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDAOImpl implements PersonDAO {
    private DAOImpl daoImpl;
    private Connection connection;
    private PreparedStatement updatePersonPreparedStatement;
    private PreparedStatement insertPersonPreparedStatement;
    private PreparedStatement deletePreparedStatement;
    private PreparedStatement deletePersonFromAllDepartmentsPreparedStatement;


    public PersonDAOImpl(DAOImpl daoImpl) {
        this.connection = daoImpl.connection;
        this.daoImpl = daoImpl;
    }

    private void buildStatements() {
        try {
            String sql = "UPDATE Pracownik SET imie = ? , nazwisko= ?, " +
                    "stanowisko= (SELECT id as sid FROM stanowisko where nazwa = ?) " +
                    "WHERE pracownik.id =?";
            updatePersonPreparedStatement = connection.prepareStatement(sql);
            sql = "INSERT INTO Pracownik (imie, nazwisko, stanowisko) " +
                    "VALUES " +
                    "(?, ?, (SELECT id as sid FROM stanowisko where nazwa = ?))";
            insertPersonPreparedStatement = connection.prepareStatement(sql);
            sql = "DELETE FROM Pracownik  WHERE id =?";
            deletePreparedStatement = connection.prepareStatement(sql);
            sql = "DELETE FROM PRACJEDNLNK  WHERE id_prac =?";
            deletePersonFromAllDepartmentsPreparedStatement = connection.prepareStatement(sql);
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
    public Person getPersonById(int id)  {
        try {
            String sql = "SELECT Pracownik.id as id, imie, nazwisko, nazwa as stanowisko, id_jedn from Pracownik, Stanowisko, PracJednLnk WHERE Pracownik.stanowisko=Stanowisko.id AND PracJednLnk.id_prac=Pracownik.id  AND Pracownik.id=" + id;
            Statement st = connection.createStatement();
            st.execute(sql);
            ResultSet rs = st.getResultSet();
            if (rs.next()) {
                return createPersonFromResultSet(rs);
            }
            return null;
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public List<Person> findPersonByName(String name) {
        try{
            String sql = "SELECT Pracownik.id as id, imie, nazwisko, nazwa as stanowisko, id_jedn from Pracownik, Stanowisko, PracJednLnk WHERE Pracownik.stanowisko=Stanowisko.id AND PracJednLnk.id_prac=Pracownik.id  AND Pracownik.imie='"+name+"'";
        Statement st = connection.createStatement();
        st.execute(sql);
        ArrayList<Person> persons = new ArrayList<>();
        ResultSet rs = st.getResultSet();
        while (rs.next()) {
            persons.add(createPersonFromResultSet(rs));
        }
        return persons;
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public List<Person> findPersonBySurname(String sname) {
        try{
            String sql = "SELECT Pracownik.id as id, imie, nazwisko, nazwa as stanowisko, id_jedn from Pracownik, Stanowisko, PracJednLnk WHERE Pracownik.stanowisko=Stanowisko.id AND PracJednLnk.id_prac=Pracownik.id  AND Pracownik.nazwisko='"+sname+"'";
        Statement st = connection.createStatement();
        st.execute(sql);
        ArrayList<Person> persons = new ArrayList<>();
        ResultSet rs = st.getResultSet();
        while (rs.next()) {
            persons.add(createPersonFromResultSet(rs));
        }
        return persons;
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public List<Person> findPersonByPosition(String name) {
        try{
        String sql = "SELECT Pracownik.id as id, imie, nazwisko, nazwa as stanowisko, id_jedn from Pracownik, Stanowisko, PracJednLnk WHERE Pracownik.stanowisko=Stanowisko.id AND PracJednLnk.id_prac=Pracownik.id  AND Stanowisko.name='"+name+"'";
        Statement st = connection.createStatement();
        st.execute(sql);
        ArrayList<Person> persons = new ArrayList<>();
        ResultSet rs = st.getResultSet();
        while (rs.next()) {
            persons.add(createPersonFromResultSet(rs));
        }
        return persons;
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    //TODO DEPARTMENT DATA
    public boolean updatePerson(Person p) {
        int rows =0;
        try {
            updatePersonPreparedStatement.setString(1, p.getName());
            updatePersonPreparedStatement.setString(2, p.getSurname());
            updatePersonPreparedStatement.setString(3, p.getPosition());
            updatePersonPreparedStatement.setInt(4, p.getId());
            rows = updatePersonPreparedStatement.executeUpdate();
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
            return false;
        }
        return rows>0;
    }
    //TODO DELETE FROM OS_JEDN_LNK
    public boolean deletePerson(Person p) {
        int rows =0;
        try {
            deletePreparedStatement.setInt(1, p.getId());
            rows = deletePreparedStatement.executeUpdate();
            deletePersonFromAllDepartmentsPreparedStatement.setInt(1,p.getId());
            deletePersonFromAllDepartmentsPreparedStatement.executeUpdate();
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
            return false;
        }
        return rows>0;
    }

    public boolean insertPerson(Person p) {
        int rows =0;
        try {
            insertPersonPreparedStatement.setString(1, p.getName());
            insertPersonPreparedStatement.setString(2,p.getSurname());
            insertPersonPreparedStatement.setString(3,p.getPosition());
            rows = insertPersonPreparedStatement.executeUpdate();
            if (rows>0){
                insertPersonPreparedStatement = connection.prepareStatement("select last_insert_rowid()");
                ResultSet rs = insertPersonPreparedStatement.executeQuery();
                rs.next();
                p.setId(rs.getInt(1));
            }
            Department dep = daoImpl.getDepartmentById(p.getDepartmentId());
            dep.getMembers().add(p);
            daoImpl.updateDepartment(dep);
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
            return false;
        }
        return rows>0;
    }

    public Person createPersonFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("imie");
        String sname = rs.getString("nazwisko");
        String position = rs.getString("stanowisko");
        int depId = rs.getInt("id_jedn");
        return new Person(id, name, sname, position, depId);
    }
}
