package dao_approach.model;

import java.util.List;

public class Department {
    private int id;
    private String Name;
    private List<Person> members;

    public Department(){}

    public Department(int id, String name, List<Person> members) {
        this.id = id;
        Name = name;
        this.members = members;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<Person> getMembers() {
        return members;
    }

    public void setMembers(List<Person> members) {
        this.members = members;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(this.id);
    }
}
