package jpa_approach.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Jednostka {
    private Integer id;
    private String nazwa;
    private List<Pracownik> pracownicy;

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
        Jednostka jednostka = (Jednostka) o;
        return Objects.equals(id, jednostka.id) &&
                Objects.equals(nazwa, jednostka.nazwa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nazwa);
    }

    @ManyToMany
    @JoinTable(name = "PracJednLnk", catalog = "",
            schema = "main",
            joinColumns = @JoinColumn(name = "id_jedn",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_prac",
                    referencedColumnName = "id"))
    public List<Pracownik> getPracownicy() {
        return pracownicy;
    }

    public void setPracownicy(List<Pracownik> pracownicy) {
        this.pracownicy = pracownicy;
    }
}
