package model;

public class Person {
    private String name;
    private String surname;
    private int shoeSize;

    public Person(){}

    public Person(String name, String surname, int shoeSize) {
        this.name = name;
        this.surname = surname;
        this.shoeSize = shoeSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getShoeSize() {
        return shoeSize;
    }

    public void setShoeSize(int shoeSize) {
        this.shoeSize = shoeSize;
    }
}
