package jpa_approach.model;

import javax.persistence.*;
import java.util.Objects;

@NamedQuery(name = "getStanowiskoByNazwa",
        query = "from Stanowisko as s where s.nazwa = :nazwa")

@Entity
public class Stanowisko {
    private Integer id;
    private String nazwa;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nazwa")
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stanowisko that = (Stanowisko) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nazwa, that.nazwa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nazwa);
    }
}
